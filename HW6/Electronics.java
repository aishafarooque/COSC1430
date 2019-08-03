/*
Your Electronics class inherits from Item. It should have following:

Attributes (private)

String model
int year
Methods (public)

void setModel(String m) - sets the model of Electronics.
void setYear(int year) - sets the manufacturing year of Electronics. If year<0, it is considered an invalid input and ignored (no update)
String getModel() - retrieves model.
int getYear() - retrieves manufacturing year.
String formattedOutput() overrides method from Item class and returns a string containing detail of the Electronic as "Name,price,model,makeYear" 
(without the quotes, no space only comma separating the values, for example: Probook,HP,2018,590.00
Constructors

Electronics(String n, double p, String md, int my) - If year<0, set it to 0.
Electronics() - default constructor, sets String attributes to "" and int/double to 0/0.00.
*/

public class Electronics extends Item {
	private String model;
	private int year;

	public void setModel(String m) {model = m;}
	public void setYear(int y) {
		if (y < 0) {
			//do nothing
		}
		else {
			year = y;
		}
	}

	public String getModel() {return model;}
	public int getYear() {return year;}
	public String formattedOutput() { //add overriding option from item
		return name + "," + price + "," + model + "," + year;
	}

	Electronics(String n, double p, String md, int my) {
		name = n;
		price = p;
		model = md;
		if (my < 0) {
			year = 0;
		}
		else {
			year = my;
		}
	}

	Electronics() {
		name = "";
		model = "";
		price = 0.0	;
		year = 0;
	}

	// public static void main(String[] args) {
	// 	Electronics abc = new Electronics("Laptop",999.99,"Mac",2018);
	// 	if(abc.formattedOutput().equals("Laptop,999.99,Mac,2018")){
	// 			 System.out.println(abc.formattedOutput());
	// 			 System.out.println("PASSED");
	// 	}
	// }
}