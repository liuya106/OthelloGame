package ca.utoronto.utm.othello.model;

public class MoveVisitor implements Visitor {
	/**
	 * This is MoveVisitor which implies the vistor pattern
	 * 
	 * @author Linfeng Zhou, Yang Liu, Xuwen Cai, Jiahe Xue
	 *
	 */


	@Override
	public boolean visit(OthelloBoard gb, int row, int col, char turn) {
		return gb.move(row, col, turn);
	}

	@Override
	public char visit(OthelloBoard gb) {
		//for winner
		return ' ';
	}
	
}
