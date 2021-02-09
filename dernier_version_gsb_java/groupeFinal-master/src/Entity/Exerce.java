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
public class Exerce {
    private int matri;
    private String Periode;
    private int codReg;
    private String travCod;
    
    public Exerce(int mat,String Per,int Reg,String role){
        matri=mat;
        Periode=Per;
        codReg=Reg;
        travCod=role;
        
    }

    /**
     * @return the matri
     */
    public int getMatri() {
        return matri;
    }

    /**
     * @return the Periode
     */
    public String getPeriode() {
        return Periode;
    }

    /**
     * @return the codReg
     */
    public int getCodReg() {
        return codReg;
    }

    /**
     * @return the travCod
     */
    public String getTravCod() {
        return travCod;
    }
}
