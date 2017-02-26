import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class OthelloBoard extends JFrame implements ActionListener {

	JButton[] theButtons = new JButton[65];
	
	JPanel buttons = new JPanel();
	
	//String pin = "0123";
	Font font = new Font("Courier", Font.BOLD, 50);
	String currentInput = "";
	int counter = 0;
	
	public OthelloBoard() {
		this.setTitle("Othelo grid test");

		this.setVisible(true);
		this.setSize(500, 725);
		this.setLayout(new BorderLayout());
		buttons.setLayout(new GridLayout(8, 8));
		makeTheButtons();
		this.getContentPane().add(BorderLayout.CENTER, buttons);
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		repaint();

	}

	public void makeTheButtons() {

		for (int i = 1; i < 65; i++) {
			theButtons[i] = new JButton("");
			theButtons[i].setFont(font);
			theButtons[i].addActionListener(this);
			theButtons[i].setActionCommand(i + "");
			buttons.add(theButtons[i]);

		}
		

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!arg0.getActionCommand().equals("ENT")&&!arg0.getActionCommand().equals("CLR")){
			currentInput += arg0.getActionCommand();
			
		}
	}
}

