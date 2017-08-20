package com.example.demo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Controller
@RequestMapping("/account")
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AccountRepository repo;
	
	@RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav){
		mav = new ModelAndView("account/list");
		mav.addObject("list", repo.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Account account){
		logger.info(account.toString());
		repo.save(account);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/create", params = "form", method = RequestMethod.GET)
	public ModelAndView toCreateForm(ModelAndView mav){
		mav = new ModelAndView("account/new");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Account account){
		logger.info(account.toString());
		repo.save(account);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/update/{id}", params = "form", method = RequestMethod.GET)
	public ModelAndView toUpdateForm(ModelAndView mav, @PathVariable int id){
		logger.info(id+"");
		mav = new ModelAndView("account/update");
		mav.addObject("account", repo.findOne(id));
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id){
		repo.delete(id);
		return "redirect:/account/list";
	}
	
}
