package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class User {
	@Column(name="username")
	@Id
	private String username;
	
	@Column(name="password")
	private String password;
	
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
}
