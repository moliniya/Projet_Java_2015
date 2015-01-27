package fr.enac.aero.display;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.enac.aero.trafficPackage.AirportTraffic;

public class CanvasAirportMove extends JPanel implements MouseListener,
		MouseMotionListener, MouseWheelListener {

	private int panX = 0;
	private int panY = 0;
	private double zoom = 1;
	private final int hauteurStd = 800;
	private final int largeurStd = 1000;
	private Etat etat = Etat.IDLE;
	private AirportTraffic airportT;

	
	public CanvasAirportMove(AirportTraffic airportT) {
		super();

		int height = 900;
		int width = 900;
		JButton jb = new JButton();
		jb.setText("mon bouton de test");

		jb.setVisible(true);

		jb.setLocation(0, 0);
		this.add(jb);

		// this.setBackground(Color.BLACK);

		// this.setSize(this.largeurStd>width?width:this.largeurStd,this.hauteurStd>height?height:this.hauteurStd);
		this.setSize(height, width);
		this.setOpaque(false);

		this.setVisible(true);
		// this.setBackground(Color.WHITE);
		// revoir pour le choix de la couleur

		this.airportT = airportT;

		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);

	}

	public void paintFlights(int t) {
		airportT.DrawAllFlight(this, t + 11130, 0, 0, 1);

	}

	@Override
	public void paint(Graphics g_) {
		System.out.println("je passe dedans");
		airportT.DrawAllFlight(this, 11130, 0, 0, 1);

	}
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
	}

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
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (etat) {
		case CLICK:
			int varX = e.getX() - tmpX;
			int varY = e.getY() - tmpY;
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

	private double xM1, xM2;
	private double yM1, yM2;

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// Calucler les coordonnees du carre dans le monde reel avant le zoom :
		xM1 = ((e.getX() / zoom) - this.panX);
		yM1 = ((e.getY() / zoom) - this.panY);
		// On change le coef de zoom :
		zoom -= e.getWheelRotation() * 0.1;
		if (zoom <= 0) {
			zoom = 0.1;
		}
		// Calculer les coordonnees reelles apres le zoom :
		xM2 = ((e.getX() / zoom) - this.panX);
		yM2 = ((e.getY() / zoom) - this.panY);
		// On adapte le pan en faisant la difference :
		this.panX += xM2 - xM1;
		this.panY += yM2 - yM1;

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
