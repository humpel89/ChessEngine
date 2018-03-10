package view.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;

public class ChessGui  {
	
	public ChessGui() {

		JFrame frame = new JFrame();
		frame.setSize(800, 600);

		JPanel chessPanel = new JPanel();
		chessPanel.setLayout(new GridLayout(8, 8));
		
		
		JButton[][] chessSquares = new JButton[8][8];
		
		
		JPanel squarePanel = new JPanel();
		squarePanel.setBackground(Color.BLUE);
		squarePanel.setSize(30, 30);
		squarePanel.setVisible(true);
		chessPanel.add(squarePanel);
		chessPanel.setVisible(true);
		JPanel textPanel = new JPanel();
		TextArea textView = new TextArea();
		textPanel.add(textView);
		
	
		frame.add(chessPanel);
		frame.add(textPanel);

		frame.setVisible(true);
		textView.setText("Hello world!");
		
	}

	public static void main(String[] args) {

		ChessGui gui = new ChessGui();


	}
}