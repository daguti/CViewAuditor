/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESA10969
 */
public class PropertiesManager {
    public Properties loadPropertiesFile() throws FileNotFoundException {
        //Variable definition
        InputStream inputStream;
        File propFile;
        Properties properties   = new Properties();
        
        try {
            //Load properties
            propFile = getPropertyFile();
            inputStream = new FileInputStream(propFile);
            properties.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("A problem occur attempting to retrieving InputStream");
        }
        return properties;
    }
    
    public String getProperty(Properties props, String propName) {
        return props.getProperty(propName);
    }
    
    /**
     * 
     * @param props
     * @param propsString Properties. 0: Server
     *                                1: SID
     *                                2: Port
     *                                3: User
     *                                4: Pass
     *                                5: Columns
     *                                6: Table
     *                                7: Where
     * @throws java.io.FileNotFoundException
     */
    public void storeProperties(Properties props, String[] propsString) throws FileNotFoundException, IOException {
        //Variable definition
        File f = getPropertyFile();
        OutputStream out;
        
        props.setProperty("server",  propsString[0]);
        props.setProperty("sid",     propsString[1]);
        props.setProperty("port",    propsString[2]);
        props.setProperty("user",    propsString[3]);
        props.setProperty("pass",    propsString[4]);
        props.setProperty("columns", propsString[5]);
        props.setProperty("table",   propsString[6]);
        props.setProperty("where",   propsString[7]);

        out = new FileOutputStream( f );
        props.store(out, "CViewAuditor Configuration");
    }
    
    public File getPropertyFile() {
        //Variable definition
        String propPath;
        
        propPath = this.getClass().getResource("/resources/").toString();
        propPath = propPath.substring(propPath.indexOf("C") - 1, propPath.indexOf("CViewAuditor") + 13) + "conf/app.properties";
        
        return new File(propPath);
    }
}
