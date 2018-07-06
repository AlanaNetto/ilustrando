package bean;

import bean.ItemsBEAN;
import java.util.Date;

public class FundAssignmentBEAN{
    
    private int id;
    private float value;
    private ItemsBEAN item;
    private Date date;
 
    public FundAssignmentBEAN(float value, ItemsBEAN item, Date date){
        this.value = value;
        this.item = item;
        this.date = date;
    }
    
    // public FundraiseBEAN(int id,float value, ReceiptsBEAN receipt, Date date){
    //     this.id = id;
    //     this.value = value;
    //     this.receipt = receipt;
    //     this.date = date;
    // }
    
    // public int getId(){return this.id;}
    public float getValue(){ return this.value; }
    public ItemsBEAN getItem(){ return this.item; }
    public Date getDate(){ return this.date; }
    
    public void setValue(float value){this.value = value;}
    public void setItem(ItemsBEAN item){this.item = item;}
    public void setDate(Date date){this.date = date;}
    
}