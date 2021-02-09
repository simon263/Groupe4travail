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
public class Visiteur {
    private String Matricule;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String CodP;
    private String ville;
    private String Date;
    private String secCode;
    private String labCode;
    private String image;
    
    public Visiteur(String mat,String nm ,String Pre,String Adrs,String CP,String Vil,String date,String Sect,String Lab,String img){
        Matricule= mat;
        Nom=nm;
        Prenom=Pre;
        Adresse=Adrs;
        CodP=CP;
        ville=Vil;
        Date=date;
        secCode=Sect;
        labCode=Lab;
        image = img;
        }

    /**
     * @return the Matricule
     */
    public String getMatricule() {
        return Matricule;
    }

    /**
     * @param Matricule the Matricule to set
     */
    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * @param Prenom the Prenom to set
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    /**
     * @return the Adresse
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @param Adresse the Adresse to set
     */
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    /**
     * @return the CodP
     */
    public String getCodP() {
        return CodP;
    }

    /**
     * @param CodP the CodP to set
     */
    public void setCodP(String CodP) {
        this.CodP = CodP;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the secCode
     */
    public String getSecCode() {
        return secCode;
    }

    /**
     * @param secCode the secCode to set
     */
    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    /**
     * @return the labCode
     */
    public String getLabCode() {
        return labCode;
    }

    /**
     * @param labCode the labCode to set
     */
    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }
    
}
