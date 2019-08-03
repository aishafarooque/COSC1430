import java.util.*;
import java.io.*;
class ExternalService implements StockPriceService {
	private Map<String, Double> tickerPrices = new HashMap<>();
	double average = 0.0;
	ExternalService() {
		try{
			FileInputStream fis = new FileInputStream("ExternalService.txt");
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
		return "External"; 
	}//end nameOfService

	public Double average() {
		for (double d : tickerPrices.values()) {
			average += Math.abs(d);
		}
		return average/tickerPrices.size();
	}//end average

	// public static void main(String[] args) {
	// 	ExternalService es = new ExternalService();
	// 	System.out.println(es.average());
	// }
}//end class


/*

3.4 Class: ExternalService implements StockPriceService

private Map tickerPrices; // You can assume that there will be a fixed 25 ticker symbols in total if you plan to implement this with arrays.
UHStockService()
The constructor reads the prices and tickers from a file, ExternalService.txt, and stores them into a HashMap tickerPrices.
public double priceForTicker(String Ticker)
This class overrides this method from the interface. The method takes a ticker and returns the price for a given ticker.
public String nameOfService() { return "External"; }

*/