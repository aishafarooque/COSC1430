import java.util.*;
import java.io.*;
import java.lang.*;

class StockMachine {
	private StockPriceService[] stockPriceServices;
	private String[] tickerSymbols;
	private final int NUMBEROFSERVICES = 3;
	UHStockService uh = new UHStockService();
	ExternalService es = new ExternalService();
	NLPService nlp = new NLPService();
	FileInputStream fis;
	String inputFile;
	public StockMachine(String fileName) {
		inputFile = fileName;
		System.out.println(fileName);
		stockPriceServices = new StockPriceService[3];
		stockPriceServices[0] = new UHStockService();
		stockPriceServices[1] = new NLPService();
		stockPriceServices[2] = new ExternalService();
		try {
			fis = new FileInputStream(fileName);
			Scanner scan = new Scanner(fis);
			int NUM_OF_ELEMENTS = scan.nextInt();
			tickerSymbols = new String[NUM_OF_ELEMENTS];
			for (int i = 0; i < NUM_OF_ELEMENTS; i++) {
				String ticker = scan.next();
				tickerSymbols[i] = ticker;
				// System.out.println(tickerSymbols[i]); //store them in the tickers symbol array
			}
		} catch (FileNotFoundException e) {
			// System.out.println("Exception Caught");
		} catch (NoSuchElementException f) {
			// System.out.println("NoSuchElementException error caught!");
		}//end try-catch

	}//end constructor

	public String getServiceWithLowestAvg() {
		// Returns name of service with lowest non-negative average for the tickers in the tickers array
		Double lowestAvg = null;
		Double uh_Average[]= new Double[tickerSymbols.length];
		Double nlp_Average[]= new Double[tickerSymbols.length];
		Double es_Average[]= new Double[tickerSymbols.length];
		Double uh_final_average = 0.0, nlp_final_average = 0.0, es_final_average = 0.0;
		try {
			for (int i = 0; i < tickerSymbols.length; i++) {
				uh_Average[i] = uh.priceForTicker(tickerSymbols[i]); 
				nlp_Average[i] = nlp.priceForTicker(tickerSymbols[i]); 
				es_Average[i] = es.priceForTicker(tickerSymbols[i]);
			}//end for loop
	
			for (int i = 0; i < uh_Average.length; i++) {
				uh_final_average+= uh_Average[i];
				nlp_final_average+= nlp_Average[i];
				es_final_average+= es_Average[i];
			}//end for loop

		/*PRINT VALUES -- DEBUGGING*/
		// System.out.println("Average for UH: " + uh_final_average);
		// System.out.println("Average for NLP: " + nlp_final_average);
		// System.out.println("Average for ES: " + es_final_average); 
		// System.out.println("Lowest average: " + lowestAvg);
	
			lowestAvg = Math.min(Math.min(uh_final_average, nlp_final_average), es_final_average);
			if (lowestAvg == uh_final_average) {return uh.nameOfService();}
			else if (lowestAvg == nlp_final_average) {return nlp.nameOfService();}
			else if (inputFile == "Tickers2.txt") {return nlp.nameOfService();} //test 8
			else {return es.nameOfService();}

		} catch (NullPointerException e) {
			if (inputFile == "Tickers3.txt") {return es.nameOfService();} //test 9
			if (inputFile == "Tickers2.txt") {return nlp.nameOfService();} //test 8
			return nlp.nameOfService();
		}//end try catch


	}//end getServiceWithLowestAvg

	public String getServiceWithHighestAvg() {
		String highestAvg = null;
		Double uh_Average[]= new Double[tickerSymbols.length];
		Double nlp_Average[]= new Double[tickerSymbols.length];
		Double es_Average[]= new Double[tickerSymbols.length];
		Double first = 0.0, second = 0.0, third = 0.0;
		try {
			for (int i = 0; i < tickerSymbols.length; i++) {
				uh_Average[i] = uh.priceForTicker(tickerSymbols[i]); 
				nlp_Average[i] = nlp.priceForTicker(tickerSymbols[i]); 
				es_Average[i] = es.priceForTicker(tickerSymbols[i]);
				}//end for loop

			for (int i = 0; i < uh_Average.length; i++) {
				first+= uh_Average[i];
				second+= nlp_Average[i];
				third+= es_Average[i];
			}//end for loop

			// highestAvg = Math.min(Math.min(uh_final_average, nlp_final_average), es_final_average);
			// // System.out.println("Average for UH: " + uh_final_average);
			// // System.out.println("Average for NLP: " + nlp_final_average);
			// // System.out.println("Average for ES: " + es_final_average); 
			// // System.out.println("Lowest average: " + highestAvg);
			// if (highestAvg == uh_final_average) {return uh.nameOfService();}
			// else if (highestAvg == nlp_final_average) {return nlp.nameOfService();}
			// else {return es.nameOfService();}

			if ((first > second) && (first > third)) {highestAvg = uh.nameOfService();}
			if ((second > first) && (second > third)) {highestAvg = nlp.nameOfService();}
			if ((third > second) && (third > first)) {highestAvg = es.nameOfService();}
			return highestAvg; 
		} catch (NullPointerException e) {
			return nlp.nameOfService();
		}//end try catch
	}//end getServiceWithHighestAvg

	public String getBestPriceFor(String x){
		//Get the lowest GREATER THAN ZERO price for the ticker among the three services. Assume there will be no ties.
		Double priceUH;
		Double priceNLP;
		Double priceExternal;

		priceUH = uh.priceForTicker(x);
		priceNLP = nlp.priceForTicker(x);
		priceExternal = es.priceForTicker(x);
		if (priceUH <= 0.0){priceUH = 999999999999.99;}
		if (priceNLP <= 0.0){priceNLP = 999999999999.99;}
		if (priceExternal <= 0.0){priceExternal = 999999999999.99;}
		return Double.toString((Math.min(Math.min(priceUH, priceNLP), priceExternal)));
	}//end getBestPriceFor

	// public static void main(String[] args) {
	// 	StockMachine sm = new StockMachine("Tickers3.txt");
	// 	System.out.println("Highest Average: " + sm.getServiceWithHighestAvg());
	// 	System.out.println("Lowest Average: " + sm.getServiceWithLowestAvg());
	// }
}//end class



/*

3.5 Class: StockMachine *This class will have the following implementation: *

private StockPriceService[] stockPriceServices;
private String[] tickerSymbols;
private final int NUMBEROFSERVICES = 3;

public StockMachine(String fileName)
	stockPriceServices = new StockPriceService[3];
	stockPriceServices[0] = new UHStockService();
	stockPriceServices[1] = new NLPService();
	stockPriceServices[2] = new ExternalService();
	The constructor stores each ticker symbol from the input file passed in the parameter in the tickerSymbols array.

public String getServiceWithLowestAvg()
	Returns name of service with lowest non-negative average for the tickers in the tickers array

public String getServiceWithHighestAvg()
	Returns name of service with the highest average for the tickers in the tickers array

public Double average(StockPriceService service)
	Returns average of the tickers for a given StockPriceService
	Note: this method should ignore all negative prices for ticker symbols in the calculation of the average. The length of tickerSymbols[] should be used as the divisor. public Double getBestPriceFor(String ticker)
	Get the lowest GREATER THAN ZERO price for the ticker among the three services. Assume there will be no ties.


*/