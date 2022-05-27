package bt.jpa;

import Bugs.BugsDTO;
import entity.BugsDb;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Shiva Gupta MyBugsDb is a JPA controller class. Refer to week 3 lab.
 */
public class MyBugsDb {

    private EntityManager em = null;

    public MyBugsDb() {
        //using default persisence unit defined in the persistence.xml file 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BT-EntityPU");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public BugsDb findBugsDb(int bugsId) {
        return em.find(BugsDb.class, bugsId);
    }

    public boolean createBugInDb(BugsDb bug) throws Exception {
        try {
            if (findBugsDb(bug.getBugid()) != null) {
                //bug with same bugid already exists
                //false -> bug was not created
                return false;
            }
            //bug does not exist in the database 
            em.getTransaction().begin();
            em.persist(bug);
            em.getTransaction().commit();

            //true -> bug was created in the DB
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private boolean updateBugInDb(BugsDb bug) throws Exception {
        try {
            if (findBugsDb(bug.getBugid()) == null) {
                return false;
            }
            em.getTransaction().begin();
            em.merge(bug);
            em.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private boolean deleteBugInDb(int bugid) throws Exception {
        try {
            if (findBugsDb(bugid) == null) {
                //no bugs are found in the database
                //false -> delete can not be performed
                return false;
            }

            em.getTransaction().begin();
            em.remove(findBugsDb(bugid));
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex; 
        }
        return true; 
    }

    //get the bug information as a DTO object using bug id
    public BugsDTO getRecord(int bugid) {
        try {
            BugsDb bug = findBugsDb(bugid);
            return this.DAO2DTO(bug);
        } catch (Exception ex) {
        }
        return null;
    }

    public boolean createRecord(BugsDTO bugsDTO) {
        BugsDb bug = this.DTO2DAO(bugsDTO);

        boolean result = false;
        try {
            result = this.createBugInDb(bug);
        } catch (Exception ex) {
        }

        return result;
    }
    
    public boolean updateRecord(BugsDTO bugsDTO) {
        BugsDb bug = this.DTO2DAO(bugsDTO); 
        boolean result = false; 
        
        try {
            result = this.updateBugInDb(bug); 
        } catch (Exception ex) {
        }
        return result; 
    }
    
    public boolean deleteRecord(int bugid) {
        boolean result = false; 
        
        try {
            result = this.deleteBugInDb(bugid); 
        } catch (Exception ex) {
        }
        return result; 
    }

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
