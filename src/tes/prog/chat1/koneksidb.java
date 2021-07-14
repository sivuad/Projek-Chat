/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes.prog.chat1;

/**
 *
 * @author sivu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksidb {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/prjkchat";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null, "koneksi berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "koneksi gagal");
        }
        return con;
    }
}
