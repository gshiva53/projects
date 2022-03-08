#pragma once
#include <iostream>
using namespace std; 

//Every entity is an item like rocks, flowers etc. 
//Worlds are NOT Items
class Item 
{
private: 
	string _name; 
	string _desc;
public: 
	Item(const string& name, const string& desc) : _name(name), _desc(desc) {}

	const string& getNameOfItem()
	{
		return _name;
	}

	const string& getDescOfItem()
	{
		return _desc;
	}

	void Print()
	{
		cout << "Item name: " << _name << endl; 
		cout << "Item Description: " << _desc << endl; 
	}
};