#pragma once
#include <iostream>
#include <sstream>
#include "Dispatcher.h"
using namespace std; 

class Dispatcher; 

class Entity
{
private: 
	string _name; 
public: 
	Dispatcher* dispatcher = nullptr; 

	Entity(const string& name);
	~Entity(); 
	void Send_Message(const string& s, const string& receiverItem, const string& type);
	void Receive_StateMessage(const string& message);
	vector<int> Receive_DataMessage(const string& Data);
	string Receive_ResponseMessage(const string& message);
	void SetState(const string& state);
	const string& GetName(); 
	void DebugEntity();
	vector<string> Split(string s);
};
