package business;

import java.util.ArrayList;

import dataAccess.category.CategoryDao;
import entities.Category;
import core.logging.Logger;

public class CategoryManager {
	private CategoryDao categoryDao;
	private Logger[] loggers;
	
	ArrayList<String> categoryNames =new ArrayList<String>();
	
	public CategoryManager(CategoryDao categoryDao,Logger[] loggers) {
		this.categoryDao=categoryDao;
		this.loggers=loggers;
	}
	
	public void add(Category category) throws Exception {
		for(String categoryName :categoryNames) {
			if(categoryName==category.getCategoryName()) {
				throw new Exception("Kategori adı aynı olamaz.");
			}
			
			categoryDao.add(category);
			categoryNames.add(category.getCategoryName());
		}
		
		for(Logger logger:loggers) {
			logger.log(category.getCategoryName());
		}
		
	}

}
