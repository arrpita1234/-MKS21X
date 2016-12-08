public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
    
    public String getZip(){
        return _zip;
        
    }
    
    public int getCheck(){
           return _checkDigit;
    }
        
  public Barcode(String zip) {
        if(!(allDigits(zip)) || zip.length() != 5){
            throw new RuntimeException("zip is not the correct length or zip contains a non digit");
        }
        else {
            _zip = zip;
            _checkDigit = (checkSum() % 10);
        }
  }
  
  private boolean allDigits(String zipcode){
       for(int i = 0; i < zipcode.length(); i++){
            if (zipcode.charAt(i) < '0' || zipcode.charAt(i) >= '0' + 9) return false;
       }
       return true;
  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
  
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
    int sum = 0;
        for(int i = 0; i < _zip.length(); i++){
            String s = "" + _zip.charAt(i);
            sum += Integer.parseInt(s);
        }
    return sum;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
    String stringy = _zip + _checkDigit();
    String stringversion = stringy + "   ";
      
      for(int i = 0; i < _zip.length(); i++){
            String s = "" + _zip.charAt(i);
            digit = Integer.parseInt(s);
            String zipString;
          
            switch (digit) {
            
            case 0:  zipString = "||:::";
                     break;
             case 1: zipString = ":::||";
                     break;
            case 2:  zipString = "::|:|";
                     break;
            case 3:  zipString = "::||:";
                     break;
            case 4:  zipString = ":|::|";
                     break;
            case 5:  zipString = ":|:|:";
                     break;
            case 6:  zipString = " :||::";
                     break;
            case 7:  zipString = "|:::|";
                     break;
            case 8:  zipString = "|::|:";
                     break;
            case 9:  zipString = "|:|::";
                     break;
            default: zipString = "Invalid digit";
                     break;
        }
            stringversion += zipString;
      }
      return stringversion;
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){}
    int i = Integer.parseInt(getZip()) * 10 +getCheck();
    int y = Integer.parseInt(other.getZip()) * 10 + other.getCheck();
    
    Integer a = new Integer(i); Integer b = new Integer(y);
    
    return a.compareTo(b);
}
