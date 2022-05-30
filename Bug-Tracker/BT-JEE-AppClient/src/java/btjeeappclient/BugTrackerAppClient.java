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

        //TEST: creating a record in the bugsFacade
        BugsDTO bugsDTO = new BugsDTO(00001, "npm fix", "npm package needs fixing", "fixing", "shiva", "high");
        boolean result = client.createRecord(bugsDTO);
        client.showCreateResult(result, bugsDTO);

        //TEST: reading a record from the bugsFacade
        client.showGetResult(client.getRecord(00001));

        //TEST: updating the record from the bugsFacade
        BugsDTO updatebugsDTO = new BugsDTO(00001, "npm fix", "npm package needs fixing", "fixing", "shiva", "medium");
        boolean updateresult = client.updateRecord(updatebugsDTO);
        client.showUpdateResult(updateresult, updatebugsDTO);

        //TEST: reading a record from the bugsFacade
        client.showGetResult(client.getRecord(00001));

        //TEST: deleting the record from the bugsFacade 
        boolean deleteresult = client.deleteRecord(1);
        client.showDeleteResult(deleteresult, 1);
        
        //TEST: reading a record from the bugsFacade
        client.showGetResult(client.getRecord(00001));
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

    //printing information from bugDTO
    public void showGetResult(BugsDTO bugDTO) {
        System.out.println("ID: " + bugDTO.getBugid()
                + "\nName: " + bugDTO.getBugname()
                + "\nDescription: " + bugDTO.getBugdesc()
                + "\nStatus: " + bugDTO.getBugstatus()
                + "\nCreated By: " + bugDTO.getBugcreatedby()
                + "\nPriority: " + bugDTO.getBugpriority());
    }

    //print the information after the exceution of updating the record
    public void showUpdateResult(boolean result, BugsDTO bugDTO) {
        if (result) {
            System.out.println("Record with primary key " + bugDTO.getBugid()
                    + " has been updated in the database table.");
        } else {
            System.out.println("Record with primary key " + bugDTO.getBugid()
                    + " has NOT been updated in the database table.");
        }
    }

    //print the information after the deleting of the record
    public void showDeleteResult(boolean result, int bugid) {
        if (result) {
            System.out.println("Record with primary key " + bugid
                    + " has been deleted in the database table.");
        } else {
            System.out.println("Record with primary key " + bugid
                    + " could not be deleted in the database table!");
        }
    }

    //wrapper method to expose functionality of the createRecord() function in bugsFacade
    public boolean createRecord(BugsDTO bugsDTO) {
        return bugsFacade.createRecord(bugsDTO);
    }

    //wrapper method to expose functionality of the getRecord() function in bugsFacade
    public BugsDTO getRecord(int bugid) {
        return bugsFacade.getRecord(bugid);
    }

    //wrapper method to expose functionality of the updateRecord() function in bugsFacade
    public boolean updateRecord(BugsDTO bugsDTO) {
        return bugsFacade.updateRecord(bugsDTO);
    }

    public boolean deleteRecord(int bugid) {
        return bugsFacade.deleteRecord(bugid);
    }
}
