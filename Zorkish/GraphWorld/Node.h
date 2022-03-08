#pragma once
#include "Direction.h"
#include <iostream>
#include <vector>
using namespace std; 

struct Node
{
	//Every node will have a name
	string name; 
	string description; 
	//Every node will have a weight value associated with the node and 
	//pointer to the connected nodes. 
	vector<pair<Direction, Node*>> nodes;

	//Default Constructor 
	Node(string str, string desc) : name(str), description(desc) {}

	//Print all the connected nodes
	void print()
	{
		cout << "Node " << name << ": "; 
		for (auto n : nodes)
		{
			cout << " -> " << n.second->name
				<< "(dir= " << DirToString(n.first) << ")";
		}
		//Print out the description, can be changed
		cout << " | Desc: " << description; 
		cout << endl;
	}

	//Function to change a String to Direction
	static const Direction StringToDir(const string dir)
	{
		if (dir == "no")
			return Direction::no;
		if (dir == "north")
			return Direction::north;
		if (dir == "south")
			return Direction::south;
		if (dir == "east")
			return Direction::east;
		if (dir == "west")
			return Direction::west;
		if (dir == "northeast")
			return Direction::northeast;
		if (dir == "northwest")
			return Direction::northwest;
		if (dir == "southeast")
			return Direction::southeast;
		if (dir == "southwest")
			return Direction::southwest;
		if (dir == "up")
			return Direction::up;
		if (dir == "down")
			return Direction::down;
	}

	static const string DirToString(const Direction dir)
	{
		switch (dir)
		{
		case Direction::no:
			return "no";
		case Direction::north:
			return "north";
		case Direction::south:
			return "south";
		case Direction::east:
			return "east";
		case Direction::west:
			return "west";
		case Direction::northeast:
			return "northeast";
		case Direction::northwest:
			return "northwest";
		case Direction::southeast:
			return "southeast";
		case Direction::southwest:
			return "southwest";
		case Direction::up:
			return "up";
		case Direction::down:
			return "down";
		default:
			cout << "Argument is not of Direction type" << endl;
		}
	}
};
