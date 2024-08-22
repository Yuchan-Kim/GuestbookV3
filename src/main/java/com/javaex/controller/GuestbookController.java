package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.guestbookDao;
import com.javaex.service.GuestbookService;
import com.javaex.vo.guestbookVo;
@Controller
public class GuestbookController {
	//Fields
	@Autowired
	private guestbookDao dao;
	
	@Autowired
	private GuestbookService service;

	//Constructors

	//Getters and Setters

	//[Methods]
	
	@RequestMapping(value ="/addpeople", method = {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("guestbookController.list()");
		
		
		List<guestbookVo> guestList = service.exegetPersonList();
		
		System.out.println(guestList);
		
		model.addAttribute("guestList",guestList);
		
		return "addPeople"; //Forwarding
	}
	
	@RequestMapping(value ="/register", method = {RequestMethod.GET, RequestMethod.POST} )
	public String register(@RequestParam(value = "name") String name, @RequestParam(value = "pw") String pw, @RequestParam(value = "comments") String comments ) {
		System.out.println("guestbookController.register()");
		
		guestbookVo guestVo = new guestbookVo(name,pw,comments);
		
		service.exeRegister(guestVo);
		
		return "redirect:/addpeople";
		
	}
	
	@RequestMapping(value ="/deleteformat", method = {RequestMethod.GET, RequestMethod.POST} )
	public String showDelete(Model model, @RequestParam(value = "num") int personId) {
		System.out.println("guestbookController.deleteInfo()");
		
		guestbookVo guestVo = service.exegetPersonInfo(personId);
		model.addAttribute("guestVo",guestVo);
		
		return "deleteInfo";
		
	}
	
	@RequestMapping(value ="/delete", method = {RequestMethod.GET, RequestMethod.POST} )
	public String delete(Model model, @RequestParam(value = "num") int personId, @RequestParam(value = "pw") String pw) {
		System.out.println("guestbookController.delete()");
		
		if(service.execheckPw(personId, pw)) {
			service.exeDeletePerson(personId);
		}
		
		
		return "redirect:/addpeople";
		
	}
	
	
	
	
	
	
	
	
	
	

}
