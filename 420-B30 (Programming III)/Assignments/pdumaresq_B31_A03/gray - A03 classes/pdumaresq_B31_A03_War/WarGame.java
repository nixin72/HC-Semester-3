package pdumaresq_B31_A03_War;

import java.util.Scanner;

public class WarGame {
	public static void main(String[] args) {
		War game = new War();
		Scanner play = new Scanner(System.in);
		game.start();

		 System.out.println("Welcome to the game of war\n"
				 + "The objective of the game is Welcome to the "
				 + "game of war.\nThe object of the game is to force "
				 + "the other player to run out of cards.\nAll "
				 + "the cards are dealt at the beginning of the "
				 + "game.\nEach play both players lay the top card "
				 + "of their pile face up.\nThe player with the "
				 + "highest rank card, puts both cards on the "
				 + "bottom of his pile.\nIf both cards have the "
				 + "same rank, each player plays three cards "
				 + "face down and plays another round.\nThe winner"
				 + " of the tie-breaking round gets all the played"
				 + " cards \n(the cards in the tie, the six face "
				 + "down and the two in the tie-breaking play.) ");
				
		System.out.println("\nPlease enter the first player's name: ");
		game.setPlayer1(play.nextLine());
		
		System.out.println("Please enter the second player's name: ");
		game.setPlayer2(play.nextLine());
		
		System.out.println("\nBoth hands have been dealt.");
		System.out.println(game.getPlayer1() + " has " + game.p1HandSize()
			 + " cards to start.");
		System.out.println(game.getPlayer2() + " has " + game.p2HandSize()
			 + " cards to start.\n\n");
		
		
		System.out.println("Press any key to begin playing.");
		play.nextLine();

		boolean playerDone = false;
		while (!game.isOver() && !playerDone) {
			if (!game.isOver()) {
				System.out.print(game.getPlayer1() + " plays " + game.p1Top() + ". ");
				System.out.println(game.getPlayer2()+ " plays " + game.p2Top() + ".");
				
				boolean war = game.play();
				
				if (war) {
					System.out.println("It's a tie! Each player lays 3 cards face down.");
					System.out.println("Kitty has " + game.getKittySize() + " cards.");
					System.out.println(game.getRoundWinner() + " has won the war! They win the kitty.");
				} else {
					System.out.println(game.getRoundWinner() + " won this hand.");
				}

				System.out.println(game.getPlayer1() 
					+ " has " + game.p1HandSize() + " cards left in hand.");
				System.out.println(game.getPlayer2() 
					+ " has " + game.p2HandSize() + " cards left in hand.");

				System.out.println("Hit any key to continue or Q to quit.\n");
//				String cont = play.nextLine();
//				if (cont.equalsIgnoreCase("q"))
//					playerDone = true;
			}
		}

		String winner = (game.p1HandSize() > game.p2HandSize()) ? game.getPlayer1() : game.getPlayer2();
		System.out.println(winner + " has won this game!");
		System.out.println("Thank you for playing!");
		
		
		play.close();
	}
}