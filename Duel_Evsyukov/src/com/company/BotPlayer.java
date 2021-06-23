package com.company;

import java.util.Scanner;

public class BotPlayer{
    static boolean[] unused_cards;
    static int[] final_look;
    static int penalty_points;
    static int max;
    public BotPlayer()
    {
        unused_cards = new boolean[5];
        final_look = new int[5];
        for (int i =0; i<5; i++)
        {
            unused_cards[i] = true;
            //final_look[i]=0;
        }
        penalty_points = 0;
        max = -1000;
    }

    public static boolean[] getUnused_cards() {
        return unused_cards;
    }


    public static int getMax() {
        return max;
    }

    public static int[] getFinal_look() {
        return final_look;
    }

    public static int getPenalty_points() {
        return penalty_points;
    }


    public static void BotTurn(int n, int maxcurr, int[] fl, boolean[] bot, boolean[] player)
    {
        if (n == 6) {
            if (maxcurr > getMax()) {
                max = maxcurr;
                final_look = fl;
                for(int i=0; i<5; i++)
                    System.out.println(final_look[i]);
                System.out.println("Max "+max);
            }
        }
        else {
            for (int k = 0; k < 5; k++) {
                if (bot[k]) {
                    fl[n - 1] = k;
                    bot[k]=false;
                }
                for (int t = 0; t < 5; t++) {
                    if (player[t]) {
                        player[t]=false;
                        if (n % 2 == 0) {
                            if (k > t) {
                                maxcurr += k - t;
                            }
                            n++;
                            BotTurn(n, maxcurr, fl, bot, player);
                            n--;
                            maxcurr -= k - t;
                        } else if (n % 2 == 1) {
                            if (k < t) maxcurr += k - t;
                            n++;
                            BotTurn(n, maxcurr, fl, bot, player);
                            n--;
                            maxcurr -= k - t;
                        }

                    }
                    player[t]=true;
                }
                bot[k]=true;
                fl[n - 1] = 0;
            }
        }
    }


}

