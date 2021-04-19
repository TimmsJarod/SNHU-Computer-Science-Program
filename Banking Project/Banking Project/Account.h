#ifndef ACCOUNT_H
#define ACCOUNT_H

using namespace std;

class Account //Header for class variable definitions
{
public:
    //Constructor declaration - Set's default values.
    Account(double initialDeposit = 0.00, double monthlyDeposit = 0.00, double annualInterest = 0.00, int numYears = 0);

    //Accessors
    double GetInitialDeposit();
    double GetMonthlyDeposit();
    double GetAnnualInterest();
    int GetNumYears();

    //Mutators
    void SetInitialDeposit();
    void SetMonthlyDeposit();
    void SetAnnualIntrest();
    void SetNumYears();

    //System Functions
    void DisplayMenu();
    void TakeInput();
    void SimulateData(double monthAmount = 0);
    
private:
    //class variables
    double initial_deposit;
    double monthly_deposit;
    int annual_interest;
    int num_years;
};

#endif