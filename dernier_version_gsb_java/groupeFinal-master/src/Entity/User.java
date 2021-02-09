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
public class User {
    
    private String nom_utili;
    private String MDP;
    
    
    
    public User( String unNom,String unId)
    {
        nom_utili = unNom;
        MDP = unId;
        
    }

    /**
     * @return the nom_utili
     */
    public String getNom_utili() {
        return nom_utili;
    }

    /**
     * @return the MDP
     */
    public String getMDP() {
        return MDP;
    }

    /**
     * @return the idUser
     */
   
}
