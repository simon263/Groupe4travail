/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Visiteur;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class ModelVisiteur extends AbstractTableModel{
    
    private String[] nomsColonnes = {"numéro","nom","prénom","Adresse","code postal","ville","date","secteur","laboratoire"};
    private Vector<String[]> rows;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }
    
    public void loadDatas(ArrayList<Visiteur>lesVisiteurs )
    {
        rows = new Vector<>();
       nomsColonnes = new String[]{"numéro","nom","prénom","Adresse","code postal","ville","date","secteur","laboratoire"};
       for(Visiteur vis :lesVisiteurs ){
           rows.add(new String[]{vis.getMatricule(),vis.getNom(),vis.getPrenom(),vis.getAdresse(),vis.getCodP(),vis.getVille(),vis.getDate(),vis.getSecCode(),vis.getLabCode()});
       }
       fireTableDataChanged();
    }
    
    
}
