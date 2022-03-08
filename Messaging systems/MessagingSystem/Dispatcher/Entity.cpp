#include "Entity.h"
#include <string>
using namespace std; 

Entity::Entity(const string& name) : _name(name) {}
Entity::~Entity()
{
	delete dispatcher;
}

//receiverItem is being passed to avoid look up costs in Dispatcher
//otehrwise Dispatcher can use the Split function and send the message to receiver
void Entity::Send_Message(const string& s, const string& receiverItem, const string& type)
{
	dispatcher->Send_Message(s, receiverItem, type);
}

void Entity::Receive_StateMessage(const string& message)
{
	vector<string> args = Split(message);
	cout << "Name: " << _name << " State: " << args[2] << endl;
	SetState(args[2]);
}

vector<int> Entity::Receive_DataMessage(const string& Data)
{
	vector<string> args = Split(Data);
	vector<int> datas;
	cout << "Name: " << _name << " Data: " << args[2] << endl;
	datas.push_back(stoi(args[2]));
	cout << "Name: " << _name << " Data: " << args[3] << endl;
	datas.push_back(stoi(args[3]));
	cout << "Name: " << _name << " Data: " << args[4] << endl;
	datas.push_back(stoi(args[4]));
	return datas; 
}

string Entity::Receive_ResponseMessage(const string& message)
{
	vector<string> args = Split(message);
	cout << "Name: " << _name << " Response: " << args[3] << endl;
	string str = args[3]; 
	return str;
}

void Entity::SetState(const string& state)
{
	if (state == "running")
		cout << "Entity: " << _name << " -> has chosen to run away." << endl;
	else if (state == "fighting")
		cout << "Entity: " << _name << " -> has chosen to fight." << endl;
}

const string& Entity::GetName()
{
	return _name;
}

void Entity::DebugEntity()
{
	cout << "Name: " << _name << endl;
}


vector<string> Entity::Split(string s)
{
	vector<string> args;
	//convert string s to stringstream str
	istringstream str(s);
	string word;

	while (getline(str, word, ':'))
		args.push_back(word);
	//while (str >> word)
	//	args.push_back(word);

	return args;
}

