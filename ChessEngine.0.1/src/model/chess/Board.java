package model.chess;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import model.chess.moves.Move;
import model.chess.pieces.*;

/**
 * This class only does exactly what is it told, illegal moves and everything, resolve to others for solving the logic.
 * @author Carlbom
 *
 */
public class Board implements ChessBoard {

	private final String FEN_START_POSITION = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

	private Square[] squares;
	private ArrayList<ChessPiece> blackPieces;
	private ArrayList<ChessPiece> whitePieces;

	private static final int LOWER_LEFT_CORNER = 0;
	private static final int LOWER_RIGHT_CORNER = 7;
	private static final int UPPER_LEFT_CORNER = 56;
	private static final int UPPER_RIGHT_CORNER = 63;
	private static final int ONE_ROW = 8;

	public Board() {
		whitePieces = new ArrayList<>();
		blackPieces = new ArrayList<>();
		setUpNewGame();
	}
	
	@Override
	public void setUpNewGame() {
		buildSquares();
		buildPlayerPieceList(whitePieces, PlayerColor.WHITE);
		buildPlayerPieceList(blackPieces, PlayerColor.BLACK);
		PlaceWhitePieces();
		PlaceBlackPieces();
	}

	private void buildSquares() {
		squares = new Square[64];
		for (int i = 0; i < squares.length; i++) {
			squares[i] = new Square();
		}
	}

	private void buildPlayerPieceList(ArrayList<ChessPiece> list, PlayerColor c) {
		list.add(new Rook(c));
		list.add(new Knight(c));
		list.add(new Bishop(c));
		list.add(new Queen(c));  //Queen on the 'd' in both starting zones.
		list.add(new King(c));
		list.add(new Bishop(c));
		list.add(new Knight(c));
		list.add(new Rook(c));
		for (int i = 0; i < 8; i++) {
			list.add(new Pawn(c));
		}
	}	

	private void PlaceWhitePieces() {
		for (int i = 0; i < whitePieces.size(); i++) {
			squares[i].placePiece(whitePieces.get(i));
		}
	}

	private void PlaceBlackPieces() {
		for (int i = 0; i < 8; i++) {
			squares[UPPER_LEFT_CORNER + i].placePiece(blackPieces.get(i));
		}
		for (int i = 0; i < 8; i++) {
			squares[48 + i].placePiece(blackPieces.get(i+7));
		}

	}

	@Override
	public void setUpBoard(String boardState) {
		setUpNewGame();
		//Do all moves requred;

	}

	@Override
	public String getFenStringOfBoardState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeMove(Move move) {
		makeMove(move.getFrom(), move.getTo());
		//printsBoardState
		System.out.println(toString());
	}

	public void makeMove(int from, int to) {
		 squares[to].placePiece(squares[from].removePiece()); 
	}
	
	@Override
	public void undoMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redoMove() {
		// TODO Auto-generated method stub

	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("    a   b   c   d   e   f   g   h   \n");

		for (int i = 8; i > 0; i--) {
			sb.append(buildStringRow(i, (i*8-8)));	
		}
		sb.append("    a   b   c   d   e   f   g   h   ");
		return sb.toString();
	}

	private String buildStringRow(int row, int arrStartNbr) {
		StringBuilder sb = new StringBuilder();
		sb.append(row + " ");

		for (int i = 0; i < 8; i++) {
			sb.append(squares[arrStartNbr].toString());
			arrStartNbr++;
		}
		sb.append(" " + row + "\n");
		return sb.toString();
	}

	public  ChessPiece getPieceAt(int i) {
		return squares[i].occupatedBy();
	}

	public boolean isEmptySquare(int i) {
		return squares[i].isEmpty();
	}

}
