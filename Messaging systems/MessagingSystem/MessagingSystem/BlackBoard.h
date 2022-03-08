#pragma once
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std; 

const char DELIMITER = ':';

vector<string> Split(string s)
{
	vector<string> args;
	//convert string s to stringstream str
	istringstream str(s);
	string word;

	while (getline(str, word, DELIMITER))
		args.push_back(word);
	//while (str >> word)
	//	args.push_back(word);

	return args;
}

class BlackBoard
{
private: 
	vector<string> board; 
public: 
	BlackBoard() {}
	~BlackBoard() {} 

	void Post_Message(const string& str)
	{
		board.push_back(str); 
	}

	void Clear_Board()
	{
		//vector clear removes all the elemetns(which are destroyed)
		//sets the vector size to 0.
		board.clear(); 
	}

	void Print_Board()
	{
		cout << "\t===============Black Board=============" << endl; 
		for (auto msg : board)
		{
			cout << msg << endl;
		}
		cout << "\t=======================================" << endl; 
	}

	string Read_StateMessage(const string& receiverName)
	{
		//Go through the board and search for the message for the receiver entity
		for (int n = 0; n < board.size(); n++)
		{
			vector<string> v = Split(board[n]);
			//As soon as you find the message 
			//return the state
			//NOTE: Assumes only one message for receiver Name
			if (v[1] == receiverName)
				return v[2];
		}
	}

	vector<int> Read_DataMessage(const string& receiverName)
	{
		//Go through the board and search for the message for the receiver entity
		for (int n = 0; n < board.size(); n++)
		{
			vector<string> v = Split(board[n]);
			//As soon as you find the message 
			//return the state
			//NOTE: Assumes only one message for receiver Name
			if (v[1] == receiverName)
			{
				vector<int> data; 
				data.push_back(stoi(v[2])); 
				data.push_back(stoi(v[3]));
				data.push_back(stoi(v[4]));
				return data; 
			}
		}
	}

	string Read_ResponseMessage(const string& receiverName)
	{
		//Go through the board and search for the message for the receiver entity
		for (int n = 0; n < board.size(); n++)
		{
			vector<string> v = Split(board[n]);
			//As soon as you find the message 
			//return the state
			//NOTE: Assumes only one message for receiver Name
			if (v[1] == receiverName)
				return v[3];
		}
	}
};