package com.nr.student;

import com.nr.student.model.Student;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableKafka
@OpenAPIDefinition(info = @Info(title = "admin-service", version = "1", description = "Admin APIs"))
@SpringBootApplication
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

//    @KafkaListener(groupId = "student-group", topics = "student-created",    containerFactory = "kafkaListenerContainerFactory"
//    )
    public void consume(Student user) {
        System.out.println("coming");
        System.out.println("Received JSON Message: " + user);

    }

}
