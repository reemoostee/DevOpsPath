package ch.zhaw.iwi.devops.model.module;

import javax.persistence.Entity;

import ch.zhaw.iwi.devops.model.AbstractEntity;

@Entity
public class Module extends AbstractEntity implements Comparable<Module> {

	private String name;
	
	private String description;
	
	private int credits;

	public String getName() {
		return name;
	}
	
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Module o) {
		return this.getName().compareTo(o.getName());
	}

}
