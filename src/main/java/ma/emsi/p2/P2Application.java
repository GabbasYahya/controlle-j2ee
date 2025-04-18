package ma.emsi.p2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ma.emsi.p2.controllers") // Add this
public class P2Application {
    public static void main(String[] args) {
        SpringApplication.run(P2Application.class, args);
    }
}