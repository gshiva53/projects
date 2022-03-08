#pragma once
#include <iostream>

class Message
{
protected: 
	string _message; 
public: 
	virtual const string& Return_Message() const = 0;
};