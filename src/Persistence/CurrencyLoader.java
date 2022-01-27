package Persistence;

import Model.Currency;
import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}