#pragma once
#include "Node.h"
#include "Item.h"
#include <map>

class Graph
{
private: 
	//Items that are plysically present in the world
	map<string, Item> _worldItems; 

public: 
	map<string, Node*> nodeMap; 
	void Print(); 
	void AddNode(const string& name, const string& descritption);
	void AddEdge(const string& from, const string& to, Direction dir); 
	Node* GetPtrToNode(const string& nodeName); 
	//Print all the connected nodes and their directions, connected to the passed in node ptr. 
	void PrintAllConnectedNodes(const Node* currentNode);

	void AddItemToWorld(Item itm);
	bool ItemExistsInWorld(string name);
	Item& TakeItemFromWorld(string name);
	void PrintItemsInWorld();
};
