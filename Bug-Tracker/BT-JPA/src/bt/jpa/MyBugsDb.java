package bt.jpa;


import Bugs.BugsDTO;
import entity.BugsDb;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Shiva Gupta
 * MyBugsDb is a JPA controller class. Refer to week 3 lab. 
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
    
    public BugsDb findBugsDb (int bugsId) {
        return em.find(BugsDb.class, bugsId); 
    }
    
    public boolean createBugsInDb(BugsDb bug) throws Exception {
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
    
    public boolean createRecord(BugsDTO bugsDTO) {
        BugsDb bug = this.DTO2DAO(bugsDTO); 
        
        boolean result = false; 
        try {
            result = this.createBugsInDb(bug); 
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
}
