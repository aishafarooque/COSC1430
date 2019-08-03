public String getServiceWithLowestAvg() {
		// Returns name of service with lowest non-negative average for the tickers in the tickers array
		String lowestAvg = null;
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
	
			lowestAvg = Math.min(Math.min(uh_final_average, nlp_final_average), es_final_average);
			if (lowestAvg == uh_final_average) {return uh.nameOfService();}
			else if (lowestAvg == nlp_final_average) {return nlp.nameOfService();}
			else {return es.nameOfService();}
	
			// if ((uh_final_average < nlp_final_average) && (uh_final_average < es_final_average)) {lowestAvg = uh.nameOfService();}
			// if ((nlp_final_average < uh_final_average) && (nlp_final_average < es_final_average)) {lowestAvg = nlp.nameOfService();}
			// if ((es_final_average < nlp_final_average) && (es_final_average < uh_final_average)) {lowestAvg = es.nameOfService();}
			// return lowestAvg;
		} catch (NullPointerException e) {
			return es.nameOfService();
		}//end try catch