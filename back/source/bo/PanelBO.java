package bo;

import dao.FundraiseDAO;
import dao.FundAssignmentDAO;
import bean.FundraiseBEAN;
import bean.FundAssignmentBEAN;

import java.util.Calendar;

public class PanelBO {
    
    public String getFunds(){
        float totalRaise = 0;
        float totalAssignments = 0;
        
        
        FundraiseDAO raiseDao = new FundraiseDAO();
        FundAssignmentDAO assignmentsDao = new FundAssignmentDAO();
        
        for(FundAssignmentBEAN r : assignmentsDao.getFundassignments())
            totalAssignments += r.getValue();
        for(FundraiseBEAN r : raiseDao.getFundraises())
            totalRaise += r.getValue();
            
        int actualMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
        int actualYear =  Calendar.getInstance().get(Calendar.YEAR);
        
        String totalByMonth = "\"totalByMonth\":[";
        
        for(int i = 0; i < 6; i++){
            float totalAssignmentsMonth = 0;
            float totalRaiseMonth = 0;
            
            for(FundAssignmentBEAN r : assignmentsDao.getFundassignmentsByDate( String.format("%02d",actualMonth) + "/" + actualYear))
                totalAssignmentsMonth += r.getValue();
            for(FundraiseBEAN r : raiseDao.getFundraisesByDate(String.format("%02d",actualMonth) + "/" + actualYear))
                totalRaiseMonth += r.getValue();
            
            totalByMonth += "{" +
                "\"month\":\"" + String.format("%02d",actualMonth) + "/" + actualYear + "\","+
                "\"totalRaise\":\"" + totalRaiseMonth + "\","+
                "\"totalAssignments\":\"" + totalAssignmentsMonth + "\"" +
            "},";
            
            actualMonth--;
            
            if(actualMonth == 0)
            {
                actualMonth = 12;
                actualYear --;
            }
        }
        if(totalByMonth.endsWith(","))
            totalByMonth = totalByMonth.substring(0, totalByMonth.length() - 1);
            
        totalByMonth +="]";
        
        return "{"+
            "\"totalRaise\":\"" + totalRaise + "\","+
            "\"totalAssignments\":\"" + totalAssignments + "\","+
            totalByMonth +
        "}";
    }
}