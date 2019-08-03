//============================================================================
// Name        : main.cpp
// Author      : Aisha Farooque
// Class       : COSC1430: Programming in C++
// Instructor  : Dr. Jerry Ebalunode
// Description : Arrays

#include <iostream>
#include <cstdlib> 
#include <string> 
#include <fstream>
#include <cmath>
using namespace std;

double difference(double grid[5][6], int r, int c, int r1, int c1) {
	/*FROM ZYBOOKS: This will take the grid, current positon and compare with the right most (upper, middle and lower) values*/
	return fabs(grid[r][c] - grid[r1][c1]);
}

double position_in_grid(double grid[5][6], double element) {
	/*This will take the grid and element and return it's location*/
	for (int rows = 0; rows < 6; rows++) {
		for (int cols = 0; cols < 5; cols++) {
			if (grid[rows][cols] == element) {
				return rows; //return them
				return cols;
			}
		}
	}
}

int main() {	
	ifstream inFS;																					
	ofstream outFS;
	string file_Name;
	int starting_position = 0, curr_row, curr_col, r1, c1, temp_row, temp_col;
	double grid[5][6], values, currentVal, difference_in_elevation, temp;

	
	cout << "Enter file name: ";
	cin >> file_Name; //file_Name = "in.txt";
	inFS.open(file_Name.c_str());
	outFS.open("out.txt");

	if (!inFS.is_open()) {
		cout << "Unable to open current file. Please try again!";
	}
	

	inFS >> starting_position;
	if (starting_position < 0 || starting_position > 7) {
		cout << "Error! Number not in range!" << starting_position;
	}

	curr_row = starting_position-1;
	curr_col = 0; 
		

	for (int r = 0; r < 5; r++) { 																		
		for (int c = 0; c < 6; c++) {
			inFS >> values;										
			grid[r][c] = values;
			}
		}

	currentVal = grid[curr_row][curr_col];
	position_in_grid(grid, currentVal);
	// cout << currentVal << " ";	
	outFS << starting_position << "," << 1 << ":" << currentVal << endl;

	temp = 99999999999999999;
	for (int c1=1; c1<6; c1++) {
		// c1 = j;

		int upper_row = curr_row - 1;  
		int middle_row = curr_row;
		int lower_row = curr_row + 1;

		for (int r1 = upper_row; r1 <= lower_row; r1++) {
			difference_in_elevation = difference(grid, curr_row, curr_col, r1, c1);

			if (difference_in_elevation < temp) {
				temp = difference_in_elevation;
				temp_row = r1;
				temp_col = c1;
				/*element_in_position(grid, temp_row, temp_col)*/
				middle_row = curr_row;
			}
			else if (difference_in_elevation == temp) {
				if (r1 == curr_row) { temp_row = r1; /*element_in_position(grid, temp_row, temp_col)*/}
				if (r1 == curr_row + 1) { 
					if(temp_row == curr_row - 1) { temp_row = r1; /*element_in_position(grid, temp_row, temp_col)*/ }
					if (temp_row == curr_row) { temp_row = r1-1; /*element_in_position(grid, temp_row, temp_col)*/ }
				}
			}

		}

		//reset values
		curr_row = temp_row;
		curr_col = temp_col;
		temp = 99999999999;

		outFS << curr_row + 1 << "," << curr_col + 1 << ":" << grid[curr_row][curr_col] << endl;
	}

	cout << "Done! Output is stored in out.txt" << endl;
	inFS.close();
	outFS.close();
	return 0;
	
}
