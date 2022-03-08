#pragma once
#include "Message.h"
using namespace std;

class ResponseMessage : public Message
{
public:
	ResponseMessage
	(
		const string& sendingEntitiy,
		const string& receivingEntity,
		const string& response
	)
	{
		_message = sendingEntitiy + ":" + receivingEntity + ":respond" + ":" + response;
	}

	const string& Return_Message() const override
	{
		return _message;
	}
};
