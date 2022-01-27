package moneycalculator;

import Controller.Controller;
import Model.Currency;
import Persistence.CurrencyLoader;
import Persistence.CurrencyLoaders.CurrencyFileLoader;
import Persistence.ExchangeRateLoader;
import Persistence.ExchangeRateLoaders.ExchangeRateApiLoader;
import View.ExchangeView;
import java.util.List;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new CurrencyFileLoader("currencies.txt");
        List<Currency> currencies = currencyLoader.load();
        
        ExchangeRateLoader loader = new ExchangeRateApiLoader(
                "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/", "/");
        ExchangeView view = new ExchangeView(loader, currencies);
        view.setVisible(true);
    }
    
}