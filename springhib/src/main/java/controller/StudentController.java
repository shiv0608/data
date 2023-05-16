package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Stu;
import model.Student;



@Controller
public class StudentController {
	@RequestMapping("stuload")
	public ModelAndView stuLoad()
	{
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from Student s");
		List lst=q.list();
		ModelAndView mo=new ModelAndView("stuview","command",new Stu());
		mo.addObject("key1",lst);
		return mo;
		//return new ModelAndView("stuview","command",new Stu());
	}
	@RequestMapping("stucode")
	public ModelAndView stucode(@ModelAttribute("abc")Stu obj,HttpServletRequest req)
	{
		 //SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		// Session session = sessionFactory.openSession();
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		 Transaction tx = s.beginTransaction();
		 Student st = new Student();
		 st.setRno(obj.getRno());
		 st.setName(obj.getName());
		 if(req.getParameter("btnsubmit").equals("update"))
		 {
			 s.update(st);
		 }
		 else
		 {
			 s.save(st);
			
		 }
		 s.save(st);
		 tx.commit();
		 Query q=s.createQuery("from Student s");
			List lst=q.list();
			s.close();
			sf.close();
			//return new ModelAndView("stuview","command",new Student()).addObject("key","update successful");
			ModelAndView mo=new ModelAndView("stuview","command",new Student());
			mo.addObject("key1",lst);
			mo.addObject("key", "succ");
			return mo;
	}
	
	@RequestMapping("stuview")
	public ModelAndView stuview()
	{
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from Student s");
		List lst=q.list();
		s.close();
		return new ModelAndView("stuview","command",new Student()).addObject("key","update successful");
	

}
	@RequestMapping("stuedit")
	public ModelAndView stuedit(HttpServletRequest request)
	{
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Student o =(Student)s.get(Student.class,Integer.parseInt(request.getParameter("q")));
				 Query q=s.createQuery("from Student s");
		List lst=q.list();
		s.close();
		ModelAndView mo=new ModelAndView("stuview","command",o);
		mo.addObject("key1",lst);
		mo.addObject("btnKey", "update");
		return mo;
		
	
}
	@RequestMapping("studel")
	public ModelAndView studel(HttpServletRequest request1)
	{
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Student o =(Student)s.get(Student.class,Integer.parseInt(request1.getParameter("g")));
		s.delete(o);	
		ModelAndView mo=new ModelAndView("stuview","command",o);
		
		return mo;
}
}