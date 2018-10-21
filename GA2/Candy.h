//Candy.h
#ifndef CANDY_H
#define CANDY_H


#include <iostream>
#include <string>
#include "Food.h"
#include "CandyWrapper.h"
using namespace std;

class Candy : public Food {
public:
//Constructers
	Candy();
	Candy(float vol, int cal, bool vege, string col, CandyWrapper wrap, float sweet);
	Candy(const Candy &a);
	void printItem();
//Accessors
	string getColor();
	CandyWrapper getCandyWrap();
	float getSweetness();
//Mutators
	void setColor(string col);
	void setSweetness(float sweet);
	void setCandyWrap(CandyWrapper wrap);

	bool operator==(Candy f);

protected:
	string color;

private:
	float sweetness;
	CandyWrapper candyWrap;

};
#endif