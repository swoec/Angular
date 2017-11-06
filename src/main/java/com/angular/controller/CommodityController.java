package main.java.com.angular.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.angular.model.CommentEntity;
import main.java.com.angular.model.CommodityEntity;
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
	
	@ResponseBody
    @RequestMapping(value="/detail/{id}" ,method = RequestMethod.POST)
    public List<CommodityEntity> getcommbyId( @PathVariable("id") int id){
		System.out.println("~~~~~~~~~~~~~");
		return commService.getCommbyId(id);
		//ModelAndView rw = new ModelAndView("list");
		
       // return rw;
    }
	
	@ResponseBody
    @RequestMapping(value="/alllist" ,method = RequestMethod.POST)
    public List<CommodityEntity> getAllcomm(){
		System.out.println("~~~~~~~~~~~~~");
		return commService.getAllComm();
		//ModelAndView rw = new ModelAndView("list");
		
       // return rw;
    }
	
	
	@ResponseBody
    @RequestMapping(value="/comment/{id}" ,method = RequestMethod.POST)
    public List<CommentEntity> getcommentbyId( @PathVariable("id") int id){
		System.out.println("~~~~~~~~~~~~~");
		return commService.getCommentbyId(id);
		
    }
	
	@ResponseBody
    @RequestMapping(value="/comment/add/" ,method = RequestMethod.POST)
    public boolean addcommentbyId( HttpServletRequest request, HttpServletResponse response){
		System.out.println("~~~~~~~~~~~~~");
		int userId = Integer.parseInt( request.getParameter("userId") );
		String userName = request.getParameter("userName");
		int commodityID = Integer.parseInt(request.getParameter("commodityID"));
		String comment = request.getParameter("comment");
		return commService.addCommentbyId(userId,commodityID,userName,comment);
		
    }
}
