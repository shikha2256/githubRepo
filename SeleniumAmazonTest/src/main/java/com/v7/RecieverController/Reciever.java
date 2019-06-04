package com.v7.RecieverController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Reciever {
	 @RequestMapping(value = { "/runTest" }, method = RequestMethod.GET)
	 public static void callMethod()
	 { 
	      System.out.println("Hello");
	 }
	 }
