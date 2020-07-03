package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping("/guestboard")
public class GuestBookController {
	
	@RequestMapping(value="/addlist",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		GuestBookDao gDao = new GuestBookDao();
		List<GuestBookVo> gList = gDao.getPersonList();
		model.addAttribute("gList", gList);
		return "/WEB-INF/view/addList.jsp";		
		//포워딩을 하는게 아니라 서블릿이 포워딩하기 위해 주소값 전달
	}
	

	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@ModelAttribute GuestBookVo gVo) {
		GuestBookDao gDao = new GuestBookDao();
		System.out.println(gVo.toString());
		gDao.GuestBookInsert(gVo);
		return "redirect:/guestboard/addlist";		
		//포워딩을 하는게 아니라 서블릿이 포워딩하기 위해 주소값 전달
	}
	
	@RequestMapping(value="/deleteForm",method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@RequestParam("no") int no, Model model2) {
		System.out.println("deleteform");
		model2.addAttribute("no", no);
		return "/WEB-INF/view/deleteForm.jsp";		
		//포워딩을 하는게 아니라 서블릿이 포워딩하기 위해 주소값 전달
	}
	
	@RequestMapping(value="/delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@RequestParam("no") int no, @RequestParam("password") String password) {
		GuestBookDao gDao = new GuestBookDao();
		gDao.guestDelete(no, password);
		return "redirect:/guestboard/addlist";		
		//포워딩을 하는게 아니라 서블릿이 포워딩하기 위해 주소값 전달
	}
}
