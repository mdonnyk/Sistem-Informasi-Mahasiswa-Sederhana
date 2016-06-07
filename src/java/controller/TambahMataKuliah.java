package controller;

import Model.Mahasiswa;
import Model.MataKuliah;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TambahMataKuliah", urlPatterns = {"/TambahMataKuliah"})
public class TambahMataKuliah extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManager db = new DatabaseManager();
        HttpSession session = request.getSession();
        Mahasiswa mahasiswa = (Mahasiswa) session.getAttribute("mahasiswa");
        MataKuliah m[] = db.showMataKuliah(mahasiswa.getNim());
        boolean sudahAda = false;
        String status;
        String kode = request.getParameter("kode");
        int sks = Integer.parseInt(request.getParameter("sks"));
        for (int i = 0; i < m.length; i++) {
            if (m[i].getKode().compareToIgnoreCase(kode)==0) {
                sudahAda = true;                
            }
        }
        if (sudahAda) {
            status = "sudah diambil";
        }
        else{
            status = "ditambahkan";
            db.tambahMakul(mahasiswa.getNim(), kode, sks);
        }
        response.setHeader("Refresh", "1; url=mahasiswa.jsp#pilihMakul");
        try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Information</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Mata Kuliah "+status+"</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
