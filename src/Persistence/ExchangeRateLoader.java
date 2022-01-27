package Persistence;

import Model.Currency;
import Model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate getExchangeRate(Currency from, Currency to);
}