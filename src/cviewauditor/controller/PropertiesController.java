/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.controller;

import cviewauditor.Manager.PropertiesManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESA10969
 */
public class PropertiesController {
    private Properties props;
    
    public void loadPropertiesFile() {
        //Variable definition
        PropertiesManager propsMgr = new PropertiesManager();
        
        try {
            props = propsMgr.loadPropertiesFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
    public String getProperty(String propName) {
        //Variable definition
        PropertiesManager propsMgr = new PropertiesManager();
        
        return propsMgr.getProperty(props, propName);
    }
    
    public void storeProperties(String[] propsString) throws IOException {
        //Variable definition
        PropertiesManager propsMgr = new PropertiesManager();
        
        propsMgr.storeProperties(props, propsString);
    }
    
}
