package dataAccess.category;

import entities.Category;

public class JdbcCategoryDao implements CategoryDao{
	
	@Override
	public void add(Category category) {
		System.out.println("Kategori Jdbc ile veri tabanına eklendi.");
	}

}
