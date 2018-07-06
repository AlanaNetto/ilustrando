package dao;

import bean.CategoryBEAN;
import java.util.List;
import java.util.ArrayList;

public class CategoryDAO {
    public static List<CategoryBEAN> categoryList = null;
    
    public CategoryDAO(){
        if(categoryList == null)
            categoryList = new ArrayList<CategoryBEAN>();
    }
    
    public boolean insert(CategoryBEAN r){
        categoryList.add(r);
        return true;
    }
    
    public List<CategoryBEAN> getCategory(){
        return categoryList;
    }
    
    public CategoryBEAN getCategoryByName(String name){
        for(CategoryBEAN c : categoryList)
        {
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}