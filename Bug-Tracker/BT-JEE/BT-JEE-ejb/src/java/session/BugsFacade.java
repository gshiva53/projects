package session;

import entity.BugsDb;
import entity.BugsDTO;
import java.util.ArrayList;
import java.util.List;
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
        boolean result = false; 
        if (find(bugDTO.getBugid()) != null) {
            // user whose userid can be found
            return result;
        }
        // user whose userid could not be found
        try {
            BugsDb bug = this.DTO2DAO(bugDTO);
            this.create(bug); // add to database
            result = true;  
        } catch (Exception ex) {
        }
        return result; 
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
    
    @Override 
    public ArrayList<BugsDTO> getAllRecords() {
        javax.persistence.Query query;
        query = em.createNamedQuery("BugsDb.findAll");
        List<BugsDb> bugs = query.getResultList();
        ArrayList<BugsDTO> bugsDTO = new ArrayList<>(); 
        
        for (BugsDb bug : bugs) {
            BugsDTO bugDTO = this.DAO2DTO(bug); 
            bugsDTO.add(bugDTO); 
        }
        return bugsDTO; 
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
