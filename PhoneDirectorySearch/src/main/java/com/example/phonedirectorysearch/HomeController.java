package com.example.phonedirectorysearch;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("home")
	public ModelAndView home(@RequestParam("search") String searchString)
	{
		ModelAndView mv = new ModelAndView();
		
		PhoneSearch ps = new PhoneSearch();
		
		final List<String> result = ps.searchDirectory(searchString);
		
		// If there are no records we will build our own message to display
		if(result.isEmpty())
		{
			ps.setEmptyString("There are no records with the serach pattern");
			mv.addObject("searchString", ps.getEmptyString());
			mv.setViewName("home");
			
			return mv;
		}
		
		ps.setSearchString(result);
		
		mv.addObject("searchString", ps.getSearchString());
		mv.setViewName("home");
		
		return mv;
	}
}
