#pragma once
#include <iostream>
#include "Command.h"
#include "CommandMove.h"
#include "CommandInventory.h"
#include "CommandLook.h"
#include "CommandDebugView.h"
using namespace std; 


//TODO: Delete all the commands and perform cleanup 
class CommandManager
{
private: 
	Player& _p; 
	Graph& _g; 
	map<string, Command*> _cmds;
public: 
	CommandManager(Graph& g, Player& p) : _g(g), _p(p)
	{
		//Move
		_cmds.insert(pair<string, Command*>("move", new CommandMove(_g, _p)));
		_cmds["go"] = _cmds["move"]; 

		//Inventory
		_cmds.insert(pair<string, Command*>("inventory", new CommandInventory(_g, _p))); 
		_cmds["inv"] = _cmds["inventory"];

		//look
		//look command handles look at
		_cmds.insert(pair<string, Command*>("look", new CommandLook(_g, _p))); 
		_cmds["inspect"] = _cmds["look"];

		//debug
		_cmds.insert(pair<string, Command*>("debug", new CommandDebugView(_g, _p)));
		//_cmds["treeview"] = _cmds["debug"]; 
	}
	
	void Process(vector<string>& args)
	{
		map<string, Command*>::iterator it;
		it = _cmds.find(args[0]);

		//if no command is entered
		if (args.size() == 0)
			cout << "Enter a command to interact with surroundings." << endl;
		//if only one word is entered in the command
		else if (args.size() == 1)
		{
			if (it != _cmds.end())
			{
				(it->second)->Process(args); 
			}
			else if (args[0] == "help")
			{
				PrintAllCommands();
			}
			//there is no command as the user entered
			//must be a direction
			else
			{
				args[0] = "move";
				(it->second)->Process(args);
			}
		}
		// if the command has two words
		else if (args.size() == 2)
		{
			if (it != _cmds.end())
			{
				(it->second)->Process(args); 
			}
		}
		//alias <new_word> <existing_word>
		else if (args.size() == 3)
		{
			map<string, Command*>::iterator itr;
			map<string, Command*>::iterator iter;
			itr = _cmds.find(args[1]);
			iter = _cmds.find(args[2]);

			if (itr != _cmds.end())
				cout << "Alias Failed. New command word " + args[1] + "already exists." << endl;
			else if (iter == _cmds.end())
				cout << "Alias Failed. Command Word " + args[2] + "clready exists" << endl; 
			//Create the alias
			else
			{
				_cmds[args[1]] = _cmds[args[2]]; 
				cout << "Alias created. Command " + args[2] + " can now be access via " + args[1] << endl; 
			}
		}
	}

	void PrintAllCommands()
	{
		map<string, Command*>::iterator it; 

		cout << "---------------------- Available Commands ----------------------------" << endl; 
		for (it = _cmds.begin(); it != _cmds.end(); it++)
		{
			cout << it->first << endl;
		}
	}
};
