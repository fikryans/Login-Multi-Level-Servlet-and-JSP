/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tutorialpedia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.tutorialpedia.model.UserModel;

/**
 *
 * @author TutorialPedia.NET
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proses=request.getParameter("proses");
        if (proses.equals("logout")){
            HttpSession sesi=request.getSession();
            sesi.invalidate();
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String proses = request.getParameter("proses");
         
        if (proses.equals("login")) {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String hak_akses=request.getParameter("hak_akses");
            String id=request.getParameter("id");
            if (pass == null || pass.equals("")) {   //validasi apabila field belum diisi
                response.sendRedirect("index.jsp");
            } else {
                UserModel pm = new UserModel();
                List<UserModel> datalogin = new ArrayList<UserModel>();

                datalogin = pm.LoginUser(user, pass);
                if (datalogin.isEmpty()) { //validasi apabila username dan password salah
                        response.sendRedirect("index.jsp");
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", datalogin.get(0).getUsername());
                    session.setAttribute("id", datalogin.get(0).getId());
                    session.setAttribute("hak_akses", datalogin.get(0).getHak_akses());
 
                    if (datalogin.get(0).getHak_akses().equals("Admin")) {
                        response.sendRedirect("admin.jsp"); // validasi login berdasarkan hak aksesnya
                    } 
                    if (datalogin.get(0).getHak_akses().equals("Pelanggan")){
                        response.sendRedirect("pelanggan.jsp");
                    }
                }
            }
        }
              
    }

}
