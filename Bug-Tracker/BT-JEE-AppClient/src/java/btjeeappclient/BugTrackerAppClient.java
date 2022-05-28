/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btjeeappclient;

import entity.BugsDTO;
import session.BugsFacadeRemote;

/**
 *
 * @author Shiva Gupta This class is the app client for Bug Tracker enterprise
 * application. Refer to Lab 04.
 */
public class BugTrackerAppClient {

    @javax.ejb.EJB
    private static BugsFacadeRemote bugsFacade;

    public BugTrackerAppClient() {
    }

    public static void main(String[] args) {
        BugTrackerAppClient client = new BugTrackerAppClient();

        //TEST: creating a record in the bug db
        BugsDTO bugsDTO = new BugsDTO(00001, "npm fix", "npm package needs fixing", "fixing", "shiva", "high");
        boolean result = client.createRecord(bugsDTO);
        client.showCreateResult(result, bugsDTO);

    }

    public void showCreateResult(boolean result, BugsDTO bugsDTO) {
        if (result) {
            System.out.println("Record with primary key " + bugsDTO.getBugid()
                    + " has been created in the database table.");
        } else {
            System.out.println("Record with primary key " + bugsDTO.getBugid()
                    + " could not be created in the database table!");
        }
    }

    //wrapper method to expose functionality of the createRecord() function in bugsDb
    public boolean createRecord(BugsDTO bugsDTO) {
        return bugsFacade.createRecord(bugsDTO);
    }
}
