package javapoker;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoker {

	@Test
	public void testDeck() {
		for (int i = 0; i < 1; i++) {
			Deck deck = new Deck();
			Hand hand = new Hand(deck);
			Hand hand2 = new Hand(deck);
			hand.display();
			hand.displayAll();
			hand2.display();
			hand2.displayAll();
			if(hand.compareTo(hand2) >0) {
				System.out.println("Hand One Won");
			}
			if(hand2.compareTo(hand) >0) {
				System.out.println("Hand Two Won");
			}
			if(hand.compareTo(hand2) ==0) {
				System.out.println("Its a Tie");
			}
			

		}
	}

}
