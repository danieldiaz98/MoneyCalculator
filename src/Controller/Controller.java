package Controller;

import Model.Currency;
import Model.ExchangeRate;
import Model.Money;
import View.ExchangeView;
import Persistence.ExchangeRateLoader;
public class Controller {
    
    private final ExchangeView view;
    private final ExchangeRateLoader loader;

    public Controller(ExchangeView view, ExchangeRateLoader loader) {
        this.view = view;
        this.loader = loader;
    }
    
    public void execute(Currency from, Currency to, Money money){
        view.showResult("" + money.getAmount() * exchangeRate(from,to).getRate());
    }
    
    public ExchangeRate exchangeRate(Currency from, Currency to){
        return loader.getExchangeRate(from, to);
    }
    
}