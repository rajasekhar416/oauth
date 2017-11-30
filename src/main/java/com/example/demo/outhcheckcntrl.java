package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class outhcheckcntrl {
	
		@GetMapping("/v2/checkoauth")
		public String getname()
		{
			return "success";
		}
		
		@GetMapping("/raj")
		public String getname1()
		{
			return "success";
		}
		
		@GetMapping("/check")
		public String getname2()
		{
			return "success";
		}

}
