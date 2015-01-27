package fr.enac.aero.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.enac.aero.trafficPackage.AirportTraffic;

public class CanvasAirportMove extends JPanel  {// implements MouseListener,
		//MouseMotionListener, MouseWheelListener {

	
	
	private AirportTraffic airportT;
private JButton jb;
	
	public CanvasAirportMove(AirportTraffic airportT) {
		super();

		int height = 900;
		int width = 900;
		 jb = new JButton();
		jb.setText("XXX");
	
		jb.setVisible(true);

		
		this.add(jb);

		// this.setBackground(Color.BLACK);

		// this.setSize(this.largeurStd>width?width:this.largeurStd,this.hauteurStd>height?height:this.hauteurStd);
		this.setSize(height, width);
		this.setOpaque(false);
		 this.setBackground(new Color(255,0,0,0));
		this.setVisible(true);
		// this.setBackground(Color.WHITE);
		// revoir pour le choix de la couleur

		this.airportT = airportT;
/*
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
*/
	}
	
	/*@Override
	public boolean contains(int x, int y){
		return jb.contains(x,y);
	}*/

	private int  t;
	public void paintFlights(int t) {
		this.t = t;
		//airportT.DrawAllFlight(this, t + 11130, 0, 0, 1);
		/*jb.setPreferredSize(new Dimension((int)(100*PanDisplay.getZoom()),(int)(100*PanDisplay.getZoom())));
		jb.setLocation((int)((t+PanDisplay.getPanX())*PanDisplay.getZoom()),(int)((t+PanDisplay.getPanY())*PanDisplay.getZoom()));
		jb.repaint();*/
		repaint ();
		
		
	}

	@Override
	public void paint(Graphics g_) {
		System.out.println("je passe dedans");
		airportT.DrawAllFlight(this, 11130, 0, 0, 1);
		//g_.fillRect(0, 0, 30, 30);
		
		jb.setPreferredSize(new Dimension((int)(100*PanDisplay.getZoom()),(int)(100*PanDisplay.getZoom())));
		jb.setLocation((int)((t+PanDisplay.getPanX())*PanDisplay.getZoom()),(int)((t+PanDisplay.getPanY())*PanDisplay.getZoom()));
		jb.repaint();
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
