package app.covidless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CovidlessApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidlessApplication.class, args);
    }


}
