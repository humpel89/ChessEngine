package view.gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.chess.rules.PieceType;

public class ChessGui  {

	private JFrame gui;
	private JPanel chessPanel;
	private ChessSquareButton[][] chessSquares;
	private final int ROWS = 8;
	private final int COLLUMNS = 8;
	private final char[] xAxis = {'A', 'B', 'C', 'D', 'E', 'F', 'H', 'G'};
	private final char[] yAxis = {'8', '7', '6', '5', '4', '3', '2', '1'};
	
	private String fromPos = "";
	private String targetPos = "";

	private boolean hasChosenFromPos = false;

	public ChessGui() {
		setFramesAndPanels();

	}

	/*
	 * This answer at stackoverflow was very helpful when constructing the GUI.
	 * https://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui
	 */
	private void setFramesAndPanels() {
		gui = new JFrame();
		gui.setSize(600, 600);

		chessPanel = new JPanel();
		chessPanel.setSize(600, 600);
		chessPanel.setLayout(new GridLayout(8, 8));
		chessSquares = new ChessSquareButton[ROWS][COLLUMNS];

		createAndAddBoardButtonsToChessPanel();
		attImagesToChessSquares();
		
		gui.add(chessPanel);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void attImagesToChessSquares() {
		chessSquares[0][0].setIcon(getImage("Chess_rdt60.png"));;
		chessSquares[1][0].setIcon(getImage("Chess_ndt60.png"));;
		chessSquares[2][0].setIcon(getImage("Chess_bdt60.png"));;
		chessSquares[3][0].setIcon(getImage("Chess_qdt60.png"));;
		chessSquares[4][0].setIcon(getImage("Chess_kdt60.png"));;
		chessSquares[5][0].setIcon(getImage("Chess_bdt60.png"));;
		chessSquares[6][0].setIcon(getImage("Chess_ndt60.png"));;
		chessSquares[7][0].setIcon(getImage("Chess_rdt60.png"));;
		
		for (int i = 0; i < 8; i++) {
			chessSquares[i][1].setIcon(getImage("Chess_pdt60.png"));
		}
		
	}
	
	public ImageIcon getImage(String imgName) {
		return new ImageIcon(getClass().getResource("/resources/chess_icons/"+ imgName));
	}

	private void createAndAddBoardButtonsToChessPanel() {
		ChessSquareButton b;
		for (int i = 0; i < COLLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				b = new ChessSquareButton(xAxis[j], yAxis[i]); 
				if((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)){
					b.setBackground(Color.DARK_GRAY);
				}
				else {
					b.setBackground(Color.WHITE);
				}
				b.addActionListener(new ChessSquareActionListener(b.getXY())
				{
					public void actionPerformed(ActionEvent e)
					{
						if(hasChosenFromPos) {
							if(getXY().matches(getChosenFromPosition())) {
								resetLocations();
							}
							else {
								setTargetPosition(getXY());
								if(sendToEngine(getChosenFromPosition(), getChosenTargetPosition()));
								doMove();
								resetLocations();
							}

						}
						else {
							setFromPosition(getXY());
							hasChosenFromPos = true;
						}

					}


				});
				chessSquares[j][i] = b;
				chessPanel.add(b);
			}

		}

	}

	private void doMove() {

	}

	private boolean sendToEngine(String from, String to) {
		System.out.println("Checks if valid move: " + from + " " + to);
		//TODO implement alternative to fail if not a valid move.
		return true;
	}

	private void resetLocations() {
		hasChosenFromPos = false;
		setFromPosition("");
		setTargetPosition("");

	}

	public static abstract class ChessSquareActionListener implements ActionListener {
		private String xy;

		public ChessSquareActionListener(String square) {
			this.xy = square;
		}

		public String getXY() {
			return xy;
		}

	}

	private String getChosenFromPosition() {
		return fromPos;
	}

	private void setFromPosition(String from) {
		this.fromPos = from;
	}

	private String getChosenTargetPosition() {
		return targetPos;
	}

	private void setTargetPosition(String target) {
		this.targetPos = target;
	}


	private void addButtonValue() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		ChessGui gui = new ChessGui();


	}
}