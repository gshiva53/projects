#pragma once
#include <iostream>
#include "Command.h"
using namespace std; 

class CommandDebugView : public Command
{
public: 
	CommandDebugView(Graph& g, Player& p) : Command(g, p) {}

	void Process(vector<string>& args) override
	{
		//if the command is debug
		if (args.size() == 1)
		{
			cout << "Current Node: " << _player.GetCurrNode()->name << endl;
			_graph.PrintAllConnectedNodes(_player.GetCurrNode());
			_graph.PrintItemsInWorld();
			_player.PrintItems(); 
		}
	}
};
