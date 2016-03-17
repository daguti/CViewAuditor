/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.dao;

import cviewauditor.model.AuditData;
import java.util.ArrayList;

/**
 *
 * @author ESA10969
 */
public interface ItfzDao {
    
    public ArrayList<AuditData> getAuditData();
    public String getStatement();
}
