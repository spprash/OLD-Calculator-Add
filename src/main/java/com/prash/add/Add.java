package com.prash.add;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Add {

	@RequestMapping("/add")
	String home() {
		return "ADD";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Add.class, args);
	}

}