#ifndef CONTACT_NODE_H
#define CONTACT_NODE_H

#include <string>
using namespace std;

class ContactNode //Header for class variable definitions
{
    public:
        ContactNode(string setName = "No Name", string GetPhoneNumber = "xxx-xxx-xxxx", ContactNode* nextLoc = nullptr);
        void InsertAfter(ContactNode* nodeLoc);
        string GetName();
        string GetPhoneNumber();
        ContactNode* GetNext();
        void PrintContactNode();

    private:
        //class variables
        string contactName; 
        string contactPhoneNum;
        ContactNode* nextNodePtr;
};

#endif