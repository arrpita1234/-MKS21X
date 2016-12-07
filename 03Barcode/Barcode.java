public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
        if(!(allDigits) || zip.length() != 5){
            throw new RuntimeException("zip is not the correct length or zip contains a non digit");
        }
        else {
            _zip = zip;
            _checkDigit = (checkSum() % 10);
        }
  }
  
  private boolean allDigits(String zipcode){
       for(i = 0; i < zipcode.length(); i++){
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
        for(i = 0; i < _zip.length(); i++){
            String s = "" + zip.charAt(i);
            sum += Integer.parseInt(s);
        }
    return sum;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
    switch (month) {
            case 0:  zipString = "January";
                     break;
            case 2:  zipString = "February";
                     break;
            case 3:  zipString = "March";
                     break;
            case 4:  zipString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
  
  
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){}
    
}
