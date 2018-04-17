package com.endsound;

import com.endsound.bean.WinningCombination;
import com.genesis.exams.slot.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args){
        //init symbol
        Symbol symbolA = new Symbol("A", 1);
        Symbol symbolB = new Symbol("B", 1);
        Symbol symbolC = new Symbol("C", 1);
        Symbol symbolX = new Symbol("X", 2);
        Symbol symbolY = new Symbol("Y", 3);
        Symbol symbolZ = new Symbol("Z", 4);
        //init reel
        Reel reel1 = new Reel(new Symbol[]{symbolA, symbolB, symbolC, symbolX, symbolY, symbolZ});
        Reel reel2 = new Reel(new Symbol[]{symbolZ, symbolY, symbolX, symbolA, symbolB, symbolC});
        Reel reel3 = new Reel(new Symbol[]{symbolA, symbolB, symbolC, symbolX, symbolY, symbolZ});
        //init evaluator
        Evaluator examEvaluator = new ExamEvaluator(new WinningCombination[]{
            new WinningCombination(new Symbol[]{symbolA, symbolA, symbolA}, 20),
            new WinningCombination(new Symbol[]{symbolB, symbolB, symbolB}, 20),
            new WinningCombination(new Symbol[]{symbolC, symbolC, symbolC}, 20),
            new WinningCombination(new Symbol[]{symbolA, symbolB, symbolC}, 30)
        });
        //init machine
        SlotMachine slotMachine = new SlotMachine(
                new Reel[]{reel1, reel2, reel3}, new ExamSpinner(), examEvaluator);

        //start
        Integer bet = 200;
        SpinResult result = slotMachine.spin(bet);
        System.out.println(String.format("bet:%d\nsymbols: %s\npayout: %s", bet, Arrays.asList(result.getSymbols()).stream().map(Symbol::getName).collect(Collectors.joining()), result.getPayout()));
    }

}
