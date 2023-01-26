package project.controller;

import org.json.simple.parser.ParseException;
import project.model.CocktailDetails;
import project.model.repository.ConnectionDetails;
import project.view.CocktailDetailsPanel;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

public class MouseCocktail implements MouseListener {
    private  String id;

    public MouseCocktail(String id){
        this.id=id;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ConnectionDetails bla=new ConnectionDetails();
        try {
            List<CocktailDetails> temp = bla.getCocktailDetails(id);
            CocktailDetailsPanel details=new CocktailDetailsPanel(temp,id);
            details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            details.setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
