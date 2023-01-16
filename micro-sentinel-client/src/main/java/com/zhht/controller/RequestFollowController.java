package com.zhht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhht.handler.UserBlockHandler;
import com.zhht.service.UserService;

@RestController
public class RequestFollowController {

	@Autowired
	private UserService userService;
	@SentinelResource(value="registerUser",fallback="fallbackRegister", blockHandler="handlerRegister")
	@RequestMapping(value="/registerUser",method=RequestMethod.GET)
	public String registerUser(@RequestParam("userName") String userName) {
		return userName+" register success";
	}
	
	
	public String handlerRegister(String userName , BlockException ex) {
		ex.printStackTrace();
		return userName +"register request blockException";
		
	}
	
	public String fallbackRegister(String userName , Throwable ex) {
		ex.printStackTrace();
		return userName +"register request fallbackException";
		
	}
	@RequestMapping(value="/getUserName",method=RequestMethod.GET)
	public String getUserName(@RequestParam("userName") String userName) {
		return userService.getUserName(userName);
	}
/*	@SentinelResource(value="/getUser", blockHandlerClass=UserBlockHandler.class,blockHandler="handlerRegister")
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public String getUser(@RequestParam("userName") String userName) {
		return userName+" success!";
	}*/
	
}
