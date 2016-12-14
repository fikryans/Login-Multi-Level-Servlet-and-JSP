/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tutorialpedia.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TutorialPedia.NET
 */
public class UserModel {
    String id,username,password,hak_akses;
    KoneksiDB db= null;
    
    public UserModel(){
        db =new KoneksiDB();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHak_akses() {
        return hak_akses;
    }

    public void setHak_akses(String hak_akses) {
        this.hak_akses = hak_akses;
    }
        public List LoginUser(String user, String password) {
        List data = new ArrayList();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM USER where username='" + user + "' and password='" + password + "'";
            rs = db.ambilData(sql);
 
            while (rs.next()) {
                UserModel am = new UserModel();
                am.setId(rs.getString("id"));
                am.setUsername(rs.getString("username"));               
                am.setPassword(rs.getString("password"));
                am.setHak_akses(rs.getString("hak_akses"));
                data.add(am);
            }
            db.diskonek(rs);
        } catch (Exception a) {
            System.out.println("Terjadi kesalahaan cari login user, pada :\n" + a);
        }
        return data;
    }
}
