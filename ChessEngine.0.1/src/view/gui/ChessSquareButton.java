package view.gui;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ChessSquareButton extends JButton {

	private char xAxis;
	private char yAxis;
	
	public ChessSquareButton(char cx, char cy) {
		this.xAxis = cx;
		this.yAxis = cy;
	}
	
	public char getXaxis() {
		return xAxis;
	}

	public char getYaxis() {
		return yAxis;
	}

	public String getXY() {
		return new StringBuilder().append(xAxis).append(yAxis).toString();
	}
	
}
