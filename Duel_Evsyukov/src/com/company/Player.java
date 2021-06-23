package com.company;

public class Player {
    static boolean[] unused_cards;
    static int penalty_points;

    public Player()
    {
        unused_cards = new boolean[5];
        for(int i = 0; i<5; i++)
            unused_cards[i] = true;
        penalty_points = 0;
    }

    public static int getPenalty_points() {
        return penalty_points;
    }

    public static boolean[] getUnused_cards() {
        return unused_cards;
    }
}

