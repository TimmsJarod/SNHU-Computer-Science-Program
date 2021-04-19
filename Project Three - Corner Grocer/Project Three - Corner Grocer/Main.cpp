/*
Jarod Timms
CS-120 H4745
Dr. Jackie Kyger, Ed.D.
April 12, 2021
*/

#include <Python.h>
#include <iostream>
#include <Windows.h>
#include <cmath>
#include <string>
#include <fstream>

using namespace std;

/*
Culled unused python access functions.
*/
void CallProcedure(string pName)
{
	char* procname = new char[pName.length() + 1];
	std::strcpy(procname, pName.c_str());

	Py_Initialize();
	PyObject* my_module = PyImport_ImportModule("PythonCode");
	PyErr_Print();
	PyObject* my_function = PyObject_GetAttrString(my_module, procname);
	PyObject* my_result = PyObject_CallObject(my_function, NULL);
	Py_Finalize();

	delete[] procname;
}

/*
displayMenu displays options to the operator, then uses a simple switch to access the appropriate python functions using CallProcedure().
default case watches for invalid user entries.
*/
void displayMenu()
{
	int userInput = 0;
	

	while (userInput != 4) //While loop terminates when user selects 4.
	{
		cout << "1. Number of times each item appears." << endl;
		cout << "2. Frequency of a specific item." << endl;
		cout << "3. Export histogram as (frequency.dat) file." << endl;
		cout << "4. Exit." << endl;
		cout << "Please make a selection. [1-4]" << endl;
		
		cin >> userInput;

		
		switch (userInput)
		{
		case 1:
			CallProcedure("printGrocery");
			break;

		case 2:
			CallProcedure("searchGrocery");
			break;

		case 3:
			CallProcedure("exportData");
			break;

		case 4:
			cout << "Exiting program." << endl;
			break;

		default:
			cout << "Invalid input. Please try again.\n" << endl;
			displayMenu();
			break;
		}
	}
}

void main()
{
	displayMenu();
}