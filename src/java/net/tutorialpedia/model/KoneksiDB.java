/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tutorialpedia.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author TutorialPedia.NET
 */
public class KoneksiDB {
    private Connection conn;
    private Statement st;
 
    public static void ambilKoneksi() {
        try {
            String db = "jdbc:mysql://localhost:3306/latihan_loginMulti";
            String user = "root";
            String pass = "jogj4k4rt4"; //dikosongkan hjika tidak ada password pada mysql anda
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db, user, pass);
        } catch (Exception x) {
            System.out.println("Terjadi kesalahan ambil koneksi : " + x);
        }
    }
 
    public void koneksi() {
        try {
            String db = "jdbc:mysql://localhost:3306/latihan_loginMulti";
            String user = "root";
            String pass = "jogj4k4rt4"; //dikosongkan hjika tidak ada password pada mysql anda
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db, user, pass);
            st = conn.createStatement();
        } catch (Exception x) {
 
            System.out.println("Terjadi kesalahan koneksi : " + x);
        }
    }
 
    public void diskonek(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            st.close();
            conn.close();
        } catch (Exception x) {
            System.out.println("Terjadi kesalahan diskoneksi : " + x);
        }
    }
 
    public ResultSet ambilData(String sql) {
        ResultSet rs = null;
        try {
            koneksi();
            rs = st.executeQuery(sql);
        } catch (Exception x) {
            System.out.println("Terjadi kesalahan ambil data : " + x);
        }
        return rs;
    }
 
}
