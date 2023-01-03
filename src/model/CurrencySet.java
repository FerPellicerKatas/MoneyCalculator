package model;

import java.util.ArrayList;

public class CurrencySet {

    private final ArrayList<Currency> list;
    private static CurrencySet currencySet;
    
    private CurrencySet() {
        
        this.list = new ArrayList<>();
        
    }
    
    public static CurrencySet getInstance() {
        
        if (currencySet == null) {
            CurrencySet.currencySet = new CurrencySet();
        }
        
        return currencySet;
        
    }
  

    public boolean add(Currency currency) {
        return list.add(currency);
    }

    public Currency get(int index) {
        return list.get(index);
    }
    
    public int size() {
        return list.size();
    }

    public ArrayList<Currency> getList() {
        return list;
    }
}
