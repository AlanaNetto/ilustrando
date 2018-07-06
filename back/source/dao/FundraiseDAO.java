package dao;

import bean.FundraiseBEAN;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FundraiseDAO{
    public static List<FundraiseBEAN> fundraiseList = null;
    public DateFormat df = null;
    
    public FundraiseDAO(){
        df = new SimpleDateFormat("MM/yyyy");
        if(fundraiseList == null)
            fundraiseList = new ArrayList<FundraiseBEAN>();
    }
    
    public boolean insert(FundraiseBEAN r){
        fundraiseList.add(r);
        return true;
    }
    
    public List<FundraiseBEAN> getFundraises(){
        return fundraiseList;
    }
    
    public List<FundraiseBEAN> getFundraisesByDate(String date){
        List<FundraiseBEAN> query = new ArrayList<FundraiseBEAN>();
        
        for(FundraiseBEAN f : fundraiseList){
            if(df.format(f.getDate()).equals(date)){
                query.add(f);
            }
        }
        return query;
    }
}