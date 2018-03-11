package view.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controller.utilities.ChessSquareInterpreter;

public class ChessGui  {

	private JFrame gui;
	private JPanel chessPanel;
	private ChessSquareButton[][] chessSquares;
	private final int ROWS = 8;
	private final int COLLUMNS = 8;
	private final char[] xAxis = {'A', 'B', 'C', 'D', 'E', 'F', 'H', 'G'};
	private final char[] yAxis = {'8', '7', '6', '5', '4', '3', '2', '1'};

	private ChessSquareButton fromPos;
	private ChessSquareButton targetPos;

	private boolean hasChosenFromPos = false;

	public ChessGui() {
		setFramesAndPanels();

	}

	/*
	 * This answer at stackoverflow was very helpful when constructing the GUI.
	 * https://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui
	 */
	private void setFramesAndPanels() {
		gui = new JFrame("Chess By Hampus");
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

		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				chessSquares[j][i].setIconEmpty();
			}
		}

		for (int i = 0; i < 8; i++) {
			chessSquares[i][6].setIcon(getImage("Chess_plt60.png"));
		}

		chessSquares[0][7].setIcon(getImage("Chess_rlt60.png"));;
		chessSquares[1][7].setIcon(getImage("Chess_nlt60.png"));;
		chessSquares[2][7].setIcon(getImage("Chess_blt60.png"));;
		chessSquares[3][7].setIcon(getImage("Chess_qlt60.png"));;
		chessSquares[4][7].setIcon(getImage("Chess_klt60.png"));;
		chessSquares[5][7].setIcon(getImage("Chess_blt60.png"));;
		chessSquares[6][7].setIcon(getImage("Chess_nlt60.png"));;
		chessSquares[7][7].setIcon(getImage("Chess_rlt60.png"));;
	}

	public ImageIcon getImage(String imgName) {
		return new ImageIcon(getClass().getResource("/resources/chess_icons/"+ imgName));
	}

	private void createAndAddBoardButtonsToChessPanel() {
		ChessSquareButton b = null;
		for (int i = 0; i < COLLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				b = new ChessSquareButton(xAxis[j], yAxis[i]); 
				if((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)){
					b.setBackground(Color.DARK_GRAY);
				}
				else {
					b.setBackground(Color.WHITE);
				}
				b.addActionListener(new ChessSquareActionListener(b)
				{
					public void actionPerformed(ActionEvent e)
					{
						if(hasChosenFromPos) {
							if(getButton().getXY().matches(getChosenFromPosition().getXY())) {
								resetLocations();
							}
							else {
								setTargetPosition(getButton());
								if(sendToEngine(getChosenFromPosition(), getChosenTargetPosition())) {
									doMove();
									resetLocations();
								}
							}

						}
						else {
							if(!getButton().isEmpty()) {
								setFromPosition(getButton());
								hasChosenFromPos = true;
							}
							else
							getButton().setSelected(false);
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

	private boolean sendToEngine(ChessSquareButton from, ChessSquareButton to) {
		System.out.println("Checks if valid move: " + from.getXY() + " " + to.getXY());
		//Ersätt TO med FROMS bild,
		if(from.isEmpty()) {
			return false;
		}
		else {
			to.setIcon(from.getIcon());
			from.setIconEmpty();
			//BUGG if empty square is pressed, it will delete target image also
			//Tilldela chess_empty till FROMS bild.
			//TODO implement alternative to fail if not a valid move.
			return true;
		}
	}

	private void resetLocations() {
		hasChosenFromPos = false;
		setFromPosition(null);
		setTargetPosition(null);

	}

	public static abstract class ChessSquareActionListener implements ActionListener {
		private ChessSquareButton button;

		public ChessSquareActionListener(ChessSquareButton button) {
			this.button = button;
		}

		public ChessSquareButton getButton() {
			return button;
		}

	}

	private ChessSquareButton getChosenFromPosition() {
		return fromPos;
	}

	private void setFromPosition(ChessSquareButton from) {
		this.fromPos = from;
	}

	private ChessSquareButton getChosenTargetPosition() {
		return targetPos;
	}

	private void setTargetPosition(ChessSquareButton target) {
		this.targetPos = target;
	}


	private void addButtonValue() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		ChessGui gui = new ChessGui();


	}
}