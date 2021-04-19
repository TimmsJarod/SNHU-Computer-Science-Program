import re
import string


def DoubleValue(v): #function doubles user input fed through C++ 
    return v * 2

def MultiplicationTable(): #Non-return fuction that takes local input and creates a mult-table.
    print("Enter a number to simulate multiplication table.")

    userDoubleNum = int(input())

    for i in range(10): #for loop uses each value i in range of 10 to create table.
        i += 1
        print( str(userDoubleNum) + " X " + str(i) + " = " + str(i * userDoubleNum) ) 