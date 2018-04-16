package com.endsound.bean;


import com.genesis.exams.slot.Symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Winning combination structure
 */
public class WinningCombination {
    private Symbol[] symbols;
    private Integer multiplier;

    public WinningCombination(Symbol[] symbols, Integer multiplier) {
        this.symbols = symbols;
        this.multiplier = multiplier;
    }

    /**
     * judge if symbols is match with this winning combination
     * @param symbols hit symbols
     * @return match or not
     */
    public Boolean match(Symbol[] symbols){
        List<Symbol> tempSymbols = new ArrayList<Symbol>(Arrays.asList(this.symbols));

        for(Symbol hitSymbol: symbols){
            for(Symbol tempSymbol: tempSymbols){
                if (tempSymbol.getName().equals(hitSymbol.getName())){
                    tempSymbols.remove(tempSymbol);
                    break;
                }
            }
        }

        return tempSymbols.size() == 0;
    }

    public Integer getMultiplier() {
        return multiplier;
    }
}
