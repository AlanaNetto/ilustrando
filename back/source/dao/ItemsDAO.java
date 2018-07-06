package dao;

import bean.ItemsBEAN;
import java.util.List;
import java.util.ArrayList;

public class ItemsDAO {
    public static List<ItemsBEAN> itemsList = null;
    
    public ItemsDAO(){
        if(itemsList == null)
            itemsList = new ArrayList<ItemsBEAN>();
    }
    
    public boolean insert(ItemsBEAN r){
        itemsList.add(r);
        return true;
    }
    
    public List<ItemsBEAN> getItems(){
        return itemsList;
    }
    
    public ItemsBEAN getItemByName(String name){
        for(ItemsBEAN c : itemsList)
        {
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}