package com.nr.student.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nr.student.exception.ErrorResponse;
import com.nr.student.exception.ExternalServiceException;
import com.nr.student.exception.GenericClientException;
import com.nr.student.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthServiceClient {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${auth-service-url}")
    private String authUrl;

    public Long getUserIdByUserName(String userName) {
        try {
            String url = authUrl + "/" + userName;
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + tokenService.getJwtFromRequest()); // Pass JWT token in header
            HttpEntity<String> entity = new HttpEntity<>(headers); // Wrap headers in HttpEntity
            ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, entity, Long.class);
            return response.getBody(); // Extract user from response
        } catch (HttpClientErrorException.NotFound ex) {
            String responseBody = ex.getResponseBodyAsString();
            ObjectMapper objectMapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule())  // Enables LocalDateTime serialization/deserialization
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Optional: Makes output more readable

            try {
                ErrorResponse errorResponse = objectMapper.readValue(responseBody, ErrorResponse.class);
                throw new UserNotFoundException(errorResponse.errorMessage());
            } catch (JsonProcessingException e) {
                throw new UserNotFoundException(e.getMessage());
            }
        } catch (HttpServerErrorException ex) {
            throw new ExternalServiceException("Error occurred while calling User Service: " + ex.getMessage());
        } catch (Exception ex) {
            throw new GenericClientException("Unexpected error: " + ex.getMessage());
        }
    }
}
