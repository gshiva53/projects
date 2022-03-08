#pragma once
#include "Message.h"
using namespace std; 

class StateMessage : public Message
{
public: 
	StateMessage
	(
		const string& sendingEntitiy, 
		const string& receivingEntity, 
		const string& stateMsg
	)
	{
		_message = sendingEntitiy + ":" + receivingEntity + ":" + stateMsg;
	}

	const string& Return_Message() const override 
	{
		return _message; 
	}
};
