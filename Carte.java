/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_graphique;

import static Interface_graphique.MenuDemo.createImageIcon;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.*;
import java.util.*;

/**
 *
 * @author Rama
 */
public class Carte {
    
    
    private Image ground, wall;
        private boolean[][] lab;
	private Coordonnees depart;
	private Coordonnees arrive;
        static Random rnd = new Random ();
    
    public Carte(int largeur, int longueur, Coordonnees d, Coordonnees a){
        
        depart=d;
	arrive=a;
	boolean[][] lab2=new boolean[largeur][longueur] ;
	lab=lab2;
	for (int i=0;i<largeur;i++){
            for (int j=0;j<longueur;j++){
		lab[i][j]=false;
            }
	}
	lab[d.getX()][d.getY()]=true;
        
        ImageIcon img = createImageIcon ("ground.png");
        ground = img.getImage();
        img = createImageIcon ("wall.jpg");
        wall=img.getImage();
        
        genereLabParfait(d);
    }
    
    public String afficheLab(){
            String r=new String();
		for (int i=0;i<this.lab.length;i++){
			r=r+"\n";
			for (int j=0;j<this.lab[0].length;j++){
				if (i==this.depart.getX() && j==this.depart.getY())
					r=r+"D";
				else {
					if (i==this.arrive.getX() && j==this.arrive.getY())
						r=r+"A";
					else {
						if (this.lab[i][j])
							r=r+"o";
						else
							r=r+"#";
					}
				}

			}
		}
                return r;
	}
    
    public void ouvrir (int x, int y){
		// passe la case de coordonnéés x et y à true
		this.lab[x][y]=true;
	}
	
	public boolean estValide(Coordonnees c){
		//renvoi true si la case de coordonnées passées en paramètre est valide (dans le lab)
		return (c.getX()>0 && c.getY()>0 && c.getX()<this.lab.length-1 && c.getY()<this.lab[1].length-1);
	}
	
	public Coordonnees deplacement (int random, Coordonnees caseCourante){
		//déplace la case courante vers une case situé soit au nord,sud,est ou ouest puis la renvoi
		switch (random){
			case 1:
				Coordonnees caseSuivante = new Coordonnees(caseCourante.getX()+1,caseCourante.getY());
				return caseSuivante;
			case 2:
				Coordonnees caseSuivante1 = new Coordonnees(caseCourante.getX()-1,caseCourante.getY());
				return caseSuivante1;
			case 3:
				Coordonnees caseSuivante2 = new Coordonnees(caseCourante.getX(),caseCourante.getY()-1);
				return caseSuivante2;
			case 0:
				Coordonnees caseSuivante3 = new Coordonnees(caseCourante.getX(),caseCourante.getY()+1);
				return caseSuivante3;
		}
		return null;
	}
        
	
	public void genereLabParfait (Coordonnees c){
		//ouverture des chemins
	    boolean choix[] = {false, false, false, false};
	    // tableau marquant les directions déja exploités
	    // Exclut la direction choisie des itérations ultérieures
	    int i,j;
		for (i=0; i<4; i++) {
		    for (j = (int)(rnd.nextDouble () * 4); choix[j%4]; j++);
		    // les deux for ont pour but de choisir succéssivement nord,sud,est ou ouest mais de façon "aléatoire"
		    // Exclut la direction choisie des itérations ultérieures
		    choix[j%4] = true;
	    	    // Calcule les coordonnées de la case dans la direction choisie
	    	    Coordonnees c1 = deplacement(j%4,c);
	    	    Coordonnees c2 = deplacement(j%4,c1);
	    	    //on se déplace de 2 cases à la fois
	    if (this.estValide (c2)){
	    	if (this.lab[c2.getX()][c2.getY()]==false) { // si c2 n'est pas ouvert on l'ouvre avec c1
	    		this.ouvrir(c1.getX(),c1.getY());
	    		    // Libère le passage vers cette case
	    		this.ouvrir(c2.getX(),c2.getY());
	    		    // Poursuit la construction depuis c2
	    		this.genereLabParfait (c2);
	    	}
	    }
	}
    }

    
    public Image getGround(){
        return ground;
    }
	
    public Image getWall(){
        return wall;
    }
}
