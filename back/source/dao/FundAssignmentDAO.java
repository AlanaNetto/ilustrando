package dao;

import bean.FundAssignmentBEAN;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FundAssignmentDAO{
    public static List<FundAssignmentBEAN> fundAssignmentList = null;
    public DateFormat df = null;
    
    public FundAssignmentDAO(){
        df = new SimpleDateFormat("MM/yyyy");
        if(fundAssignmentList == null)
            fundAssignmentList = new ArrayList<FundAssignmentBEAN>();
    }
    
    public boolean insert(FundAssignmentBEAN r){
        fundAssignmentList.add(r);
        return true;
    }
    
    public List<FundAssignmentBEAN> getFundassignments(){
        return fundAssignmentList;
    }
    
    public List<FundAssignmentBEAN> getFundassignmentsByDate(String date){
        List<FundAssignmentBEAN> query = new ArrayList<FundAssignmentBEAN>();
        
        for(FundAssignmentBEAN f : fundAssignmentList){
            if(df.format(f.getDate()).equals(date)){
                query.add(f);
            }
        }
        return query;
    }
}