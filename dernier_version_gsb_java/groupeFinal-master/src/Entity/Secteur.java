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
public class Secteur {
    
    private int sc_Code;
    private String sc_Libel;
    
    public Secteur(int Cd,String Libel){
        sc_Code = Cd;
        sc_Libel= Libel;
        
    }

    /**
     * @return the sc_Code
     */
    public int getSc_Code() {
        return sc_Code;
    }

    /**
     * @return the sc_Libel
     */
    public String getSc_Libel() {
        return sc_Libel;
    }
    
}
