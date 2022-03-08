#pragma once
#include <list>
#include <vector>
#include <iostream>
#include "Entity.h"
using namespace std; 

//to avaoid diamond dependency problem
class Entity; 

class Dispatcher
{
private:
	vector<string> messages;
	list<Entity*> entities; 
public: 
	Dispatcher();
	~Dispatcher();
	void AddEntity(Entity* e);
	void Send_Message(const string& message, const string& receiverName, const string& type); 
	void ClearMessages();
	void PrintMessages();
};