package ca.utoronto.utm.othello.model;
/**
 * This is WinnerVisitor which implies the vistor pattern
 * 
 * @author Linfeng Zhou, Yang Liu, Xuwen Cai, Jiahe Xue
 *
 */
public class WinnerVisitor implements Visitor {



	@Override
	public boolean visit(OthelloBoard gb, int row, int col, char turn) {
		return false;
	}

	@Override
	public char visit(OthelloBoard gb) {
		if(gb.getCount(OthelloBoard.P1)> gb.getCount(OthelloBoard.P2))return gb.P1;
		if(gb.getCount(OthelloBoard.P1)< gb.getCount(OthelloBoard.P2))return gb.P2;
		return gb.EMPTY;
		
	}
}
	