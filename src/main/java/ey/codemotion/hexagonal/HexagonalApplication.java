package ey.codemotion.hexagonal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration;

@SpringBootApplication(exclude = {HttpClientAutoConfiguration.class})
public class HexagonalApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(HexagonalApplication.class);
        application.run(args);
    }

}
