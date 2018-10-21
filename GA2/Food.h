//Food.h
#ifndef FOOD_H
#define FOOD_H

//Food.h
#include <iostream>
#include <string>
using namespace std;

class Food {
private:
	float volume;

protected: 
	int calories;
	bool vegetarian;
public:
	void setVolume(float volume);
	void setCalories(int foodCalories);
	void setVegetarian(bool foodVegetarian);
	float getVolume() const;
	int getCalories() const;
	bool getVegetarian() const;

	//constructors
	Food();
	Food(const Food &a);
	Food(float volume, int calories, bool vegetarian);

	bool operator==(Food f);
	void printItem() const;

};
#endif