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

public class Runway extends ObjectAirport {
	

	/* ---- Attributs : ---- */
	
	//  name : l'identifiant du point
	private String name;
	//QFU : les deux QFU du RunWay
	private String qfu_1;
	private String qfu_2;
	//coord_qfu_1 et coord_qfu_2 : les coordonnees des qfu 
	private Point coord_1;
	private Point coord_2;
	private ArrayList<String> listNamePoint ;
	//private HashMap<String,AirportPoint> listNamePoint2 ;
	
	private Airport apt;
	/* ---- ---- */
	
	
	/* ---- Constucteurs : ---- */
	
/**
 * Constructeur d'un runway, cree sans parametres
 */
	public Runway(Airport apt){
		this(apt,"inconnu","inconnu","inconnu",new Point(0,0),new Point(0,0));
				
	}
	
	/**
	 * Constructeur d'un runway,
	 * prend en parametre toutes les informations sur le runway.
	 * @param nom
	 * @param qfu_1 et qfu_2
	 * @param coord_qfu_1 et coord_qfu_2 
	 * @param pt les coordonnees cartesiennes du point sur l'aeroport
	 */
		public Runway(Airport apt,String name, String qfu_1, String qfu_2, Point pt1, Point pt2)
				
			{
				super(apt);
				this.apt=apt;
				this.name=name;
				this.qfu_1=qfu_1;
				this.qfu_2=qfu_2;				
				this.coord_1=pt1;
				this.coord_2=pt2;	
			listNamePoint = new ArrayList<String>();
				//listNamePoint2 = new HashMap<String,AirportPoint>();
			  }
			
		
		/* ---- requetes ---- */
		/**
		 * Methode qui renvoie le nom du runway
		 * @return le nom du runway
		 */
		
		
		
		public String getName() {
			return name;
		}
		
		@Override
		public String getId() {
			
			return this.getName();
		}
		
		

		@Override
		public void drawObject(Graphics g, int panX, int panY, double zoom, int height, int width) {
	//Graphics2D g = (Graphics2D)ge;
            
            g.setColor(Color.BLACK);
            int x1, x2, y1, y2;                       
                        for (int i=0;i<(listNamePoint.size()-1);i++)
                        {
                        	
                        	 AirportPoint ap1 = (AirportPoint) (super.getAirportPoint(listNamePoint.get(i)));
                        	 AirportPoint ap2 = (AirportPoint) (super.getAirportPoint(listNamePoint.get(i+1)));
                        	 
                        	 Point  pt1 = new Point(ap1.getCoord().x,ap1.getCoord().y);
                        	 Point  pt2 = new Point(ap2.getCoord().x,ap2.getCoord().y);
                        	 
                        	 super.changerPointRepere(pt1,height,width);
                             super.changerPointRepere(pt2,height,width);
                         //    Stroke s = g.getStroke();
                          
                           //  g.setStroke(new BasicStroke(4*(int)zoom));
                             int xe =  (int) ((pt1.getX()+panX)*zoom);
                             int ye = (int) ((pt1.getY()+panY)*zoom);
                             int xe2 =  (int) ((pt2.getX()+panX)*zoom);
                             int ye2 = (int) ((pt2.getY()+panY)*zoom);
                             
                            g.drawLine(xe,ye, xe2,ye2);
                         //   g.setStroke(s);
                    	
                           
                        }
		}
		
		
		/* Méthode qui ajoiute un point au Runway*/
		
		public void addPtName(String pt) {
			//listNamePoint.add(pt);
			listNamePoint.add(pt);
			
			
		}
		
		public String toString() {
			
			return "Runway :"+name+" QFU 1: "+qfu_1+" QFU 2: "+qfu_2+" Point 1: "+coord_1.x+" "+coord_1.x+" Point 2: "+coord_2.x+" "+coord_2.y;
			
		
		
		}
		/* ---- ---- */

	

}