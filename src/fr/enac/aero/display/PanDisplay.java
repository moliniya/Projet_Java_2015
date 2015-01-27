package fr.enac.aero.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class PanDisplay extends JComponent implements MouseListener, MouseMotionListener, MouseWheelListener  {
	private CanvasAirportFix airportDrawPaper;
	private CanvasAirportMove vols;

	static private int panX = 0;
	static   private int panY = 0;
	static   private double zoom = 1;
	static   private final int hauteurStd=800;
	static	private final int largeurStd=1000;
	static	private Etat etat = Etat.IDLE;

	
	
	public PanDisplay(CanvasAirportFix airportDrawPaper){//,CanvasAirportMove vols
		//gestionnaire  fenetrage Display
		super();
		this.airportDrawPaper = airportDrawPaper;
	//	this.vols = vols;
		this.setPreferredSize(new Dimension(900,900));
		
		
		//airportDrawPaper.setBackground(new Color(0,0,0,0));
		
		//this.add(vols, -1);
		this.add(airportDrawPaper,-1);
	
		airportDrawPaper.setOpaque(true);
		//vols.setOpaque(false);
		//this.add(airportDrawPaper,1);
		//this.add(airportDrawPaper, 2);
		
		//this.setComponentZOrder(canvas2, 1);
		
				//this.setSize( new Dimension (900,850));
			//	this.setAutoscrolls(true);
			//	this.setBackground(Color.WHITE);
		
		addMouseListener (this);
	    addMouseMotionListener (this);
	    addMouseWheelListener (this);
	    
				
	}
	
	
	
	static public int getPanX() {
			return panX;
		}


	static public void setPanX(int panX) {
		PanDisplay.panX = panX;
		}


	static public int getPanY() {
			return panY;
		}


	static public void setPanY(int panY) {
		PanDisplay.panY = panY;
		}


	static public double getZoom() {
			return zoom;
		}


	static public void setZoom(double zoom) {
		PanDisplay.zoom = zoom;
		}


	static public Etat getEtat() {
			return etat;
		}


	static public void setEtat(Etat etat) {
			PanDisplay.etat = etat;
		}


	static public int getHauteurStd() {
			return hauteurStd;
		}


	static public int getLargeurStd() {
			return largeurStd;
		}


	
	
	  @Override
	    public void mouseClicked(MouseEvent e) {}

	    private int tmpX;
	    private int tmpY;
	    @Override
	    public void mousePressed(MouseEvent e) {
	        etat = Etat.CLICK;
	        tmpX = e.getX();
	        tmpY = e.getY();
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	       etat = Etat.IDLE;
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {}

	    @Override
	    public void mouseExited(MouseEvent e) {}

	    @Override
	    public void mouseDragged(MouseEvent e) {
	       switch (etat){
	            case CLICK:
	                int varX = e.getX() - tmpX;
	                int varY =  e.getY() - tmpY;
	                tmpX = e.getX();
	                tmpY = e.getY();
	                panX += varX;
	                panY += varY;
	                repaint();
	                break;
	            case IDLE:
	                break;            
	       }
	    }
	    
	    private double xM1,xM2;
	    private double yM1, yM2;
	    @Override
	    public void mouseWheelMoved(MouseWheelEvent e) {
	    	// Calucler les coordonnees du carre dans le monde reel avant le zoom :
	        xM1 =  ((e.getX()/zoom) - this.panX);
	        yM1 =  ((e.getY()/zoom) - this.panY);
	        // On change le coef de zoom :
	       zoom -= e.getWheelRotation()*0.1;
	       if (zoom <= 0){
	           zoom = 0.1;
	       }
	       // Calculer les coordonnees reelles apres le zoom :
	        xM2 =  ((e.getX()/zoom) - this.panX);
	        yM2 =  ((e.getY()/zoom) - this.panY);
	        // On adapte le pan en faisant la difference :
	        this.panX += xM2 - xM1;
	        this.panY += yM2 - yM1;
	       
	       repaint();
	    }

	    @Override
	    public void mouseMoved(MouseEvent e) {}
	    

  
}
