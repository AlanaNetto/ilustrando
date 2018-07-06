package bo;

import bean.CategoryBEAN;
import dao.CategoryDAO;

public class CategoryBO{
    
    public String insert(String name){
        try {
            if(name == null)
                return "{\"Error\":\"Erro ao inserir categoria\"}" ;
            CategoryDAO dao = new CategoryDAO();
            CategoryBEAN bean = new CategoryBEAN(name);
            
            if(dao.insert(bean))
                return "{\"Success\":\"Categoria de nome " + name + " inserida com sucesso\"}" ;
            else
                return "{\"Error\":\"Erro ao inserir categoria\"}" ;
        }
        catch (Exception e){
           return "{\"Error\":\"Erro ao inserir categoria\"}" ;
        }
    }
    
    public String getAllCategorys(){
        try{
            String json = "[";
            CategoryDAO dao = new CategoryDAO();
            for(CategoryBEAN r : dao.getCategory())
            {
                json += "{" +
                    "\"nome\":\"" + r.getName() + "\"" +
                "},";
            }
            if(json.endsWith(","))
                json = json.substring(0, json.length() - 1);
            json +="]";
            System.out.println("teste");
            return json;
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar categorias\"}" ;
        }
    }
    
    public String getCategoryByName(String name){
        try{
            CategoryDAO dao = new CategoryDAO();
            CategoryBEAN category = dao.getCategoryByName(name);
            if(category != null)
                return "[{\"nome\":\"" + category.getName() + "\"}]";
            else
                return "[]";
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar categoria\"}" ;
        }
    }
}