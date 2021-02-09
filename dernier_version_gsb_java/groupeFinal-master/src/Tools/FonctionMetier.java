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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class FonctionMetier  implements IMetier {

    @Override
    public User GetUnUser(String login, String mdp)
            
    {
            User  user = null;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select nom_utilisateur , mots_de_passe from utilisateur  where nom_utilisateur ='"+login+"'and mots_de_passe ='"+mdp+"'");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();     
            rs.next();
            user =  new User(rs.getString("nom_utilisateur"),rs.getString("mots_de_passe"));
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user ;
    }

    @Override
    public ArrayList<Visiteur> GetAllVisiteur() {
            ArrayList<Visiteur>mesVisiteurs = new ArrayList<>();
        try {
            
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select * from visiteur");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Visiteur v = new Visiteur(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                mesVisiteurs.add(v);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesVisiteurs;
    }

    @Override
    public ArrayList<Region> GetAllRegions() {
          ArrayList<Region> mesRegion= new ArrayList<>();
        try {
            Connection cnx= ConnexionBDD.getCnx();
            PreparedStatement stm=cnx.prepareStatement("select * from region");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               Region uneRegions= new Region(rs.getInt(1), rs.getInt(2), rs.getString(3));
               mesRegion.add(uneRegions);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesRegion;
    }

    @Override
    public void InsererRegions(int Region, int Code, String nom) {
       try {
            Connection cnx= ConnexionBDD.getCnx();
            PreparedStatement stm=cnx.prepareStatement("insert into region values ("+Region+",'"+Code+"','"+nom+"')");
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @Override
    public void ModifierRegions(int id, String nomRegion, int Code) {
    try {
            Connection cnx= ConnexionBDD.getCnx();
            PreparedStatement stm=cnx.prepareStatement("update region set rg_nom='"+nomRegion+"', sc_code="+Code+" where rg_code="+id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    @Override
    public int GetLastMatricule() {
            int numMat=0;
        try {
            
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select max(V_matricule) from visiteur");
            rs = stm.executeQuery();
            rs.next();
            numMat = rs.getInt(1)+1;
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
            return numMat;
    }

    @Override
    public ArrayList<Secteur> getlesZones() {
        ArrayList<Secteur>mesZones = new ArrayList<>();
        try {
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select sc_code,sc_libelle from zone");
            rs = stm.executeQuery();
            while(rs.next()){
                Secteur s = new Secteur(rs.getInt(1),rs.getString(2));
                mesZones.add(s);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesZones;
    }

    @Override
    public ArrayList<Laboratoire> getLesLaboratoires() {
        
            ArrayList<Laboratoire>mesLaboratoires = new ArrayList<>();
        try {
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select lb_code,lb_nom,lb_chefvente from labo");
            rs = stm.executeQuery();
            while(rs.next()){
                Laboratoire L = new Laboratoire(rs.getInt(1),rs.getString(2),rs.getString(3));
                mesLaboratoires.add(L);
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesLaboratoires;
    }
       
     public int getLabCode(String Nom) {
        int numero = 0;
        try {
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select lb_code from labo where lb_nom ='"+Nom+"'");
            rs = stm.executeQuery();
            rs.next();
            numero = rs.getInt(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          return numero; 
    }

    @Override
    public int getSecCode(String nom) {
            int numero = 0;
        try {
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select sc_code from zone where sc_libelle ='"+nom+"'");
            rs = stm.executeQuery();
            rs.next();
            numero = rs.getInt(1);
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero; 
    }


    public ArrayList<Exerce> GetAllTravaille() {
        ArrayList<Exerce>mesExerces = new ArrayList<>();
        try {
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select V_matricule,jjmmaa,rg_code,role from exerce");
            rs = stm.executeQuery();
            while(rs.next()){
                Exerce E = new Exerce(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
                mesExerces.add(E);
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesExerces;
    }

    @Override
    public void InsererVisiteur(int num, String nom, String prenom, String Adresse, String Cp, String Ville, String date, int secteur, int labo,String image) {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into visiteur values ("+num+",'"+nom+"','"+prenom+"','"+Adresse+"','"+Cp+"','"+Ville+"','"+date+"',"+secteur+","+labo+",'"+image+"')");
             ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ModifierVisiteur(int mat,String nom, String prenom, String Adresse, String Cp, String Ville, String date, int secteur, int labo,String image) {
        try {
            PreparedStatement stm;
            Connection cnx = ConnexionBDD.getCnx();
            stm =cnx.prepareStatement("UPDATE gsbgroupe.visiteur SET V_nom= '"+nom+"', V_prenom ='"+prenom+"', V_adresse ='"+ Adresse+"', V_cp='" +Cp+"', V_ville = '"+Ville+"', V_dateembauche ='"+date+"', sc_code = "+secteur+", lb_code =" +labo+",image ='"+image+"' where V_matricule ="+mat+"" );
            
            System.out.println("le UPDATE  a réussi.");
            stm.executeUpdate();
            stm.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String rechercheVisiteur(String Nom) {
            String nom ="";
        try {
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select V_nom from visiteur where V_nom='"+Nom+"'");
            rs = stm.executeQuery();
            rs.next();
            nom = rs.getString(1);
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return nom;
    }


    @Override
    public ArrayList<Visiteur> nomCherche(String nom) {
            ArrayList<Visiteur>monVisiteurs = new ArrayList<>();
        try {
            
            
            
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select * from visiteur where V_nom='"+nom+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Visiteur v = new Visiteur(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                monVisiteurs.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return monVisiteurs;
    }

    @Override
    public String getNomLabCode(int labcod) {
        String labo="";
        try {
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select lb_nom from labo where lb_code ="+labcod+"");
            rs = stm.executeQuery();
            rs.next();
            labo = rs.getString("lb_nom");
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
            return labo;
    }

    @Override
    public String getNomSecCode(int secCode) {
        String codi="";
        try {
            
            PreparedStatement stm;
            ResultSet rs;
            Connection Cnx = ConnexionBDD.getCnx();
            stm = Cnx.prepareStatement("select sc_libelle from zone where sc_code ="+secCode+"");
            
            rs = stm.executeQuery();
            rs.next();
            codi = rs.getString("sc_libelle");
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
            return codi;
    }

   

    @Override
    public int GetlastMatriculeRegion() {
      int unMat = 0;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement stm;
            stm = cnx.prepareStatement("select max(rg_code) from region");
            ResultSet rs=stm.executeQuery();
            rs.next();
            unMat=rs.getInt(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unMat  ;     
    }

    @Override
    public Region getRegionByNom(String unNom) {
              Region uneRegion = null;
        try {
            Connection cnx= ConnexionBDD.getCnx();
            PreparedStatement stm=cnx.prepareStatement("select * from region where rg_nom='"+unNom+"'");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
              uneRegion= new Region(rs.getInt(1), rs.getInt(2), rs.getString(3));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uneRegion;
    }

    @Override
    public VisiteurBis getVisiteurById(int id) {
        VisiteurBis unVisiteur = null;
        try {
            Connection cnx= ConnexionBDD.getCnx();
            PreparedStatement stm=cnx.prepareStatement("select * from visiteur where V_matricule="+id);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
              unVisiteur= new VisiteurBis(rs.getInt(1), rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unVisiteur;
    }

    @Override
    public ArrayList<Region> getRegionByIdVisiteur(int id) {
        ArrayList<Region> mesRegion= new ArrayList<>();
        try {
            Connection cnx= ConnexionBDD.getCnx();
            PreparedStatement stm=cnx.prepareStatement("select region.* from region, exerce where region.rg_code=exerce.rg_code and exerce.V_matricule="+id);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               Region uneRegions= new Region(rs.getInt(1), rs.getInt(2), rs.getString(3));
               mesRegion.add(uneRegions);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesRegion;
    }

    @Override
    public void InsererExerce(int idVis, String date, int idReg, String role) {
         try {
            Connection cnx= ConnexionBDD.getCnx();
            PreparedStatement stm=cnx.prepareStatement("insert into exerce values ("+idVis+",'"+date+"',"+idReg+",'"+role+"')");
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
                
}
