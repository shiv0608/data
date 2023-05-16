package cont;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import help.HiberHelper;
import mod.Use;
import mod.User;


@Controller
public class RegistrationController {
	HiberHelper db = new HiberHelper();

	@RequestMapping("home")
	public String home()
	{
		return "home";
	}
	@RequestMapping("loginview")
	   public ModelAndView viewstu1()
	   {
		  db.hiberConfigure();
		   List lst = db.getData("from User s");
		   return new ModelAndView("data","command",new User()).addObject("key",lst);
	   }
	
	
	@RequestMapping("checkuserinfo")
	public ModelAndView checkuserinfo(HttpServletRequest req)
	{
		db.hiberConfigure();
		Object o=db.findData(User.class,req.getParameter("q"));
		if(o!=null)
		{
			return new ModelAndView("info","key","useralredy exist");
		}
		else
		{
			return new ModelAndView("info","key", "not exist");
		}
	}
	
	
	
	
	@RequestMapping("register")
	public ModelAndView register()
	{
		
		return new ModelAndView("register","command",new User());
	}
	@RequestMapping("data")
	   public ModelAndView viewstu()
	   {
		  db.hiberConfigure();
		   List lst = db.getData("from User s");
		   return new ModelAndView("data","command",new User()).addObject("key",lst);
	   }
	
	@RequestMapping("editdata")
	   public ModelAndView editstu(HttpServletRequest request)
	   {
		   db.hiberConfigure();
		   User o =(User) db.findData(User.class,(request.getParameter("q")));
		   List lst = db.getData("from User s");
		   ModelAndView mo = new ModelAndView("edit","command",o);
		   mo.addObject("key1",lst);
		   
			return mo;
		   
		   
	   }
	

	@RequestMapping("blockdata")
	   public ModelAndView block(HttpServletRequest request)
	   {
		   db.hiberConfigure();
		   User o =(User) db.findData(User.class,(request.getParameter("q")));
		   List lst = db.getData("from User s");
		   ModelAndView mo = new ModelAndView("block","command",o);
		   mo.addObject("key1",lst);
		   
			return mo;
		   
		   
	   }
	

@RequestMapping("editsave")
public ModelAndView upCode(@ModelAttribute("xyz")Use obj,HttpServletRequest req)
{
	 db.hiberConfigure();
	   User ur = new User();
	   ur.setUsername(obj.getUsername());
	   ur.setPassword(obj.getPassword());
 	   ur.setEmail(obj.getEmail());
 	   ur.setPhone(obj.getPhone());
	   ur.setStatus(obj.getStatus());
	   db.updateData(ur);
	 
	// return new ModelAndView("edit","command",new User()).addObject("key","update successful");
	 return new ModelAndView("home","command",new User());
	   }

@RequestMapping("editblock")
public ModelAndView blockcode(@ModelAttribute("xyz")Use obj,HttpServletRequest req)
{
	 db.hiberConfigure();
	   User ur = new User();
	   ur.setUsername(obj.getUsername());
	   ur.setPassword(obj.getPassword());
 	   ur.setEmail(obj.getEmail());
 	   ur.setPhone(obj.getPhone());
	   ur.setStatus(obj.getStatus());
	   db.updateData(ur);
	 //  return new ModelAndView("redirect:data.do");
	 
	// return new ModelAndView("block","command",new User()).addObject("key","update successful");
	 return new ModelAndView("home","command",new User());
	   }
	

	
	
	
	
	
	
	
	
	
   // @RequestMapping("register")  
//public String registerForm(Model model)  
//{  
        //  User ur=new User ();  
         //  model.addAttribute("user", ur);  
          // return "register";  
//}  
    @RequestMapping("regcode")
    public ModelAndView stuCode(@ModelAttribute("user")Use obj,HttpServletRequest req)
    {
 	   db.hiberConfigure();
 	   User ur = new User();
 	   ur.setUsername(obj.getUsername());
 	   ur.setPassword(obj.getPassword());
 	   ur.setEmail(obj.getEmail());
 	   ur.setPhone(obj.getPhone());
 	  db.insertData(ur);
 	 return new ModelAndView("register","command",new User()).addObject("key","Register successful");
}
    }
