package com.rit.chess.model;

public class ChessGame {

}

enum PieceType {
	King, Queen, Rook, Knight, Bishop, Pawn
}

enum PieceColor{
	White,Black
}

class Square{
	int X;
	int Y;
}

class Board{
	private Square[][] squareSet= new Square[8][8];
}