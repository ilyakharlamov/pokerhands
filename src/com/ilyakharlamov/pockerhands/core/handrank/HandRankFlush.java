package com.ilyakharlamov.pockerhands.core.handrank;

import java.util.Arrays;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankFlush extends HandRank {
	public String toString () {
		return hand+"{Flush}";
	}
	public HandRankFlush(Hand hand) {
		super(hand, 5);
	}
	@Override
	public int compareTo(HandRank handrank) {
		int shallow = super.compareTo(handrank);
		if (shallow!=0) return shallow;
		Card[] mycards = hand.getCards();
		Arrays.sort(mycards);
		Card[] remotecards=handrank.hand.getCards();
		Arrays.sort(remotecards);
		return mycards[mycards.length-1].compareTo(remotecards[remotecards.length-1]);
	}
	
	static boolean isApplicable (Hand hand) {
		if (hand.isEmpty()) return false;
		Card[] cards = hand.getCards();
		if (cards.length!=5) return false;
		Card.Suit suit = cards[0].getSuit();
		for(int i=1;i<cards.length;i++) {
			Card card = cards[i];
			if (!card.getSuit().equals(suit)) return false;
		}
	    return true;
	}


}
