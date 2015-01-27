package fr.enac.aero.display;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class PanUser extends JPanel {

	
	/**
	 * Déclaration des  elements des panels
	 */
	
	private JButton chargerAeroport;
	private JButton chargerVol;
	private JButton buttonRetour;
	private JButton buttonPlay;
	private JButton buttonAvance ;
	private Font fontEntered = new Font(Font.DIALOG, Font.CENTER_BASELINE, 10);
	
	private JTextField nameAerport;
	private JTextField fichierVol;
	private JTextField compagnie ;
	private JTextField type ;
	private JTextField pointDepart ;
	private JTextField pointArrive ;

	private JTextArea log;
	
	private JComboBox <String> selectionVol ;
	
	// Séparateur
	private JSplitPane separateur;
	
	public PanUser(){

		super();
		
		// edition d'un log 
		log  = new JTextArea(5,20);
		log.setMargin(new Insets(5,5,5,5));
		log.setEditable(true);
		log.setVisible(true);
		
				
				//mise en forme  panneau User
				this.setLayout( new GridLayout(3,1));
				//this.setSize( new Dimension (35,850));
				
				
				// Partie utilisateur
				
				/**
				 * @ la partie utilisateur est consistituée de trois zones créer à partir 
				 * de trois panel
				 * pan1User : -contient un une bouton charger fichier avec zone de saisie
				 * 			  -contient une zone de  simulateur ( trois partie) 	
				 */
				
				/*****************************************
				 * pan1User
				 * 
				 *****************************************/
			
				JPanel pan1User = new JPanel();
				pan1User.setLayout(new GridLayout(7, 5));
				
				
			//	pan1User.setSize(200, 300);
				pan1User.setAutoscrolls(true);
				pan1User.doLayout();
				pan1User.setBackground(Color.darkGray);
			//	pan1User.setPreferredSize(pan1User.getParent().getPreferredSize());
				// this.setPreferredSize(this.getParent().getPreferredSize());
			//	 this.pack();
				pan1User.validate();
				
				JPanel pan2User = new JPanel();
				pan2User.setLayout(new GridLayout(3, 5));
				pan2User.setAutoscrolls(true);
				pan2User.setBackground(Color.GRAY);
			//	pan2User.setSize(200, 300);
				
				JPanel pan3User = new JPanel();
				pan3User.setLayout(new GridLayout(3, 5));
				pan3User.setAutoscrolls(true);
				pan3User.setBackground(Color.LIGHT_GRAY);
				pan3User.add(log);
			//	pan3User.setSize(200, 300);
							
				this.add(pan1User);
				this.add(pan2User);
				this.add(pan3User);
				
				// Ligne 1 pan1User inclus dans panUser
				JLabel pan1User_L1_1 = new JLabel();
				pan1User.add(pan1User_L1_1);
				JLabel pan1User_L1_2 = new JLabel();
				pan1User.add(pan1User_L1_2);
				JLabel pan1User_L1_3 = new JLabel();
				pan1User.add(pan1User_L1_3);
				JLabel pan1User_L1_4 = new JLabel();
				pan1User.add(pan1User_L1_4);
				JLabel pan1User_L1_5= new JLabel();
				pan1User.add(pan1User_L1_5);
				
				// Ligne 2  pan1User inclus dans panUser
				JLabel pan1User_L2_1 = new JLabel();
				pan1User.add(pan1User_L2_1);
				nameAerport= new JTextField();
				pan1User.add(nameAerport);
				JLabel pan1User_L2_3 = new JLabel();
				pan1User.add(pan1User_L2_3);
				chargerAeroport = new JButton("Charger un fichier Aeroport");
				chargerAeroport.setSize(5, 5);
				chargerAeroport.setFont(fontEntered);
				chargerAeroport.addActionListener(new chargerfichierAeroport());
				pan1User.add(chargerAeroport);
				JLabel pan1User_L2_5= new JLabel();
				pan1User.add(pan1User_L2_5);
				
				
				// Ligne 3 pan1User inclus dans panUser
				
				JLabel pan1User_L3_1 = new JLabel();
				pan1User.add(pan1User_L3_1);
				JLabel pan1User_L3_2 = new JLabel();
				pan1User.add(pan1User_L3_2);
				JLabel pan1User_L3_3 = new JLabel();
				pan1User.add(pan1User_L3_3);
				JLabel pan1User_L3_4 = new JLabel();
				pan1User.add(pan1User_L3_4);
				JLabel pan1User_L3_5= new JLabel();
				pan1User.add(pan1User_L3_5);
				
				
				
				// Ligne 4  pan1User inclus dans panUser
				JLabel pan1User_L4_1 = new JLabel();
				pan1User.add(pan1User_L4_1);
				fichierVol= new JTextField();
			
				pan1User.add(fichierVol);
				JLabel pan1User_L4_3 = new JLabel();
				pan1User.add(pan1User_L4_3);
				chargerVol = new JButton("Charger un fichier Vol");
				chargerVol.addActionListener(new chargerfichierVol());
				pan1User.add(chargerVol);
				JLabel pan1User_L5_5= new JLabel();
				pan1User.add(pan1User_L5_5);
				
			// Ligne 3 pan1User inclus dans panUser
				
				JLabel pan1User_L6_1 = new JLabel();
				pan1User.add(pan1User_L6_1);
				JLabel pan1User_L6_2 = new JLabel();
				pan1User.add(pan1User_L6_2);
				JLabel pan1User_L6_3 = new JLabel();
				pan1User.add(pan1User_L6_3);
				JLabel pan1User_L6_4 = new JLabel();
				pan1User.add(pan1User_L6_4);
				JLabel pan1User_L6_5= new JLabel();
				pan1User.add(pan1User_L6_5);
				
				
				// Ligne 7 pan1User inclus dans panUser
				
				JLabel pan1User_L71 = new JLabel();
				pan1User.add(pan1User_L71);
				buttonRetour = new JButton(" <<");
				pan1User.add(buttonRetour);
				buttonPlay = new JButton("  Play");
				pan1User.add(buttonPlay);
				buttonAvance = new JButton(" >> ");
				pan1User.add(buttonAvance);
				JLabel pan1User_L7_5= new JLabel();
				pan1User.add(pan1User_L7_5);
				
				/*****************************************
				 * pan2User
				 * 
				 *****************************************/
				
				
				pan2User.setLayout(new GridLayout(5, 3));
				
				
				
				// Ligne 1 pan2User inclus dans panUser
				JLabel pan2User_L1_1 = new JLabel();
				pan2User.add(pan2User_L1_1);
				selectionVol = new JComboBox<String>();
				pan2User.add(selectionVol);
				JLabel pan2User_L1_3 = new JLabel();
				pan2User.add(pan2User_L1_3);
			
				// Ligne 2 pan2User inclus dans panUser
				JButton pan2User_B2_1 = new JButton(" Compagnie");
				
				
				pan2User_B2_1.setEnabled(false);
				pan2User.add(pan2User_B2_1);
				pan2User_B2_1 .setPreferredSize(new Dimension(4,4));
				pan2User_B2_1 .setMaximumSize(pan2User_B2_1 .getPreferredSize());
				pan2User_B2_1.validate();
				JLabel pan2User_L2_2 = new JLabel();
				pan2User.add(pan2User_L2_2);
				compagnie = new JTextField();
				pan2User.add(compagnie);
				
				
				// Ligne 3 pan2User inclus dans panUser
				JButton pan2User_B3_1 = new JButton(" Type mouvement");
				pan2User_B3_1.setEnabled(false);
				pan2User.add(pan2User_B3_1);
				JLabel pan2User_L3_2 = new JLabel();
				pan2User.add(pan2User_L3_2);
				type = new JTextField();
				pan2User.add(type);
				
				// Ligne 4 pan2User inclus dans panUser
				JButton pan2User_B4_1 = new JButton(" Origine");
				pan2User_B4_1.setEnabled(false);
				pan2User.add(pan2User_B4_1);
				JLabel pan2User_L4_2 = new JLabel();
				pan2User.add(pan2User_L4_2);
				pointDepart= new JTextField();
				pan2User.add(pointDepart);
				
				// Ligne 5 pan2User inclus dans panUser
				JButton pan2User_B5_1 = new JButton(" Arrivée ");
				pan2User_B5_1.setEnabled(false);
				pan2User.add(pan2User_B5_1);
				JLabel pan2User_L5_2 = new JLabel();
				pan2User.add(pan2User_L5_2);
				pointArrive= new JTextField();
				pan2User.add(pointArrive);
				
				
				
				
				
				/*
				// Ligne 2  pan1User inclus dans panUser
				JLabel pan1User_L2_1 = new JLabel();
				pan1User.add(pan1User_L2_1);
				nameAerport= new JTextField();
				pan1User.add(nameAerport);
				JLabel pan1User_L2_3 = new JLabel();
				pan1User.add(pan1User_L2_3);
				chargerAeroport = new JButton("Charger un fichier Aeroport");
				chargerAeroport.setSize(5, 5);
				chargerAeroport.addActionListener(new chargerfichierAeroport());
				pan1User.add(chargerAeroport);
				JLabel pan1User_L2_5= new JLabel();
				pan1User.add(pan1User_L2_5);
				
				
				// Ligne 3 pan1User inclus dans panUser
				
				JLabel pan1User_L3_1 = new JLabel();
				pan1User.add(pan1User_L3_1);
				JLabel pan1User_L3_2 = new JLabel();
				pan1User.add(pan1User_L3_2);
				JLabel pan1User_L3_3 = new JLabel();
				pan1User.add(pan1User_L3_3);
				JLabel pan1User_L3_4 = new JLabel();
				pan1User.add(pan1User_L3_4);
				JLabel pan1User_L3_5= new JLabel();
				pan1User.add(pan1User_L3_5);
				
				
				
				// Ligne 4  pan1User inclus dans panUser
				JLabel pan1User_L4_1 = new JLabel();
				pan1User.add(pan1User_L4_1);
				fichierVol= new JTextField();
			
				pan1User.add(fichierVol);
				JLabel pan1User_L4_3 = new JLabel();
				pan1User.add(pan1User_L4_3);
				chargerVol = new JButton("Charger un fichier Vol");
				chargerVol.addActionListener(new chargerfichierVol());
				pan1User.add(chargerVol);
				JLabel pan1User_L5_5= new JLabel();
				pan1User.add(pan1User_L5_5);
				
			// Ligne 3 pan1User inclus dans panUser
				
				JLabel pan1User_L6_1 = new JLabel();
				pan1User.add(pan1User_L6_1);
				JLabel pan1User_L6_2 = new JLabel();
				pan1User.add(pan1User_L6_2);
				JLabel pan1User_L6_3 = new JLabel();
				pan1User.add(pan1User_L6_3);
				JLabel pan1User_L6_4 = new JLabel();
				pan1User.add(pan1User_L6_4);
				JLabel pan1User_L6_5= new JLabel();
				pan1User.add(pan1User_L6_5);
				
				
				// Ligne 7 pan1User inclus dans panUser
				
				JLabel pan1User_L71 = new JLabel();
				pan1User.add(pan1User_L71);
				buttonRetour = new JButton(" <<");
				pan1User.add(buttonRetour);
				buttonPlay = new JButton("  Play");
				pan1User.add(buttonPlay);
				buttonAvance = new JButton(" >> ");
				pan1User.add(buttonAvance);
				JLabel pan1User_L7_5= new JLabel();
				pan1User.add(pan1User_L7_5);
				
				
				
				*/
				
				
				pan3User.setLayout(new GridLayout(3, 3));
				pan3User.setAutoscrolls(true);
				pan3User.setBackground(Color.LIGHT_GRAY);
				
				JLabel pan3User_L3_1 = new JLabel();
				pan3User.add(pan3User_L3_1);
				JLabel pan3User_L3_2 = new JLabel();
				pan3User.add(pan3User_L3_2);
				//JLabel pan3User_L3_3 = new JLabel();
				//pan3User.add(pan3User_L3_3);
				
				pan3User.add(log);
			//	pan3User.setSize(200, 300);
				
				
				/**
				 * ajout scroll
				 */
							
				
				/* JScrollPane scrollpan1User = new JScrollPane(pan1User) ;
				 JScrollPane scrollpan2User = new JScrollPane(pan2User) ;
				 JScrollPane scrollpan3User = new JScrollPane(pan3User) ;
				
				 
				 scrollpan1User.add(pan1User);
				 scrollpan1User.setEnabled(true);
				 scrollpan1User.setViewportView(pan1User);

				 fenetre.add(scrollpan1User);
				 
				 
				panUser.add(pan1User);
				panUser.add(pan2User);
				panUser.add(pan3User);*/
					
	}
	


	/*
	 * Chargement fichier Aeroport / action listener
	 * En classe inner
	 */
	
	
	class chargerfichierAeroport implements ActionListener
	 {
			public void actionPerformed(ActionEvent arg0) {
				
				// creation d'un objet JFileChooser
				
			JFileChooser fichierAerport = new JFileChooser();
			fichierAerport.setDialogTitle("Choisir un fichier Aeroport");
			 int returnVal = fichierAerport.showOpenDialog(null);
			 
			   if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File aeroportTxt = fichierAerport.getSelectedFile();
		            // inscription dans un log 
		            log.append("Ouverture de :  " + aeroportTxt.getName()+ "\n" );
		            log.append("\n");
		        
		            nameAerport.setText(aeroportTxt.getName());
			         
		         
		         
		        } else {
		            log.append("Ouverture du fichier annulé" );
		        }
				 
			
			   // option /
			   ///  fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			   
			   
				
				
			}
			}
	
	
	
	
	/*
	 * Chargement fichier Vol / action listener
	 */
	
	
  class chargerfichierVol implements ActionListener
	 {
			public void actionPerformed(ActionEvent arg0) {
				
				// creation d'un objet JFileChooser
				
			JFileChooser ficVol = new JFileChooser();
			ficVol.setDialogTitle("Choisir un fichier trafic avion  de la plateforme ");
			 int returnVal = ficVol.showOpenDialog(null);
			 
			   if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File fichiervoltTxt = ficVol.getSelectedFile();
		            //This is where a real application would open the file.
		            log.append("Ouverture de :  " + fichiervoltTxt.getName() );
		        
		        fichierVol.setText(fichiervoltTxt.getName());
		         
		         
		        } else {
		            log.append("Ouverture du fichier annulé" );
		        }
				 
			
			   
			   ///  fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			  
			}
	 }

	

}
