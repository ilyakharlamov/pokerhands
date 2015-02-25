package com.ilyakharlamov.pockerhands.core;

public class Card implements Comparable<Card> {
	private final Rank rank;
    private final Suit suit;
    public Card (Rank rank, Suit suit) {
    	this.rank = rank;
    	this.suit=suit;
    }
	public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;
        private static final String[] labels = {"\u2663","\u2666","\u2665","\u2660"};

        public String toString() {
            return labels[this.ordinal()];
        }
    }

	public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        private static final String[] labels = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

        public String toString() {
            return labels[this.ordinal()];
        }
    }
	public Suit getSuit() {
        return suit;
    }
	public Rank getRank() {
        return rank;
    }
	@Override
	public int compareTo(Card o) {
		return Integer.signum(rank.compareTo(o.getRank()));
	}
	public String toString() {
		return ""+rank+suit;
	}

}
