#include "Dispatcher.h"
using namespace std; 

Dispatcher::Dispatcher() {}

Dispatcher::~Dispatcher()
{
	for (auto e : entities)
		delete e;
}

void Dispatcher::AddEntity(Entity* e)
{
	entities.push_back(e);
}

void Dispatcher::Send_Message(const string& message, const string& receiverName, const string& type)
{
	messages.push_back(message);
	for (list<Entity*>::iterator it = entities.begin(); it != entities.end(); ++it)
		//for (auto e : entities)
	{
		if ((*it)->GetName() == receiverName)
		{
			if (type == "state")
				(*it)->Receive_StateMessage(message);
			if (type == "data")
				(*it)->Receive_DataMessage(message);
			if (type == "response")
				(*it)->Receive_ResponseMessage(message);	
		}
	}
}


void Dispatcher::ClearMessages()
{
	messages.clear();
}

void Dispatcher::PrintMessages()
{
	cout << "\t===============Dispatcher=================" << endl;
	for (auto msg : messages)
	{
		cout << msg << endl;
	}
	cout << "\t==========================================" << endl;
}


