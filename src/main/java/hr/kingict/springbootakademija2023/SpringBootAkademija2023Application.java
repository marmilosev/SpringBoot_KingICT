package hr.kingict.springbootakademija2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"hr.kingict.springbootakademija2023", "util"}) //alternativa za skeniranje paketa, umjesto config
@SpringBootApplication
public class SpringBootAkademija2023Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAkademija2023Application.class, args);
	}

}
