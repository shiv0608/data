package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import helper.HiberHelper;
import model.Admin;

@Controller
public class AdminController {
	HiberHelper db = new HiberHelper();
@RequestMapping("login")
public ModelAndView login()
{
	return new ModelAndView("login","command",new Admin());
}
@RequestMapping("logincode")
public ModelAndView logincode(@ModelAttribute("xyz")Admin obj)
{
	db.hiberConfigure();
	List lst = db.loginData("from Admin o where o.userid=? and o.password=?",obj.getUserid(),obj.getPassword());
	if(lst.size()>0)
	{
		return new ModelAndView("redirect:stuload.do");
	}
	return new ModelAndView("login","command",new Admin()).addObject("key","Invalid Credentials");
}
}
