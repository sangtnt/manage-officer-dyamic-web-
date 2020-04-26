package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name="officer")
public class Officer {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="fullname")
	String fullname;
	
	@Column(name="age")
	int age;
	
	@Column(name="sex")
	String sex;
	
	@Column(name="address")
	String address;
	
	@Column(name="job")
	String job;
	
	@Column(name="jobProp")
	String jobProp;

	public int getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getAddress() {
		return address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setJobProp(String jobProp) {
		this.jobProp = jobProp;
	}

	public String getJob() {
		return job;
	}

	public String getJobProp() {
		return jobProp;
	}
}
