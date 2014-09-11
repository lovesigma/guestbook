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
	public int addGuestBook(GuestBook guestBook) {
		if (isValidEmail(guestBook.getEmail())) {
			return guestBookDao.insert(guestBook);
		}
		return -1;
	}
	public boolean isValidEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public boolean isValidPassword(int id, String password) {
		// TODO Auto-generated method stub
		String originPassword = guestBookDao.getPassword(id);
		if (originPassword.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public void chageGuestBook(GuestBook guestBook) {
		String originPassword = guestBookDao.getPassword(guestBook.getId());
		if (originPassword.endsWith(guestBook.getPassword())) {
			guestBookDao.changeGuestBook(guestBook);
		} else {
		}
	}
}
