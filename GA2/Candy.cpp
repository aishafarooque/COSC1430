//Candy.cpp
#include <iostream>
#include <string>
#include "Candy.h"
using namespace std;

//Constructers
Candy::Candy() {
  setVolume(0);
  setCalories(0);
  setVegetarian(true);
  sweetness = 0;
  color = "NA";
//candyWrap = new CandyWrapper();
}

Candy::Candy(float vol, int cal, bool vege, string col, CandyWrapper wrap, float sweet) {
  setVolume(vol);
  setCalories(cal);
  setVegetarian(vege);
  color = col;
  candyWrap = wrap;
  sweetness = sweet;
}

Candy::Candy(const Candy &a) {  
  setVolume(a.getVolume());
  setCalories(a.calories);
  setVegetarian(a.vegetarian);
  color = a.color;
  candyWrap = a.candyWrap;
  sweetness = a.sweetness;
}

//Accessors
string Candy::getColor() {return color;}
CandyWrapper Candy::getCandyWrap(){return candyWrap;}
float Candy::getSweetness() {return sweetness;}

//Mutators
void Candy::setColor(string col) { color = col; }
void Candy::setSweetness(float sweet) { sweetness = sweet;}
void Candy::setCandyWrap(CandyWrapper wrap) { candyWrap = wrap; }

// The class overloads the operator ==
bool Candy::operator==(Candy f) {
  if(this->color == f.color && this->sweetness == f.sweetness)
    if(this->candyWrap.getLength() == f.candyWrap.getLength())
      if(this->candyWrap.getWidth() == f.candyWrap.getWidth())
        if(this->candyWrap.getColor() == f.candyWrap.getColor())
          return true;
  
  else return false;

}

void Candy::printItem() {
  cout << "I am ";

  if(vegetarian==true)
  {
    cout << "a vegetarian ";
  }
  else
    cout << "not a vegetarian ";

  cout <<  "Candy";
  cout << ", my volume is "<<getVolume()<<" fl.Oz";
  cout << " and I have " << calories << " calories";
  cout << ", my sweetness level is " << sweetness;
  cout << ", my color is "<<color;
  cout << " and my wrapper has ";
  candyWrap.printItem();

}