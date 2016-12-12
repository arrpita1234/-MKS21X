public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;


// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//          or zip contains a non digit
//           _zip and _checkDigit are initialized.
    
    public String getZip(){
        return _zip;
    }
    
   public int getCheck(){
        return _checkDigit;
  }
 
  public Barcode(String zip) {
        if(!(allDigits(zip)) || zip.length() != 5){
            throw new IllegalArgumentException("zip is not the correct length or zip contains a non digit");
        }
        else {
            _zip = zip;
            _checkDigit = Barcode.checkSum(_zip));
        }
  }
 
  private boolean allDigits(String zipcode){
    for(int i = 0; i < zipcode.length(); i++){
        if (zipcode.charAt(i) < '0' || zipcode.charAt(i) > '0' + 9) return false;
        }
    return true;
  }


public static String toCode(String zip){
    String barCode = "|";
    if(!(allDigits(zip)) || zip.length() != 5){
        throw new IllegalArgumentException("zip is not the correct length or zip contains a non digit");
    }
    else {
        zip = zip + Barcode.checksum(zip);
        for(int i = 0; i < zip.length(); i++){
            digit = zip.charAt(i) - '0';
            String zipString;
         
            switch (digit) {
                case 0:  zipString = "||:::";
                        break;
                case 1: zipString = ":::||";
                        break;
                case 2: zipString = "::|:|";
                        break;
                case 3:  zipString = "::||:";
                        break;
                case 4:  zipString = ":|::|";
                        break;
                case 5:  zipString = ":|:|:";
                        break;
                case 6:  zipString = ":||::";
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
            barCode += zipString;
            }
        }
        return barCode + “|”
    }
    
    public static String toZip(String code){
        if(code.length() != 32) {throw new IllegalArgumentException("barcode length is not 32");}
        else{
        if(code.charAt(0) != '|' || code.charAt(31) != '|') throw new IllegalArgumentException("the left and rigthmost charcters are not '|'");

        String[] digits = new String[6];
        digits = encoding(code);
        String zipcode = "";
        for(int i = 0; i < digits.length; i++){
            if(digits[i].equals("Invalid characters")){
                throw new IllegalArgumentException("non-barcode characters are used");
            }
            else{
                    String digit = digits[i];
                    if(barToNum(digit) == "Invalid encoding"){
                        throw new IllegalArgumentException("encoded ints are invalid");
                    }
                    else{
                        zipcode += barToNum(digit);
                    }
                }
            }
           String checkDigit = "" + checkSum(zipcode.substring(0, 5)); 
           if(!(checkDigit.equals(zipcode.charAt(5)))){
                throw new IllegalArgumentException("checksum is invalid");
           }
        }
        return zipcode;
     }
    
    public static String[] encoding(String code){
        String[] temp = new String[6];
        int n = 0;
        for(int i = 1; i + 5 < code.length(); i += 5){
            if (!(checkBarcode(code.substring(i, i + 5)))) {temp[n] = "Invalid characters";}
            else {temp[n] = code.substring(i, i + 5);}
            n++;
        }
      return temp;
    }
    
    private static boolean checkBarcode(String digit){
        for (int i = 0; i < digit.length(); i++){
            if (digit.charAt(i) != '|' && digit.charAt(i) != ':') return false;
        }
        return true;
    }
    
    private static String barToNum(String digit){
        String zipString;
            switch (digit) {
                case "||:::":  zipString = "0";
                        break;
                case ":::||": zipString = "1";
                        break;
                case "::|:|": zipString = "2";
                        break;
                case "::||:":  zipString = "3";
                        break;
                case ":|::|":  zipString = "4";
                        break;
                case ":|:|:":  zipString = "5";
                        break;
                case ":||::":  zipString = "6";
                        break;
                case "|:::|":  zipString = "7";
                        break;
                case "|::|:":  zipString = "8";
                        break;
                case "|:|::":  zipString = "9";
                        break;
                default: zipString = "Invalid encoding";
                        break;
            }
        return zipString;
    }
    
    private static int checkSum(String zip){
        int sum = 0;
        for(int i = 0; i < zip.length(); i++){
            sum += zip.charAt(i) - '0' ;
        }
        return sum % 10
    }




//postcondition: format zip + check digit + Barcode
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"  
  public String toString(){


	String stringversion = _zip + _checkDigit + " " + Barcode.toCode(_zip + _checkDigit);
	return stringversion;
  }




// postcondition: compares the zip + checkdigit, in numerical order.
  public int compareTo(Barcode other){}
	int i = Integer.parseInt(getZip());
	int y = Integer.parseInt(other.getZip());
    
	Integer a = new Integer(i); Integer b = new Integer(y);
    
	return a.compareTo(b);
}




