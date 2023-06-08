import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JPanel implements MouseListener {
	
	int gameMatrix[][];
	int player;
	int winner;
	boolean playAgain;

	public TicTacToe(){	
		gameMatrix = new int [3][3];
		// 1 for "O" 2 for "X"
		player = 1;
		winner = 0;
		playAgain = false;
	}
	
	@Override
	public void paintComponent(Graphics g2) {
		
		Graphics2D g = (Graphics2D) g2.create();
		
		if(playAgain) {
			String winnerSymbol = winner == 1 ? "O" : "X";
			int paneOption = JOptionPane.showConfirmDialog(this, (
					winner != 3 ? "Jogador " + winnerSymbol + " venceu!" : "Deu velha!")  + " Jogar de novo?"
			);
			
			if(paneOption == JOptionPane.OK_OPTION ) {
				playAgain = false;
				restartGame();
			}else {
				System.exit(1);
			}
		}
		
		g.setStroke(new BasicStroke(3));
		Font font = new Font("Consolas", Font.BOLD, 100);
		g.setFont(font);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 600, 600);
		
		g.setColor(Color.black);
		g.drawLine(0, 200, 600, 200);
		g.drawLine(0, 400, 600, 400);
		
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		
		for(int lin = 0; lin < 3; lin++) {
			for(int col = 0; col < 3; col++) {
				if(gameMatrix[lin][col] == 1) {
					g.setColor(Color.black);
					g.drawString("o", 75 + col * 200, 125 + lin * 200);
				}else if(gameMatrix[lin][col] == 2) {
					g.setColor(Color.black);
					g.drawString("x", 75 + col * 200, 125 + lin * 200);
				}
			}
		}
		
		if(winner != 0) {
			playAgain = true;
			repaint();
		}
	}	

	@Override
	public void mouseReleased(MouseEvent e) {
		int lin = e.getY()/200;
		int col = e.getX()/200;
		
		if(lin == 3) {
			lin = 2;
		}else if(col == 3) {
			col = 2;
		}
		
		if(gameMatrix[lin][col] != 0) 
			return;
		
		gameMatrix[lin][col] = player;
		player = player == 1 ? 2 : 1;
		
		verifyWinner();
		repaint();
	}
	
	private void verifyWinner() {
		  for (int col = 0; col < 3; col++) {
			  if (gameMatrix[0][col] == gameMatrix[1][col] &&
	              gameMatrix[0][col] == gameMatrix[2][col] &&
	              gameMatrix[0][col] != 0) {
	                  winner = gameMatrix[0][col];
	           }
	      }
		  
		  for (int lin = 0; lin < 3; lin++) {
			  if (gameMatrix[lin][0] == gameMatrix[lin][1] &&
				  gameMatrix[lin][0] == gameMatrix[lin][2] &&
				  gameMatrix[lin][0] != 0) {
	                  winner = gameMatrix[lin][0];
	          } 
		  }
		   
	      if (gameMatrix[0][0] == gameMatrix[1][1] &&
	          gameMatrix[0][0] == gameMatrix[2][2] &&
	          gameMatrix[0][0] != 0) {
	    	  	  winner = gameMatrix[0][0];
	      }
	      
	      if (gameMatrix[0][2] == gameMatrix[1][1] &&
	          gameMatrix[0][2] == gameMatrix[2][0] &&
	          gameMatrix[0][2] != 0) {
	          	  winner = gameMatrix[0][2];
	      }
	        
	      boolean full = true;
	        
	      for(int lin = 0; lin < 3; lin++) {
	    	  for(int col = 0; col < 3; col++) {
	    		  if (gameMatrix[lin][col] == 0)
	    			  full = false;
		      }
	      }
	        
	      if (full) 
	    	  winner = 3;
	}
	
	private void restartGame() {
		for(int lin = 0; lin < 3; lin++) {
			for(int col = 0; col < 3; col++) {
				gameMatrix[lin][col] = 0;
				winner = 0;
			}
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}