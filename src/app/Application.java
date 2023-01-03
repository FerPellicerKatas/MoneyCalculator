package app;

import control.ExchangeOperation;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Application {

    public static void main(String[] args) throws IOException, ParseException {
        ExchangeOperation exchange = new ExchangeOperation();
        exchange.execute();
    }    
}
