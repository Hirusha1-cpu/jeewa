package lk.jeewacomputers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class JeewacomputersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeewacomputersApplication.class, args);
		System.out.println("Hello Jeewa");
	}

	@GetMapping(value =  "/testjeewa",produces = "application/json")
	public String testRequest(){
		return "Welcome Jeewa Computers";
	}

	@RequestMapping(value = "/jeewacomputers",method = RequestMethod.GET)
	public ModelAndView testJeewaUi(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/index.html");
		return modelAndView;
	}

}
