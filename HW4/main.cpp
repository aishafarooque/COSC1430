//============================================================================
// Name        : main.cpp
// Author      : Aisha Farooque
// Class       : COSC1430: Programming in C++
// Instructor  : Dr. Jerry Ebalunode
// Description : Dynamic Arrays


#include <iostream>
#include <string>
#include <bits/stdc++.h> 
#include <sstream>
using namespace std;

class DynamicArray{
private: 
	int arraySize;
	int numOfElements;
	int *arr;

public:
	DynamicArray(int Arraysize_) { //constructor
        if (Arraysize_ < 1) {
        	arraySize = 1;
        	arr = new int[arraySize];
        }

        else {
	        arraySize = Arraysize_;
	        arr = new int[arraySize];
	    }
        numOfElements = 0;
    }

    DynamicArray(const DynamicArray &a) { //copy constructor
       	arraySize = a.arraySize;
		numOfElements = a.numOfElements;
		arr = new int[arraySize];
		for (int i = 0; i < numOfElements; i++) {
			arr[i] = a.arr[i];
		}
    }

	int getArraySize() const {return arraySize;}
	int getNumOfElements() const {return numOfElements;}

	
	string print() const {
		std::string strArr = " ";

		if (numOfElements > 0) { //while there are elements to print
			strArr = ""; 
			for (int i = 0; i < numOfElements; i++) {
				stringstream ss;
				ss << arr[i]; //insert everything into ss
				std::string temp_print = ss.str(); 
				strArr = strArr + temp_print;

				//strArr += to_string(arr[i]) + ",";
				if (i < numOfElements - 1) {
					strArr = strArr+ ",";
				}

				//strArr += to_string(arr[numOfElements] - 1);
			}
			return strArr;
		}

		return 0;
		
	}

	void addElement(int num) {
		if (numOfElements == arraySize) { //if it's full
			// arraySize *= 2; //new size (doubled)
			int* temparr = new int [arraySize*2]; //new arr
			for (int i = 0; i < arraySize*2; i++) { //copy old arr to new
				temparr[i] = arr[i]; 
			}
			arraySize *= 2;		
			delete arr; //delete old array
			arr = temparr; //make old arr set to new
		}

		arr[numOfElements] = num;
		numOfElements++;
	}

	void deleteElement(int num) {
		for (int i = 0; i < numOfElements; i++) 
            if (arr[i] == num) {
                for (; i < numOfElements; i++) 
                    arr[i] = arr[i + 1]; 
                numOfElements--; 
                break; 
            }

        if (numOfElements <= (arraySize / 2)) {
            int* temp = new int[arraySize / 2];
            for (int i = 0; i < numOfElements; i++) 
                temp[i] = arr[i];
            arraySize /= 2;
            delete arr; 
            arr = temp; 
		}
		
		if (numOfElements == 0)
			arraySize = 3; 
	}

	void setArraySize(int size) {
		if (size >= numOfElements) {
			int* temp = new int[size];
			for (int i = 0; i < numOfElements; i++) {
				temp[i] = arr[i];
			}
			arraySize = size;
			delete arr;

			arr = temp;
		}
	}

	~DynamicArray() {
		delete[] arr;
	}

};


int main() {
//***********  addElements Function is Tested  ***********

   // cout << "Testing addElement: " << endl;
   DynamicArray Darr(1);
   Darr.addElement(1);
   Darr.addElement(2);
   Darr.addElement(3);
   Darr.addElement(4);
   Darr.addElement(5);
   if (Darr.getArraySize() == 8 )
   {
       cout << "Correct Result"<<  endl;
       // cout << "array Size after expansion is : 8" << endl<< endl;
   }
   else
   {
       cout << "Your addElement Function is NOT correct" << endl;
       cout << "Your arraySize after Expansion is : " << Darr.getArraySize() << endl;
       cout << "Expected Output : 8 " <<endl<< endl;
   }

   //*********** Constructor with invalid input  is Tested  ***********
   // cout << "Testing constructor with invalid input: " << endl;
   DynamicArray Darr2(0);
   if (Darr2.getArraySize() == 1 )
    {
       cout << "Correct Result" << endl;
       // cout << "array Size after given wrong value (less than one) : 1" << endl<< endl;
    }
   else
    {
       cout << "Your constrcutor is NOT Correct" << endl;
       cout << "The arraySize should be 1" << endl << endl;
    }

    //***********  Method with invalid input  is Tested ***********
    // cout << "Testing method with invalid input: " << endl;
   DynamicArray Darr3(3);
   Darr3.addElement(20);
   Darr3.addElement(22);
   Darr3.setArraySize(1);
   if(Darr3.getArraySize() == 3){
      cout << "Correct Result" << endl;
    // cout << "array Size is after given a wrong value (less than actual numOfElements) : 3"<<endl<< endl;
   }
   else {
       cout << "Your Constrcutor is NOT correct" << endl;
       cout << "The value passed for arraySize should be bigger than actual numOfElements" << endl<<endl;
   }

   // // //*********** Print Function  is Tested  ***********
   DynamicArray Darr4(1);
   Darr4.addElement(1);
   Darr4.addElement(2);
   Darr4.addElement(3);
   string s = Darr4.print();
   string str1 = "1,2,3";

   if(s == str1 ){
      cout << "Correct Result" << endl;
      // cout << "Elements of array :1,2,3" << endl<< endl;
   }
   else{
      cout << "Result is NOT correct " << endl;
      cout << "your function prints:" ;
      cout << s << endl;
      cout << "But, Expected output should be:" << str1 <<endl<<endl;

   }

    //*********** Copy Constructor  is Tested  ***********
   DynamicArray Darr5(1);
   Darr5.addElement(10);
   DynamicArray Darr6 = Darr5;
   Darr6.addElement(100);
   Darr6.addElement(1000);
   string s1 = Darr5.print();
   string output1 = "10";
   string s2 = Darr6.print();
   string output2 = "10,100,1000";
   //if(Darr.getnumOfElements() == 3 && Darr.getarraySize() == 4)
   if (s1==output1 && s2==output2){
        cout << "Correct Result"<< endl;
        // cout << "First array has " << Darr5.print() << endl;
        // cout << "Copied array after modification has " << Darr6.print() << endl<< endl;
        return true;
    }
   else{
      cout << "Result is NOT correct " << endl;
      cout << "First array has " << Darr5.print() << " should have: 10" << endl;
      cout << "Copied array after modification has " << Darr5.print() << " should have: 10,100,1000" << endl;
      return false;

   }
	return 1;
}
