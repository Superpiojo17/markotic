package edu.ben.rate_review.controller.user;

import java.util.HashMap;
import java.util.List;

import edu.ben.rate_review.app.Application;
import edu.ben.rate_review.authorization.AuthException;
import edu.ben.rate_review.daos.AnnouncementDao;
import edu.ben.rate_review.daos.DaoManager;
import edu.ben.rate_review.daos.UserDao;
import edu.ben.rate_review.models.Announcement;
import edu.ben.rate_review.models.MassEditForm;
import edu.ben.rate_review.models.RecoveringUser;
import edu.ben.rate_review.models.User;
import edu.ben.rate_review.models.UserForm;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class EditUserController {

	public ModelAndView showEditUserPage(Request req, Response res) throws AuthException {
		// Just a hash to pass data from the servlet to the page
		HashMap<String, Object> model = new HashMap<>();
		UserDao user = DaoManager.getInstance().getUserDao();
		Session session = req.session();

		// Get the :id from the url
		String idString = req.params("id");

		// Convert to Long
		// /user/uh-oh/edit for example
		long id = Long.parseLong(idString);

		// Get user if ID is valid
		User u = user.findById(id);

		// Authorize that the user can edit the user selected
		// AuthPolicyManager.getInstance().getUserPolicy().showAdminDashboardPage();

		// create the form object, put it into request
		model.put("user_form", new UserForm(u));

		DaoManager adao = DaoManager.getInstance();
		AnnouncementDao ad = adao.getAnnouncementDao();
		List<Announcement> announcements = ad.all();
		model.put("announcements", announcements);

		// Render the page
		return new ModelAndView(model, "users/edituser.hbs");
	}

	public String massEditConfirmed(Request req, Response res) {
		UserDao userDao = DaoManager.getInstance().getUserDao();

		MassEditForm massedit = new MassEditForm();
		massedit.setBefore(Integer.parseInt(req.queryParams("confirmedbefore")));
		massedit.setAfter(Integer.parseInt(req.queryParams("confirmedafter")));
		userDao.massEditConfirmed(massedit);

		res.redirect(Application.ALLUSERS_PATH);
		return " ";

	}

	public String massEditYear(Request req, Response res) {
		UserDao userDao = DaoManager.getInstance().getUserDao();

		MassEditForm massedit = new MassEditForm();
		massedit.setBefore(Integer.parseInt(req.queryParams("yearbefore")));
		massedit.setAfter(Integer.parseInt(req.queryParams("yearafter")));
		userDao.massEditYear(massedit);

		
		res.redirect(Application.ALLUSERS_PATH);
		return " ";

	}

	public String massEditRole(Request req, Response res) {
		UserDao userDao = DaoManager.getInstance().getUserDao();

		MassEditForm massedit = new MassEditForm();
		massedit.setBefore(Integer.parseInt(req.queryParams("rolebefore")));
		massedit.setAfter(Integer.parseInt(req.queryParams("roleafter")));
		userDao.massEditRole(massedit);

		res.redirect(Application.ALLUSERS_PATH);
		return " ";

	}

	public String massEditActive(Request req, Response res) {
		UserDao userDao = DaoManager.getInstance().getUserDao();

		MassEditForm massedit = new MassEditForm();
		massedit.setBefore(Integer.parseInt(req.queryParams("activebefore")));
		massedit.setAfter(Integer.parseInt(req.queryParams("activeafter")));
		userDao.massEditActive(massedit);
		
		
		res.redirect(Application.ALLUSERS_PATH);
		return " ";

	}

	public String updateUser(Request req, Response res) {
		String idString = req.params("id");
		long id = Long.parseLong(idString);
		UserDao userDao = DaoManager.getInstance().getUserDao();
		UserForm user = new UserForm();
		user.setFirst_name(req.queryParams("first_name"));
		user.setLast_name(req.queryParams("last_name"));
		user.setEmail(req.queryParams("email"));
		user.setRole(Integer.parseInt(req.queryParams("role")));
		user.setMajor(req.queryParams("major"));
		user.setSchool_year(Integer.parseInt(req.queryParams("year")));
		user.setId(id);

		userDao.updateUser(user);

		
		req.attribute("error", "error");

		res.redirect(Application.ALLUSERS_PATH);
		return " ";

	}

	public String deleteUser(Request req, Response res) {
		String idString = req.params("id");
		long id = Long.parseLong(idString);
		UserDao userDao = DaoManager.getInstance().getUserDao();
		userDao.deleteUser(id);

		res.redirect(Application.ALLUSERS_PATH);
		return " ";

	}

}
