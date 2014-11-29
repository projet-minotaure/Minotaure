/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_graphique;

import javax.swing.*;

/**
 *
 * @author Rama
 */
public class Maze {
    
    public static void main(String [] args){
        new Maze();
    }
    
    public Maze(){
        JFrame f = new JFrame();
        f.setTitle("Minotaure");
        f.add(new Plateau());
        f.setSize(464,485);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
