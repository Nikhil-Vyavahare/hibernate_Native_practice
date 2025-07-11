package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Country;
import sessionFactory.SessionF;

public class CountryService {
	
	static SessionFactory  sf = SessionF.getSessionFactory();
	
	public void createCountry(Country obj) {
		try(Session session = sf.openSession()) {
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Country> getAllCountries() {
		try (Session session = sf.openSession()){
             return session.createQuery("FROM Country",Country.class).list();
		} 
	}
	
	public void updateCountryName(String newName, String CountryId) {
		try (Session session = sf.openSession()){
			session.beginTransaction();
			Country objCountry = session.find(Country.class,CountryId);
			if(objCountry != null) {
				objCountry.setCountryName(newName);
				session.merge(objCountry);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCountry(String CountryId){
		try(Session session = sf.openSession()){
			session.beginTransaction();
			Country objCountry = session.find(Country.class,CountryId);
			if (objCountry != null) {
				session.remove(objCountry);	
			}
			session.getTransaction().commit();
		}
	}
}
