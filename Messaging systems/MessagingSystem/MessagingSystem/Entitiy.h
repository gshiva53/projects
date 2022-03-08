#pragma once
#include <iostream>
#include "BlackBoard.h"
#include "StateMessage.h"
#include "DataMessage.h"
#include "ResponseMessage.h"
using namespace std; 

class Entity
{
private: 
	string name; 
public:
	//Every Entitiy will know about the blackboard
	BlackBoard* blackboard = nullptr; 
	StateMessage* stateMessage = nullptr; 
	DataMessage* dataMessage = nullptr; 
	ResponseMessage* responseMessage = nullptr; 
	
	//default constructor
	Entity(const string& name) 
		: name(name) {}
	
	//When Entity is destroyed then destroy blackboard
	~Entity() 
	{
		if (stateMessage != nullptr)
			delete stateMessage; 
		if (dataMessage != nullptr)
			delete stateMessage;
		if (responseMessage != nullptr)
			delete stateMessage;
		delete blackboard; 
	}

	void DebugEntity() const 
	{
		cout << name << endl; 
		if (stateMessage == nullptr)
			cout << "StateMessage is not assigned" << endl; 
		else
			cout << stateMessage->Return_Message() << endl; 
		if (dataMessage == nullptr)
			cout << "dataMessage is not assigned" << endl;
		else
			cout << dataMessage->Return_Message() << endl;
		if (responseMessage == nullptr)
			cout << "ResponseMessage is not assigned" << endl;
		else
			cout << responseMessage->Return_Message() << endl;
	}

	void stateChange(const string& state) const
	{
		if (state == "attacking")
			cout << "Entitiy -> " + name + " being attacked " << endl; 
		if (state == "defending")
			cout << "Entitiy -> " + name + " trying to defend " << endl; 
	}

	void DataFromDataMessage(const vector<int>& v)
	{
		for (int i : v)
		{

			cout << "Name: " << name << " -> Data: " << i << endl;
		}
	}

	void Response(const string& response) const
	{
		cout << "Name: " << name << " ->  Response: " << response << endl; 
	}

	string getName()
	{
		return name; 
	}
};