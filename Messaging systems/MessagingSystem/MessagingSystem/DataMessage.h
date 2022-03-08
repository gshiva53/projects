#pragma once
#include "Message.h"
#include <vector>
#include <string>
using namespace std;

class DataMessage : public Message
{
public:
	DataMessage
	(
		const string& sendingEntitiy,
		const string& receivingEntity,
		const vector<int>& data
	)
	{
		_message = sendingEntitiy + ":" + receivingEntity; 
		for (int i : data)
		{
			_message += ":" + to_string(i);
		}
	}

	const string& Return_Message() const override
	{
		return _message;
	}
};
