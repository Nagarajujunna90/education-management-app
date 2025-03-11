package com.nr.student;

import com.nr.student.model.Student;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
//@EnableKafka
@OpenAPIDefinition(info = @Info(title = "student-service", version = "1", description = "Student APIs"))
@SpringBootApplication
public class StudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

//    @KafkaListener(groupId = "student-group", topics = "student-created",    containerFactory = "kafkaListenerContainerFactory"
//    )
    public void consume(Student user) {
        System.out.println("coming");
        System.out.println("Received JSON Message: " + user);

    }

}
