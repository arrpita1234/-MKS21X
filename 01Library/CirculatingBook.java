public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    
    private String dueDate;
    
    public CirculatingBook(String author, String title, String ISBN, String callNumber){
        super(author, title, ISBN, callNumber);
    }
    

    public String getCurrentHolder(){
        return currentHolder;
    }
    
    public void setCurrentHolder(String newHolder){
         currentHolder = newHolder;
    }
    
     public String getDueDate(){
        return dueDate;
    }
    
    public void setDueDate(String newDate){
         dueDate = newDate;
    }
    
    public void checkout(String patron, String due){
        setCurrentHolder(patron);
        setDueDate(due);
    }
    
    public void returned(){
        currentHolder = null;
        dueDate = null;
    }
    
    public String circulationStatus(){
       if(currentHolder != null && dueDate != null){
           return (getCurrentHolder() + ", " +  getDueDate());
       }
        else{
            return  "book available on shelves";
        }
        
    }
    
    public String toString(){
        if(currentHolder != null && dueDate != null){
            return (super.toString() + ", " + currentHolder + ", " + dueDate);
        }
        else return (super.toString());
    }
}