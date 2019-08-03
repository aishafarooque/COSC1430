/*

ITEM CLASS Your Item class should contain:

Attributes (protected)

String name - name of the Item
double price - price of the item
Methods (public)

void setName(String n) - sets the name of Item
void setPrice(double p) - sets the price of Item
String getName() - retrieves name
double getPrice() - retrieves price
String formattedOutput() returns a string containing detail of the Item as "Name,price" (without the 
quotes, no space only comma separating the values, for example: Apple,1.00
Constructors

Item(String n, double p) - constructor, sets name=n & price=p.
Item() - default constructor, sets name="" & price=0

*/

public class Item {
	protected String name;
	protected double price;

	public void setName(String n) {name = n;}
	public void setPrice(double p) {
		if (p <= 0) {
			//do nothing
		} else {
		price = p;
		}
	}
	public String getName() {return name;}
	public double getPrice() {return price;}
	public String formattedOutput() {
		return name + "," + price;
	}

	Item(String n, double p) {
		name = n;
		price = p;
	}

	Item() {
		name = "";
		price = 0;
	}

	// public static void main(String[] args) {
	// 	String test = "Test 2 (Item class mutator)";
	// 	Item item2 = new Item("Apple",1.99);
	// 	item2.setName("Organic Banana");
	// 	item2.setPrice(2.01);
	// 	item2.setPrice(-2.99);
        
 //        String name1 = item2.getName();
 //        double price1 = item2.getPrice();
        
 //        if(name1.equals("Organic Banana") && (price1 > 2.00 && price1 < 2.1) ){
 //           System.out.println("PASSED "+test);
 //         }
 //         else{
 //            System.out.println("FAILED >>>"+test);
	// 		System.out.println("Error in Item class! Item name was set to \"Organic Banana\" and price to 2.01. Tried to set price to -2.99");
 //            System.out.println("Found name:"+name1+", price="+price1);
 //         }
	// 	 System.out.println("");

	// 	// i.formattedOutput();
	// }
}