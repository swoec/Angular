package main.java.com.angular.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.angular.service.IOrderService;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/orders")
public class OrderController {
	@Resource
	private  IOrderService orderservice;
	

	@ResponseBody
    @RequestMapping(value="/index")
    public ModelAndView usrs( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		ModelAndView rw = new ModelAndView("index");
		
        return rw;
    }

}
