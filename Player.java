/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_graphique;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Rama
 */
public class Player {
    
    private int x, y;
    
    private Image player;
    
    public Player(Coordonnees depart){
        
        ImageIcon img = new ImageIcon("player.gif");
        player =img.getImage();
        
        //donne aux joueurs les coordonées du départ du labyrinthe
        x=depart.getX();
        y=depart.getY();
    }
    
    public Image getPlayer(){
        return player;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void move(int _x, int _y){
        
        x+=_x;
        y+=_y;
        
    }
    
}
