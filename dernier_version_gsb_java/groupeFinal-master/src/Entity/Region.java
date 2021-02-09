/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author PC
 */
public class Region {
    private int codReg;
    private int secReg;
    private String regNom;
    
    public Region(int reg,int sec,String nom){
        codReg=reg;
        secReg=sec;
        regNom=nom;
     
        
    }

    /**
     * @return the codReg
     */
    public int getCodReg() {
        return codReg;
    }

    /**
     * @return the secReg
     */
    public int getSecReg() {
        return secReg;
    }

    /**
     * @return the regNom
     */
    public String getRegNom() {
        return regNom;
    }
    
    
}
