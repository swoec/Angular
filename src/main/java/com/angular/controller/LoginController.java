package main.java.com.angular.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@ResponseBody
    @RequestMapping(value="/init1")
    public ModelAndView login( HttpServletRequest request, HttpServletResponse response){
		System.out.println("login");
		ModelAndView rw = new ModelAndView("login");
        return rw;
    }
	
	@ResponseBody
    @RequestMapping(value="/user")
    public ModelAndView usr( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		ModelAndView rw = new ModelAndView("UserManagement");
        return rw;
    }

}
