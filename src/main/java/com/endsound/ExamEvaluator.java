package com.endsound;

import com.endsound.bean.WinningCombination;
import com.genesis.exams.slot.Evaluator;
import com.genesis.exams.slot.Symbol;

import java.util.Arrays;

public class ExamEvaluator implements Evaluator {
    private WinningCombination[] combinations;

    public ExamEvaluator(WinningCombination[] combinations) {
        this.combinations = combinations;
    }

    @Override
    public long evaluate(Symbol[] symbols, long bet) {
        //get multiplier
        Integer multiplier = Arrays.asList(combinations).parallelStream()
                .filter(combination -> combination.match(symbols))
                .findFirst()
                .map(WinningCombination::getMultiplier)
                .orElse(0);

        return bet * multiplier;
    }
}
