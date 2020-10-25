package com.rowel.company;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {
	
	@Autowired
	private EmpService service;
	List<Employee> temp;
	HttpSession session;
	@RequestMapping("/")
	public ModelAndView login()
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView home(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest req)
	{
		if(username.equalsIgnoreCase("username")&&password.equalsIgnoreCase("password"))
		{
			session=req.getSession();
			session.setAttribute("authorised",username);
			return new ModelAndView("home");
		}
		else
		{
			return new ModelAndView("login").addObject("msg", "Unauthorised login");
		}
	}
	
	@RequestMapping(value="/back")
	public ModelAndView again()
	{
		if(session.getAttribute("authorised")!=null)
		{return new ModelAndView("home"); }
		else {return new ModelAndView("login");}
	}

	@RequestMapping(path="/all",method=RequestMethod.GET)
	public ModelAndView getAllEmployees()
	{
		if(session.getAttribute("authorised")!=null)
		{
			temp = service.every();
			return new ModelAndView("show").addObject("all", temp);
		}
		else {return new ModelAndView("login");}
	}
	
	@RequestMapping(value="/add")
	public ModelAndView askToAdd()
	{
		if(session.getAttribute("authorised")!=null)
		{
			return new ModelAndView("insert");
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="/newemployee", method=RequestMethod.POST)
	public ModelAndView addNewEmployee(@Valid Employee emp, BindingResult bind)
	{
		if(session.getAttribute("authorised")!=null)
		{
			ModelAndView mv = new ModelAndView("insert");
			if(bind.hasErrors()) {return mv;}
			if(service.newadd(emp)!=null)
			{
				mv.addObject("msg", "Employee "+emp.getEmpid()+" details inserted." );
			}
			else
			{
				mv.addObject("msg","Employee "+emp.getEmpid()+" details did not get inserted.");
			}
			return mv;
		}
		
		else
			{return new ModelAndView("login");}
	}
	@RequestMapping(value="/deletable",method=RequestMethod.GET)
	public ModelAndView deleteRequest(@RequestParam("empid") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
			Employee temp=service.single(id);
			String hold=service.remove(temp);
			return getAllEmployees().addObject("msg",hold+" has deleted");
		}
		else {return new ModelAndView("login");}
	}
	@RequestMapping(value="/remove",method=RequestMethod.GET)
	public ModelAndView remove()
	{
		if(session.getAttribute("authorised")!=null)
		{
			return new ModelAndView("remove");
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="/change")
	public ModelAndView editEmployee(@Valid Employee emp, BindingResult bind)
	{
		if(session.getAttribute("authorised")!=null)
		{
			service.alter(emp);
			return getAllEmployees().addObject("msg", emp.getEname()+" has been updated");
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	@RequestMapping(value="/editable",method=RequestMethod.GET)
	public ModelAndView editRequest(@RequestParam("empid") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
			Employee emp = service.single(id);
			return new ModelAndView("update").addObject("one", emp);
		}
		else {return new ModelAndView("login");}
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView out()
	{
		session.removeAttribute("authorised");
		session.setAttribute("authorised", null);
		return new ModelAndView("login").addObject("msg", "Logged out successfully");
	}
	
	
	@RequestMapping(value="/search")
	public ModelAndView find()
	{
		if(session.getAttribute("authorised")!=null)
		{
			return new ModelAndView("find");
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="getemp",method=RequestMethod.GET)
	public ModelAndView list(@RequestParam("type") int type, @RequestParam("val") String val)
	{
		
			if(type==1 && val!="")
			{
				Employee tm=service.single(Integer.parseInt(val));
				temp = new ArrayList<Employee>();
				temp.add(tm);
				return new ModelAndView("show").addObject("all", temp);
			}
			if(type==2 && val!="")
			{
				temp = service.getByDno(Integer.parseInt(val));
				return new ModelAndView("show").addObject("all", temp);
			}
			else if(type==3 && val!="")
			{
				temp = service.getBySalary(Double.parseDouble(val));
				return new ModelAndView("show").addObject("all", temp);
			}
			else if(type==4 && val!="")
			{
				temp = service.getBySex(val.toString().toUpperCase());
				return new ModelAndView("show").addObject("all", temp);
			}
			else if(type==5 && val!="")
			{
				temp = service.getBySuperssn(Integer.parseInt(val));
				return new ModelAndView("show").addObject("all", temp);
			}
			else
			{
				return new ModelAndView("login");
			}
		
	}
	
	
	
}



