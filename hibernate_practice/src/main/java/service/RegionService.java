package service;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Region;
import sessionFactory.SessionF;

public class RegionService {
    static SessionFactory  sf = SessionF.getSessionFactory();

    public void createRegion(Region region){
        try(Session session = sf.openSession()){
            session.beginTransaction();
            session.persist(region);
            session.getTransaction().commit();
        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    public List<Region> getAllRegions(){
        try(Session session = sf.openSession()){
            return session.createQuery("FROM regions",Region.class).list();  
        }
    }


    public void updateRegionName(String newName, int regionId){
        try(Session session = sf.openSession()){
            session.beginTransaction();
            Region objRegion = session.find(Region.class,regionId);
            if (objRegion != null) {
                objRegion.setRegionName(newName);
                session.merge(objRegion);
            }
            session.getTransaction().commit();
        }catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void deleteRegion(int regionId){
		try(Session session = sf.openSession()){
			session.beginTransaction();
			Region objRegion  = session.find(Region.class,regionId);
			if (objRegion != null) {
				session.remove(objRegion);	
			}
			session.getTransaction().commit();
		}
	}
}
