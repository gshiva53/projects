#include "Graph.h"
#include "Item.h"
using namespace std; 

void Graph::Print()
{
	for (auto nodeMapObject : nodeMap)
	{
		nodeMapObject.second->print();
	}
}

//Print all the connected nodes and their directions, connected to the passed in node ptr. 
void Graph::PrintAllConnectedNodes(const Node* currentNode)
{
	const Node* currNode = currentNode;
	for (auto n : currNode->nodes)
	{
		cout << " -> " << n.second->name
			<< "(dir= " << Node::DirToString(n.first) << ")" << endl;
	}
}

void Graph::AddNode(const string& name, const string& description)
{
	map<string, Node*>::iterator itr = nodeMap.find(name);

	if (itr == nodeMap.end())
	{
		Node* n;
		n = new Node(name, description);
		nodeMap[name] = n;
		return; 
	}
	cout << "Node " << name << " already exists " << endl;
}

void Graph::AddEdge(const string& from, const string& to, Direction dir)
{
	Node* f = nodeMap.find(from)->second; 
	Node* t = nodeMap.find(to)->second; 

	pair<Direction, Node*> edge = make_pair(dir, t); 
	f->nodes.push_back(edge); 
}

Node* Graph::GetPtrToNode(const string& nodeName)
{
	Node* node = nodeMap.find(nodeName)->second; 
	return node; 
}

void Graph::AddItemToWorld(Item itm)
{
	_worldItems.insert(pair<string, Item>(itm.getNameOfItem(), itm));
}

bool Graph::ItemExistsInWorld(string name)
{
	map<string, Item>::iterator it; 
	it = _worldItems.find(name); 

	if (it != _worldItems.end())
		return true; 
	return false; 
}

Item& Graph::TakeItemFromWorld(string name)
{
	map<string, Item>::iterator it;
	it = _worldItems.find(name); 

	Item temp = it->second; 
	return temp;
}

void Graph::PrintItemsInWorld()
{
	cout << "----------------------- Items in World ---------------------- " << endl;
	map<string, Item>::iterator it; 
	
	for (it = _worldItems.begin(); it != _worldItems.end(); ++it)
	{
		it->second.Print(); 
	}
	cout << "------------------------------------------------------------- " << endl;
}