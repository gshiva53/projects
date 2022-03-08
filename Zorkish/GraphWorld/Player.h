#pragma once
#include <iostream>
#include "Item.h"
#include "Node.h"
#include <map>
using namespace std; 

//contains a list of items, 
//game loop flag, 
//pointer to current world location
class Player 
{
private: 
	//List of all the physical items 
	//Holds all the physical items
	map<string, Item> _items;
	//currNode is the current location of the player
	Node* _currNode;
public: 
	bool playing = false; 
	Player()
	{
		_currNode = nullptr;
	}

	Node* GetCurrNode()
	{
		return _currNode;
	}

	void SetCurrNode(Node* currentPosition)
	{
		_currNode = currentPosition;
	}

	//Print all the items that player has
	void PrintItems()
	{
		cout << "----------------------- Items with Player ---------------------- " << endl;
		map<string, Item>::iterator it;

		for (it = _items.begin(); it != _items.end(); ++it)
		{
			it->second.Print();
		}
		cout << "------------------------------------------------------------- " << endl;
	}

	bool PlayerHasItem(string name)
	{
		map<string, Item>::iterator it;
		it = _items.find(name);

		if (it != _items.end())
			return true;
		return false;
	}

	//Add the passed in item to the list of items
	void AddItem(Item item)
	{
		_items.insert(pair<string, Item>(item.getNameOfItem(), item)); 
	}

	Item& TakeItemfromPlayer(string& name)
	{
		map<string, Item>::iterator it;
		it = _items.find(name);

		Item temp = it->second;
		return temp;
	}
};