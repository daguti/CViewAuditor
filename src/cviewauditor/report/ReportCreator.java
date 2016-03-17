/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.report;

import cviewauditor.model.AuditData;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author ESA10969
 */
public class ReportCreator {
    
    public boolean createReport(String path, ArrayList<AuditData> dataList) {
        //Variable definition
        JasperPrint jsPrint;
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        String filePath;
        
        try {            
            filePath = this.getClass().getResource("/resources/").toString();
            filePath = filePath.substring(filePath.indexOf("C") - 1, filePath.indexOf("CViewAuditor") + 13) + "build/classes/resources/";            
            JasperCompileManager.compileReportToFile(filePath.substring(filePath.indexOf("C") - 1) + "AuditReport.jrxml");
            jsPrint = JasperFillManager.fillReport(filePath.substring(filePath.indexOf("C") - 1) + "AuditReport.jasper",
                                                   retrieveParameters(dataList.get(0)), 
                                                   beanColDataSource);
            JasperExportManager.exportReportToPdfFile(jsPrint, path + "AuditReport.pdf");
        } catch (JRException ex) {
            Logger.getLogger(ReportCreator.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public Map<String, Object> retrieveParameters(AuditData data) {
        //Variable definition
        Map<String, Object> parameters = new HashMap<String, Object>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        int i = 1;
                
        for(String colName : data.getColumnNames()) {
             parameters.put("col" + i, colName);
             i++;
        }
        parameters.put("fecha", formatter.format(new Date(System.currentTimeMillis())));
        
        return parameters;
    }
}
