package view.gui;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class ChessSquareButton extends Button{

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
