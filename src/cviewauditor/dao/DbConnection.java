/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.dao;

import cviewauditor.controller.PropertiesController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESA10969
 */
public class DbConnection {
    
    public static Connection getConnection() {
        //Variable definition
        String server;
        String sid;
        String user;
        String pass;
        String conUrl;
        int port;
        Connection con;
        PropertiesController propsCtrl = new PropertiesController();
        
        try {
            //Register the driver
            DriverManager.registerDriver (new oracle.jdbc.OracleDriver());

            //Load Properties file
            propsCtrl.loadPropertiesFile();
            
            //Get properties values
            server = propsCtrl.getProperty("server");
            sid    = propsCtrl.getProperty("sid");
            user   = propsCtrl.getProperty("user");
            pass   = propsCtrl.getProperty("pass");
            port   = Integer.valueOf(propsCtrl.getProperty("port"));
            
            //Compose Oracle connection URL
            conUrl = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
            
            //Get connection
            con = DriverManager.getConnection(conUrl, user, pass);
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error retrieving SQL Connection\n" + ex);
            return null;
        }
        
        return con;
    }
}
