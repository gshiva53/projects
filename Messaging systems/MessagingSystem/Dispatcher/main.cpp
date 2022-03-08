#include <iostream>
#include "Entity.h"
#include "Dispatcher.h"
using namespace std;

int main()
{
	Dispatcher* dispatcher= new Dispatcher();

	Entity* a = new Entity("A");
	Entity* b = new Entity("B");
	Entity* c = new Entity("C");
	Entity* d = new Entity("D");
	Entity* e = new Entity("E");
	Entity* f = new Entity("F");
	dispatcher->AddEntity(a); 
	dispatcher->AddEntity(b); 
	dispatcher->AddEntity(c); 
	dispatcher->AddEntity(d); 
	dispatcher->AddEntity(e); 
	dispatcher->AddEntity(f); 

	a->dispatcher= dispatcher; 
	b->dispatcher = dispatcher; 
	c->dispatcher = dispatcher; 
	d->dispatcher = dispatcher; 
	e->dispatcher = dispatcher; 
	f->dispatcher = dispatcher; 

	a->Send_Message("A:B:running", "B", "state");
	a->dispatcher->PrintMessages(); 

	b->Send_Message("C:D:123:456:678", "D", "data");
	a->dispatcher->PrintMessages(); 

	e->Send_Message("E:F:Choose to pay or steal?", "D", "state");
	f->Send_Message("F:E:Response: player choose to steal", "D", "response");
	a->dispatcher->PrintMessages();

	return 0;
}