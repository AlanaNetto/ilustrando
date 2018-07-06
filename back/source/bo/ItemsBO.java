package bo;

import bean.ItemsBEAN;
import dao.CategoryDAO;
import dao.ItemsDAO;

public class ItemsBO{
    
    public String insert(String name, String categoryName){
        try {
            if(name == null || categoryName == null)
                return "{\"Error\":\"Erro ao inserir item\"}" ;
            ItemsDAO dao = new ItemsDAO();
            CategoryDAO categoryDao = new CategoryDAO();
            ItemsBEAN bean = new ItemsBEAN(name,categoryDao.getCategoryByName(categoryName));
            
            if(dao.insert(bean))
                return "{\"Success\":\"Item de nome " + name + " inserido com sucesso\"}" ;
            else
                return "{\"Error\":\"Erro ao inserir item\"}" ;
        }
        catch (Exception e){
           return "{\"Error\":\"Erro ao inserir item\"}" ;
        }
    }
    
    public String getAllItems(){
        try{
            String json = "[";
            ItemsDAO dao = new ItemsDAO();
            for(ItemsBEAN r : dao.getItems())
            {
                json += "{" +
                    "\"nome\":\"" + r.getName() + "\"," +
                    "\"categoria\":\"" + r.getCategory().getName() + "\"" +
                "},";
            }
            if(json.endsWith(","))
                json = json.substring(0, json.length() - 1);
            json +="]";
            return json;
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar itens\"}" ;
        }
    }
}