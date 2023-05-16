package cont;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import help.HiberHelper;
import mod.Admin;
import mod.Login;
import mod.Use;
import mod.User;


;
@Controller
public class LoginController {
	HiberHelper db = new HiberHelper();
	
	
	@RequestMapping("login")
	public ModelAndView login()
	{
		
		return new ModelAndView("login","command",new Login());
	}
	@RequestMapping("logincode")
	public ModelAndView logincode1(@ModelAttribute("xyz") Login obj,HttpServletRequest request)
	{
		
		db.hiberConfigure();
		List lst = db.loginData("from User o where o.username=? and o.password=?",obj.getUsername(),obj.getPassword());
		if(lst.size()>0)
		{
			

		 }else {
			 return new ModelAndView("login","command",new Login()).addObject("key","Invalid Userid and Password");
		 }
	List lst5=db.loginData1("from User o where o.username=? and o.password=? and o.status=?", obj.getUsername(), obj.getPassword(),1); 
		
		if(lst5.size()>0) {
			
			ModelAndView mo=new ModelAndView("loginview","command",new Login());
			mo.addObject("key",lst);
			return mo;
			//return new ModelAndView("loginview","command","key");
			
		//	return new ModelAndView("redirect:loginview.do");
		}else {
			return new ModelAndView("login","command",new Login()).addObject("key","You are Blocked");
		}
	}
}


		
		
		
		




