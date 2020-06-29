package ca.utoronto.utm.othello.model;

import java.util.ArrayList;

public class PlayerAlpha extends Player {
	private ArrayList<Move> corner_side;

	public PlayerAlpha(Othello othello, char player) {
		super(othello, player);
		this.corner_side = Corner_Side_Move();
	}

	@Override
	public Move getMove() {
		if (this.Corner_side_best_move() != null) {
			return this.Corner_side_best_move();
		} else if (this.fourbyfourgridbestmove() != null) {
			return this.fourbyfourgridbestmove();
		}
		PlayerGreedy greedy = new PlayerGreedy(othello, player);
		return greedy.getMove();
	}

	private Move Corner_side_best_move() {
		for (Move ch : this.corner_side) {
			Othello othelloCopy = othello.copy();
			if (othelloCopy.move(ch.getRow(), ch.getCol())) {
				return ch;
			}
		}
		return null;
	}

	private static ArrayList<Move> Corner_Side_Move() {
		ArrayList<Move> Move_List = new ArrayList<Move>();
		Move_List.add(new Move(0, 7));
		Move_List.add(new Move(7, 0));
		Move_List.add(new Move(7, 7));
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				if (row == 0 || row == 7) {
					Move_List.add(new Move(row, col));
				} else if (col == 0 || col == 7) {
					Move_List.add(new Move(row, col));
				}
			}
		}
		return Move_List;
	}

	private Move fourbyfourgridbestmove() {
		Othello othelloCopy = othello.copy();
		Move bestMove = null;
		int bestMoveCount = othelloCopy.getCount(this.player);
		for (int row = 2; row < 6; row++) {
			for (int col = 2; col < 6; col++) {
				othelloCopy = othello.copy();
				if (othelloCopy.move(row, col) && othelloCopy.getCount(this.player) > bestMoveCount) {
					bestMoveCount = othelloCopy.getCount(this.player);
					bestMove = new Move(row, col);
				}
			}
		}
		return bestMove;
	}

}
