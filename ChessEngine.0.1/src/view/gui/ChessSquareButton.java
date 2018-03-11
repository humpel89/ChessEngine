package view.gui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ChessSquareButton extends JButton {

	private char xAxis;
	private char yAxis;
	private boolean isEmpty;
	
	
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

	public void setIconEmpty() {
		this.isEmpty = true;
		super.setIcon(new ImageIcon(getClass().getResource("/resources/chess_icons/Chess_Empty.png")));
	}
	
	@Override
	public void setIcon(Icon defaultIcon) {
		this.isEmpty = false;
		super.setIcon(defaultIcon);
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
}
