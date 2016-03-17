/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.Manager;

import cviewauditor.dao.DaoImplementation;
import cviewauditor.model.AuditData;
import cviewauditor.report.ReportCreator;
import java.util.ArrayList;

/**
 *
 * @author ESA10969
 */
public class AuditManager {
    public boolean createAuditReport(String path) {
        //Variable definition
        DaoImplementation dao = new DaoImplementation();
        ArrayList<AuditData> dataList;
        ReportCreator reporter = new ReportCreator();
        
        //Retrieve needed data
        dataList = dao.getAuditData();
        
        if(dataList == null) {
            return false;
        }
        //Create report with collected data
        return reporter.createReport(path, dataList);
    }
}
