package com.verizon.eda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
	@GetMapping("/header")
	public String headerAction() {
		return "header";
	}
	
	@GetMapping("/footer")
	public String footerAction() {
		return "footer";
	} 
}
