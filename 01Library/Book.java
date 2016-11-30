public class Book{
    private String title;
    private String author;
    private String ISBN;
    
    public Book(){
        title = "";
        author = "";
        ISBN = "";
    }
    
    public Book(String author, String title, String ISBN){
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getISBN(){
        return ISBN;
    }
    
    public void setTitle(String newTitle){
        title = newTitle;
    }
    
    public void setAuthor(String newAuthor){
        author = newAuthor;
    }
    
    public void setISBN(String newISBN){
        ISBN = newISBN;
    }
    
    public String toString(){
        return ("Title: " + getTitle() + "; Author: " + getAuthor() + "; ISBN: " + getISBN());
    }
}