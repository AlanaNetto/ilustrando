package bean;
import bean.CategoryBEAN;

public class ItemsBEAN{
    private int id;
    private String name;
    private CategoryBEAN category;
    
    public ItemsBEAN(String name, CategoryBEAN category){
        this.name = name;
        this.category = category;
    }
    
    public String getName(){ return this.name; }
    public CategoryBEAN getCategory(){ return this.category; }
    // public int getID(){ return this.id; }
    
    public void setName(String name){ this.name = name; }
    public void setCategory(CategoryBEAN category){ this.category = category; }
    // public void setID(int id){ this.id = id; }
}