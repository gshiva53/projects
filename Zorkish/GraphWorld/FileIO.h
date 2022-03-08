#pragma once
#include <iostream>
#include <fstream> 
#include <string>
#include "Graph.h"
#include "Node.h"
#include "Player.h"
using namespace std;

class FileIO
{
private:
	//instatiate the objects
	string fileName; 
	Graph g = Graph();
	Player p = Player(); 

public:
	FileIO(const string& fileName) : fileName(fileName) {}

	Graph& GetGraph()
	{
		return g; 
	}

	Player& GetPlayer()
	{
		return p; 
	}

	void ReadingFromFile()
	{ 
		ifstream file(fileName);

		if (file.is_open())
		{
			string name, desc;
			//Reading the first line for the number of nodes/locations
			string numOfNodes; 
			getline(file, numOfNodes); 
			int index = stoi(numOfNodes); 
			
			for (int n = 1; n <= index; ++n)
			{
				getline(file, name); 
				name = trim(name); 
				getline(file, desc); 
				desc = trim(desc); 

				//Adding the node that we read from the file to the private graph member
				g.AddNode(name, desc);
				//cout << name << endl << desc << endl; 
			}
			
			string numOfEdges; 
			getline(file, numOfEdges); 
			int counter = stoi(numOfEdges); 

			string edgeFrom, edgeTo, dirStr; 
			Direction direction; 

			for (int j = 1; j <= counter; ++j)
			{
				getline(file, edgeFrom);
				edgeFrom = trim(edgeFrom); 
				getline(file, edgeTo);
				edgeTo = trim(edgeTo); 
				getline(file, dirStr);
				direction = Node::StringToDir(dirStr); 
				g.AddEdge(edgeFrom, edgeTo, direction); 
			}

			//Items are physical Entities
			string numOfItems;
			getline(file, numOfItems);
			int loopCounter = stoi(numOfItems);

			string itemName; 
			string itemDesc; 
			//Read all the items 
			for (int k = 1; k <= loopCounter; ++k)
			{
				//Read the name and desc of each item and 
				//add the item to the players item list
				getline(file, itemName); 
				itemName = trim(itemName);
				getline(file, itemDesc); 
				itemDesc = trim(itemDesc);
				g.AddItemToWorld(Item(itemName, itemDesc));
			}
		}
		else
		{
			cout << "ERROR: File could not be opened for reading" << endl;
		}

		file.close();
	}

	void PrintGraphToConsole()
	{
		g.Print();
	}

	string& trim(string& str)
	{
		return str.erase(str.find_last_not_of(" \n\r\t") + 1); 
	}
};
