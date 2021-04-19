import re
import string

#Pyhton builds dictionary when accessed. 
#Dictionary is erased from memory when called function terminates.
groceryDict = {}

#for loop reads each line from provided list and adds it to the dictionary.
#If the entry matches no keys in the dictionary, it is initialized as a key with the value of 1
#Matched cases add 1 to value each time the for loop reads a duplicate entry.
eachLine = open("vegList.txt", "r")
for x in eachLine:
    x = x.replace("\n","")
    if x in groceryDict:
        groceryDict[x] += 1
    else:
        groceryDict[x] = 1

#Selection 1 - Reads through dictionary and displays all entries.
def printGrocery():
    for x in groceryDict:
        print( str(x) + " " + str(groceryDict[x]) )

#Selection 2 - Takes user input and searches dictionary for specified item and displays frequency of that item.
#If item is not in dictionary, function displays message to user.
def searchGrocery():
    print("Please search for an Item. \nBegin Item with captical letter.")
    x = input()
    if x in groceryDict:
        print( str(x) + " " + str(groceryDict[x]));
    else:
        print("No item in system matches that description.\nPlease try another item.")

#Selection 3 - Writes formatted dictionary to frequency.dat and informs the user the information has been copied.
def exportData():
    print("Writing to file...")
    f = open("frequency.dat", "w")
    for x in groceryDict:
        f.write(str(x) + " " + str(groceryDict[x]) + "\n")
    print("Writing finished!")
    f.close()

