package fr.enac.aero.airportPackage;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JComponent;

import fr.enac.aero.display.CanvasAirportFix;

public abstract class ObjectAirport {
	private Airport apt;
	
	public ObjectAirport(final Airport apt){
		this.apt = apt;
	}
	
	/**
	 * Methode qui renvoie l'identifiant de l'objet 
	 * @return l'identifiant de l'objet
	 */
	public abstract String getId();
	
	/**
	 * Methode qui permet de representer graphiqement un objet sur la plateforme graphique de l'aeroport
	 * @param canvas le canvas sur lequel l'objet graphique doit etre trace
	 */
	public abstract void drawObject(Graphics g, int panX, int panY, double zoom);
	
	/** 
	 * Redefinition de la methode String pour un objet aeroport
	 * @return les informations sur l objet aeroport
	 */
	public abstract String toString();
	
	 protected void changerPointRepere(Point p , Graphics g){
		 
		
	        if (apt.getxMax()-apt.getxMin() != 0  && apt.getyMax()-apt.getyMin() !=0){
	            int T=(apt.getyMin());
	            int B=apt.getyMax();
	           //// int H=(g.getHeight())-(g.getHeight()/20);
	            int H=400;
	            //int H=(c.getHeight());
	            int Y=p.y;
	            int L=(apt.getxMin());
	            int R=apt.getxMax();
	          ////  int W=(g.getWidth())-(g.getWidth()/20);
	            int W=400;
	           // int W=(c.getWidth());
	            int X=p.x;
	            p.x=((W*(X-L))/(R-L));
	            p.y=(-(H*(T-Y))/(T-B))+H;    
	        
	        }
	    }
	
	protected ObjectAirport getAirportPoint(String nom){
		return apt.getObjectAirport(nom);
	}
}
