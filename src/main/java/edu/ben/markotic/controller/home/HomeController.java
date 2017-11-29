package edu.ben.markotic.controller.home;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {

	public static ModelAndView showHomePage(Request req, Response res) throws Exception {
		// Just a hash to pass data from the servlet to the page
		HashMap<String, Object> model = new HashMap<>();

		return new ModelAndView(model, "home/home.hbs");
	}

}
