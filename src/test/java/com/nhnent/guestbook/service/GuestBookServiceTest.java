package com.nhnent.guestbook.service;


import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhnent.guestbook.dao.GuestBookDao;
import com.nhnent.guestbook.model.GuestBook;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = {"classpath:config/spring/appServlet/test.servlet-context.xml", "classpath:config/spring/root-context.xml", "classpath:testconfig/mybatis/testmybatis*.xml"})
public class GuestBookServiceTest {
	@Autowired
	private GuestBookService guestBookService;
	@Autowired
	private GuestBookDao guestBookDao;
	@Test
	public void 올바른GuestBook추가(){
		GuestBook guestBook = new GuestBook("lovate@naver.com","0415","test");
		int id = guestBookService.addGuestBook(guestBook);
		GuestBook guestBook2 = guestBookDao.getGuestBook(id);
		assertThat(guestBook.getPassword(), is(guestBook2.getPassword()));
		assertThat(guestBook.getContent(), is(guestBook2.getContent()));
		assertThat(guestBook.getEmail(), is(guestBook2.getEmail()));
	}
	@Test
	public void 올바르지_못한_Email_GuestBook추가(){
		GuestBook guestBook = new GuestBook("test","0415","lovatecom");
		int id = guestBookService.addGuestBook(guestBook);
		assertThat(id, is(-1));
	}
	@Test
	public void 비밀번호가_올바면_True(){
		String password = "0415";
		GuestBook guestBook = new GuestBook("lovate@naver.com",password,"test");
		int id = guestBookService.addGuestBook(guestBook);
		assertTrue(guestBookService.isValidPassword(id,password));
	}
	@Test
	public void 비밀번호가_올바지못하면_False(){
		String password = "0415";
		GuestBook guestBook = new GuestBook("lovate@naver.com",password,"test");
		int id = guestBookService.addGuestBook(guestBook);
		assertFalse(guestBookService.isValidPassword(id,password+"ddd"));
	}
	@Test
	public void 이메일이_형식이_올바르지_못하면_False(){
		String email = "124124asdasdasdasd.com";
		assertFalse(guestBookService.isValidEmail(email));
	}
	
	
	@Test
	public void 이메일이_형식이_올바르_True(){
		String email = "lovesigma@naver.com";
		assertTrue(guestBookService.isValidEmail(email));
	}
	@Test
	public void 이메일이_비밀번호가_맞지않고_내용을_바꾸려고하면_안바뀜(){
		String password = "0415";
		String originalContent = "test";
		GuestBook guestBook = new GuestBook("lovate@naver.com",password,originalContent);
		int id = guestBookService.addGuestBook(guestBook);
		GuestBook guestBook2 = guestBookDao.getGuestBook(id);
		String changeStr = "change";
		guestBook2.setContent(changeStr);
		guestBook2.setPassword(password+password);
		guestBookService.chageGuestBook(guestBook2);
		GuestBook guestBook3 = guestBookDao.getGuestBook(id);

		assertThat(guestBook3.getContent(), is(originalContent));
	}
	@Test
	public void 이메일이_비밀번호가_맞고_내용을_바꾸려고하면_바뀜(){
		String password = "0415";
		GuestBook guestBook = new GuestBook("lovate@naver.com",password,"test");
		int id = guestBookService.addGuestBook(guestBook);
		GuestBook guestBook2 = guestBookDao.getGuestBook(id);
		String changeStr = "change";
		guestBook2.setContent(changeStr);
		guestBookService.chageGuestBook(guestBook2);
		GuestBook guestBook3 = guestBookDao.getGuestBook(id);
		assertThat(guestBook3.getContent(), is(changeStr));
	}
}
