package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Player you = new Player();
		BotPlayer AI = new BotPlayer();
		boolean PlayerTurn = true;
		Scanner sc = new Scanner(System.in);
		int card = 0;
		int botpoints = 0;
		boolean[] BotUnused = new boolean[5];
		boolean[] PlayerUnused = new boolean[5];
		int[] fl;
		fl = new int[5];
		fl = AI.getFinal_look();
		for(int i=0; i<5; i++)
			fl[i]=0;
		for(int i=1; i<=5; i++)
		{
			System.out.println("Ваш ход!");
			card = sc.nextInt();
			BotUnused = AI.getUnused_cards();
			PlayerUnused = you.getUnused_cards();
			AI.BotTurn(i, botpoints, fl, BotUnused, PlayerUnused);

			if(PlayerTurn) {
				if (AI.getFinal_look()[i - 1] < card) {
					AI.penalty_points = (AI.getPenalty_points() + card - AI.getFinal_look()[i - 1]);
					System.out.println("Игрок 2 зарабатывает штрафные очки!");
				}
				PlayerTurn = false;
			}
			else {
				if (AI.getFinal_look()[i - 1] > card) {
					botpoints += AI.getFinal_look()[i - 1] - card;
					you.penalty_points = (you.getPenalty_points() + AI.getFinal_look()[i - 1] - card);
					System.out.println("Вы зарабатываете штрафные очки.");
				}
				PlayerTurn = true;
			}
			PlayerUnused[card]=false;
			BotUnused[AI.getFinal_look()[i-1]]=false;
			you.unused_cards= PlayerUnused;
			AI.unused_cards = BotUnused;
			for(int j=0; j<5; j++)
			System.out.println(AI.getFinal_look()[j]);
			System.out.println("Смена сторон!");
		}
		System.out.println("Ваши штрафные очки - "+ you.getPenalty_points());
		System.out.println("Штрафные очки игрока 2 - "+ AI.getPenalty_points());
		if (you.getPenalty_points()<AI.getPenalty_points())
			System.out.println("Вы победили!");
		else
			System.out.println("Вы проиграли.");

    }
}
