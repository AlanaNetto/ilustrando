package bean;

import bean.ReceiptsBEAN;
import java.util.Date;

public class FundraiseBEAN{
    
    private int id;
    private float value;
    private ReceiptsBEAN receipt;
    private Date date;
 
    public FundraiseBEAN(float value, ReceiptsBEAN receipt, Date date){
        this.value = value;
        this.receipt = receipt;
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
    public ReceiptsBEAN getReceipt(){ return this.receipt; }
    public Date getDate(){ return this.date; }
    
    public void setValue(float value){this.value = value;}
    public void setReceipt(ReceiptsBEAN receipt){this.receipt = receipt;}
    public void setDate(Date date){this.date = date;}
    
}