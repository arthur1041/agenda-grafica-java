/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peoo.persistencia;

import br.edu.ifrn.peoo.modelo.Pessoa;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur Cruz
 */
public class Persistencia {
     public static void convertListToXML(List<Pessoa> list) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("./pessoas.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(list);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static List<Pessoa> getListFromXML(){
        List<Pessoa> listaPessoas = null;
        try {
            FileInputStream fis = new FileInputStream(new File("./pessoas.xml"));
            XMLDecoder decoder = new XMLDecoder(fis);
            listaPessoas = (ArrayList<Pessoa>) decoder.readObject();
            decoder.close();
            fis.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaPessoas;
    }
}
