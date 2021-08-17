//============================================================================
// Name        : Lab1-3.cpp
// Author      : Jarod Timms
// Course      : CS-260-X6350
// Date        : 7/2/2021
// Version     : 1.0
// Copyright   : Copyright © 2017 SNHU COCE
// Description : Lab 1-3 Up to Speed in C++
//============================================================================

#include <string>
#include <algorithm>
#include <iostream>



using namespace std;

//============================================================================
// Global definitions visible to all methods and classes
//============================================================================

// Defined structure BidInfo to take in variables and defined strToDouble fucntion. 
struct BidInfo
{
    string title;
    string fund;
    string vehicle;
    double amount;
};
double strToDouble(string str, char ch);

// replaced missing variables.
void displayBid(BidInfo bidInstance) {
    cout << "Title: " << bidInstance.title << endl;
    cout << "Fund: " << bidInstance.fund << endl;
    cout << "Vehicle: " << bidInstance.vehicle << endl;
    cout << "Bid Amount: " << bidInstance.amount << endl;

    return;
}

// Declared struct instance, assigned temp variables, and assigned return to function.
BidInfo getBid() {
    BidInfo bidVehicle;

    cout << "Enter title: ";
    cin.ignore();
    getline(cin, bidVehicle.title );

    cout << "Enter fund: ";
    cin >> bidVehicle.fund ;

    cout << "Enter vehicle: ";
    cin.ignore();
    getline(cin, bidVehicle.vehicle );

    cout << "Enter amount: ";
    cin.ignore();
    string strAmount;
    getline(cin, strAmount);
    bidVehicle.amount = strToDouble(strAmount, '$');

    return bidVehicle;
}

/**
 * Simple C function to convert a string to a double
 * after stripping out unwanted char
 *
 * credit: http://stackoverflow.com/a/24875936
 *
 * @param ch The character to strip out
 */
double strToDouble(string str, char ch) {
    str.erase(remove(str.begin(), str.end(), ch), str.end());
    return atof(str.c_str());
}


/**
 * The one and only main() method
 */
int main() {

    // Declared main() struct instance of BidInfo.
    BidInfo vehicle1;

    // loop to display menu until exit chosen
    int choice = 0;
    while (choice != 9) {
        cout << "Menu:" << endl;
        cout << "  1. Enter Bid" << endl;
        cout << "  2. Display Bid" << endl;
        cout << "  9. Exit" << endl;
        cout << "Enter choice: ";
        cin >> choice;

        // replaced vairables with BidInfo instance.
        switch (choice) {
            case 1:
                vehicle1 = getBid();
                break;
            case 2:
                displayBid(vehicle1);
                break;
        }
    }

    cout << "Good bye." << endl;

    return 0;
}
