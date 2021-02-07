package io.github.himcs.itlaoqi.jpa;

import static io.github.himcs.itlaoqi.jpa.constan.PATHS.JPA_REPOSITORY_PATH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = JPA_REPOSITORY_PATH)
public class ItlaoqiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ItlaoqiApplication.class, args);
  }

}
