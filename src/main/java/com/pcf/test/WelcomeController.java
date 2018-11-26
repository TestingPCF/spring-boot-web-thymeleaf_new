package com.pcf.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	 @RequestMapping(value="/home", method = RequestMethod.GET)
	public String main(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	 
	 @RequestMapping(value="/msg", method = RequestMethod.GET)
		public String welcome(@RequestParam("name") String name,Model model) {
			String mes="Hi "+name+" ";
			model.addAttribute("mes",mes);
			return "msg";
		}

}