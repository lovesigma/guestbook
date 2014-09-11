package com.nhnent.guestbook.service;

import java.sql.Connection;

public interface IMakeConnection {
	Connection getConnection();
}
