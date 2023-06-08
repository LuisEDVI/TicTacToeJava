import javax.swing.JFrame;

public class GameWindow {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Jogo da velha");
		frame.setSize(600,630);
		frame.setVisible(true);
		frame.setResizable(false);
		
		TicTacToe game = new TicTacToe();
		game.setBounds(0, 0, 600, 600);
		frame.add(game);
		
		frame.addMouseListener(game);

	}
}