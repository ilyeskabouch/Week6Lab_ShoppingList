/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ilyes
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("action") != null && request.getParameter("action").equals("logout")){
            session.invalidate();
            session = request.getSession();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("action") != null && request.getParameter("action").equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
        }
        if (request.getParameter("action") != null && request.getParameter("action").equals("add")) {
            String item = request.getParameter("item");
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
            if (list != null) {
                list.add(item);
            } else {
                list = new ArrayList<>();
                list.add(item);
            }
            session.setAttribute("list", list);
        }
        if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
            String item = request.getParameter("choice");
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
            list.remove(item);
            session.setAttribute("list", list);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
