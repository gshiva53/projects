#pragma once
#include <iostream>
#include "Command.h"
using namespace std;

class CommandTake : public Command
{
public: 
	CommandTake(Graph& graph, Player& player) : Command(graph, player) {}

	void Process(vector<string>& args) override
	{
		//TODO: take item from container NOT IMPLEMENTED
		if (args.size() == 2)
		{
			//Check if player already has the item with them
			if (_player.PlayerHasItem(args[1]))
			{
				cout << "You already have the item " + args[1] + "in your inventory" << endl; 
			}
			//if the player doesnt has the item then
			else
			{
				//check if the world has the item 
				//take the item from the world 
				//add it to the player
				if (_graph.ItemExistsInWorld(args[1]))
				{
					Item temp = _graph.TakeItemFromWorld(args[1]); 
					_player.AddItem(temp);
					cout << "Item " + args[1] + "taken" << endl; 
				}
				//print item could not be found if item not in world
				else
				{
					cout << "Can't find item " + args[1] + "to take from world." << endl; 
				}
			}
		}
	}
};