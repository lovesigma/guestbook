package com.nhnent.guestbook;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nhnent.guestbook.dao.GuestBookDao;
import com.nhnent.guestbook.model.GuestBook;
import com.nhnent.guestbook.service.GuestBookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	GuestBookService guestBookService;
	@Autowired
	GuestBookDao guestBookDao;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		List<GuestBook> guestBookList = guestBookDao.getGuestBookList();
//		ArrayList<Board> boards ;
//		DBController dbController = new DBController();
//		boards = dbController.getBoardList();
		model.addAttribute("guestBookList", guestBookList);
//		return new ModelAndView("boardlist", "command", new Board());
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertGuestBook(@ModelAttribute GuestBook guestBook){
		System.out.println("asdasdasd");
		guestBookService.addGuestBook(guestBook);
		return "redirect:/";
	}
	
	
	
}
