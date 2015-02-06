package fr.enac.aero.airportPackage;

import java.awt.*;
import java.util.*;

import javax.swing.JComponent;

import fr.enac.aero.display.CanvasAirportFix;

/**
 * Cette classe contient les informations concernant un Runway
 * Elle contient des methodes 
 *  
 * @author Karim
 *
 */

public class TaxiWay extends ObjectAirport {
	

	/* ---- Attributs : ---- */
	
	//  name : le nom du point
	private String name;
	
	/**
	 * id  :  l'identifiant unique du taxiway, cree a partir de son ordre de recuperation
	 */
	private String id;
	
	//Velocity: vitesse
	private int velocity;

	//Caterogie M, H, L
	private EnumTypeCat category;
	
	//Direction S, D
	private EnumTypeDir direction;
	
	//Liste des points constituant ce TaxyWay
	private ArrayList<Point> listPoint = new ArrayList<Point>();
	
	
	static int cpt =0;
	private int rayon=2;
	/* ---- ---- */
	
	
	/* ---- Constucteurs : ---- */
	
/**
 * Constructeur d'un TaxyWay, cree sans parametres
 */
	public TaxiWay(Airport apt){
		this(apt,"inconnu",0, EnumTypeCat.L,EnumTypeDir.S);
		
		
	}
	
	/**
	 * Constructeur d'un TaxyWay avec paramètres
	 * @param nom
	 * @param vitesse
	 * @param catégorie
	 * @param direction
	 */
		public TaxiWay (Airport apt,String name, int v, EnumTypeCat cat, EnumTypeDir dir)
				
			{super(apt);
				cpt++;
				this.id="T"+cpt;
				this.name=name;
				this.velocity=v;
				this.category=cat;
				this.direction=dir;
			  }
			
		
		/* ---- requetes ---- */

		public String getId(){
			return id;
		}
		
		/**
		 * Methode qui renvoie le nom du runway
		 * @return le nom du runway
		 */
		public String getName() {
			return name;
		}
		
		
		@Override
		public void drawObject(Graphics g, int panX, int panY, double zoom, int height, int width) {

			
		//	Graphics2D g = (Graphics2D)ge;
          
            
            g.setColor(Color.GRAY);
            
            int x1, x2, y1, y2;                       
                        for (int i=0;i<(listPoint.size()-1);i++)
                        {
                            x1=((Point)listPoint.get(i)).x;                 
                            y1=((Point)listPoint.get(i)).y;                           
                            x2=((Point)listPoint.get(i+1)).x;                           
                            y2=((Point)listPoint.get(i+1)).y;
                            
                            Point  pt1 = new Point(x1,y1);
                            Point  pt2 = new Point(x2,y2);
                            super.changerPointRepere(pt1,height,width);
                            super.changerPointRepere(pt2,height,width);
                        //    Stroke s = g.getStroke();
                            
                         //  g.setStroke(new BasicStroke((int)zoom));
                            int xe =  (int) ((pt1.getX()+panX)*zoom);
                            int ye = (int) ((pt1.getY()+panY)*zoom);
                            int xe2 =  (int) ((pt2.getX()+panX)*zoom);
                            int ye2 = (int) ((pt2.getY()+panY)*zoom);
                            
                           g.drawLine(xe,ye, xe2,ye2); 
                          // g.setStroke(s);
                          
                    		
                           
                        }
                       
			
		}
		
		
		/* Methode qui ajoute un point au Runway*/
		
		public void addPt(Point pt) {
			listPoint.add(pt);
		}
		
		public String toString() {
			
			return "TaxyWay: "+name+"id: "+id+" Category: "+category+" Velocity: "+velocity+" Direction: "+direction;
			
		
		
		}
		/* ---- ---- */

		
	

}