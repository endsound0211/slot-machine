package com.endsound;

import com.genesis.exams.slot.Reel;
import com.genesis.exams.slot.Spinner;
import com.genesis.exams.slot.Symbol;

import java.util.Arrays;
import java.util.Random;

public class ExamSpinner implements Spinner {
    @Override
    public Symbol spin(Reel reel) {
        //count all weight
        Integer total = Arrays.asList(reel.getSymbols()).stream()
                .mapToInt(Symbol::getWeight)
                .sum();

        //random hit number
        Integer hitNumber =  new Random().nextInt(total) + 1;

        //calculator which symbol
        for(Symbol symbol: reel.getSymbols()){
            hitNumber -= symbol.getWeight();
            if(hitNumber <= 0)
                return symbol;
        }

        //not happened here
        return null;
    }
}
