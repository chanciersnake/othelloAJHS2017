import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.w3c.dom.ranges.Range;





public class Grid extends JFrame implements ActionListener {

	public boolean Player = true;		//true = white ..... false = black
	public boolean Firstturn = true;
	public String BorW;
	public int GetActionCommand;
	public int Down;
	public int LeftRight;
	public boolean InArow = false;
	public int previousGetAction;
	
	
	JButton[] theButtons = new JButton[65];
	
	JLabel[][] theLabels = new JLabel[8][8];
	
	JFrame VisibleC = new JFrame();
	
	JPanel label = new JPanel();
	JPanel buttons = new JPanel();
	
	
	
	Object[][] twoDim = new Object[8][8];{
		
		for(int z = 0; z < 8; z++){
			for(int x = 0; x < 8; x++){
				twoDim[z][x] = Chips.EMPTY;
			}
		}
		if(Firstturn == true){
			twoDim[3][3] = Chips.cBLACK;
			twoDim[3][4] = Chips.cWHITE;
			twoDim[4][3] = Chips.cWHITE;
			twoDim[4][4] = Chips.cBLACK;
		}
	}
	
	
	
	
	
	
	Font font = new Font("Courier", Font.BOLD, 50);
	
	
	public Grid() {
		gridShit();
		VisibleCheck();
	}

	
	public void gridShit(){
		this.setTitle("Othelo grid test");

		this.setVisible(true);
		this.setSize(800, 800);
		this.setLayout(new BorderLayout());
		buttons.setLayout(new GridLayout(8, 8));
		makeTheButtons();
		this.getContentPane().add(BorderLayout.CENTER, buttons);
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		repaint();
	}
	
	public void VisibleCheck(){
		VisibleC.setTitle("EnumCheck");

		
		VisibleC.setVisible(true);
		VisibleC.setSize(800, 800);
		VisibleC.setLayout(new BorderLayout());
		label.setLayout(new GridLayout(8, 8));
		
		makeTheJlabels();
		
		
		VisibleC.getContentPane().add(BorderLayout.CENTER, label);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		repaint();
	}
	
	
	
	public void makeTheButtons() {

		for (int i = 0; i < 64; i++) {
			theButtons[i] = new JButton("");
			theButtons[i].setFont(font);
			theButtons[i].addActionListener(this);
			theButtons[i].setActionCommand(i + "");
			theButtons[i].setBackground(Color.GREEN);
			buttons.add(theButtons[i]);

		}
		
		theButtons[27].setBackground(Color.BLACK);
		theButtons[28].setBackground(Color.WHITE);
		theButtons[35].setBackground(Color.WHITE);
		theButtons[36].setBackground(Color.BLACK);

		repaint();
	}
	
	
	
	public void makeTheJlabels(){

		for(int z = 0; z < 8; z++){
			for(int x = 0; x < 8; x++){
		theLabels[z][x] = new JLabel((twoDim[z][x]).toString());
		label.add(theLabels[z][x]);
			}
		}
		repaint();
	}
	
	
	
	//enums for each chip
	public enum Chips{
		EMPTY, cWHITE, cBLACK
	}

	
	
	
	
	
	
	
	public void refreshtheJLabel(){
		VisibleC.remove(label);
		label.removeAll();
		VisibleCheck();
		label.updateUI();
	}
	
	//two[y][x];
	
	
	
	
	
	public void CheckVertical(){
		if (Player == true){ 		//white
			for(int o = 7; o >= 0; o --){
				if(twoDim[o][GetActionCommand%8].toString().equals("cWHITE")){
					if(o<7){
						//if(GetActionCommand/8 != 7)
					if(twoDim[o+1][GetActionCommand%8].toString().equals("cBLACK")){
						
						
						
						if(((o+1) != 7)&&(twoDim[o+2][GetActionCommand%8].toString().equals("cWHITE"))){
							twoDim[o+1][GetActionCommand%8] = Chips.cWHITE;
							theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
							
							}else{
								if(((o+1) != 7)&&(twoDim[o+2][GetActionCommand%8].toString().equals("cBLACK"))){
									if(twoDim[o+3][GetActionCommand%8].toString().equals("cWHITE")){
										twoDim[o+1][GetActionCommand%8] = Chips.cWHITE;
										twoDim[o+2][GetActionCommand%8] = Chips.cWHITE;
										theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
										theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
										
										}else{
											if(twoDim[o+3][GetActionCommand%8].toString().equals("cBLACK")){
												if(((o+3) != 7)&&(twoDim[o+4][GetActionCommand%8].toString().equals("cWHITE"))){
												twoDim[o+1][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+2][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+3][GetActionCommand%8] = Chips.cWHITE;
												theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+3)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
										}else{
											if(((o+3) != 7)&&(twoDim[o+4][GetActionCommand%8].toString().equals("cBLACK"))){
												if(((o+4) != 7)&&(twoDim[o+5][GetActionCommand%8].toString().equals("cWHITE"))){
												twoDim[o+1][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+2][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+3][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+4][GetActionCommand%8] = Chips.cWHITE;
												theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+3)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+4)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
										}else{
											if(((o+4) != 7)&&(twoDim[o+5][GetActionCommand%8].toString().equals("cBLACK"))){
												if(((o+5) != 7)&&(twoDim[o+6][GetActionCommand%8].toString().equals("cWHITE"))){
												twoDim[o+1][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+2][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+3][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+4][GetActionCommand%8] = Chips.cWHITE;
												twoDim[o+5][GetActionCommand%8] = Chips.cWHITE;
												theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+3)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+4)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
												theButtons[(o+5)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
										}
								}
							}
						}
					}		
				}
			}
		}
	}
	}
}else{
	
	
							if(twoDim[o-6][GetActionCommand%8].toString().equals("cBLACK")){
								if(twoDim[o-7][GetActionCommand%8].toString().equals("cWHITE")){
									if(twoDim[o-5][GetActionCommand%8].toString().equals("cBLACK")){
										if(twoDim[o-4][GetActionCommand%8].toString().equals("cBLACK")){
											if(twoDim[o-3][GetActionCommand%8].toString().equals("cBLACK")){
												if(twoDim[o-2][GetActionCommand%8].toString().equals("cBLACK")){
													if(twoDim[o-1][GetActionCommand%8].toString().equals("cBLACK")){
								twoDim[o-1][GetActionCommand%8] = Chips.cWHITE;
								twoDim[o-2][GetActionCommand%8] = Chips.cWHITE;
								twoDim[o-3][GetActionCommand%8] = Chips.cWHITE;
								twoDim[o-4][GetActionCommand%8] = Chips.cWHITE;
								twoDim[o-5][GetActionCommand%8] = Chips.cWHITE;
								twoDim[o-6][GetActionCommand%8] = Chips.cWHITE;
								theButtons[(o-1)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
								theButtons[(o-2)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
								theButtons[(o-3)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
								theButtons[(o-4)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
								theButtons[(o-5)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
								theButtons[(o-6)*8 + (GetActionCommand%8)].setBackground(Color.WHITE);
								
										}
									}
								}
							}	
						}
					}
				}
			}
		}
	}		
}else{
	for(int o = 7; o >= 0; o --){
		//isGetActionCommandEqual();
	if(twoDim[o][GetActionCommand%8].toString().equals("cBLACK")){
		if(o<7){
		if(twoDim[o+1][GetActionCommand%8].toString().equals("cWHITE")){
			
			if(((o+1) != 7)&&(twoDim[o+2][GetActionCommand%8].toString().equals("cBLACK"))){
				twoDim[o+1][GetActionCommand%8] = Chips.cBLACK;
				theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
				
				}else{
					if(((o+1) != 7)&&(twoDim[o+2][GetActionCommand%8].toString().equals("cWHITE"))){
						if(((o+1) != 7&&(twoDim[o+3][GetActionCommand%8].toString().equals("cBLACK")))){
							twoDim[o+1][GetActionCommand%8] = Chips.cBLACK;
							twoDim[o+2][GetActionCommand%8] = Chips.cBLACK;
							theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
							theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
							
							}else{
								if(twoDim[o+3][GetActionCommand%8].toString().equals("cWHITE")){
									if(((o+3) != 7)&&(twoDim[o+4][GetActionCommand%8].toString().equals("cBLACK"))){
									twoDim[o+1][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+2][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+3][GetActionCommand%8] = Chips.cBLACK;
									theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+3)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
							}else{
								if(((o+3) != 7)&&(twoDim[o+4][GetActionCommand%8].toString().equals("cWHITE"))){
									if(twoDim[o+5][GetActionCommand%8].toString().equals("cBLACK")){
									twoDim[o+1][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+2][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+3][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+4][GetActionCommand%8] = Chips.cBLACK;
									theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+3)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+4)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
							}else{
								if(twoDim[o+5][GetActionCommand%8].toString().equals("cWHITE")){
									if(((o+5) != 7)&&(twoDim[o+6][GetActionCommand%8].toString().equals("cBLACK"))){
									twoDim[o+1][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+2][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+3][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+4][GetActionCommand%8] = Chips.cBLACK;
									twoDim[o+5][GetActionCommand%8] = Chips.cBLACK;
									theButtons[(o+1)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+2)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+3)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+4)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
									theButtons[(o+5)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
			
									
						
									}
								}
							}
						}
					}		
				}
			}
		}
	}
}
}else{


				if(twoDim[o-6][GetActionCommand%8].toString().equals("cWHITE")){
					if(twoDim[o-7][GetActionCommand%8].toString().equals("cBLACK")){
						if(twoDim[o-5][GetActionCommand%8].toString().equals("cWHITE")){
							if(twoDim[o-4][GetActionCommand%8].toString().equals("cWHITE")){
								if(twoDim[o-3][GetActionCommand%8].toString().equals("cWHITE")){
									if(twoDim[o-2][GetActionCommand%8].toString().equals("cWHITE")){
										if(twoDim[o-1][GetActionCommand%8].toString().equals("cWHITE")){
					twoDim[o-1][GetActionCommand%8] = Chips.cBLACK;
					twoDim[o-2][GetActionCommand%8] = Chips.cBLACK;
					twoDim[o-3][GetActionCommand%8] = Chips.cBLACK;
					twoDim[o-4][GetActionCommand%8] = Chips.cBLACK;
					twoDim[o-5][GetActionCommand%8] = Chips.cBLACK;
					twoDim[o-6][GetActionCommand%8] = Chips.cBLACK;
					theButtons[(o-1)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
					theButtons[(o-2)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
					theButtons[(o-3)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
					theButtons[(o-4)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
					theButtons[(o-5)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
					theButtons[(o-6)*8 + (GetActionCommand%8)].setBackground(Color.BLACK);
					
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}		
	}
}

	
	
	public void CheckHorizontal(){
		if (Player == true){ 		//white
			//System.out.println(theButtons[GetActionCommand-1].getBackground().toString());
			for(int o = 7; o >= 0; o --){
					
				if(twoDim[GetActionCommand/8][o].toString().equals("cWHITE")){
					if(o<7){
					if(twoDim[GetActionCommand/8][o+1].toString().equals("cBLACK")){
						
						if(((o+1) != 7)&&(twoDim[GetActionCommand/8][o+2].toString().equals("cWHITE"))){
							twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
							
							
							if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
							theButtons[GetActionCommand-1].setBackground(Color.WHITE);
							}else{
								theButtons[GetActionCommand+1].setBackground(Color.WHITE);
							}
							
							
							
							
							if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))
									&&(!theButtons[GetActionCommand-2].getBackground().toString().equals("java.awt.Color[r=0,g=0,b=0]"))
									&&(!theButtons[GetActionCommand+2].getBackground().toString().equals("java.awt.Color[r=0,g=0,b=0]"))){
									theButtons[GetActionCommand-1].setBackground(Color.WHITE);
									theButtons[GetActionCommand+1].setBackground(Color.WHITE);
								}
							
							
							
							}else{
								if(((o+1) != 7)&&(twoDim[GetActionCommand/8][o+2].toString().equals("cBLACK"))){
									if(twoDim[GetActionCommand/8][o+3].toString().equals("cWHITE")){
										twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
										twoDim[GetActionCommand/8][o+2] = Chips.cWHITE;
										
										
										
										
										if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
											theButtons[GetActionCommand-1].setBackground(Color.WHITE);
											theButtons[GetActionCommand-2].setBackground(Color.WHITE);
											}else{
												theButtons[GetActionCommand+1].setBackground(Color.WHITE);
												theButtons[GetActionCommand+2].setBackground(Color.WHITE);
											}
										
										
										
										if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
											theButtons[GetActionCommand-1].setBackground(Color.WHITE);
											theButtons[GetActionCommand-2].setBackground(Color.WHITE);
											theButtons[GetActionCommand+1].setBackground(Color.WHITE);
											theButtons[GetActionCommand-2].setBackground(Color.WHITE);
										}
										
										
										
										
										}else{
											if(twoDim[GetActionCommand/8][o+3].toString().equals("cBLACK")){
												if(((o+3) != 7)&&(twoDim[GetActionCommand/8][o+4].toString().equals("cWHITE"))){
												twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+2] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+3] = Chips.cWHITE;
												
												
												
												if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
													theButtons[GetActionCommand-1].setBackground(Color.WHITE);
													theButtons[GetActionCommand-2].setBackground(Color.WHITE);
													theButtons[GetActionCommand-3].setBackground(Color.WHITE);
													}else{
														theButtons[GetActionCommand+1].setBackground(Color.WHITE);
														theButtons[GetActionCommand+2].setBackground(Color.WHITE);
														theButtons[GetActionCommand+3].setBackground(Color.WHITE);
													}
												
												
												
												
											
												if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
													theButtons[GetActionCommand-1].setBackground(Color.WHITE);
													theButtons[GetActionCommand-2].setBackground(Color.WHITE);
													theButtons[GetActionCommand-3].setBackground(Color.WHITE);
													theButtons[GetActionCommand+1].setBackground(Color.WHITE);
													theButtons[GetActionCommand+2].setBackground(Color.WHITE);
													theButtons[GetActionCommand+3].setBackground(Color.WHITE);
												}
												
												
												
										}else{
											if(((o+3) != 7)&&(twoDim[GetActionCommand/8][o+4].toString().equals("cBLACK"))){
												if(twoDim[GetActionCommand/8][o+5].toString().equals("cWHITE")){
												twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
												
												
												
												if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
													theButtons[GetActionCommand-1].setBackground(Color.WHITE);
													theButtons[GetActionCommand-2].setBackground(Color.WHITE);
													theButtons[GetActionCommand-3].setBackground(Color.WHITE);
													theButtons[GetActionCommand-4].setBackground(Color.WHITE);
													}else{
														theButtons[GetActionCommand+1].setBackground(Color.WHITE);
														theButtons[GetActionCommand+2].setBackground(Color.WHITE);
														theButtons[GetActionCommand+3].setBackground(Color.WHITE);
														theButtons[GetActionCommand+4].setBackground(Color.WHITE);
													}
												
												
												
												
												if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
													theButtons[GetActionCommand-1].setBackground(Color.WHITE);
													theButtons[GetActionCommand-2].setBackground(Color.WHITE);
													theButtons[GetActionCommand-3].setBackground(Color.WHITE);
													theButtons[GetActionCommand-4].setBackground(Color.WHITE);
													theButtons[GetActionCommand+1].setBackground(Color.WHITE);
													theButtons[GetActionCommand+2].setBackground(Color.WHITE);
													theButtons[GetActionCommand+3].setBackground(Color.WHITE);
													theButtons[GetActionCommand+4].setBackground(Color.WHITE);
												}
												
												
												
												
										}else{
											if(twoDim[GetActionCommand/8][o+5].toString().equals("cBLACK")){
												if(((o+5) != 7)&&(twoDim[GetActionCommand/8][o+6].toString().equals("cWHITE"))){
												twoDim[GetActionCommand/8][o+1] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+2] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+3] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+4] = Chips.cWHITE;
												twoDim[GetActionCommand/8][o+5] = Chips.cWHITE;
												
												
												
												if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
													theButtons[GetActionCommand-1].setBackground(Color.WHITE);
													theButtons[GetActionCommand-2].setBackground(Color.WHITE);
													theButtons[GetActionCommand-3].setBackground(Color.WHITE);
													theButtons[GetActionCommand-4].setBackground(Color.WHITE);
													theButtons[GetActionCommand-5].setBackground(Color.WHITE);
													}else{
														theButtons[GetActionCommand+1].setBackground(Color.WHITE);
														theButtons[GetActionCommand+2].setBackground(Color.WHITE);
														theButtons[GetActionCommand+3].setBackground(Color.WHITE);
														theButtons[GetActionCommand+4].setBackground(Color.WHITE);
														theButtons[GetActionCommand+5].setBackground(Color.WHITE);
													}
												
												
												
												if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
													theButtons[GetActionCommand-1].setBackground(Color.WHITE);
													theButtons[GetActionCommand-2].setBackground(Color.WHITE);
													theButtons[GetActionCommand-3].setBackground(Color.WHITE);
													theButtons[GetActionCommand-4].setBackground(Color.WHITE);
													theButtons[GetActionCommand-5].setBackground(Color.WHITE);
													theButtons[GetActionCommand+1].setBackground(Color.WHITE);
													theButtons[GetActionCommand+2].setBackground(Color.WHITE);
													theButtons[GetActionCommand+3].setBackground(Color.WHITE);
													theButtons[GetActionCommand+4].setBackground(Color.WHITE);
													theButtons[GetActionCommand+5].setBackground(Color.WHITE);
												}
												
												
												
										}
								}
							}
						}
					}		
				}
			}
		}
	}
	}
}else{
	
	
							if(twoDim[GetActionCommand/8][o-6].toString().equals("cBLACK")){
								if(twoDim[GetActionCommand/8][o-7].toString().equals("cWHITE")){
									if(twoDim[GetActionCommand/8][o-5].toString().equals("cBLACK")){
										if(twoDim[GetActionCommand/8][o-4].toString().equals("cBLACK")){
											if(twoDim[GetActionCommand/8][o-3].toString().equals("cBLACK")){
												if(twoDim[GetActionCommand/8][o-2].toString().equals("cBLACK")){
													if(twoDim[GetActionCommand/8][o-1].toString().equals("cBLACK")){
											
										twoDim[GetActionCommand/8][o-1] = Chips.cWHITE;
										twoDim[GetActionCommand/8][o-2] = Chips.cWHITE;
										twoDim[GetActionCommand/8][o-3] = Chips.cWHITE;
										twoDim[GetActionCommand/8][o-4] = Chips.cWHITE;
										twoDim[GetActionCommand/8][o-5] = Chips.cWHITE;
										twoDim[GetActionCommand/8][o-6] = Chips.cWHITE;
								
								
								if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
									theButtons[GetActionCommand-1].setBackground(Color.WHITE);
									theButtons[GetActionCommand-2].setBackground(Color.WHITE);
									theButtons[GetActionCommand-3].setBackground(Color.WHITE);
									theButtons[GetActionCommand-4].setBackground(Color.WHITE);
									theButtons[GetActionCommand-5].setBackground(Color.WHITE);
									theButtons[GetActionCommand-6].setBackground(Color.WHITE);
									}
								
								
								
								
								
								if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
									theButtons[GetActionCommand-1].setBackground(Color.WHITE);
									theButtons[GetActionCommand-2].setBackground(Color.WHITE);
									theButtons[GetActionCommand-3].setBackground(Color.WHITE);
									theButtons[GetActionCommand-4].setBackground(Color.WHITE);
									theButtons[GetActionCommand-5].setBackground(Color.WHITE);
									theButtons[GetActionCommand-6].setBackground(Color.WHITE);
								}
								
								
										}
									}
								}
							}	
						}
					}
				}
			}
		}
	}		
}else{
	for(int o = 7; o >= 0; o --){
		
	if(twoDim[GetActionCommand/8][o].toString().equals("cBLACK")){
		if(o<7){
		if(twoDim[GetActionCommand/8][o+1].toString().equals("cWHITE")){
			
			if(((o+1) != 7)&&(twoDim[GetActionCommand/8][o+2].toString().equals("cBLACK"))){
				twoDim[GetActionCommand/8][o+1] = Chips.cBLACK;
				
				
				if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
					theButtons[GetActionCommand-1].setBackground(Color.BLACK);
					}else{
						theButtons[GetActionCommand+1].setBackground(Color.BLACK);
					}
				
				
				if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
					theButtons[GetActionCommand-1].setBackground(Color.WHITE);
					theButtons[GetActionCommand+1].setBackground(Color.WHITE);
				}
				
				
				
				}else{
					if(((o+1) != 7)&&(twoDim[GetActionCommand/8][o+2].toString().equals("cWHITE"))){
						if(twoDim[GetActionCommand/8][o+3].toString().equals("cBLACK")){
							twoDim[GetActionCommand/8][o+1] = Chips.cBLACK;
							twoDim[GetActionCommand/8][o+2] = Chips.cBLACK;
							
							if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
								theButtons[GetActionCommand-1].setBackground(Color.BLACK);
								theButtons[GetActionCommand-2].setBackground(Color.BLACK);
								}else{
									theButtons[GetActionCommand+1].setBackground(Color.BLACK);
									theButtons[GetActionCommand+2].setBackground(Color.BLACK);
								}
							
							
							
							if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
								theButtons[GetActionCommand-1].setBackground(Color.WHITE);
								theButtons[GetActionCommand+1].setBackground(Color.WHITE);
								theButtons[GetActionCommand-2].setBackground(Color.WHITE);
								theButtons[GetActionCommand+2].setBackground(Color.WHITE);
							}
							
							
							
							}else{
								if(twoDim[GetActionCommand/8][o+3].toString().equals("cWHITE")){
									if(((o+3) != 7)&&(twoDim[GetActionCommand/8][o+4].toString().equals("cBLACK"))){
									twoDim[GetActionCommand/8][o+1] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+2] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+3] = Chips.cBLACK;
									
									
									if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
										theButtons[GetActionCommand-1].setBackground(Color.BLACK);
										theButtons[GetActionCommand-2].setBackground(Color.BLACK);
										theButtons[GetActionCommand-3].setBackground(Color.BLACK);
										}else{
											theButtons[GetActionCommand+1].setBackground(Color.BLACK);
											theButtons[GetActionCommand+2].setBackground(Color.BLACK);
											theButtons[GetActionCommand+3].setBackground(Color.BLACK);
										}
									
									
									
									if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
										theButtons[GetActionCommand-1].setBackground(Color.WHITE);
										theButtons[GetActionCommand+1].setBackground(Color.WHITE);
										theButtons[GetActionCommand-2].setBackground(Color.WHITE);
										theButtons[GetActionCommand+2].setBackground(Color.WHITE);
										theButtons[GetActionCommand-3].setBackground(Color.WHITE);
										theButtons[GetActionCommand+3].setBackground(Color.WHITE);
									}
									
									
									
							}else{
								if(((o+3) != 7)&&(twoDim[GetActionCommand/8][o+4].toString().equals("cWHITE"))){
									if(((o+4) != 7)&&(twoDim[GetActionCommand/8][o+5].toString().equals("cBLACK"))){
									twoDim[GetActionCommand/8][o+1] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+2] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+3] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+4] = Chips.cBLACK;
									
									
									if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
										theButtons[GetActionCommand-1].setBackground(Color.BLACK);
										theButtons[GetActionCommand-2].setBackground(Color.BLACK);
										theButtons[GetActionCommand-3].setBackground(Color.BLACK);
										theButtons[GetActionCommand-4].setBackground(Color.BLACK);
										}else{
											theButtons[GetActionCommand+1].setBackground(Color.BLACK);
											theButtons[GetActionCommand+2].setBackground(Color.BLACK);
											theButtons[GetActionCommand+3].setBackground(Color.BLACK);
											theButtons[GetActionCommand+4].setBackground(Color.BLACK);
										}
									
									if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
										theButtons[GetActionCommand-1].setBackground(Color.WHITE);
										theButtons[GetActionCommand+1].setBackground(Color.WHITE);
										theButtons[GetActionCommand-2].setBackground(Color.WHITE);
										theButtons[GetActionCommand+2].setBackground(Color.WHITE);
										theButtons[GetActionCommand-3].setBackground(Color.WHITE);
										theButtons[GetActionCommand+3].setBackground(Color.WHITE);
										theButtons[GetActionCommand-4].setBackground(Color.WHITE);
										theButtons[GetActionCommand+4].setBackground(Color.WHITE);
									}
									
									
									
							}else{
								if(((o+4) != 7)&&(twoDim[GetActionCommand/8][o+5].toString().equals("cWHITE"))){
									if(((o+5) != 7)&&(twoDim[GetActionCommand/8][o+6].toString().equals("cBLACK"))){
									twoDim[GetActionCommand/8][o+1] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+2] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+3] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+4] = Chips.cBLACK;
									twoDim[GetActionCommand/8][o+5] = Chips.cBLACK;
									
									
									
									
									if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
										theButtons[GetActionCommand-1].setBackground(Color.BLACK);
										theButtons[GetActionCommand-2].setBackground(Color.BLACK);
										theButtons[GetActionCommand-3].setBackground(Color.BLACK);
										theButtons[GetActionCommand-4].setBackground(Color.BLACK);
										theButtons[GetActionCommand-5].setBackground(Color.BLACK);
										}else{
											theButtons[GetActionCommand+1].setBackground(Color.BLACK);
											theButtons[GetActionCommand+2].setBackground(Color.BLACK);
											theButtons[GetActionCommand+3].setBackground(Color.BLACK);
											theButtons[GetActionCommand+4].setBackground(Color.BLACK);
											theButtons[GetActionCommand+5].setBackground(Color.BLACK);
										}
									
									
									if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
										theButtons[GetActionCommand-1].setBackground(Color.WHITE);
										theButtons[GetActionCommand+1].setBackground(Color.WHITE);
										theButtons[GetActionCommand-2].setBackground(Color.WHITE);
										theButtons[GetActionCommand+2].setBackground(Color.WHITE);
										theButtons[GetActionCommand-3].setBackground(Color.WHITE);
										theButtons[GetActionCommand+3].setBackground(Color.WHITE);
										theButtons[GetActionCommand-4].setBackground(Color.WHITE);
										theButtons[GetActionCommand+4].setBackground(Color.WHITE);
										theButtons[GetActionCommand-5].setBackground(Color.WHITE);
										theButtons[GetActionCommand+5].setBackground(Color.WHITE);
									}
									
									
									
									
							}
					}
				}
			}
		}		
	}
}
}
}
}
}else{


	if(twoDim[GetActionCommand/8][o-6].toString().equals("cWHITE")){
		if(twoDim[GetActionCommand/8][o-7].toString().equals("cBLACK")){
			if(twoDim[GetActionCommand/8][o-5].toString().equals("cWHITE")){
				if(twoDim[GetActionCommand/8][o-4].toString().equals("cWHITE")){
					if(twoDim[GetActionCommand/8][o-3].toString().equals("cWHITE")){
						if(twoDim[GetActionCommand/8][o-2].toString().equals("cWHITE")){
							if(twoDim[GetActionCommand/8][o-1].toString().equals("cWHITE")){
		twoDim[GetActionCommand/8][o-1] = Chips.cBLACK;
		twoDim[GetActionCommand/8][o-2] = Chips.cBLACK;
		twoDim[GetActionCommand/8][o-3] = Chips.cBLACK;
		twoDim[GetActionCommand/8][o-4] = Chips.cBLACK;
		twoDim[GetActionCommand/8][o-5] = Chips.cBLACK;
		twoDim[GetActionCommand/8][o-6] = Chips.cBLACK;
		
		
		if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
			theButtons[GetActionCommand-1].setBackground(Color.BLACK);
			theButtons[GetActionCommand-2].setBackground(Color.BLACK);
			theButtons[GetActionCommand-3].setBackground(Color.BLACK);
			theButtons[GetActionCommand-4].setBackground(Color.BLACK);
			theButtons[GetActionCommand-5].setBackground(Color.BLACK);
			theButtons[GetActionCommand-6].setBackground(Color.BLACK);
			}
					
		
		
		if((!theButtons[GetActionCommand-1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))&&(!theButtons[GetActionCommand+1].getBackground().toString().equals("java.awt.Color[r=0,g=255,b=0]"))){
			theButtons[GetActionCommand-1].setBackground(Color.WHITE);
			theButtons[GetActionCommand-2].setBackground(Color.WHITE);
			theButtons[GetActionCommand-3].setBackground(Color.WHITE);
			theButtons[GetActionCommand-4].setBackground(Color.WHITE);
			theButtons[GetActionCommand-5].setBackground(Color.WHITE);
			theButtons[GetActionCommand-6].setBackground(Color.WHITE);
			}
							
									}
								}
							}
						}
					}
				}
			}
		}
	}
}		
	
	
	
}
	}
	
	
	public void CheckDiagnol(){
		
	}
	
	
	public void isMoveValid(){
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//System.out.println(arg0.getActionCommand());
		//System.out.println(Player);
		
		
		GetActionCommand = Integer.parseInt(arg0.getActionCommand());
		previousGetAction = GetActionCommand;
		
		
		
		
		if(Player == true){
			BorW = "white";
			previousGetAction = GetActionCommand;
		}else{
			BorW = "black";
		}
		
		
		for (int i = 0; i < 64; i++) {
			
			if((arg0.getActionCommand().equals(i + ""))&&(twoDim[Integer.parseInt(arg0.getActionCommand())/8][Integer.parseInt(arg0.getActionCommand())%8] == Chips.cWHITE)||
					(twoDim[Integer.parseInt(arg0.getActionCommand())/8][Integer.parseInt(arg0.getActionCommand())%8] == Chips.cBLACK)){
				JOptionPane.showMessageDialog(null, "Error player " + BorW + " placed a chip on top of another chip. Try again.");
				break;
			}
			
			if((arg0.getActionCommand().equals(i + ""))&&(Player == true)){
				theButtons[Integer.parseInt(arg0.getActionCommand())].setBackground(Color.WHITE);
				twoDim[Integer.parseInt(arg0.getActionCommand())/8][Integer.parseInt(arg0.getActionCommand())%8] = Chips.cWHITE;
				
				CheckVertical();
				CheckHorizontal();
				//CheckDiagnol();
				
				//System.out.println(twoDim[Integer.parseInt(arg0.getActionCommand())/8][Integer.parseInt(arg0.getActionCommand())%8]);
				refreshtheJLabel();
				Player = false;
				break;
			
			}
			
			if((arg0.getActionCommand().equals(i + ""))&&(Player == false)){
				theButtons[Integer.parseInt(arg0.getActionCommand())].setBackground(Color.BLACK);
				twoDim[Integer.parseInt(arg0.getActionCommand())/8][Integer.parseInt(arg0.getActionCommand())%8] = Chips.cBLACK;
				
				CheckVertical();
				CheckHorizontal();
				//CheckDiagnol();
				
				//System.out.println(twoDim[Integer.parseInt(arg0.getActionCommand())/8][Integer.parseInt(arg0.getActionCommand())%8]);
				refreshtheJLabel();
				Player = true;
				break;
				
				
			}
			
		}
	}
}