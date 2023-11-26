package com.dog.shelter.rescue.system.dogrescuesheltersystem;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.WebSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DogRescueShelterSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogRescueShelterSystemApplication.class, args);
//        WebSocket.setApplicationContext(applicationContext);
    }

}
