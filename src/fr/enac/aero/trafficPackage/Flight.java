package fr.enac.aero.trafficPackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.sql.Time;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.enac.aero.display.CanvasAirportMove;

/**
 * Cette classe contient les informations relatives a un vol.
 * 
 * @author Claire
 *
 */
public class Flight {
	
	
	/* ---- Attributs : ---- */
	/**
	 * type du vol : depart ou arrivee
	 */
	private EnumTypeFlight flightType;
	
	/**
	 * identifiant du vol
	 */
	private String callSign;
	
	/**
	 * categorie de l'avion : H, M ou L
	 */
	private EnumCat category;
	
	/**
	 * nom du point de depart du vol
	 */
	private String startPoint;
	
	/**
	 * QFU du vol
	 */
	private String qfuFlight;
	
	/**
	 * Heure de depart du vol
	 */
	private int startTime;
	
	/**
	 * Heure de slot
	 */
	private String slotTime;

	/**
	 * Liste de points ou passe l avion , ces points sont releves toutes les 5 secondes
	 * et forment une trajectoire
	 */
	private HashMap<Integer, Point> mapPath;
	
	private AirportTraffic apt;
	
	private int rayon = 1;
	
	/* ---- ---- */
	
	

	
	/* ---- Constucteurs : ---- */
	/**
	 * Constructeur qui construit un vol sans parametres
	 */
	public Flight(AirportTraffic apt){
		this(apt,EnumTypeFlight.ARR,"inconnu",EnumCat.M,"inconnu","inconnu",0,"inconnu");
	}
	
	/**
	 * Constructeur qui construit un vol avec ses parametres
	 * @param callSign l'identifiant du vol
	 * @param startPoint le point de depart du vol
	 * @param qfuFlight le QFU du vol
	 * @param startTime l'heure de depart du vol
	 */
	public Flight(AirportTraffic apt,EnumTypeFlight flightType, String callSign,EnumCat category,String startPoint, String qfuFlight,int startTime, String slotTime){
		this.apt=apt;
		this.flightType = flightType;
		this.callSign=callSign;
		this.category=category;
		this.startPoint=startPoint;
		this.qfuFlight=qfuFlight;
		this.startTime=startTime;
		this.slotTime=slotTime;
		mapPath=new HashMap<Integer, Point>();
	}
	/* ---- ---- */


	/* ---- requetes ---- */

	/**
	 * Methode qui retourne le type du vol (arrivee : ARR ou Depart : DEP)
	 * @return  le type du vol
	 */
	public EnumTypeFlight getFlightType(){
		return flightType;
	}
	
	
	/**
	 * Methode qui renvoie l'identifiant du vol
	 * @return l'identifiant du vol
	 */
	public String getCallSign() {
		return callSign;
	}
	
	/**
	 * Methode qui retourne la categorie d'un point ( H, M ou L)
	 * @return  la categorie d'un point
	 */
	public EnumCat getCategory(){
		return category;
	}
	
	/**
	 * Methode qui renvoie le nom du point de depart du vol
	 * @return le nom du point de depart du vol
	 */
	public String getStartPoint() {
		return startPoint;
	}

	
	/**
	 * Methode qui renvoie le QFU du vol
	 * @return le QFU du vol
	 */
	public String getQfuFlight() {
		return qfuFlight;
	}

	/**
	 * Methode qui renvoie l'heure de depart du vol
	 * @return l'heure de depart du vol
	 */
	public int getStartTime() {
		return startTime;
	}
	

	/**
	 * Methode qui renvoie l'heure de slot
	 * @return l'heure de slot
	 */
	public String getSlotTime() {
		return slotTime;
	}

	
	/**
	 * Methode qui permet de recuperer un point particulier du vol 
	 * a partir du temps auquel l'avion passe par ce point
	 * @param secondes heure de passage (en seconde par rapport au debut de la journee) 
	 * sur un point particulier
	 * @return le point associé a l'heure passee en parametre 
	 */
	public Point getPoint(int secondes){
		return mapPath.get(secondes);
	}
	
	@Override
	public String toString(){
		
		return 
		"flightType: "+flightType+" callSign: "+callSign+
		"category: "+ category + " startPoint: " + startPoint+
		" qfuFlight: "+qfuFlight +" startTime: " + startTime+
		 " slotTime: "+ slotTime+"\n"+
		"deux points de la traj : \n"+
		 "point 1: "+getPoint(startTime)+
		 "point 2: "+getPoint(startTime+5);
				
	}
	
	
	/* ---- ---- */



	/* ----  commandes ---- */

	/**
	 * Methode qui permet de modifier le type du vol (arrivee : ARR ou Depart : DEP)
	 * @param flightType  le type du vol
	 */
	public void setFlightType(EnumTypeFlight flightType){
		 this.flightType = flightType;
	}
	
	
	/**
	 * Methode qui permet de modifier l'identifiant du vol
	 * @param callSign l'identifiant du vol
	 */
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	
	/**
	 * Methode qui permet de modifier la categorie d'un point ( H, M ou L)
	 * @param category  la categorie d'un point
	 */
	public void setCategory(EnumCat category){
		this.category = category;
	}
	
	/**
	 * Methode qui permet de modifier le nom du point de depart du vol
	 * @param startPoint le nom du point de depart du vol
	 */
		public void setStartPoint(String startPoint) {
			this.startPoint = startPoint;
		}
	
	/**
	 *  Methode qui permet de modifier le QFU du vol
	 * @param qfuFlight le QFU du vol
	 */
	public void setQfuFlight(String qfuFlight) {
		this.qfuFlight = qfuFlight;
	}
	
	/**
	 * Methode qui permet de modifier l'heure de depart du vol
	 * @param startTime l'heure de depart du vol
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Methode qui renvoie l'heure de slot
	 * @return l'heure de slot
	 */
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
	
	/**
	 * Methode qui ajoute un point dans la collection des points du vol 
	 * en utilisant comme cle le temps auquel l'avion passe par ce point 
	 * @param pt  point a ajouter dans la liste de points du vol
	 * @param secondes temps de passage (en seconde par rapport au debut de la journee) 
	 */
	public void addInMapPath(Point pt, int secondes){
		this.mapPath.put(secondes, pt);
	}
	
	/* ---- ---- */



		}
	
