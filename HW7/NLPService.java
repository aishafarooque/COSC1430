import java.util.*;
import java.io.*;
class NLPService implements StockPriceService {
	private Map<String, Double> tickerPrices = new HashMap<>();
	double average = 0.0;
	NLPService() {
		try{
			FileInputStream fis = new FileInputStream("NLPService.txt");
			Scanner scan = new Scanner(fis);
			String ticker = scan.next();
			Double d = scan.nextDouble();
			while (scan.nextLine() != null) {
				tickerPrices.put(ticker, d);
				ticker = scan.next();
				d = scan.nextDouble();
			}
		} catch (FileNotFoundException e) {
			// System.out.println("FileNotFoundException caught!");
		} catch (NoSuchElementException f) {
			// System.out.println("End of file.");
			// System.out.println(tickerPrices);
		}//end catch
	}//end constructor

	@Override
	public Double priceForTicker(String ticker) {
		double price = tickerPrices.get(ticker);
		if (price > 0.0) {return price;}
		else {price = 0.0; return price;}
	}//end priceForTicker

	public String nameOfService() {
		return "NLP"; 
	}//end nameOfService
	
	public Double average() {
		for (double d : tickerPrices.values()) {
			average += Math.abs(d);
		}
		return average/tickerPrices.size();
	}

	public static void main(String[] args) {
		NLPService nlp = new NLPService();
		System.out.println(nlp.average());
	}
}//end class

/*

3.2 Class: NLPService implements StockPriceService

private Map tickerPrices; // You can assume that there will be fixed 25 ticker symbols in total if you plan to implement this with arrays.
NLPService()
The constructor reads the prices and tickers from a file, NLPService.txt, and stores them into a HashMap tickerPrices
public Double priceForTicker(String ticker)
This class overrides this method from the interface. The method takes a ticker and returns the price for a given ticker
If the price is not found, return 0
public String nameOfService() { return "NLP"; }

*/