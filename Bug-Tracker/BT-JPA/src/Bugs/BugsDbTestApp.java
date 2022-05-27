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

        BugsDTO bugsDTO = new BugsDTO(00001, "npm fix", "npm package needs fixing", "fixing", "shiva", "high");
        boolean result = client.createRecord(bugsDTO); 
        client.showCreateResult(result, bugsDTO);
    }

    public boolean createRecord(BugsDTO bugsDTO) {
        return bugsDb.createRecord(bugsDTO);
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
}
