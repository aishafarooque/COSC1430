// Food.cpp
#include <iostream>
#include <string>
#include "Food.h"
using namespace std;

// A default constructor that sets the volume to 0, the calories to 0 and vegetarian to true.
Food::Food() {volume = 0; calories = 0; vegetarian = true;}

// A copy constructor.
Food::Food(const Food &a) {volume = a.volume; calories = a.calories; vegetarian = a.vegetarian;}

// A constructor that takes a volume, calories and vegetarian as parameters. 
Food::Food(float volume, int calories, bool vegetarian) {this->volume = volume; this->calories = calories; this->vegetarian = vegetarian;}

// Public accessors and mutators for volume, calories and vegetarian.
//mutators
void Food::setVolume(float foodVolume) { volume = foodVolume;}
void Food::setCalories(int foodCalories) { calories = foodCalories;}
void Food::setVegetarian(bool foodVegetarian) { vegetarian = foodVegetarian;}

//accessors
float Food::getVolume() const { return volume;}
int Food::getCalories() const { return calories;}
bool Food::getVegetarian() const { return vegetarian;}

// The class overloads the operator ==
bool Food::operator==(Food f) {
	if(this->volume == f.volume && this->calories == f.calories && this->vegetarian == f.vegetarian) return true;
	else return false;
}

// A function called printItem() printing the a description of the class in the following
// format
void Food::printItem() const {
	if (vegetarian == true) {
		cout << "I am a vegetarian Food, my volume is " << volume << " fl.Oz and I have " << calories << " calories";
	}
	else 
		cout << "I am not a vegetarian Food, my volume is " << volume << " fl.Oz and I have " << calories << " calories";
}


int main() {
	Food fd1 = Food(1,200,true);
	Food fd2 = Food(fd1);

	if (fd1 == fd2)
		cout << "we are similar !!" << endl << endl;
	else
		cout << "we are different !!" << endl << endl;
	fd1.printItem();
	cout << endl;
	fd2.printItem();
	cout << endl;
}