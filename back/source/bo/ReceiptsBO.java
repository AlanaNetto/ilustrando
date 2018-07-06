package bo;

import bean.ReceiptsBEAN;
import dao.ReceiptsDAO;

public class ReceiptsBO{
    
    public String insert(String name){
        try {
            ReceiptsDAO dao = new ReceiptsDAO();
            ReceiptsBEAN bean = new ReceiptsBEAN(name);
            
            if(dao.insert(bean))
                return "{\"Success\":\"Receita de nome " + name + " inserida com sucesso\"}" ;
            else
                return "{\"Error\":\"Erro ao inserir receita\"}" ;
        }
        catch (Exception e){
           return "{\"Error\":\"Erro ao inserir receita\"}" ;
        }
    }
    
    public String getAllReceipts(){
        try{
            String json = "[";
            ReceiptsDAO dao = new ReceiptsDAO();
            for(ReceiptsBEAN r : dao.getReceipts())
            {
                json += "{" +
                    "\"nome\":\"" + r.getName() + "\"" +
                "},";
            }
            if(json.endsWith(","))
                json = json.substring(0, json.length() - 1);
            json +="]";
            return json;
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar receitas\"}" ;
        }
    }
}