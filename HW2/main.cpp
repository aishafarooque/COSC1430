#include <iostream>
#include <iomanip>
#include <stdlib.h>
using namespace std;

int main() {
  int myVariable;
  int myVariable2;
  int array1[10];
  int array2[10];
  double average1 = 0.0;
  double average2 = 0.0;

  int seed_value;
  cin >> seed_value;
  srand(seed_value);

  for (int i = 0; i < 10; i++) {
    myVariable = rand() % 101;
    array1[i] = myVariable;
    //cout << array1[i] << " ";
    average1 += array1[i];
    
    myVariable2 = rand() % 101;
    array2[i] = myVariable2;
    //cout << array1[i] << " ";
    average2 += array2[i];
  }

  cout << fixed;
  cout << setprecision(2) << "Class A average is: " << (average1/10.0) << endl;

  cout << fixed;
  cout << setprecision(2) << "Class B Average is: " << (average2/10.0) << endl;

  if (average1 > average2) cout << "Class A wins!";
  else cout << "Class B wins!";

  return 0;
}
