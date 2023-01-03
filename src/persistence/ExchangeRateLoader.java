package persistence;

import java.io.IOException;
import model.CurrencySet;
import model.ExchangeRate;
import model.ExchangeRateSet;
import org.json.simple.parser.ParseException;


public class ExchangeRateLoader {

    public ExchangeRateSet load(CurrencySet c) throws IOException, ParseException {
        ExchangeRateSet set = new ExchangeRateSet();
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < c.size(); j++) {
                if (c.get(i).equals(c.get(j))) {
                    set.add(new ExchangeRate(c.get(i), c.get(i), 1));
                } else {
                    
                    set.add(new ExchangeRate(c.get(i), c.get(j), rate(c.get(i).getCode(), c.get(j).getCode())));
                    
                }
            }
        }

        return set;
    }

    private float rate(String from, String to) {
    
        return JsonLoad.readJsonFromUrl(from, to);
        

    }


}