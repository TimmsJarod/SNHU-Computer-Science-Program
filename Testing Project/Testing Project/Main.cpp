#include <iostream>
#include <cstring>
#include "ContactNode.h"
using namespace std;

int main() {
    //Builds ContactNode objects
    ContactNode* headNode = nullptr; 
    ContactNode* contactNodes1 = nullptr;
    ContactNode* contactNodes2 = nullptr;
    ContactNode* currNode = nullptr;

    //temp variables for node assignment
    string name;
    string phone_number;

    cout << "Person 1" << endl;
    cout << "Enter name:" << endl;
    getline(cin, name);
    cout << "Enter phone number:" << endl;
    cin >> phone_number;
    cin.ignore(256, '\n');
    cout << "You Entered: " << name << ", " << phone_number << endl;
    cout << endl;
    // Front of nodes list
    headNode = new ContactNode(name, phone_number);
    

    cout << "Person 2" << endl;
    cout << "Enter name:" << endl;
    getline(cin, name);
    cout << "Enter phone number:" << endl;
    cin >> phone_number;
    cin.ignore(256, '\n');
    cout << "You Entered: " << name << ", " << phone_number << endl;
    cout << endl;
    contactNodes1 = new ContactNode(name, phone_number);
    headNode->InsertAfter(contactNodes1);
    

    cout << "Person 3" << endl;
    cout << "Enter name:" << endl;
    getline(cin, name);
    cout << "Enter phone number:" << endl;
    cin >> phone_number;
    cin.ignore(256, '\n');
    cout << "You Entered: " << name << ", " << phone_number << endl;
    cout << endl;
    contactNodes2 = new ContactNode(name, phone_number);
    contactNodes1->InsertAfter(contactNodes2);
    

    //Prints linked list
    currNode = headNode;
    cout << "CONTACT LIST" << endl;
    while (currNode != nullptr) {
        currNode->PrintContactNode();
        currNode = currNode->GetNext();

        cout << endl;
    }

    return 0;
}