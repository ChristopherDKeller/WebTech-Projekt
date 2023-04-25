package htwberlin.de.WebTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebTechApplication.class, args);
	}

	@RestController
	public class HelloWorldController {
		@GetMapping("/helloWorld")
		public String helloWorld(){
			return "Hello World";
		}


	}

}
