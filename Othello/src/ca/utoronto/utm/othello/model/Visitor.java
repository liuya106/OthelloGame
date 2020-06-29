package ca.utoronto.utm.othello.model;
/**
 * This is Visitor which implies the vistor pattern
 * 
 * @author Linfeng Zhou, Yang Liu, Xuwen Cai, Jiahe Xue
 *
 */
public interface Visitor {
	public boolean visit(OthelloBoard gb, int row, int col, char turn); // for move
	public char visit(OthelloBoard gb);
}
