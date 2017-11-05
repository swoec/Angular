package main.java.com.angular.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.angular.service.ICommodityService;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/comm")
public class CommodityController {
	@Resource
	private ICommodityService commService;
	

	@ResponseBody
    @RequestMapping(value="/detail")
    public ModelAndView usrs( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		ModelAndView rw = new ModelAndView("detail");
		
        return rw;
    }
	

	@ResponseBody
    @RequestMapping(value="/cart")
    public ModelAndView cart( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		ModelAndView rw = new ModelAndView("cart");
		
        return rw;
    }
	

	@ResponseBody
    @RequestMapping(value="/list")
    public ModelAndView list( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		ModelAndView rw = new ModelAndView("list");
		
        return rw;
    }
}
