package com.nr.student;

import com.nr.student.model.StudentPersonalInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableKafka
@OpenAPIDefinition(info = @Info(title = "admin-service", version = "1", description = "Admin APIs"))
@SpringBootApplication
public class AdminServiceApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

//    @KafkaListener(groupId = "student-group", topics = "student-created",    containerFactory = "kafkaListenerContainerFactory"
//    )
    public void consume(StudentPersonalInfo user) {
        System.out.println("coming");
        System.out.println("Received JSON Message: " + user);

    }

}
