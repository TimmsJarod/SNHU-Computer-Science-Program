#include <iostream>
using namespace std;

#include "ContactNode.h"

//Consntructor
ContactNode::ContactNode(string setName, string setPhoneNumber, ContactNode* nextLoc)
{
	this->contactName = setName;
	this->contactPhoneNum = setPhoneNumber;

	this->nextNodePtr = nextLoc;
}

//All class functions
void ContactNode::InsertAfter(ContactNode* nodeLoc) {
	ContactNode* tmpNext = nullptr;

	tmpNext = this->nextNodePtr;
	this->nextNodePtr = nodeLoc;
	nodeLoc->nextNodePtr = tmpNext;
}

string ContactNode::GetName()
{
	return this->contactName;
}

string ContactNode::GetPhoneNumber()
{
	return this->contactPhoneNum;
}

ContactNode* ContactNode::GetNext()
{
	return this->nextNodePtr;
}

void ContactNode::PrintContactNode()
{
	cout << "Name: " << this->contactName << endl;

	cout << "Phone number: " << this->contactPhoneNum << endl;

}

