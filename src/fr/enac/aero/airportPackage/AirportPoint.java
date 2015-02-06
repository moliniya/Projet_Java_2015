package fr.enac.aero.airportPackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.enac.aero.display.CanvasAirportFix;

/**
 * Cette classe contient les informations relatives � un point physique de la plateforme aeroportuaire
 * Elle contient des methodes permettant de recuperer ou modifier ces donnees.
 *  
 * @author Claire
 *
 */


public class AirportPoint extends ObjectAirport{
	
	
	/* ---- Attributs : ---- */
	

	/**
	 * name : l'identifiant du point
	 */
	private String name;
	
	/**
	 * type : le type de point de la plateforme aeroport
	 */
	private EnumTypePt type;
	
	/**
	 * coord : les coordonnees cartesiennes du point
	 */
	private Point coord;
	
	private int rayon = 3;
	

	
	//static int cpt =0;
	/* ---- ---- */
	
	

	
	/* ---- Constucteurs : ---- */
	
/**
 * Constructeur d'un point, cree le point sans parametres
 */
	public AirportPoint(Airport apt){
		this(apt,"inconnu",EnumTypePt.Deicing,new Point(0,0));
		
	}
	

/**
 * Constructeur d'un point,
 * prend en parametre toutes les informations sur le point.
 * @param id l'identifiant du point
 * @param type le type de point de la plateforme aeroport
 * @param pt les coordonnees cartesiennes du point sur l'aeroport
 */
	public AirportPoint(Airport apt,String id, EnumTypePt type, Point pt){
		super(apt);
		this.name =id;
		this.type = type;
		this.coord = pt;
	
		
	}
	/* ---- ---- */



	/* ---- requetes ---- */

	/**
	 * Methode qui renvoie l'identifiant du point
	 * @return l'identifiant du point
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Methode qui renvoie le type de point de la plateforme aeroport
	 * @return le type de point de la plateforme
	 */
	public EnumTypePt getType() {
		return type;
	}

	/**
	 * Methode qui renvoie les coordonnees cartesiennes du point sur l'aeroport
	 * @return les coordonnees cartesiennes du point sur l'aeroport
	 */
	public Point getCoord() {
		return coord;
	}
	
	/* ---- ---- */



	/* ----  commandes ---- */
	/**
	 * Methode qui permet de modifier l'identifiant du point
	 * @param name l'identifiant du point
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  Methode qui permet de modifier le type de point
	 * @param type le type de point
	 */
	public void setType(EnumTypePt type) {
		this.type = type;
	}
	
	/**
	 *  Methode qui permet de modifier l'emplacement du point sur la plateforme aeroportuaire
	 * @param coord les coordonnees cartesiennes du point sur l'aeroport
	 */
	public void setCoord(Point coord) {
		this.coord = coord;
	}


	/**
	 * Methode qui permet d'afficher le point sur la plateforme graphique de l'aeroport
	 * @param canvas canvas sur lequel il faut afficher l'objet
	 */
	@Override
	public void drawObject(Graphics g, int panX, int panY, double zoom, int height, int width) {
		//cpt++;
		
		//System.out.println("draw point : " + cpt +"\n");
		
		
		//Graphics g = canvas.getGraphics();
		//premier parametre : x
		//deuxieme parametre : y
		//troisieme et quatrieme parametre : le rayon
		
	//g.translate(2500, 2000);
		g.setColor(Color.RED);
		Point pt = new Point(coord.x,coord.y);
		super.changerPointRepere(pt,height,width);
		int xe =  (int) ((pt.getX()+panX)*zoom);
        int ye = (int) ((pt.getY()+panY)*zoom);
        int we = (int) (rayon*zoom);
        
		//g.drawOval(xe, ye, we, we);
		g.fillOval(xe-we/2, ye-we/2, we, we);
		
		
		
		
	}
	

	
	@Override
	public String toString(){
		return "nom : "+name+"\n"+"type : "+type+"\n"+"coordonnees : "+coord;
	}


	@Override
	public String getId() {
		
		return this.getName();
	}


	
	
	/* ---- ---- */


}
