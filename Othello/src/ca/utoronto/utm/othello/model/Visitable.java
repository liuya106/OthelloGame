package ca.utoronto.utm.othello.model;
/**
 * This is Visitable which implies the vistor pattern
 * 
 * @author Linfeng Zhou, Yang Liu, Xuwen Cai, Jiahe Xue
 *
 */
public abstract class Visitable {
	abstract boolean accept(MoveVisitor visitor, int row, int col, char turn);// for move
	abstract char accept(WinnerVisitor visitor);

	
}
