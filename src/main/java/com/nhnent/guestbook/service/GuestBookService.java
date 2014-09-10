package com.nhnent.guestbook.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhnent.guestbook.dao.GuestBookDao;
import com.nhnent.guestbook.model.GuestBook;

@Service
public class GuestBookService {
@Autowired
private GuestBookDao guestBookDao;

	public void addGuestBook(GuestBook guestBook) {
		guestBookDao.insert(guestBook);
		
	}

	private void isValidEmail(String email) {
		// 이메일이 유효한지 봐야함.
	}

	public boolean isValidPassword(int id, String password) {
		// TODO Auto-generated method stub
		String originPassword = guestBookDao.getPassword(id);
		if(originPassword.equals(password)){
			return true;
		}
		else{
			return false;
		}
	}

	public void chageGuestBook(GuestBook guestBook) {
		String originPassword = guestBookDao.getPassword(guestBook.getId());
		if(originPassword.endsWith(guestBook.getPassword())){
			guestBookDao.changeGuestBook(guestBook);
			System.out.println("sucess");
		}
		else{
			System.out.println("fail");
		}
	}
}
