package edu.ben.rate_review.controller.user;

//import static spark.Spark.get;

import java.util.HashMap;
import java.util.List;

import edu.ben.rate_review.app.Application;
import edu.ben.rate_review.authorization.AuthException;
import edu.ben.rate_review.daos.AnnouncementDao;
import edu.ben.rate_review.daos.DaoManager;
import edu.ben.rate_review.daos.UserDao;
import edu.ben.rate_review.models.Announcement;
import edu.ben.rate_review.models.MassEditForm;
//import edu.ben.rate_review.models.RecoveringUser;
import edu.ben.rate_review.models.User;
import edu.ben.rate_review.models.UserForm;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import static spark.Spark.halt;
//import spark.Spark;
//import spark.template.handlebars.HandlebarsTemplateEngine;

public class EditUserController {

    public static ModelAndView showEditUserPage(Request req, Response res) throws AuthException {
        // Just a hash to pass data from the servlet to the page
        HashMap<String, Object> model = new HashMap<>();
        Session session = req.session();
        if (session.attribute("current_user") == null) {
            // return new ModelAndView(model, "home/notauthorized.hbs");
            res.redirect(Application.AUTHORIZATIONERROR_PATH);
            halt();
        } else {
            User us = (User) session.attribute("current_user");

            if (us.getRole() != 1) {
                // return new ModelAndView(model, "home/notauthorized.hbs");
                res.redirect(Application.AUTHORIZATIONERROR_PATH);
                halt();
            } else {
                model.put("user_admin", true);
            }
        }

        // Get the :id from the url
        String idString = req.params("id");

        // Convert to Long
        // /user/uh-oh/edit for example
        long id = Long.parseLong(idString);

        UserDao user = DaoManager.getInstance().getUserDao();
        // Get user if ID is valid
        User u = user.findById(id);
        boolean role_flag = true;

        if (u.getRole() == 1 || u.getRole() == 2) {
            role_flag = false;
        }
        model.put("role_flag", role_flag);

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

    public static ModelAndView massEditConfirmed(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();

        UserDao userDao = DaoManager.getInstance().getUserDao();

        MassEditForm massedit = new MassEditForm();
        massedit.setBefore(Integer.parseInt(req.queryParams("confirmedbefore")));
        massedit.setAfter(Integer.parseInt(req.queryParams("confirmedafter")));
        userDao.massEditConfirmed(massedit);

        model.put("error", "You mass updated the email confirmation status of all users");

        // DaoManager dao = DaoManager.getInstance();
        // UserDao ud = dao.getUserDao();
        List<User> users = userDao.sortbyRole();
        model.put("users", users);

        DaoManager adao = DaoManager.getInstance();
        AnnouncementDao ad = adao.getAnnouncementDao();
        List<Announcement> announcements = ad.all();
        model.put("announcements", announcements);

        return new ModelAndView(model, "users/allusers.hbs");

    }

    public static ModelAndView massEditYear(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();

        UserDao ud = DaoManager.getInstance().getUserDao();

        MassEditForm massedit = new MassEditForm();
        massedit.setBefore(Integer.parseInt(req.queryParams("yearbefore")));
        massedit.setAfter(Integer.parseInt(req.queryParams("yearafter")));
        ud.massEditYear(massedit);

        model.put("error", "You mass updated the school year of all users");

        List<User> users = ud.sortbyRole();
        model.put("users", users);

        AnnouncementDao ad = DaoManager.getInstance().getAnnouncementDao();
        List<Announcement> announcements = ad.all();
        model.put("announcements", announcements);

        return new ModelAndView(model, "users/allusers.hbs");

    }

    public static ModelAndView massEditRole(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();

        UserDao ud = DaoManager.getInstance().getUserDao();

        MassEditForm massedit = new MassEditForm();
        massedit.setBefore(Integer.parseInt(req.queryParams("rolebefore")));
        massedit.setAfter(Integer.parseInt(req.queryParams("roleafter")));
        ud.massEditRole(massedit);

        model.put("error", "You mass updated the role of all users");

        List<User> users = ud.sortbyRole();
        model.put("users", users);

        DaoManager adao = DaoManager.getInstance();
        AnnouncementDao ad = adao.getAnnouncementDao();
        List<Announcement> announcements = ad.all();
        model.put("announcements", announcements);

        return new ModelAndView(model, "users/allusers.hbs");

    }

    public static ModelAndView massEditActive(Request req, Response res) {

        HashMap<String, Object> model = new HashMap<>();

        UserDao ud = DaoManager.getInstance().getUserDao();

        MassEditForm massedit = new MassEditForm();
        massedit.setBefore(Integer.parseInt(req.queryParams("activebefore")));
        massedit.setAfter(Integer.parseInt(req.queryParams("activeafter")));
        ud.massEditActive(massedit);

        model.put("error", "You mass updated the account status of all users");

        List<User> users = ud.sortbyRole();
        model.put("users", users);

        DaoManager adao = DaoManager.getInstance();
        AnnouncementDao ad = adao.getAnnouncementDao();
        List<Announcement> announcements = ad.all();
        model.put("announcements", announcements);

        return new ModelAndView(model, "users/allusers.hbs");

    }

    public static ModelAndView updateUser(Request req, Response res) throws AuthException {
        HashMap<String, Object> model = new HashMap<>();

        String idString = req.params("id");
        long id = Long.parseLong(idString);
        UserDao ud = DaoManager.getInstance().getUserDao();
        UserForm user = new UserForm();
        user.setFirst_name(req.queryParams("first_name"));
        user.setLast_name(req.queryParams("last_name"));
        user.setEmail(req.queryParams("email"));
        user.setRole(Integer.parseInt(req.queryParams("role")));
        user.setMajor(req.queryParams("major"));
        user.setSchool_year(Integer.parseInt(req.queryParams("year")));
        user.setId(id);
        ud.updateUser(user);

        // Get user if ID is valid
        User u = ud.findById(id);

        model.put("error", "You updated " + user.getFirst_name() + " " + user.getLast_name() + "'s account");

        // create the form object, put it into request
        model.put("user_form", new UserForm(u));

        DaoManager adao = DaoManager.getInstance();
        AnnouncementDao ad = adao.getAnnouncementDao();
        List<Announcement> announcements = ad.all();
        model.put("announcements", announcements);
        
    	List<User> users = ud.sortbyRole();
		model.put("users", users);

        return new ModelAndView(model, "users/allusers.hbs");

    }

    public static String deleteUser(Request req, Response res) {
        String idString = req.params("id");
        long id = Long.parseLong(idString);
        UserDao userDao = DaoManager.getInstance().getUserDao();
        userDao.deleteUser(id);

        res.redirect(Application.ALLUSERS_PATH);
        halt();
        return " ";

    }

}
