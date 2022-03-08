#pragma once
#include "Graph.h"
#include "Player.h"
#include <vector>

class Command
{
protected: 
	Graph& _graph; 
	Player& _player;
public: 
	Command(Graph& graph, Player& player) : _graph(graph), _player(player) {}
	virtual void Process(vector<string>& args) = 0;
};