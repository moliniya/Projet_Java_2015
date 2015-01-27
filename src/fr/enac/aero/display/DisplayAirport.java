package fr.enac.aero.display;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.Timer;

import fr.enac.aero.airportPackage.Airport;
import fr.enac.aero.trafficPackage.AirportTraffic;

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
		PanUser panUser = new PanUser();
		//PanDisplay panDisplay = new PanDisplay();
		
		 
		
		
		
	
		

	   

	
		
		JMenuBar Barmenu = new JMenuBar();
		this.setJMenuBar(Barmenu);
		
		

		
		airport = new Airport();
		airportT = new AirportTraffic();
	
		
		this.initData();
		
		airportDrawPaper = new CanvasAirportFix(this.airport,this.airportT);
		
		
		
		vols= new CanvasAirportMove(this.airportT);
		
		//PanDisplay panDisplay = new PanDisplay(airportDrawPaper,vols);
		PanDisplay panDisplay = new PanDisplay(airportDrawPaper);
		
		
		
		// ajout des panneaux à  la fenetre avec  
		this.add(panDisplay,BorderLayout.EAST);
		//this.add(panUser,BorderLayout.WEST);
		
		
		//this.initData();
		
		 
		 
		//panDisplay.add(airportDrawPaper);
		 
		
		
	
		
	 
	 
	 
		////////////////////
	 
		//le temps du timer est en millisecondes
		 //on veut un delay de 5 secondes => 5000
		/* final Timer timer=new Timer(5000,new ActionListener() {
			  int i=0;
			@Override
			 public void actionPerformed(ActionEvent e) {
				 //for(int i=0;i<5;i++){
			//airportDrawPaper.repaint();
			
				vols.paintFlights(i);
				
				//vols.repaint();
				
				
				i+=5;
					 System.out.println("coucou\n"+ i);
				// }

				}	
			}
			);
		 
		
		 	 final JButton timerButton=new JButton("start");
		 timerButton.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 if (timer.isRunning())
					 timer.stop();
				 else
					 timer.start();
				 timerButton.setText((timer.isRunning())?"stop":"start");
			 }
			 
		 }
		 );
		
			 this.add(timerButton,BorderLayout.NORTH);*/
			 
			 
			 
			 
			 
		
		this.setSize(1200, 900);
		this.pack();
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
