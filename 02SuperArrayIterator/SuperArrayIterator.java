import java.util.*

public  class SuperArrayIterator implements Iterator<String> {
    private int start;
    private SuperArray n;
    
    public SuperArrayIterator(int start, SuperArray n){
        this.start = start;
        this.n = n;
        
    }
    
    
    public boolean hasNext(){
        return start < n.size();
    }
    
    public String next(){
        if(hasNext()){
            start ++;
            return (n.get(start -1));
        }
	else{
	    throw new NoSuchElementException("Reached end of SuperArray");
	    }
    }
    
    public void remove(){
    	   throw new UnsupportedOperationException();
    }
 }
