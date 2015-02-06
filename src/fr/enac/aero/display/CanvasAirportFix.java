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
    
    private int heightPanel,widthPanel;
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
	//this.setPreferredSize(new Dimension(900,900));
	//this.setSize(900,900);
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


    
    
    
    
    
    public AirportTraffic getAirportTraffic(){
    	return this.airportT;
    }
    

	public int getHeightPanel() {
		return heightPanel;
	}
	public void setHeightPanel(int heightPanel) {
		this.heightPanel = heightPanel;
	}
	public int getWidthPanel() {
		return widthPanel;
	}
	public void setWidthPanel(int widthPanel) {
		this.widthPanel = widthPanel;
	}
    
    @Override
    public void paintComponent(Graphics g) {

    	
    	apt.drawAirport(g,PanDisplay.getPanX(),PanDisplay.getPanY(),PanDisplay.getZoom(), this.heightPanel, this.widthPanel);

    	
    }
 
}
