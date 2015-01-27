package fr.enac.aero.trafficPackage;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.enac.aero.display.CanvasAirportMove;

/**
 * Cette classe contient les informations relatives a l'ensemble du trafic sur l'aeroport.
 * Elle permet de stocker l'ensemble des vols.
 * 
 * @author Claire
 *
 */
public class AirportTraffic {
	
	
	
	
	/* ---- Constucteurs : ---- */
	/**
	 * Constructeur qui cree une HashMap d'avions vide
	 */
	public AirportTraffic(){
		this.mapFlight = new HashMap<String,Flight> ();
	}
	
	/* ---- ---- */
	
	

	/* ---- Attributs : ---- */
	//HashMap stockant l'ensemble des avions 
	private HashMap<String,Flight> mapFlight;
	
	
	private int xMax,xMin,yMax,yMin;
	/* ---- ---- */
	
	

	
	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getxMin() {
		return xMin;
	}

	public void setxMin(int xMin) {
		this.xMin = xMin;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	public int getyMin() {
		return yMin;
	}

	public void setyMin(int yMin) {
		this.yMin = yMin;
	}

	



	/* ---- requetes ---- */
	/**
	 * Methode qui permet de recuperer les informations relatives a un vol en specifiant l'identifiant du vol
	 * @param name identifiant du vol dont on veut recuperer les donnees
	 * @return les informations relatives a un vol
	 */
	public String getInfoFlight(String name){
		return this.mapFlight.get(name).toString();
		
	}
	
/**
 * Methode qui charge le fichier dont le nom est passe en parametre et cree les objets vols decrits dans le fichier
 * avant de les stocker dans la liste de vol : mapFlight
 * @param nameFile nom fu fichier ou recuperer les donnees
 */
	public void loadTraffic(String nameFile){
		
		String ligne;
		BufferedReader fe;
		
			try {
				fe = new BufferedReader ( new FileReader(nameFile));
				
				try {
					while((ligne = fe.readLine() )!= null	){
						// on lit le fichier ligne par ligne. 
					
						Scanner ps = new Scanner(ligne);
						//chaque element a recuperer est delimite par un espace
						//le delimiteur par defaut convient

						
						String donnee = ps.next(); // donnee est le mot en cours de traitement
						EnumTypeFlight flightType = EnumTypeFlight.valueOf(donnee);
						
						
						
						if (flightType.equals(EnumTypeFlight.ARR) || flightType.equals(EnumTypeFlight.DEP) ){
						
							//Recuperation de tous les attributs hors liste de points
						    String callSign = ps.next();
							
							String cat = ps.next();
							EnumCat category = EnumCat.valueOf(cat);
							
							String startPoint = ps.next();
							String qfuFlight = ps.next();
							int startTime = ps.nextInt();
							String slotTime= ps.next();
														
							//c'est un nouveau vol donc on cree un objet vol
							Flight monVol = new Flight(this,flightType ,callSign,category,startPoint,qfuFlight,startTime,slotTime);
						
							
							//Recuperation de tous les points
							int timeToAdd = 0;
							while(ps.hasNext()){
								
								String ptTraj = ps.next();
								String tabPoint[]= new String[2];
								tabPoint = ptTraj.split(",");
								Point pt = new Point(Integer.parseInt(tabPoint[0]),Integer.parseInt(tabPoint[1]));
								
								monVol.addInMapPath(pt, startTime+timeToAdd);
								
								timeToAdd += 5;
							}
							//System.out.println("affichage du vol : \n ");
							//System.out.println(monVol.toString());
							this.addFlight(monVol);
							ps.close();
							
						}
						
					 }
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
	
		
	
	 public void changerPointRepere(Point p , JPanel g){
	        
	        if (xMax-xMin != 0  && yMax-yMin !=0){
	            int T=(yMin);
	            int B=yMax;
	           int H=(g.getHeight())-(g.getHeight()/20);
	          //  int H=400;
	            //int H=(c.getHeight());
	            int Y=p.y;
	            int L=(xMin);
	            int R=xMax;
	            int W=(g.getWidth())-(g.getWidth()/20);
	           // int W=400;
	           // int W=(c.getWidth());
	            int X=p.x;
	            p.x=((W*(X-L))/(R-L));
	            p.y=(-(H*(T-Y))/(T-B))+H;    
	        
	        }
	    }
	/* ---- ---- */



	/* ----  commandes ---- */
	/**
	 * Methode qui permet d'ajouter un avion a la liste des avions circulant sur la plateforme
	 * @param p l'avion a ajouter
	 */
	public void addFlight(Flight p){
		this.mapFlight.put(p.getCallSign(),p);
	}
	/* ---- ---- */
	
	/**
	 * Methode pour tracer tous les point de trajectoire des vols associes au temps n passe en parametre
	 * @param canvas
	 * @param n
	 */
public void DrawAllFlight(JPanel g,int n,  int panX, int panY, double zoom) {
		
		
		for (HashMap.Entry<String,Flight> entry : mapFlight.entrySet()) {
			Flight monVol = entry.getValue();
			if (monVol.getPoint(n) != null ){
				//System.out.println("non nul \n");
				//Graphics g = canvas.getGraphics();
				
				//g.setColor(Color.BLUE);
				Point pt = new Point(monVol.getPoint(n).x,monVol.getPoint(n).y);
				changerPointRepere(pt,g);
				int xe =  (int) ((pt.getX()+panX)*zoom);
		        int ye = (int) ((pt.getY()+panY)*zoom);
		        int we = (int) (50*zoom);
		        
		        
		        JButton jb = new JButton("coucou");
				jb.setText("mon bouton");
				jb.setVisible(true);
				jb.setLocation(xe,ye);
				g.add(jb);
		        
				
				//g.fillOval(xe, ye, we, we);
				/*JButton jb = new JButton("coucou");
				jb.setText("mon bouton");
				jb.setVisible(true);
				jb.setLocation(xe,ye);*/
				//g.add(jb);
				
				
			}
		}

			}

}
	
