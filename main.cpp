#include <iostream>
#include <iomanip>
using namespace std;

int main() {
   
   int age;
   double price;
   float finalPrice;
   char category;
   int discount;
   
   cin >> price;
   cin >> age;
   cin >> category;
   
   if (age <= 0 || price <= 0) { 
      cout << "Wrong input" << endl;
      return 0;
   }
   
    if ((age > 0 && age <= 5) && (category != 'A' && category != 'a')) {
      discount = 90;
   } 
   
   else if ((age > 0 && age <= 5) && (category == 'A' || category == 'a')) {
      discount = 0;
   }
   
    if ((age > 5 && age <= 18) && (category != 'B' && category != 'b')) {
      discount = 45;
   }
   
   else if ((age > 5 && age <= 18) && (category == 'B' || category == 'b')) {
      discount = 0;
   }
   
    if ((age > 18 && age <= 25) && (category != 'C' && category != 'c')) {
      discount = 55;
   } 
   
   else if ((age > 18 && age <= 25) && (category == 'C' || category == 'c')) {
      discount = 0;
   }
   
    if ((age > 25 && age <= 65) && (category != 'D' && category != 'd')) {
      discount = 65;
   }
   
   else if ((age > 25 && age <= 65) && (category == 'D' || category == 'd')) {
      discount = 0;
   }
   
    if ((age > 65) && (category != 'E' && category != 'e')) {
      discount = 75;
   }
   
   else if ((age > 65) && (category == 'E' || category == 'e')) {
      discount = 0;
   }
   
   finalPrice  =  price - (( price * discount)/100);
   cout << fixed; 
   cout << setprecision(2) << finalPrice;
   
   return 0;  
}