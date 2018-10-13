package com.niit.digikart.dao;

import java.util.List;

import com.niit.digikart.model.Category;


public interface CategoryDao {
void save(Category cat);
void delete(int categoryid);
public List<Category> list(Integer offset, Integer maxResults);
public Category getcategory(int categoryid);
void update(Category cat);
List<Category>Categorylist();
}
