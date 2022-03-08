#include "Graph.h"
#include "FileIO.h"
#include "CommandMove.h"
#include "CommandManager.h"
#include <sstream>

const string DELIMITER = " ";

vector<string> Split(string s)
{
	vector<string> args;
	//convert string s to stringstream str
	stringstream str(s); 
	string word; 

	while (str >> word)
		args.push_back(word); 

	return args;
}

string& trim(string& str)
{
	return str.erase(str.find_last_not_of(" \n\r\t") + 1);
}

int main()
{

	FileIO myFileIO("test.txt");
	//Pass in the player 
	myFileIO.ReadingFromFile();
	myFileIO.PrintGraphToConsole();

	Player& p = myFileIO.GetPlayer();
	Graph& g = myFileIO.GetGraph();

	p.PrintItems();
	g.PrintItemsInWorld();

	p.SetCurrNode(g.GetPtrToNode("A"));
	cout << "Current Node: " << p.GetCurrNode()->name << endl;
	
	//CommandMove cmdMove = CommandMove(g, p);
	//Command* cmd = &cmdMove; 
	CommandManager mgr = CommandManager(g, p); 
	//mgr.cmds.insert(pair<string, Command*>("move", &cmdMove));
	

	string command;
	char _command[100];
	vector<string> args;

	do
	{
		cout << "Enter Command: " << endl;
		cin.getline(_command, 100);

		args = Split(_command); 

		mgr.Process(args);
		//cmdMove.Process(args);
		//(mgr.cmds["move"])->Process(args); 
		//cmdHelp.Process(args); 
		//cmdMovePtr->Process(args); 

	} while (_command != "break");

	/*do 
	{
		cout << "Which world do you want to go to? (\"quit\" to escape)" << endl;
		cin >> command;

		p.SetCurrNode(g.GetPtrToNode(command));
		cout << "Current Node: " << p.GetCurrNode()->name << endl;

		g.PrintAllConnectedNodes(p.GetCurrNode());

		do
		{
			cout << "Which direction do you want to go in? (break to exit this option)" << endl; 
			cin.getline(_command, 100);
			cout << _command;
			vector<string> args = Split(_command);

			for (auto n : args)
			{
				cout << n << endl; 
			}

			cmdMove.Process(args);

		} while (_command != "break");

		if (command == "quit")
			p.playing = false; 
	} while (!(p.playing));*/
	//do
	//{
	//	cout << "Which world do you want to go to? (\"quit\" to escape)" << endl;
	//	cin >> command;

	//	//Graph g = myFileIO.GetGraph();
	//	//const Node* currNode = g.GetPtrToNode(command);
	//	p.SetCurrNode(g.GetPtrToNode(command));

	//	//Current World position of the player
	//	cout << "Current Node: " << p.GetCurrNode()->name << endl;

	//	g.PrintAllConnectedNodes(p.GetCurrNode()); 

	//	do
	//	{
	//		cout << "Which direction do you want to go in? ((\"break\" to exit this option)" << endl;
	//		cin >> command;

	//		for (auto n : p.GetCurrNode()->nodes)
	//		{
	//			if (command == Node::DirToString(n.first))
	//			{
	//				p.SetCurrNode(n.second);
	//				cout << p.GetCurrNode()->name << endl;
	//				g.PrintAllConnectedNodes(p.GetCurrNode());
	//			}
	//			else
	//				break;
	//		}
	//	}while (command != "break"); 
	//} while (command != "quit");
	
	//Graph g = Graph(); 

	//g.AddNode("A", "Lorem Ipsum");
	//g.AddNode("B", "Lorem Ipsum");
	//g.AddNode("B", "Lorem Ipsum");
	//g.AddNode("C", "Lorem Ipsum");
	//g.AddNode("D", "Lorem Ipsum");
	//g.AddNode("E", "Lorem Ipsum");
	//g.AddNode("F", "Lorem Ipsum");

	////A is connected to Node B and Node B is South of A
	//g.AddEdge("A", "B", Direction::south); 
	//g.AddEdge("B", "D", Direction::southeast);
	//g.AddEdge("C", "B", Direction::northwest);
	//g.AddEdge("B", "B", Direction::no);
	//g.AddEdge("E", "F", Direction::west);

	//g.Print(); 
}