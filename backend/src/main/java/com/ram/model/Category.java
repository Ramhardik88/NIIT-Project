package com.ram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category 
{
	@Id
	@GeneratedValue
	int categoryid;
	String categoryname;
	String categorydecs;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydecs() {
		return categorydecs;
	}
	public void setCategorydecs(String categorydecs) {
		this.categorydecs = categorydecs;
	}
	

}
