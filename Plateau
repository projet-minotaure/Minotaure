/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_graphique;

/**
 *
 * @author Rama
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;

public class Plateau extends JPanel implements ActionListener{
    
    private Timer timer; 
    
    private Carte c;
    private Player p;
    private String s;
    private int largeur=27;
    private int longueur=91;
    
    public Plateau(){
        
        Coordonnees depart=new Coordonnees (11,11);
	Coordonnees arrive=new Coordonnees (25,89);
	Carte c=new Carte(largeur,longueur,depart,arrive);        
        s=c.afficheLab();
        System.out.println(s);
        
        p=new Player(depart);
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25,this);
        timer.start();
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    public void paint (Graphics g){        
        int i;    
        super.paint(g);

        for (i=0; i<s.length(); i++){
            if(s.charAt(i)=='o'){
               // g.drawImage(c.getGround(), i*10, i*10, null);
            }
            if(s.charAt(i)=='#'){
                //g.drawImage(c.getWall(), i*10, i*10, null);
            }
        }
        
        //g.drawImage(p.getPlayer(), p.getX(),p.getY(), null);
    }
    
    public class Al extends KeyAdapter{
        
        public void keyPressed(KeyEvent e){
            int keycode=e.getKeyCode();
            //si on appuie sur la touche z
            if(keycode==KeyEvent.VK_Z){
                if(s.charAt(p.getX()-longueur)!='#'){
                    p.move(0, -10); //bouge de 10 y vers le haut (les images font 10 unités de côté
                }
            }
            //si on appuie sur la touche s
            if(keycode==KeyEvent.VK_S){
                if(s.charAt(p.getX()+longueur)!='#'){
                    p.move(0, 10);
                }
            }
            
            if(keycode==KeyEvent.VK_Q){
                if(s.charAt(p.getX()-1)!='#'){
                    p.move(-10, 0);
                }
            }
            
            if(keycode==KeyEvent.VK_D){
                if(s.charAt(p.getX()+1)!='#'){
                    p.move(10, 0);
                }
            }
            
        }
        
        public void keyReleased(KeyEvent e){
            
        }
        
        public void keyTyped(KeyEvent e){
            
        }
    }

    
}
