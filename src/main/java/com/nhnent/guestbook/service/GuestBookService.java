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
}
