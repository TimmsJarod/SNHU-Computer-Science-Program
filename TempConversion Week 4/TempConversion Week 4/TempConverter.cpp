#include <iostream>
#include <fstream>
using namespace std;

int main() 
{
	//creates file stream variables to store the input file and output file.
	ifstream fileA;
	ofstream fileB;
	//Stores city name and 
	string degreeLocation;
	int degreeFar;
	int degreeCel;

	//opens the files 
	fileA.open("FahrenheitTemperature.txt");
	fileB.open("CelsiusTemperature.txt");

	//Reads FahrenheitTemperature.txt inputs
	fileA >> degreeLocation;
	fileA >> degreeFar;

	//while look checks for lines in fileA 
	while (!fileA.fail()) {
		/*
		Calculation to convert fahrenheit to celsius. I chose integers for the final numbers 
		however changing the declaration for the storage variables to doubles also works.
		Values are floor rounded.
		*/
		degreeCel = (degreeFar - 32.0) * (5.0 / 9.0);
		//console output just for fun.
		cout << "City: " << degreeLocation << " Temp: " << degreeCel << " degrees celsius" << endl;

		//Writes the converted information to the destination file.
		fileB << degreeLocation << " " << degreeCel << endl;

		//Intakes new values and restarts the loop.
		fileA >> degreeLocation;
		fileA >> degreeFar;
	}
	
	//After operations are complete, the files are closed.
	fileA.close();
	fileB.close();
}