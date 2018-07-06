package bo;

import java.util.Date;
import bean.FundAssignmentBEAN;
import dao.ItemsDAO;
import dao.FundAssignmentDAO;

public class FundAssignmentBO{
    public String insert(float value,String itemName,String date){
        try {
            if(value < 1 || itemName==null || date == null)
                return "{\"Error\":\"Erro ao inserir categoria\"}" ;
            FundAssignmentDAO dao = new FundAssignmentDAO();
            ItemsDAO itemDao = new ItemsDAO();
            
            FundAssignmentBEAN bean = new FundAssignmentBEAN(value, itemDao.getItemByName(itemName),(Date) dao.df.parse(date));
            
            if(dao.insert(bean))
                return "{\"Success\":\"Destinação de valor " + value + " inserida com sucesso\"}" ;
            else
                return "{\"Error\":\"Erro ao inserir destinação\"}" ;
        }
        catch (Exception e){
           return "{\"Error\":\"Erro ao inserir destinação\"}" ;
        }
    }
    
    public String getFundassignmentsByDate(String date){
        try{
            String json = "[";
            FundAssignmentDAO dao = new FundAssignmentDAO();
            for(FundAssignmentBEAN r : dao.getFundassignmentsByDate(date))
            {
                json += "{" +
                    "\"valor\":\"" + r.getValue() + "\"," +
                    "\"data\":\"" + dao.df.format(r.getDate()) + "\"," +
                    "\"itemName\":\"" + r.getItem().getName() + "\"" +
                "},";
            }
            if(json.endsWith(","))
                json = json.substring(0, json.length() - 1);
            json +="]";
            return json;
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar destinações "+ e +"\"}" ;
        }
    }
    
    public String getAllFundassignments(){
        try{
            String json = "[";
            FundAssignmentDAO dao = new FundAssignmentDAO();
            for(FundAssignmentBEAN r : dao.getFundassignments())
            {
                json += "{" +
                    "\"valor\":\"" + r.getValue() + "\"," +
                    "\"data\":\"" + dao.df.format(r.getDate()) + "\"," +
                    "\"itemName\":\"" + r.getItem().getName() + "\"" +
                "},";
            }
            if(json.endsWith(","))
                json = json.substring(0, json.length() - 1);
            json +="]";
            return json;
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar destinações\"}" ;
        }
    }
}