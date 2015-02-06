package fr.enac.aero.airportPackage;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.enac.aero.display.CanvasAirportFix;

/**
 * Cette classe contient les informations relatives a un aeroport :
 * son code OACI ainsi que la liste des objets graphiques qui le constituent.
 * Un Objet graphique peut etre un point physique de la plateforme, un taxiway ou un runway.
 * L'ensemble de ces objets sont stockes dans une HashMap avec pour cle leur nom.
 * 
 * @author Claire
 *
 */
public class Airport {

	

	/* ---- Attributs : ---- */
	
	//le code OACI de l aeroport
	private String id_OACI_Ap;
	
	
	//la collection d'objets graphiques caracterisant l'aeroport
	private HashMap<String,ObjectAirport> mapObjAeroport;
	
	
	
	// A VERIFIER
	private int xMin,xMax,yMin,yMax;
	
	
	
	static int cpt=0;
	/* ---- ---- */
	
	

	
	/* ---- Constucteurs : ---- */
	
	/**
	 * Constructeur d'un aeroport, cree l'aeroport sans parametres
	 */
	public Airport(){
		this.id_OACI_Ap="inconnu";
		mapObjAeroport = new HashMap<String,ObjectAirport>();
	}
	
	/* ---- ---- */



	/* ---- requetes ---- */
	
	/**
	 * Methode qui renvoie le code OACI de l aeroport
	 * @return le code OACI de l aeroport
	 */
	public String getId() {
		return id_OACI_Ap;
	}
	
	/**
	 * Methode qui renvoie la collection des objets composant l'aeroport
	 * La cle utilisee pour stocker un objet dans la HashMap est le nom de l'objet
	 * @return une HashMap d'IObjectAirport 
	 */
	public HashMap<String, ObjectAirport> getMapAirport() {
		return mapObjAeroport;
	}
	
	
	public ObjectAirport getObjectAirport(String id){
		return mapObjAeroport.get(id);
	}
	/* ---- ---- */



	/* ----  commandes ---- */
	
	/**
	 * Methode qui permet de modifier le code OACI de l aeroport
	 * @param id le code OACI de l aeroport
	 */
	public void setId(String id) {
		this.id_OACI_Ap = id;
	}

/**
 * Methode qui permet de modifier la valeur minimum des abscisses xMin prise par les points de l'aeroport
 * @param xMin valeur x minimum 
 */
	public void setxMin(int xMin) {
		this.xMin = xMin;
	}

	
	/**
	 * Methode qui permet de modifier la valeur maximum  des abscisses xMax prise par les points de l'aeroport
	 * @param xMax valeur x maximum 
	 */
	public void setxMax(int xMax) {
		this.xMax = xMax;
	}


	/**
	 * Methode qui permet de modifier la valeur minimum des ordonnees yMin prise par les points de l'aeroport
	 * @param yMin valeur y minimum 
	 */
	public void setyMin(int yMin) {
		this.yMin = yMin;
	}

	
	/**
	 * Methode qui permet de modifier la valeur maximum  des ordonnees yMax prise par les points de l'aeroport
	 * @param yMax valeur y maximum 
	 */
	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	/**
	 * Methode qui permet d'ajouter un objet dans la liste des objets composant l'aeroport
	 * @param object l'objet a ajouter a la collection d objets mapAirport
	 */
	public void addObject(ObjectAirport object) {
		
			this.mapObjAeroport.put(object.getId(), object);

	}
	
	/**
	 * Methode qui permet de d'afficher sur l'aeroport graphique l'ensemble des objets graphiques qui le constituent
	 * @param canvas canvas sur lequel doivent etre affiches les objets graphique
	 */
	public void drawAirport(Graphics g, int panX, int panY, double zoom, int height, int width){
		
		for (HashMap.Entry<String,ObjectAirport> entry : mapObjAeroport.entrySet()) {
			ObjectAirport object = entry.getValue();
			//String k = entry.getKey();
			
			object.drawObject(g,panX,panY,zoom,height, width);
			
		}
		
		
	}
	

	/**
	 * Methode qui permet de recuperer les donnees caracteristiques d'un aeroport a partir d'un fichier dont on passe le nom en parametre
	 * @param nameFile nom du fichier qui contient les donnees a recuperer
	 */
	public void loadAirport(String nameFile){
		
		String ligne;
		BufferedReader fe;
		int r=0;
		int t=0;
		int p=0;
			try {
				fe = new BufferedReader ( new FileReader(nameFile));
				
				try {
					while((ligne = fe.readLine() )!= null	){
						// on lit le fichier ligne par ligne. 
					
						Scanner ps = new Scanner(ligne);
						//chaque element a recuperer est delimite par un espace
						//le delimiteur par defaut convient

						
						String donnee = ps.next(); // donnee est le mot en cours de traitement
						
						
						
						
						if (donnee.equals("P")){ //La ligne contient les informations d'un point
						
							//Recuperation de tous les attributs d'un point
						    String name = ps.next();
							EnumTypePt type= EnumTypePt.valueOf("Runway_Point");
							int cat = ps.nextInt();
							//System.out.println(name+" "+cat);
							if(cat==0) { type = EnumTypePt.valueOf("Stand");}
							else if(cat==1) { type = EnumTypePt.valueOf("Deicing");}
							else if(cat==2) { type = EnumTypePt.valueOf("Runway_Point");}						
								
							String ptCoord = ps.next();
							String tabPoint[]= new String[2];
							tabPoint = ptCoord.split(",");
							Point pt = new Point(Integer.parseInt(tabPoint[0]),Integer.parseInt(tabPoint[1]));
							AirportPoint obj = new AirportPoint(this,name, type, pt);
							//System.out.println(tabPoint[0]);
							addObject(obj);
							p++;
												
						}
						
						else if(donnee.equals("L")) { // La ligne contient les informations d'un TaxiWay
							
						    String name = ps.next();
						    int v = ps.nextInt();
						    String cat = ps.next(); 
							EnumTypeCat taxyCat = EnumTypeCat.valueOf(cat);
							
							String dir = ps.next();
							EnumTypeDir taxyDir = EnumTypeDir.valueOf(dir);
							TaxiWay obj = new TaxiWay(this,name, v, taxyCat, taxyDir);
	
							String ptCoord = ps.next();
							Scanner ptNames=new Scanner(ptCoord);
							ptNames.useDelimiter(";");
							 while(ptNames.hasNext()) {
								 String temp = ptNames.next();
								 Scanner coord = new Scanner(temp);
								 coord.useDelimiter(",");
								 int x=coord.nextInt();
								 int y=coord.nextInt();
								 Point pt = new Point(x, y);
								 obj.addPt(pt);
							 }
							 addObject(obj);
							 t++;
				
							}
							
						
							
						
						else if(donnee.equals("R")) { // La ligne contient les informations d'un RunWay
						    String name = ps.next();
						    String qfu_1 = ps.next();
						    String qfu_2 = ps.next();		    
												
							String ptCoord = ps.next();
							String tabPoint[]= new String[4];
							tabPoint = ptCoord.split(",|;");
							Point pt1 = new Point(Integer.parseInt(tabPoint[0]),Integer.parseInt(tabPoint[1]));
							Point pt2 = new Point(Integer.parseInt(tabPoint[2]),Integer.parseInt(tabPoint[3]));
							Runway obj = new Runway(this,name, qfu_1, qfu_2, pt1, pt2);
				
							Scanner ptNames=new Scanner(ps.next());
							ptNames.useDelimiter(";");
							 while(ptNames.hasNext()) {
								 obj.addPtName(ptNames.next());
							 }
							
							addObject(obj);
							r++;
						}
					}
						
						
						/////ON MET A JOUR LA HASHMAP DE AIRPORT POINTS DANS RUNWAY
						/**for (HashMap.Entry<String,ObjectAirport> entry : mapObjAeroport.entrySet()) {
							ObjectAirport object = entry.getValue();
							if (object instanceof Runway){
								for (HashMap.Entry<String,ObjectAirport> entry2 : mapObjAeroport.entrySet()) {
									ObjectAirport object2 = entry2.getValue();
							}
						}
						
					 }**/
						
					System.out.println("Point: "+p+" TaxyWay: "+t+" RunWay: "+r);
					
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					fe.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		
	}
	
	
	
	/**
	 * Methode qui renvoie la valeur minimum des abscisses prises par l'ensemble des points de l'aeroport 
	 * @return la valeur minimum des abscisses  
	 */
	public int getxMin() {
		return xMin;
	}
	
	/**
	 * Methode qui renvoie la valeur maximum des abscisses prises par l'ensemble des points de l'aeroport 
	 * @return la valeur maximum des abscisses  
	 */
	public int getxMax() {
		return xMax;
	}
	
	/**
	 * Methode qui renvoie la valeur minimum des ordonnees prises par l'ensemble des points de l'aeroport 
	 * @return la valeur minimum des ordonnees  
	 */
	public int getyMin() {
		return yMin;
	}
	
	/**
	 * Methode qui renvoie la valeur maximum des ordonnees prises par l'ensemble des points de l'aeroport 
	 * @return la valeur maximum des ordonnees  
	 */
	public int getyMax() {
		return yMax;
	}
	
/**
 * Methode qui calcule les valeurs x et y minimum, respectivement maximum que prennent les points de l'aeroport
 */
	public void getBounds(){
		
		
		for (HashMap.Entry<String,ObjectAirport> entry : mapObjAeroport.entrySet()) {
			ObjectAirport object = entry.getValue();
			//String k = entry.getKey();
			
			//on ne teste que les objets graphiques qui sont des points de l'aeroport
			if (object instanceof AirportPoint){
				
				//mise a jour de xmin
				if (((AirportPoint) object).getCoord().x < xMin){
					setxMin( ((AirportPoint) object).getCoord().x);
				}
				//mise a jour de ymin
				if (((AirportPoint) object).getCoord().y < yMin){
					setyMin( ((AirportPoint) object).getCoord().y);
				}
				//mise a jour de xmax
				if (((AirportPoint) object).getCoord().x > xMax){
					setxMax(((AirportPoint) object).getCoord().x);
				}
				//mise a jour de ymax
				if (((AirportPoint) object).getCoord().y > yMax){
					setyMax(((AirportPoint) object).getCoord().y);
				}
				
				
			}
		}
		
		
		
	}
	/* ---- ---- */
	
}
