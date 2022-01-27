package Persistence.CurrencyLoaders;

import Model.Currency;
import Persistence.CurrencyLoader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CurrencyFileLoader implements CurrencyLoader {
    private String fileName;

    public CurrencyFileLoader(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public List<Currency> load() {
        List<Currency> currencies = new ArrayList<>();
        String line = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            while(true){
                line = reader.readLine();
                if(line == null) break;
                String[] aux = line.split(","); 
                currencies.add(new Currency(aux[0], aux[1], aux[2]));
            }
        } catch (FileNotFoundException ex){
        }catch (IOException ex){}
        
        return currencies;
    }
    
}