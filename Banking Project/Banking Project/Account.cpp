#include "Account.h"
#include <iomanip>
#include <vector>
#include <iostream>

using namespace std;

//Constructor declaration - Set's default values.
Account::Account(double initialDeposit, double monthlyDeposit, double annualInterest, int numYears)
{
	initial_deposit = initialDeposit;
	monthly_deposit = monthlyDeposit;
	annual_interest = annualInterest;
	num_years = numYears;
}

/*
Accessors
*/

double Account::GetInitialDeposit()
{
	return initial_deposit;
}
double Account::GetMonthlyDeposit() 
{
	return monthly_deposit;
}
double Account::GetAnnualInterest() 
{
	return annual_interest;
}
int Account::GetNumYears() 
{
	return num_years;
}

/*
Mutators
*/

void Account::SetInitialDeposit() 
{
	cout << "What would you like your INITIAL deposit to be?" << endl;
	cin >> initial_deposit;
}
void Account::SetMonthlyDeposit() 
{
	cout << "What would you like your MONTHLY deposit to be?" << endl;
	cin >> monthly_deposit;
}
void Account::SetAnnualIntrest() 
{
	cout << "What would you like your annual interest to be?" << endl;
	cin >> annual_interest;
}
void Account::SetNumYears() 
{
	cout << "How many years would you like to save your money with us?" << endl;
	cin >> num_years;
}

/*
System Functions
*/


//simple menu display that shows the values that may be changed to the user.
void Account::DisplayMenu() 
{
	cout << "****************************************" << endl;
	cout << "****Airgead Banking App______Ver.0_1****" << endl;
	cout << "***************Input_Menu***************" << endl;
	cout << "1. Initial Investment Ammount: $";
	cout<< fixed << setprecision(2) << initial_deposit << endl;
	cout << "2. Monthly Deposit: $";
	cout << fixed << setprecision(2) << monthly_deposit << endl;
	cout << "3. Annual Interest: " << annual_interest << "%" << endl;
	cout << "4. Number of Years: " << num_years << endl;
	cout << "Enter [number] to edit a field, or [$] to simulate." << endl;

	TakeInput();
}

/*Switch that takes user input to change mutators.
* The User may make as many changes as they desire
* or simulate the results and return for more changes.
*/
void Account::TakeInput()
{
	char menu_input = NULL;
	cin >> menu_input;

	switch (menu_input)
	{
	case '1':
		SetInitialDeposit();
		break;
	case '2':
		SetMonthlyDeposit();
		break;
	case '3':
		SetAnnualIntrest();
		break;
	case '4':
		SetNumYears();
		break;
	case '$':
		SimulateData();
		SimulateData(monthly_deposit);
		break;
	default:
		cout << "Invalid entry. Please try agian. Enter [number] to edit a field, or [$] to simulate." << endl;
		TakeInput();
		break;
	}

	DisplayMenu();
}

/*
Takes the inputs and simulates the annual balances with monthly compount interest.
Includes a for loop that creates a vector list for montly changes in the balance that can be called on in set increments.
*/
void Account::SimulateData(double monthAmount)
{

	string with_without;
	int i;

	vector<double> bal_total((num_years * 12) + 1);
	vector<double> interest_total((num_years*12) + 1);

	bal_total.at(0) = initial_deposit;
	interest_total.at(0) = (0);

	for (i = 1; i <= num_years*12; ++i)
	{
		interest_total.at(i) = (bal_total.at(i-1) + monthAmount) * ((annual_interest / 100.00) / 12.00);

		bal_total.at(i) = (bal_total.at(i-1) + monthAmount) + interest_total.at(i);
	}

	//(Opening Amount + Deposited Amount) * ((Interest Rate/100)/12)

	with_without = (monthAmount > 0) ?  " With " : " Without ";

	cout << "Balance and Interest"<< with_without <<"Additonal Monthly Deposits" << endl;
	cout << "=============================================================" << endl;
	cout << "Year        Year End Ballance        Year End Earned Interest" << endl;
	cout << "-------------------------------------------------------------" << endl;

	//for loop to call on yearly balances. Formatted to display info in an appealing fashion.
	for (i = 1; i <= num_years; ++i)
	{
		cout << right << setw(3) << i;
		cout << right << setw(24) <<  bal_total.at(i * 12);
		cout << right << setw(32) <<  interest_total.at((i * 12) - 1) * 12 << endl;
	}
	cout << endl;
}

