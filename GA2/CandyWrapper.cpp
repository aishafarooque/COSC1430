//CandyWrapper.cpp
#include <iostream>
#include <string>
using namespace std;

#include "CandyWrapper.h"

CandyWrapper::CandyWrapper() {  //default constructor definition
  length = 0;
  width = 0;
  color = "NA";
}

CandyWrapper::CandyWrapper(float wrapperLength, float wrapperWidth, string wrapperColor){  //definition for primary constructor
  length = wrapperLength;
  width = wrapperWidth;
  color = wrapperColor;
}
void CandyWrapper::printItem() {  //definition for print constructor
  cout << "a length of " << length << " in, a width of " << width << " in and a ";
  cout << color;
  cout << " color"<< endl;
}