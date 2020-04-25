package models;

import javax.persistence.EntityManager;

import Entities.User;
import Utils.JpaUtils;

public class UserModel {
	public static User getDetails(String username) {
		EntityManager em= JpaUtils.getEntityManagerFactory().createEntityManager();
		User user = em.find(User.class, username);
		return user;
	}
}
