/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session  = request.getSession();
        try {      
            session.removeAttribute("mahasiswa");
            session.invalidate();                               
            String pageToForward = request.getContextPath() + "/index.jsp";
            response.sendRedirect(pageToForward);
        }
        catch (Exception sqle) {
            System.out.println("error UserValidateServlet message : " + 
                    sqle.getMessage());
            System.out.println("error UserValidateServlet exception : " + 
                     sqle);
       }
    }
}
