package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("username") != null) {
            response.sendRedirect("/register");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // TODO: ensure the submitted information is valid
        if ((username.isEmpty()) || email.isEmpty() || password.isEmpty()) {
            request.getRequestDispatcher("/WEB-INF/register.jsp");

        } else {
            User user = new User(
                    username,
                    email,
                    password);
            DaoFactory.getUsersDao().insert(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        }
        // TODO: create a new user based off of the submitted information

        // TODO: if a user was successfully created, send them to their profile
    }
}
