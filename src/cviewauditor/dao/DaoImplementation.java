/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.dao;

import cviewauditor.controller.PropertiesController;
import cviewauditor.model.AuditData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESA10969
 */
public class DaoImplementation implements ItfzDao {

    private String[] columns;
    
    @Override
    public ArrayList<AuditData> getAuditData() {
        //Variable definition
        Connection con;
        ArrayList<AuditData> dataList;
        Statement st;
        ResultSet rs;
        String statement;
        
        try {
            //Get Db Connection
            con = DbConnection.getConnection();
            
            if(con == null) {
                return null;
            }
            
            //Prepara and execute query
            st = con.createStatement();
            statement = getStatement();
            
            System.out.println(statement);
            
            if(statement != null) {
                rs = st.executeQuery(statement);
            } else {
                return null;
            }
            
            dataList = storeColumnsValues(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return dataList;
    }

    @Override
    public String getStatement() {
        //Variable definition
        String table;
        String statement = "SELECT ";
        String where;
        boolean fst = true;
        PropertiesController propsCtrl = new PropertiesController();
        
        //Load properties
        propsCtrl.loadPropertiesFile();

        //Get columns and table
        table   = propsCtrl.getProperty("table");
        columns = (propsCtrl.getProperty("columns")).split(",");
        where   = propsCtrl.getProperty("where");

        for (String column : columns) {
            if(!fst) {
                statement += ", ";
            }
            statement += column;
            fst = false;
        }
        statement += " FROM " + table;

        if(where != null && !where.equals("")) {
            statement += " WHERE " + where;
        }
        return statement;
    }
    
    public ArrayList<AuditData> storeColumnsValues(ResultSet rs) throws SQLException {
        //Variable definition
        AuditData dtaModel;
        ArrayList<AuditData> dataList = new ArrayList<AuditData>();
        
        //Retrieve audit data and store into AuditData bean
        while (rs.next()) {
            dtaModel = new AuditData();
            dtaModel.setPeticion(rs.getString(columns[0]));
            dtaModel.setUsuarioCod(rs.getString(columns[1]));
            
            if(columns.length >= 3) {
                dtaModel.setFecalt(rs.getString(columns[2]));
            } else {
                dtaModel.setFecalt(null);
            }
            if(columns.length >= 4) {
                dtaModel.setComent(rs.getString(columns[3]));
            } else {
                dtaModel.setComent(null);
            }
            if(columns.length >= 5) {
                dtaModel.setPkgcod(rs.getString(columns[4]));
            } else {
                dtaModel.setPkgcod(null);
            }
            if(columns.length >= 6) {
                dtaModel.setDatabase(rs.getString(columns[5]));
            } else {
                dtaModel.setDatabase(null);
            }
            if(columns.length >= 7) {
                dtaModel.setRefext(rs.getString(columns[6]));
            } else {
                dtaModel.setRefext(null);
            }
            if(columns.length >= 8) {
                dtaModel.setTiempo(rs.getString(columns[7]));
            } else {
                dtaModel.setTiempo(null);
            }
            dtaModel.setColumnNames(columns);
            dataList.add(dtaModel);
        }
        return dataList;
    }
}
