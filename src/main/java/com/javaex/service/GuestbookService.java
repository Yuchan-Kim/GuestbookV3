package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.guestbookDao;
import com.javaex.vo.guestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private guestbookDao dao;
	
	public int exeRegister(guestbookVo guestVo) {
		int count = dao.registerInfo(guestVo);
		
		return count;
	}
	
	public int exeDeletePerson(int no) {
		
		int count = dao.deletePerson(no);
		
		return count;
	}
	
	public guestbookVo exegetPersonInfo(int no) {
		
		guestbookVo guest = dao.getPersonInfo(no);
		
		return guest;
	}
	
	public List<guestbookVo> exegetPersonList(){
		
		List<guestbookVo> guestList = dao.getPersonList();
		
		return guestList;
	}
	
	public boolean execheckPw(int no, String pw) {
		
		return dao.checkPw(no, pw);
		
	}
	
	
	
}
