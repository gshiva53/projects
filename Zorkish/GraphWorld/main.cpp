#include <iostream>
#include <vector>
using namespace std; 

#define GRAPH_NODES 5

int main()
{
	vector<int> list[GRAPH_NODES] =
	{
		{3, 4},
		{3},
		{0, 1, 2},
		{0},
		{4}
	}; 

	cout << "Printing graph usign list" << endl; 
	for (int i = 0; i < GRAPH_NODES; ++i)
	{
		cout << i + 1; 
		for (auto n : list[i])
		{
			cout << " -> " << n + 1; 
		}
		cout << endl;
	}

	int a, b; 
	cin >> a >> b; 
	cout << endl; 

	list[a - 1].push_back(b - 1); 
	list[b - 1].push_back(a - 1); 

	return EXIT_SUCCESS;
}

void GraphMatrix()
{
	int graph[GRAPH_NODES][GRAPH_NODES]
	{
		{0, 0, 0, 1, 0},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 1, 0},
		{1, 1, 1, 0, 0},
		{0, 1, 0, 0, 0}
	};

	for (int i = 0; i < GRAPH_NODES; ++i)
	{
		cout << endl << i << " -> ";
		for (int j = 0; j < GRAPH_NODES; ++j)
		{
			cout << graph[i][j];
		}
	}
	cout << endl;

	int node;
	cout << "enter a node " << endl;
	cin >> node;

	for (int j = 0; j < GRAPH_NODES; ++j)
	{
		if (graph[node - 1][j] == 1)
			cout << j + 1;
		cout << endl;
	}
}