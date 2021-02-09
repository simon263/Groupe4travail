/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Region;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class ModelRegion extends AbstractTableModel{
    private String[] nomsColonnes = {"Region","Secteur","Nom"};
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
    
    public void loadDatas(ArrayList<Region> lesRegions)
    {
        rows = new Vector<>();
       nomsColonnes = new String[]{"Region","Secteur","nom"};
       for(Region reg :lesRegions ){
           rows.add(new String[]{String.valueOf(reg.getCodReg()),String.valueOf(reg.getSecReg()),reg.getRegNom()});
       }
       fireTableDataChanged();
    }
    
    public void loadDatas2(ArrayList<Region> lesRegions)
    {
        rows = new Vector<>();
       nomsColonnes = new String[]{"Region"};
       for(Region reg :lesRegions ){
           rows.add(new String[]{reg.getRegNom()});
       }
       fireTableDataChanged();
    }
    
}
