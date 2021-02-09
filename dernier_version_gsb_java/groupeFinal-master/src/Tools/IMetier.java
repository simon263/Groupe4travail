/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Exerce;
import Entity.Laboratoire;
import Entity.Region;
import Entity.Secteur;
import Entity.User;
import Entity.Visiteur;
import Entity.VisiteurBis;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface IMetier {
    public User GetUnUser(String login, String mdp);
    public ArrayList<Visiteur> GetAllVisiteur();
    public void InsererVisiteur(int num,String nom, String prenom,String Adresse, String Cp, String Ville,String date,int secteur,int labo,String image);
    public void ModifierVisiteur(int mat,String nom, String prenom,String Adresse, String Cp, String Ville,String date,int secteur,int labo,String image);
    public String rechercheVisiteur(String Nom);
    public ArrayList<Region> GetAllRegions();
    public void InsererRegions(int Region, int Code,String nom);
    public void ModifierRegions(int id,String nomRegion, int Code);
    public ArrayList<Laboratoire>getLesLaboratoires();
    public int getLabCode(String Nom);
    public int getSecCode(String nom);
    public ArrayList<Exerce> GetAllTravaille();
    public int GetLastMatricule();
    public ArrayList<Visiteur> nomCherche(String nom);
    public String getNomLabCode(int labcod);
    public  String getNomSecCode(int secCode);
    public int GetlastMatriculeRegion();
    public Region getRegionByNom(String unNom);
    public ArrayList<Secteur> getlesZones();
    public VisiteurBis getVisiteurById(int id);
    public ArrayList<Region> getRegionByIdVisiteur(int id);
    public void InsererExerce(int idVis, String date, int idReg, String role);
    
    
    
    
}
