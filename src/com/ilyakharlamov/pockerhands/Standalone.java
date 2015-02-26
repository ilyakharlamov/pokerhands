package com.ilyakharlamov.pockerhands;

import java.util.Arrays;

import com.ilyakharlamov.pockerhands.core.Hand;
import com.ilyakharlamov.pockerhands.core.Card.Rank;
import com.ilyakharlamov.pockerhands.core.Card.Suit;
import com.ilyakharlamov.pockerhands.core.handrank.HandRank;

public class Standalone {

	public static void main(String[] args) {
		if (args.length<2 || args[0].length()!=10 || args[1].length()!=10) {
			System.out.println("Ranks:"+Arrays.asList(Rank.values()));
			System.out.println("Suits:"+Arrays.asList(Suit.values()));
			System.out.println("arg1: first hand arg2: second hand");
			System.out.println("example: 2C3D4H5S6S 2D3D4D5D6D");
			System.exit(127);
		}
		HandRank handrank1 = HandRank.fromHand(new Hand(args[0]));
		System.out.println("first hand is "+handrank1);
		HandRank handrank2 = HandRank.fromHand(new Hand(args[1]));
		System.out.println("second hand is "+handrank2);
		int result = handrank1.compareTo(handrank2);
		if (result>0) {
			System.out.println("first hand wins");
		} else if (result<0) {
			System.out.println("second hand wins");
		} else {
			System.out.println("second hand wins");
		}
	}

}
