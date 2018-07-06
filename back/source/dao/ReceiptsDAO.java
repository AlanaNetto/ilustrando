package dao;

import bean.ReceiptsBEAN;
import java.util.List;
import java.util.ArrayList;

public class ReceiptsDAO {
    public static List<ReceiptsBEAN> receiptsList = null;
    
    public ReceiptsDAO(){
        if(receiptsList == null)
            receiptsList = new ArrayList<ReceiptsBEAN>();
    }
    
    public boolean insert(ReceiptsBEAN r){
        receiptsList.add(r);
        return true;
    }
    
    public List<ReceiptsBEAN> getReceipts(){
        return receiptsList;
    }
    
    public ReceiptsBEAN getReceiptsByName(String name){
        for(ReceiptsBEAN c : receiptsList)
        {
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}