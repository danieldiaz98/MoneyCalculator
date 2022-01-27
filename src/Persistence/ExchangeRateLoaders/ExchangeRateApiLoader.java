package Persistence.ExchangeRateLoaders;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeRateApiLoader implements ExchangeRateLoader {
    //https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/from/to.json
    private URL url;
    private String from;
    private String to;
    
    public ExchangeRateApiLoader(String from, String to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    public ExchangeRate getExchangeRate(Currency begin, Currency end){
        try{
            this.url = new URL(from + begin.getCode().toLowerCase() 
                    + to + end.getCode().toLowerCase() + ".json");
        }catch(MalformedURLException ex){
            System.out.println("Error" + ex);
        }
        String line = "";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                url.openStream()));
            
            while(true){
                line = reader.readLine();
                if (line == null) break;
                if(line.contains(end.getCode().toLowerCase())) break;
            }
        }catch (IOException ex){}
        
        return new ExchangeRate(begin, end, Double.parseDouble(line.split(": ")[1]));
    }
}