package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;

public class CurrencySetFetcher implements CurrencySetLoader {

    
    public CurrencySet load() {
        
        CurrencySet set = CurrencySet.getInstance();
        try {
            FileReader fr = new FileReader("../MONEYCALCULATOR/src/currency/currencies.txt");
            BufferedReader br = new BufferedReader(fr);

            String text = "";
            while ((text = br.readLine()) != null) {
                String[] split = text.split(",");

                set.add(new Currency(split[0], split[1],split[2]));
            }
           
        } catch (IOException e) {}
        return set;
    }
       
    
    
}