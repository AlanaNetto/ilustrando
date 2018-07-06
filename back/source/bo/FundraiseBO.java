package bo;

import java.util.Date;
import bean.FundraiseBEAN;
import dao.ReceiptsDAO;
import dao.FundraiseDAO;

public class FundraiseBO{
    public String insert(float value,String receiptName,String date){
        try {
            if(value < 1 || receiptName==null || date == null)
                return "{\"Error\":\"Erro ao inserir categoria\"}" ;
            FundraiseDAO dao = new FundraiseDAO();
            ReceiptsDAO receiptDao = new ReceiptsDAO();
            
            FundraiseBEAN bean = new FundraiseBEAN(value, receiptDao.getReceiptsByName(receiptName),(Date) dao.df.parse(date));
            
            if(dao.insert(bean))
                return "{\"Success\":\"Arrecadação de valor " + value + " inserida com sucesso\"}" ;
            else
                return "{\"Error\":\"Erro ao inserir arrecadação\"}" ;
        }
        catch (Exception e){
           return "{\"Error\":\"Erro ao inserir arrecadação\"}" ;
        }
    }
    
    public String getFundraisesByDate(String date){
        try{
            String json = "[";
            FundraiseDAO dao = new FundraiseDAO();
            for(FundraiseBEAN r : dao.getFundraisesByDate(date))
            {
                json += "{" +
                    "\"valor\":\"" + r.getValue() + "\"," +
                    "\"data\":\"" + dao.df.format(r.getDate()) + "\"," +
                    "\"receiptName\":\"" + r.getReceipt().getName() + "\"" +
                "},";
            }
            if(json.endsWith(","))
                json = json.substring(0, json.length() - 1);
            json +="]";
            return json;
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar arrecadações "+ e +"\"}" ;
        }
    }
    
    public String getAllFundraises(){
        try{
            String json = "[";
            FundraiseDAO dao = new FundraiseDAO();
            for(FundraiseBEAN r : dao.getFundraises())
            {
                json += "{" +
                    "\"valor\":\"" + r.getValue() + "\"," +
                    "\"data\":\"" + dao.df.format(r.getDate()) + "\"," +
                    "\"receiptName\":\"" + r.getReceipt().getName() + "\"" +
                "},";
            }
            if(json.endsWith(","))
                json = json.substring(0, json.length() - 1);
            json +="]";
            return json;
        }
        catch(Exception e){
            return "{\"Error\":\"Erro ao buscar arrecadações\"}" ;
        }
    }
}