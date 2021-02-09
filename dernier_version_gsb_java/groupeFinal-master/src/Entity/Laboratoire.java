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
public class Laboratoire {
    private int Code;
    private String nom;
    private String chef;
    
    public Laboratoire(int cd,String nm ,String cf){
        Code =cd;
        nom= nm;
        chef=cf;
    }

    /**
     * @return the Code
     */
    public int getCode() {
        return Code;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the chef
     */
    public String getChef() {
        return chef;
    }
    
    
    
    
    
}
