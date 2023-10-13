package com.library;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
   private String checkedOutTo;


    public Book(){
        this.id = 0;
        this.isbn= "";
        this.title = "";
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
    }

    //getter
    public int getId(){
        return id;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getCheckedOutTo(){
        return checkedOutTo;
    }
    public boolean IsCheckedOut(){
        return isCheckedOut;
    }

    //setter
    public void setId(int newId){
        this.id = newId;
    }
    public void setIsbn(String newIsbn){
        this.isbn= newIsbn;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setCheckedOut(String newCheckedOutTo){
        this.checkedOutTo = newCheckedOutTo;
    }

    public void setIsCheckedOut(boolean newIsCheckedOut){
        this.isCheckedOut = newIsCheckedOut;
    }


    public String checkOut(String name){
        if (isCheckedOut == true) {
            checkedOutTo = name;
        }
        return checkedOutTo;


    }
    public String checkIn(){
        if (isCheckedOut == false){
            checkedOutTo = "";
        }
       return checkedOutTo;
    }
    @Override
    public String toString(){
        return "Id: "+ id + ", ISBN: "+ isbn+ ", Title: "+ title+" ";
    }
}
