/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Model.Mahasiswa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "HapusMataKuliah", urlPatterns = {"/HapusMataKuliah"})
public class HapusMataKuliah extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManager db = new DatabaseManager();
        HttpSession session = request.getSession();
        Mahasiswa mahasiswa = (Mahasiswa) session.getAttribute("mahasiswa");
        String nim = mahasiswa.getNim();
        String kode = request.getParameter("kode");
        int sks = Integer.parseInt(request.getParameter("sks"));
        String status = null;
        try {
            status = db.hapusMakul(nim, kode, sks);
        } catch (Exception ex) {
            status = ex.getMessage();
        }
        response.setHeader("Refresh", "1; url=mahasiswa.jsp#showMakul");
        try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Information</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Mata Kuliah sudah dihapus</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    }
        
    }

}
