import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class BeginingGameScreen extends JFrame implements ActionListener {
	
	//Play boolean
	public boolean GameOn = true;
	
	
	//JLabel
	JLabel Othello = new JLabel("Othello");
	JLabel CoolBackground = new JLabel(new ImageIcon("C:/Users/Vincent Kelly/Pictures/gifgif.gif"));
	
	
	
	//Buttons
	JButton PlayOthello = new JButton("Play Othello");
	JButton Exit = new JButton("Exit");
	
	//set Font of text
    Font Cool = new Font("Zapfino", Font.ITALIC,100);
    Font ok = new Font("Rockwell", Font.BOLD,20);

	public BeginingGameScreen() {
		
		
		
		int x = 550;
		int y = 550;
	
		
		
		
	    //JFrame layout
		this.setSize(x, y);
	    this.setVisible(true);
	    this.setResizable(false);
	    this.setTitle("Othello");
	    this.getContentPane().setBackground(Color.decode("#252525"));
	    
	    //this.setBackground(Color.);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	    //JPanel layout
	    CoolBackground.setLayout(null);
	    
	    //Color
	    Othello.setForeground(Color.decode("#63F472"));
	    
	    
	    // Positioning
	    //						x	       y	width	height
	    PlayOthello.setBounds((x/2)-75, (y/2), 150, 50);
	    Exit.setBounds((x/2)-75, ((y/2)+100), 150, 50);
	    Othello.setBounds(100, 25, 500, 200);
	    
	    
	   //Adding commands to the 2 buttons
	    PlayOthello.addActionListener(this);
		PlayOthello.setActionCommand("PLAY");
	    
		Exit.addActionListener(this);
		Exit.setActionCommand("EXIT");
		
	    //Adding to JFrame
	    
	    CoolBackground.add(Othello);
	    CoolBackground.add(PlayOthello);
	    CoolBackground.add(Exit);
	    this.add(CoolBackground);
	    
	    //setting Font
	    PlayOthello.setFont(ok);
	    Exit.setFont(ok);
	    Othello.setFont(Cool);
	   

	}
	
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("PLAY")){
			Grid Vince = new Grid();
			this.setVisible(false);
		}else{
			GameOn = false;
			System.exit(0);
		}
			
			
		}
	}