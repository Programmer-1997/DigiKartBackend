package com.niit.digikart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Category {
	@Id	
	@GeneratedValue
private int categoryid;
private String categoryname;
private String catdesc;

@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER,mappedBy="category")
private Set<Product> productlist = new HashSet<Product>(0);

public Set<Product> getProductlist() {
	return productlist;
}
public void setProductlist(Set<Product> productlist) {
	this.productlist = productlist;
}
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
public String getCatdesc() {
	return catdesc;
}
public void setCatdesc(String catdesc) {
	this.catdesc = catdesc;
}

}
