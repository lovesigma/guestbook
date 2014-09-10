package com.nhnent.guestbook.service;


import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhnent.guestbook.dao.GuestBookDao;
import com.nhnent.guestbook.model.GuestBook;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = {"classpath:config/spring/appServlet/test.servlet-context.xml", "classpath:config/spring/root-context.xml", "classpath:config/mybatis/testmybatis*.xml"})
public class GuestBookServiceTest {
	@Autowired
	private GuestBookService guestBookService;
	@Autowired
	private GuestBookDao guestBookDao;
	@Test
	public void 올바른GuestBook추가(){
		int beforeSize = guestBookDao.getListSize();
		GuestBook guestBook = new GuestBook("test","0415","lovate@naver.com");
		guestBook.setContent("test");
		guestBook.setEmail("lovesigma@naver.com");
		guestBook.setPassword("0412412415");
		guestBookDao.insert(guestBook);
		int afterSize = guestBookDao.getListSize();
		assertThat(beforeSize+1, is(afterSize));
	}
}
