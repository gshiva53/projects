#pragma once
#include "Command.h"
using namespace std; 

class CommandLook : public Command
{
public: 
	CommandLook(Graph& g, Player& p) : Command(g, p) {} 

	void Process(vector<string>& args) override
	{
		//if command is "look"
		//return the current position description 
		//edge information
		if (args.size() == 1)
		{
			cout << "Current Node: " << _player.GetCurrNode()->name << endl;
			_graph.PrintAllConnectedNodes(_player.GetCurrNode()); 
		}
		//if the command is "look at"
		else if (args.size() == 2)
		{
			_graph.PrintItemsInWorld();
		}
	}
};
