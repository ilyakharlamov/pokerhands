package com.ilyakharlamov.pockerhands.core;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>(5);
    }
    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
        }
        return sb.toString();
    }

}
