//CandyWrapper.h
#ifndef CANDYWRAPPER_H
#define CANDYWRAPPER_H

class CandyWrapper {
public:
  CandyWrapper(); //default constructor
  CandyWrapper(float wrapperLength, float wrapperWidth, string wrapperColor); // primary constructor
  void printItem(); //print constructor
  void setLength(float wrapperLength) { //mutator for length
    length = wrapperLength;
  }
  void setWidth(float wrapperWidth) { //mutator for width
    width = wrapperWidth;
  }
  void setColor(string wrapperColor) { //mutator for color
    color = wrapperColor;
  }
  float getLength() const { //accessor for length
    return length;
  }
  float getWidth() const {  //accessor for width
    return width;
  }
  string getColor() const { //accessor for color
    return color;
  }
  CandyWrapper(const CandyWrapper &r) { //copy constructor
    length = r.length;
    width = r.width;
    color = r.color;
  }

private:
  float length;
  float width;
  string color;
};



#endif