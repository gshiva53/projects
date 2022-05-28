/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.BugsDb;
import entity.BugsDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Shiva Gupta This class is the Stateless session bean class(SLSB).
 * Refer to lab 04.
 */
@Stateless
public class BugsFacade implements BugsFacadeRemote {

    @PersistenceContext(unitName = "BT-JEE-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }
    
    //Private CRUD operations 
    private void create(BugsDb bug) {
        em.persist(bug);
    }

    private void edit(BugsDb bug) {
        em.merge(bug);
    }

    private void remove(BugsDb bug) {
        em.remove(em.merge(bug));
    }

    private BugsDb find(Object id) {
        return em.find(BugsDb.class, id);
    }
    
    //CRUD operations functionality exposed
    @Override
    public boolean createRecord(BugsDTO bugDTO) {
        if (find(bugDTO.getBugid()) != null) {
            // user whose userid can be found
            return false;
        }
        // user whose userid could not be found
        try {
            BugsDb bug = this.DTO2DAO(bugDTO);
            this.create(bug); // add to database
        } catch (Exception ex) {
        }
        return true;
    }

    @Override
    public boolean updateRecord(BugsDTO bugDTO) {
        if (find(bugDTO.getBugid()) == null) {
            return false;
        }
        try {
            BugsDb bug = this.DTO2DAO(bugDTO);
            this.edit(bug);
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public boolean deleteRecord(int bugid) {
        if (find(bugid) == null) {
            return false; //bugid  does not exist in the table
        }
        try {
            this.remove(find(bugid));
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public BugsDTO getRecord(int bugid) {
        if (find(bugid) != null) {
            return this.DAO2DTO(find(bugid));
        }
        //if the bug with bugid is NOT found 
        return null;
    }
    
    //Information passing between the DAO and DTO
    private BugsDb DTO2DAO(BugsDTO bugsDTO) {
        BugsDb bug = new BugsDb();

        bug.setBugid(bugsDTO.getBugid());
        bug.setBugname(bugsDTO.getBugname());
        bug.setBugdesc(bugsDTO.getBugdesc());
        bug.setBugstatus(bugsDTO.getBugstatus());
        bug.setBugcreatedby(bugsDTO.getBugcreatedby());
        bug.setBugpriority(bugsDTO.getBugpriority());

        return bug;
    }

    private BugsDTO DAO2DTO(BugsDb bug) {
        BugsDTO bugDTO = new BugsDTO(bug.getBugid(),
                bug.getBugname(),
                bug.getBugdesc(),
                bug.getBugstatus(),
                bug.getBugcreatedby(),
                bug.getBugpriority());

        return bugDTO;
    }
}
