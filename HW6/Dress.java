/*
Your Dress class inherits from Item. It should have following:

Attributes (private)

String size
String fabric
Methods (public)

Constructor with parameters.
Additional set/get functions for new attributes.
String formattedOutput() overrides method from Item class and returns a string containing 
detail of the Food as "Name,price,size,fabric" (without the quotes, no space only comma separating the values, for example: Shirt,Small,cotton,9.49
Constructors

Dress(String n, double p, String s, String f)
Dress() - default constructor, sets String attributes to "" and int/double to 0/0.00.

*/

public class Dress extends Item {
	private String size;
	private String fabric;

	public void setSize(String s) {size = s;}
	public void setFabric(String f) {fabric = f;}
	public String getSize() {return size;}
	public String getFabric() {return fabric;}
	public String formattedOutput() { //add overriding option from item
		return name + "," + price + "," + size + "," + fabric;
	}

	Dress(String n, double p, String s, String f){
		name = n;
		price = p;
		size = s;
		fabric = f;
	}	

	Dress() {
		name = "";
		price = 0.0;
		size = "";
		fabric = "";
	}


	public static void main(String[] args) {
		Dress abc = new Dress("PoloShirt",20.01,"XL", "Mixed");
		if(abc.formattedOutput().equals("PoloShirt,20.01,XL,Mixed")){
				 System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
		}
	}


}