package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Contact;
import com.example.repository.ContactRepository;

@Controller
@RequestMapping(value="/")
public class HelloController {
	
	@Autowired(required=true)
	private ContactRepository contactRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index()
	{
		return "main_page";
	}
	
	@RequestMapping(value="/form")
	public String form()
	{
		return "form";
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(@ModelAttribute Contact c)
	{
		this.contactRepository.save(c);
		return "Hello "+c.getF_name()+"\n"+c.getF_email();
	}
	
}
