/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.controller;

import cviewauditor.Manager.AuditManager;

/**
 *
 * @author ESA10969
 */
public class AuditController {
    
    public boolean createAuditReport(String path) {
        //Variable definition
        AuditManager mgr = new AuditManager();
        
        //Call hole process
        return mgr.createAuditReport(path);
    }
}
