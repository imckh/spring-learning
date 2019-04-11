package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author CKH
 * @date 2018/12/17 19:42
 */
@SpringBootApplication
@EnableScheduling // @EnableScheduling ensures that a background task executor is created. Without it, nothing gets scheduled.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
