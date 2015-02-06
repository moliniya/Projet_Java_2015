package fr.enac.aero.display;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.enac.aero.airportPackage.Airport;
import fr.enac.aero.display.panelUser.PanUser;
import fr.enac.aero.display.panelUser.SplitIHM;
import fr.enac.aero.trafficPackage.AirportTraffic;

import java.util.Dictionary;
import java.util.Hashtable;
import java.awt.Component;


/**
 * Classe  HIM qui affiche 
 * 1-Les pistes ( Runway)
 * 2-Les voies de circulation ( tawiway)
 * 3-les parking ( stand)
 * @author moliniya
 *
 *Creation 11 janvier 2015  Y.Molinier
 *
 *Modification le 14 janvier 2015
 */





//import DisplayAirport.chargerfichierAeroport;
//import DisplayAirport.chargerfichierVol;
//import DisplayAirport.quitterHIM;


public class DisplayAirport extends JFrame  {
	
	
	
	static final int SIZE = 12;
	//private SCanvas airportDrawPaper;
	CanvasAirportFix airportDrawPaper;
	private Airport  airport;
	private AirportTraffic airportT;
	private CanvasAirportMove vols;
	private JScrollPane Scroll_Display;
	private JScrollPane Scroll_User;
	private PanUser panUser;
	
	/**
	 * Constructeur principale 
	 */
	
	
	public DisplayAirport()
	{

		/*********************************
		 * Fenetre principale  & Panel
		 */
		
		super("Aeroport de Roissy Charles de Gaulle ");
		
		
		
		//Gestionnaire mise en page fenetre BorderLayout
		this.setLayout(new BorderLayout());
		//this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		
		// panneau
		
		
		airport = new Airport();
		airportT = new AirportTraffic();
	
		
		this.initData();
		 panUser = new PanUser(airportT);
		airportDrawPaper = new CanvasAirportFix(this.airport,this.airportT);
		
		
		
		vols= new CanvasAirportMove(this.airportT);
		
		PanDisplay panDisplay = new PanDisplay(airportDrawPaper,vols);
		
		 
		
		
		
	//DImensions de la fenetre
		 Dimension screenDim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int heightScreen = (int)screenDim.getHeight();
			int widthScreen  = (int)screenDim.getWidth();
			
			

		// Ajout du Menu 
					MenuBarIHM Barmenu = new MenuBarIHM(panUser);
					this.setJMenuBar(Barmenu);

		         	 // Ajout des panneaux avec positionnement
		         	this.add(panDisplay,BorderLayout.EAST);
		         	this.add(panUser,BorderLayout.CENTER);
	
					
					// Ajout Separateur  position 1/4 3/4
		        	/// ajout doit se faire après l'ajout des pannneaux 
	         		SplitIHM SplitDisplayAirport = new SplitIHM(panUser, panDisplay, heightScreen, widthScreen);	
	         		this.getContentPane().add(SplitDisplayAirport, BorderLayout.WEST);
					//SplitDisplayAirport.setOneTouchExpandable(true);
					//SplitDisplayAirport.setAutoscrolls(true);
					this.add(SplitDisplayAirport, BorderLayout.WEST);
		
			
					
			         	TimerDisplay timerDisplay = new TimerDisplay(panUser, vols);
		
		
			 
			 
			
			 
			 // Activation de la fenetre 
			this.setSize(widthScreen,heightScreen);
			//this.pack();
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
public void initData(){
	 //PENSER A LEVER L'EXCEPTION SI LE FICHIE N'EXISTE PAS/ OU NON ADAPTE OU VIDE
	 airport.loadAirport("lfpg.txt");
	
	 airport.getBounds();
	 
	 airportT.loadTraffic("trafic.txt");
	 
	 airportT.setxMin(airport.getxMin());
	 airportT.setxMax(airport.getxMax());
	 airportT.setyMin(airport.getyMin());
	 airportT.setyMax(airport.getyMax());
	
	 
	
}



	
	




}
