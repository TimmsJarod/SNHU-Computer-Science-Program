/*
Jarod Timms
3-19-2021
CS-120-H4745
*/

#include <iostream>
#include <iomanip>

using namespace std;

/*
Classes - I opted for classes to keep functions orgonized.
*/

class HourSet24;

//Enumerator to easily switch between A.M. and P.M.
enum AMPM { AM, PM }ampm;
// Time is a parent class that feeds into HourSet12 and 24.
// Defined variables for hour, minute, and second as well as incrementing functions are stored here.
class Time
{
	public:
		int hour;
		int minute;
		int second;

		//virtual functions can be overwritten by child classes.
		virtual void addOneHour() = 0;
		virtual void addOneMinute() = 0;
		virtual void addOneSecond() = 0;
};

//Child class to Time that modifies initialized clocks based on if it should end at 12 hours or 23.
class HourSet12 : public Time {

public:

	HourSet12(int h, int m, int s) {
		//variables intake from initialized clock
		hour = h;
		minute = m;
		second = s;
		ampm = PM; // sets time to PM by default. (This is due to initialization)
	}

	void addOneHour() {
		//Once the hour reaches 12 it is set back to one and an elif exchanges enum value AM for PM or vise versa based on enum value.
		if (hour == 11) {
			ampm = (ampm == AM) ? PM : AM;
		}
		if (hour == 12) {
			hour = 1;
		}
		else {
			//If hour criteria is not met, value increments normally.
			hour += 1;
		}
	}

	void addOneMinute() {

		if (minute == 59) {

			minute = 0;
			addOneHour();
		}
		else {
			minute += 1;
		}
	}

	void addOneSecond() {

		if (second == 59) {

			second = 0;
			addOneMinute();
		}
		else {

			second += 1;

		}

	}
};

//Child class is the same as 12, with the difference of incrementing 23 to 0 hours and dropping enum.
class HourSet24 : public Time {

public:

	HourSet24(int h, int m, int s) {
		hour = h;
		minute = m;
		second = s;
	}

	void addOneHour() {

		if (hour == 23) {
			hour = 0;
		}
		else {
			hour += 1;
		}

	}

	void addOneMinute() {

		if (minute == 59) {
			minute = 0;

			addOneHour();
		}
		else {
			minute += 1;
		}
	}

	void addOneSecond() {

		if (second == 59) {
			second = 0;

			addOneMinute();
		}
		else {
			second += 1;
		}
	}
};


/*
Non-Classed Functions. displayTime and displayMenu are for printing the clocks and initiating the menus.
*/

void displayTime(const HourSet12& time12, const HourSet24& time24) {

	//Builds the "clock" graphics and takes in the info from the initialized clocks then displays them.
	cout << "*************************** ***************************" << endl;
	cout << "*     12-Hour Clock       * *      24-Hour Clock      *" << endl;
	cout << "*     ";

	if (time12.hour < 10) cout << "0"; cout << time12.hour << ":";
	if (time12.minute < 10) cout << "0"; cout << time12.minute << ":";
	if (time12.second < 10) cout << "0"; cout << time12.second;
	
	if (ampm == AM) cout << " A M"; 
	else cout << " P M";

	cout << "        * *         ";

	if (time24.hour < 10) cout << "0"; cout << time24.hour << ":";
	if (time24.minute < 10) cout << "0"; cout << time24.minute << ":";
	if (time24.second < 10) cout << "0"; cout << time24.second;

	cout << "        *" << endl;
	cout << "*************************** ***************************" << endl;

}

void displayMenu()
{
	//Multi function Menu doubles for initialization of the clocks and enters a loop.
	//Within the loop, users may edit the clocks by adding time to hours, minutes, and seconds.
	char userInput = 1;

	//24 hour clock is initialized just before midnight, the reasoning for the initalizing the enum with PM.
	HourSet12 time12Initialize(11, 59, 59);
	HourSet24 time24Initialize(23, 59, 59);

	while (userInput != '4')
	{
		displayTime(time12Initialize, time24Initialize);

		cout << setfill('*') << setw(27) << "" << endl;
		cout << "* 1 - Add One Hour        *" << endl << endl;
		cout << "* 2 - Add One Minute      *" << endl << endl;
		cout << "* 3 - Add One Second      *" << endl << endl;
		cout << "* 4 - Exit Program        *" << endl << endl;
		cout << setfill('*') << setw(27) << "" << endl;

		cin >> userInput;

		switch (userInput)
		{
		case '1':
			time12Initialize.addOneHour();
			time24Initialize.addOneHour();
			break;

		case '2':
			time12Initialize.addOneMinute();
			time24Initialize.addOneMinute();
			break;

		case '3':
			time12Initialize.addOneSecond();
			time24Initialize.addOneSecond();
			break;

		case '4':
			cout << "Clocking out." << endl;
			break;
		default:
			cout << "Invalid input. Please try again." << endl;
			break;
		}

	}
}

/*
Main
*/

//An exceptionally minimized main.  
void main() 
{
	displayMenu();
}