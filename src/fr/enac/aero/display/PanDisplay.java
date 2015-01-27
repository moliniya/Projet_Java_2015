package fr.enac.aero.display;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class PanDisplay extends JComponent {

	public PanDisplay(CanvasAirportFix airportDrawPaper,CanvasAirportMove vols){//,CanvasAirportMove vols
		//gestionnaire  fenetrage Display
		super();
		
		this.setPreferredSize(new Dimension(900,900));
		
		
		//airportDrawPaper.setBackground(new Color(0,0,0,0));
		
		
		this.add(airportDrawPaper,0);
		this.add(vols, 1);
		airportDrawPaper.setOpaque(true);
		vols.setOpaque(false);
		//this.add(airportDrawPaper,1);
		//this.add(airportDrawPaper, 2);
		
		//this.setComponentZOrder(canvas2, 1);
		
				//this.setSize( new Dimension (900,850));
			//	this.setAutoscrolls(true);
			//	this.setBackground(Color.WHITE);
				
	}
}
