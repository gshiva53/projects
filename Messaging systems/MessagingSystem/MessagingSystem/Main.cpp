#include <iostream>
#include "BlackBoard.h"
#include "Entitiy.h"
#include "StateMessage.h"
#include "DataMessage.h"
#include "ResponseMessage.h"
using namespace std; 

int main()
{
	//A is attacking B
	StateMessage* stateMessageAB = new StateMessage("A", "B", "attacking");
	//C is defeding D
	StateMessage* stateMessageCD = new StateMessage("C", "D", "defending");
	//E is attacking F
	StateMessage* stateMessageEF = new StateMessage("E", "F", "attacking");

	DataMessage* dataMessageGH = new DataMessage("G", "H", { 1, 23, 45 });
	DataMessage* dataMessageIJ = new DataMessage("I", "J", { 6, 78, 90 });
	DataMessage* dataMessageKL = new DataMessage("K", "L", { 1123123, 21233, 451 });

	StateMessage* stateMessage1 = new StateMessage("X", "z", "Are you ready to surrender?");
	ResponseMessage* responseMessage1 = new ResponseMessage("X", "Z", "Ready to surrender"); 
	StateMessage* stateMessage2 = new StateMessage("V", "w", "Raise or Call?");
	ResponseMessage* responseMessage2 = new ResponseMessage("v", "W", "raising the bid"); 

	BlackBoard* blackboard = new BlackBoard(); 

	Entity a("A"); 
	Entity b("B");
	Entity c("C");
	Entity d("D");
	Entity e("E");
	Entity f("F");	
	
	Entity g("G"); 
	Entity h("H");
	Entity i("I");
	Entity j("J");
	Entity k("K");
	Entity l("L");

	Entity x("X");
	Entity z("Z");
	Entity v("V");
	Entity w("W");

	a.stateMessage = stateMessageAB; 
	c.stateMessage = stateMessageCD; 
	e.stateMessage = stateMessageEF; 

	g.dataMessage = dataMessageGH;
	i.dataMessage = dataMessageIJ;
	k.dataMessage = dataMessageKL;

	x.responseMessage = responseMessage1;
	x.stateMessage = stateMessage1;
	v.responseMessage = responseMessage2;
	v.stateMessage = stateMessage2;

	a.blackboard = blackboard;
	b.blackboard = blackboard;
	c.blackboard = blackboard;
	d.blackboard = blackboard;
	e.blackboard = blackboard;
	f.blackboard = blackboard;

	g.blackboard = blackboard;
	h.blackboard = blackboard;
	i.blackboard = blackboard;
	j.blackboard = blackboard;
	k.blackboard = blackboard;
	l.blackboard = blackboard;

	x.blackboard = blackboard;
	z.blackboard = blackboard;
	v.blackboard = blackboard;
	w.blackboard = blackboard;

/*	a.DebugEntity(); 
	b.DebugEntity(); 
	c.DebugEntity(); 
	d.DebugEntity(); 
	e.DebugEntity(); 
	f.DebugEntity();*/ 
	a.blackboard->Post_Message(a.stateMessage->Return_Message()); 
	c.blackboard->Post_Message(c.stateMessage->Return_Message()); 
	e.blackboard->Post_Message(e.stateMessage->Return_Message()); 
	a.blackboard->Print_Board(); 

	g.blackboard->Post_Message(g.dataMessage->Return_Message());
	i.blackboard->Post_Message(i.dataMessage->Return_Message());
	k.blackboard->Post_Message(k.dataMessage->Return_Message());
	g.blackboard->Print_Board();


	x.blackboard->Post_Message(x.stateMessage->Return_Message()); 
	x.blackboard->Post_Message(x.responseMessage->Return_Message());
	v.blackboard->Post_Message(v.stateMessage->Return_Message()); 
	v.blackboard->Post_Message(v.responseMessage->Return_Message());
	v.blackboard->Print_Board();

	b.stateChange(h.blackboard->Read_StateMessage(h.getName()));
	d.stateChange(j.blackboard->Read_StateMessage(j.getName()));
	f.stateChange(l.blackboard->Read_StateMessage(l.getName()));

	h.DataFromDataMessage(h.blackboard->Read_DataMessage(h.getName()));
	j.DataFromDataMessage(j.blackboard->Read_DataMessage(j.getName()));
	l.DataFromDataMessage(l.blackboard->Read_DataMessage(l.getName()));

	z.Response(z.blackboard->Read_ResponseMessage(z.getName()));
	w.Response(w.blackboard->Read_ResponseMessage(w.getName()));

	z.blackboard->Clear_Board(); 
	z.blackboard->Print_Board();

	return 0; 
}