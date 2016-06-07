/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Model.Mahasiswa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Michael Donny Kusuma
 */
@WebServlet(name = "UpdatePassword", urlPatterns = {"/UpdatePassword"})
public class UpdatePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManager db = new DatabaseManager();
        HttpSession session = request.getSession();
        Mahasiswa mhs = (Mahasiswa) session.getAttribute("mahasiswa");
        String pesan = null;
        String passLama = request.getParameter("passLama");
        String passBaru = request.getParameter("passBaru");
        
        if (passLama.compareTo(passBaru)==0) {
            pesan = "Password lama dan baru sama";
        }
        try{
            pesan = db.updatePassword(mhs, passLama, passBaru);
        }
        catch(Exception e){
            pesan = e.getMessage();
        }
        
        tampil(response, pesan);
    }
    
    void tampil(HttpServletResponse response, String pesan) throws IOException{
        response.setHeader("Refresh", "1; url=mahasiswa.jsp#setting");
        try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>ERROR</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>"+pesan+"</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    }
        
    }
}
