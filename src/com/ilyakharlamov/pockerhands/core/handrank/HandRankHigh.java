package com.ilyakharlamov.pockerhands.core.handrank;

import java.util.Arrays;

import com.ilyakharlamov.pockerhands.core.Card;
import com.ilyakharlamov.pockerhands.core.Hand;

public class HandRankHigh extends HandRank {
	public HandRankHigh(Hand hand) {
		super(hand, 0);
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

	public static boolean isApplicable(Hand hand) {
		return true;
	}
}
