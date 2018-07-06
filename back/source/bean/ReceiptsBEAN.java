package bean;

public class ReceiptsBEAN{
    private int id;
    private String name;
    
    public ReceiptsBEAN(String name){
        this.name = name;
    }
    
    public String getName(){ return this.name; }
    // public int getID(){ return this.id; }
    
    public void setName(String name){ this.name = name; }
    // public void setID(int id){ this.id = id; }
    
}