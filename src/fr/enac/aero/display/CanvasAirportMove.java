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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.enac.aero.trafficPackage.AirportTraffic;
import fr.enac.aero.trafficPackage.FlightIcon;

public class CanvasAirportMove extends JPanel {

	private AirportTraffic airportT;

	private int heightPanel, widthPanel;
	private int time;
	private ArrayList<FlightIcon> listeIcones;
	
	public CanvasAirportMove(AirportTraffic airportT) {
		super();

		this.setOpaque(false);
		this.setBackground(new Color(255, 0, 0, 0));
		this.setVisible(true);
		this.airportT = airportT;

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

	

	public void paintFlights(int t) {
		this.time = t;

		this.repaint();

	}

	

	@Override
	public void paint(Graphics g_) {

		if (listeIcones != null) {
			for (FlightIcon ic : listeIcones) {
				this.remove(ic);
			}
			listeIcones.clear();
		}

		listeIcones = this.airportT.getFlightButton(this, time,
				PanDisplay.getPanX(), PanDisplay.getPanY(),
				PanDisplay.getZoom(), this.getHeightPanel(),
				this.getWidthPanel());
		for (FlightIcon ic : listeIcones) {

			this.add(ic);
			ic.setIcon(new ImageIcon("Avion_silhouette2.png"));
			this.airportT.updateIconCoord(ic, time, this.getHeightPanel(),
					this.getWidthPanel(), PanDisplay.getPanX(),
					PanDisplay.getPanY(), PanDisplay.getZoom());
			ic.setSize(new Dimension(ic.getwDisplay(), ic.getwDisplay()));
			ic.setLocation(ic.getxDisplay() - ic.getwDisplay() / 2,
					ic.getyDisplay() - ic.getwDisplay() / 2);
			ic.repaint();

		}

	}

}
