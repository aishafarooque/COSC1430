/*
Your Food class inherits from Item. It should have following:

Attributes (private)

double weight
String weightUnit
Methods (public)

void setWeightUnit(String wu) - sets the weightUnit of Food.
void setWeight(double wt) - sets the weight of Food. If w<0, no update is required.
String getWeightUnit() - retrieves weightUnit.
double getWeight() - retrieves weight.
String formattedOutput() overrides method from Item class and returns a string containing detail 
of the Food as "Name,prince,weight,weightUnit" (without the quotes, no space only comma separating the values, for example: Greens,1,lb,2.49
Constructors

Food(String n, double p, double w, String wu) - If w<0, set it to 0.
Food() - default constructor, sets String attributes to "" and int/double to 0/0.00.
*/

public class Food extends Item {
	private double weight;
	private String weightUnit;

	public void setWeightUnit(String wu) {weightUnit = wu;}
	public void setWeight(double wt) {weight = wt;}
	public String getWeightUnit() {return weightUnit;}
	public double getWeight() {return weight;}
	public String formattedOutput(){
		return name + "," + price + "," + weight + "," + weightUnit;
	}

	Food(String n, double p, double w, String wu) {
		name = n;
		price = p;
		weight = w;
		weightUnit = wu;
	}	

	Food() {
		name = "";
		weightUnit = "";
		price = 0.0;
		weight = 0;
	}

	// public static void main(String[] args) {
	// 	Food abc = new Food("Meat",14.01,10.01, "lb");
	// 	System.out.println(abc.formattedOutput());
	// }
}