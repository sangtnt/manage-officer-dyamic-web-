package models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Officer;
import Utils.JpaUtils;

public class OfficerModel {
	public static List<Officer> getFull() {
		EntityManager em= JpaUtils.getEntityManagerFactory().createEntityManager();
		String hql="From Officer";
		TypedQuery<Officer> query= em.createQuery(hql, Officer.class);
		List<Officer> officers = query.getResultList();
		return officers;
	}
	public static boolean add(Officer officer) {
		boolean result=false;
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager(); 
		try {
			em.getTransaction().begin();
			em.persist(officer);
			em.getTransaction().commit();
			result=true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public static Officer getDetails(int id) {
		EntityManager em= JpaUtils.getEntityManagerFactory().createEntityManager();
		Officer officer = em.find(Officer.class, id);
		return officer;
	}
	public static boolean deleteOfficer(int id) {
		boolean result=false;
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager(); 
		Officer officer = em.find(Officer.class, id);
		try {
			em.getTransaction().begin();
			em.remove(officer);
			em.getTransaction().commit();
			result=true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public static boolean updateOfficer(Officer officer) {
		boolean result=false;
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager(); 
		try {
			em.getTransaction().begin();
			em.merge(officer);
			em.getTransaction().commit();
			result=true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
