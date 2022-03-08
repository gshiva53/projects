#pragma once
#include <iostream>
#include "Command.h"
using namespace std; 

class CommandInventory : public Command
{
public: 
	CommandInventory(Graph& graph, Player& player) : Command(graph, player) {} 

	void Process(vector<string>& args) override
	{
		cout << "You currently have: " << endl; 

		_player.PrintItems(); 
	}
};
