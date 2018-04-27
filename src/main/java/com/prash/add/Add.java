package com.prash.add;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@SpringBootApplication

public class Add {

	@RequestMapping(value="/add/API")
	@ResponseBody
	String addAPI() {
		return "API is /add/{N1}/{N2} or /add?param1={N1}&param2={N2}";
	}

	@RequestMapping(value="/add/{param1}/{param2}")
	@ResponseBody
	int addPathStyle(@PathVariable int param1, @PathVariable int param2) {
		return param1+param2;
	}

	@RequestMapping(value="/add")
	@ResponseBody
	int addParamStyle(@RequestParam("param1") int param1, @RequestParam("param2") int param2) {
		return param1+param2;
	}

	@RequestMapping(value="/add/JSON",method = RequestMethod.POST)
	@ResponseBody
	AddDO addJSONStyle(@RequestBody AddDO addDO) {
		addDO.result = addDO.param1+addDO.param2;
		return addDO;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Add.class, args);
	}

}