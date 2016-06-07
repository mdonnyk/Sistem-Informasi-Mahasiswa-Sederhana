package controller;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
DatabaseManager m = new DatabaseManager();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = null;       
        Mahasiswa mahasiswa = null;
        Admin admin = null;
        String nim = request.getParameter("nim");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        
        try{
            Integer.parseInt(nim); // Cek apakah angka atau ada huruf
            try{ // Kalau nim angka semua masuk ke blok try
            mahasiswa = m.login(nim, pass); // ngecek nim dan password ada di database
            }
            catch(Exception e){
                 String ex = e.getMessage();
                 tampil(response, ex);               
            }           
            session.setAttribute("mahasiswa", mahasiswa); // Session diisi obyek mahasiswa
            dispatcher = request.getRequestDispatcher("mahasiswa.jsp");
        }
        catch (Exception intError){
            // kalau ada huruf masuk ke catch
            try{
            admin = m.loginAdmin(nim, pass);
            }
            catch(Exception e){
                 String ex = e.getMessage();
                 tampil(response, ex);
                 
            }       
            session.setAttribute("admin", admin);
            dispatcher = request.getRequestDispatcher("admin.jsp");
        }
        
        
        dispatcher.forward(request, response);   
        
    }
    
    void tampil(HttpServletResponse response, String pesan) throws IOException{
        response.setHeader("Refresh", "1; url=index.jsp");
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
