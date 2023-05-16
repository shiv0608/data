package cont;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import help.HiberHelper;
import mod.Admin;



@Controller
public class AdminController {
	HiberHelper db = new HiberHelper();
@RequestMapping("adminlogin")
public ModelAndView adminlogin()
{
	
	return new ModelAndView("adminlogin","command",new Admin());
}
@RequestMapping("admincode")
public ModelAndView logincode(@ModelAttribute("xyz")Admin obj,HttpServletRequest request)
{
	db.hiberConfigure();
	List lst = db.loginData("from Admin o where o.username=? and o.password=?",obj.getUsername(),obj.getPassword());
	if(lst.size()>0)
	{
		
		return new ModelAndView("redirect:data.do");
	}
	return new ModelAndView("adminlogin","command",new Admin()).addObject("key","Invalid Credentials");
}

}
