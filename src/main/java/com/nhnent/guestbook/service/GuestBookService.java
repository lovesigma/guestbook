package com.nhnent.guestbook.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.nhnent.guestbook.model.GuestBook;

@Service
public class GuestBookService {

	public void addGuestBook(GuestBook guestBook) {}

	private void isValidEmail(String email) {
		// 이메일이 유효한지 봐야함.
	}
}
