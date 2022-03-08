#pragma once
#include <iostream>
#include <vector>
#include "Command.h"
using namespace std; 

//If the specified direction is valid then move to that position
class CommandMove : public Command
{
public: 
	CommandMove(Graph& graph, Player& player) : Command(graph, player) {}

	void Process(vector<string>& args) override
	{
	/*	_graph.Print();
		_player.PrintItems();*/
		//_player.GetCurrNode()->name;
		//if the size of the command is not equal to 2
		//command is not valid.
		if (args.size() != 2)
		{
			cout << "Can't move like that! Syntax: \" move (direction)\" " << endl;
		}
		else
		{
			//cout << "##########################################" << endl; 
			//cout << args[1] << endl; 

			for (auto n : _player.GetCurrNode()->nodes)
			{
				//cout << "-------------------------------" << endl; 
				//cout << Node::DirToString(n.first) << endl;
				//cout << "-------------------------------" << endl; 

				//if the direction entered by user is same as that of connected node
				if (args[1] == Node::DirToString(n.first))
				{
					//set the cuurent position/node to that node
					//print the new node/position 
					//print all the connected nodes to that node
					_player.SetCurrNode(n.second);
					cout << _player.GetCurrNode()->name << endl;
					_graph.PrintAllConnectedNodes(_player.GetCurrNode());
					break; 
				}
				else
				{
					cout << "Can't move " << args[1] << endl;
					break;
				}
			}
		}
	}
};
