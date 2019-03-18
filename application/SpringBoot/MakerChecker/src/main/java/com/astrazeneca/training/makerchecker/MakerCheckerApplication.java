package com.astrazeneca.training.makerchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.astrazeneca.training.makerchecker.*"})
@EntityScan("com.astrazeneca.training.makerchecker.entity")
@EnableJpaRepositories("com.astrazeneca.training.makerchecker.repository")


public class MakerCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakerCheckerApplication.class, args);
    }

}
