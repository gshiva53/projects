/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bugs;

import bt.jpa.MyBugsDb;
import Bugs.BugsDTO;

/**
 *
 * @author Shiva Gupta This is a class to test the BugsDb JPA functionality.
 * functionality should provide CRUD operations. Refer to lab 03.
 */
public class BugsDbTestApp {

    private MyBugsDb bugsDb;

    public BugsDbTestApp() {
        bugsDb = new MyBugsDb();
    }

    public static void main(String[] args) {
        BugsDbTestApp client = new BugsDbTestApp();

//        //TEST: creating a record in the bug db
//        BugsDTO bugsDTO = new BugsDTO(00001, "npm fix", "npm package needs fixing", "fixing", "shiva", "high");
//        boolean result = client.createRecord(bugsDTO);
//        client.showCreateResult(result, bugsDTO);
//
//        //TEST: reading a record from the bug db
//        client.showGetResult(client.getRecord(00001));
//
//        //TEST: updating the record from the bug db
//        BugsDTO updatebugsDTO = new BugsDTO(00001, "npm fix", "npm package needs fixing", "fixing", "shiva", "medium");
//        boolean updateresult = client.updateRecord(updatebugsDTO);
//        client.showUpdateResult(updateresult, updatebugsDTO);
        
        //TEST: deleting the record from the bug db 
        boolean deleteresult = client.deleteRecord(3);
        client.showDeleteResult(deleteresult, 3); 
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
        System.out.println("ID; " + bugDTO.getBugid()
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

    //wrapper method to expose functionality of the createRecord() function in bugsDb
    public boolean createRecord(BugsDTO bugsDTO) {
        return bugsDb.createRecord(bugsDTO);
    }

    //wrapper method to expose functionality of the getRecord() function in bugsDb
    public BugsDTO getRecord(int bugid) {
        return bugsDb.getRecord(bugid);
    }

    //wrapper method to expose functionality of the updateRecord() function in bugsDb
    public boolean updateRecord(BugsDTO bugsDTO) {
        return bugsDb.updateRecord(bugsDTO);
    }

    public boolean deleteRecord(int bugid) {
        return bugsDb.deleteRecord(bugid);
    }
}
