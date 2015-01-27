package fr.enac.aero.display;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.enac.aero.airportPackage.Airport;
import fr.enac.aero.trafficPackage.AirportTraffic;





public class CanvasAirportFix extends JPanel  {//implements MouseListener, MouseMotionListener, MouseWheelListener {
   /* private int panX = 0;
    private int panY = 0;
    private double zoom = 1;
    private final int hauteurStd=800;
	private final int largeurStd=1000;*/
    private Airport apt;
    private AirportTraffic airportT;
   // private Etat etat = Etat.IDLE;
    
   // private Graphics g;
    
    //Font font;
    public CanvasAirportFix(Airport apt, AirportTraffic airportT) {
    super();
    System.out.println("check 1\n");
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int)dimension.getHeight();
	int width  = (int)dimension.getWidth();
    
//g= this.getGraphics();
	
	JButton jb = new JButton();
	jb.setText("mon bouton");
	
	jb.setVisible(true);

//	this.add(jb);	jb.setLocation(0,0);
	 
	 
	//this.setBackground(Color.BLACK);
	this.setPreferredSize(new Dimension(900,900));
	this.setSize(900,900);
	//this.setSize(this.largeurStd>width?width:this.largeurStd,this.hauteurStd>height?height:this.hauteurStd);
	this.setVisible(true);
	//this.setBackground(Color.WHITE);
	
	this.setOpaque(true);
	
   /* addMouseListener (this);
    addMouseMotionListener (this);
    addMouseWheelListener (this);
    */
   // this.setOpaque(true);
    
    this.apt=apt;
    this.airportT=airportT;
    }


   /* @Override
    public void paint(Graphics g_) {

    	apt.drawAirport(this,panX,panY,zoom);

    	//apt.drawAirport(this,0,0,1);
    	
    	//airportT.DrawAllFlight(this, 1440,0,0,1);
    	//airportT.DrawAllFlight(this, 5725,0,0,1);
    	
    }*/
    
    
    
    
    @Override
    public void paintComponent(Graphics g) {

    	g.clearRect(0, 0, PanDisplay.getHauteurStd(), PanDisplay.getLargeurStd());
    	apt.drawAirport(g,PanDisplay.getPanX(),PanDisplay.getPanY(),PanDisplay.getZoom());
    	
    	//apt.drawAirport(this,0,0,1);
    	
    	//airportT.DrawAllFlight(this, 1440,0,0,1);
    	//airportT.DrawAllFlight(this, 5725,0,0,1);
    	
    }
     
    /*
     @Override
    public void mouseClicked(MouseEvent e) {}

    private int tmpX;
    private int tmpY;
    @Override
    public void mousePressed(MouseEvent e) {
    	PanDisplay.setEtat( Etat.CLICK); 
        tmpX = e.getX();
        tmpY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	PanDisplay.setEtat( Etat.IDLE);  
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
       switch (PanDisplay.getEtat()){
            case CLICK:
                int varX = e.getX() - tmpX;
                int varY =  e.getY() - tmpY;
                tmpX = e.getX();
                tmpY = e.getY();
                PanDisplay.setPanX(varX + PanDisplay.getPanX() ) ;
                PanDisplay.setPanY(varY + PanDisplay.getPanY() ) ;
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
        xM1 =  ((e.getX()/PanDisplay.getZoom()) - PanDisplay.getPanX());
        yM1 =  ((e.getY()/PanDisplay.getZoom()) - PanDisplay.getPanY());
        // On change le coef de zoom :
        PanDisplay.setZoom(e.getWheelRotation()*0.1 -PanDisplay.getZoom() ) ;
       if (PanDisplay.getZoom() <= 0){
    	   PanDisplay.setZoom(0.1) ;
       }
       // Calculer les coordonnees reelles apres le zoom :
        xM2 =  ((e.getX()/PanDisplay.getZoom()) - PanDisplay.getPanX());
        yM2 =  ((e.getY()/PanDisplay.getZoom()) -PanDisplay.getPanY());
        // On adapte le pan en faisant la difference :
        PanDisplay.setPanX( (int)(xM2 - xM1+PanDisplay.getPanX() )); 
        PanDisplay.setPanY( (int)(yM2 - yM1 + PanDisplay.getPanY()));
       
       repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
*/
   
}
