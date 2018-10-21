#include "Food.h"
#include "Candy.h"
#include "CandyWrapper.h"
#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

int main() {
	Food fd1 = Food(1,200,true);
	Food fd2 = Food(fd1);
	Candy cd1;
	Candy cd2;
	CandyWrapper cw1 = CandyWrapper(1,0.5,"red");
	CandyWrapper cw2 = CandyWrapper(0.5, 0.25, "blue");
	cd1.setVolume(0.05);
	cd1.setCalories(100);
	cd1.setVegetarian(true);
	cd1.setSweetness(0.7);
	cd1.setColor("pink");
	cd1.setCandyWrap(cw1);
	cd2 = cd1;
	cd2.setCandyWrap(cw2);
	if (fd1 == fd2)
		cout << "we are similar !!" << endl << endl;
	else
		cout << "we are different !!" << endl << endl;
	fd1.printItem();
	cout << endl;
	fd2.printItem();
	cout << endl;
	if (cd1 == cd2)
		cout << "we are similar !!" << endl << endl;
	else
		cout << "we are different !!" << endl << endl;
	cd1.printItem();
	cout << endl;
	cd2.printItem();
	cout << endl;
	system("pause");
	return 0;
}

//How to run:

/*

g++ -std=c++11 main.cpp Food.cpp CandyWrapper.cpp Candy.cpp
a.exe

OUTPUT:
we are similar !!

I am a vegetarian Food, my volume is 1 fl.Oz and I have 200 calories
I am a vegetarian Food, my volume is 1 fl.Oz and I have 200 calories
we are different !!

I am a vegetarian Candy, my volume is 0.05 fl.Oz and I have 100 calories, my sweetness level is 0.7, my color is pink and my wrapper has a length of 1 in, a width of 0.5 in and a red color

I am a vegetarian Candy, my volume is 0.05 fl.Oz and I have 100 calories, my sweetness level is 0.7, my color is pink and my wrapper has a length of 0.5 in, a width of 0.25 in and a blue color
*/