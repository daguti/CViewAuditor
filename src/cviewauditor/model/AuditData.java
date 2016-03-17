/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cviewauditor.model;

/**
 *
 * @author ESA10969
 */
public class AuditData {
    // All data will be saved into unique variable separated by comma
    String[]          columnNames;
    String            peticion;                                    
    String            usuarioCod;                                       
    String            fecalt;                                           
    String            coment;                                          
    String            pkgcod;                                             
    String            database;                                      
    String            refext;                                          
    String            tiempo;   
    
    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }

    public String getUsuarioCod() {
        return usuarioCod;
    }

    public void setUsuarioCod(String usuarioCod) {
        this.usuarioCod = usuarioCod;
    }

    public String getFecalt() {
        return fecalt;
    }

    public void setFecalt(String fecalt) {
        this.fecalt = fecalt;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getPkgcod() {
        return pkgcod;
    }

    public void setPkgcod(String pkgcod) {
        this.pkgcod = pkgcod;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getRefext() {
        return refext;
    }

    public void setRefext(String refext) {
        this.refext = refext;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
