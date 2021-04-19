#include <Python.h>
#include <iostream>
#include <Windows.h>
#include <cmath>
#include <string>

using namespace std;

//python integration
//Deleted unused string call function from assignment example.
/*
Description:
	To call this function, simply pass the function name in Python that you wish to call.
Example:
	callProcedure("printsomething");
Output:
	Python will print on the screen: Hello from python!
Return:
	None
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
Description:
	To call this function, pass the name of the Python functino you wish to call and the string parameter you want to send
Example:
	int x = callIntFunc("doublevalue",5);
Return:
	25 is returned to the C++
*/
int callIntFunc(string proc, int param)
{
	char* procname = new char[proc.length() + 1];
	std::strcpy(procname, proc.c_str());

	PyObject* pName, * pModule, * pDict, * pFunc, * pValue = nullptr, * presult = nullptr;
	// Initialize the Python Interpreter
	Py_Initialize();
	// Build the name object
	pName = PyUnicode_FromString((char*)"PythonCode");
	// Load the module object
	pModule = PyImport_Import(pName);
	// pDict is a borrowed reference 
	pDict = PyModule_GetDict(pModule);
	// pFunc is also a borrowed reference 
	pFunc = PyDict_GetItemString(pDict, procname);
	if (PyCallable_Check(pFunc))
	{
		pValue = Py_BuildValue("(i)", param);
		PyErr_Print();
		presult = PyObject_CallObject(pFunc, pValue);
		PyErr_Print();
	}
	else
	{
		PyErr_Print();
	}
	//printf("Result is %d\n", _PyLong_AsInt(presult));
	Py_DECREF(pValue);
	// Clean up
	Py_DECREF(pModule);
	Py_DECREF(pName);
	// Finish the Python Interpreter
	Py_Finalize();

	// clean 
	delete[] procname;

	return _PyLong_AsInt(presult);
}

//printMenu fuction to display user interaction options.
void printMenu()
{
	int userInput = 0;

	while (userInput != 3) //while loop keeps the program running until the user selects the quit option.0
	{
		cout << "1: Display a Multiplication Table\n" << endl;
		cout << "2: Double a Value\n" << endl;
		cout << "3: Exit\n" << endl;
		cout << "Enter your selection as a number 1, 2, or 3." << endl;

		cin >> userInput;

		//Switch takes user input, calls fuctions, or quits the program.
		switch (userInput)
		{
		case 1:
			CallProcedure("MultiplicationTable"); //Calls non-return function from python file.
			break;
		case 2:
			int userDoubleNum;
			cout << "Enter a number to double." << endl;
			cin >> userDoubleNum;

			cout << callIntFunc("DoubleValue", userDoubleNum) << endl; //Calls the python function to double user input.
			break;
		case 3:
			cout << "Exiting.\n" << endl; //Exits the program
			break;
		default:
			cout << "Invalid input. Please try again." << endl; //default triggers to invalid user inputs and loops back.
			break;
		}
	}
}

void main()
{
	printMenu(); //Prints the user menu.
}