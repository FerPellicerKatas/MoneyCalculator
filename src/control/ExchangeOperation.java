package control;

import java.io.IOException;
import model.CurrencySet;
import model.ExchangeRateSet;
import org.json.simple.parser.ParseException;
import persistence.CurrencySetFetcher;
import persistence.ExchangeRateLoader;
import view.MoneyCalculatorView;

public class ExchangeOperation {

    private final CurrencySet currencySet;
    private final ExchangeRateSet rateSet;

    public ExchangeOperation() throws IOException, ParseException {
        currencySet = new CurrencySetFetcher().load();
        rateSet = new ExchangeRateLoader().load(currencySet);
    }

    public void execute() {
        
        MoneyCalculatorView view = new MoneyCalculatorView(currencySet.getList(), rateSet);
    }

}
