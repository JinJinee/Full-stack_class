package javaProject2;

class Book {
    int bookNo;
    String bookTitle;
    String bookAuthor;
    int bookYear;
    int bookPrice;
    String bookPublisher;

    Book() {}

    Book(int bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher){
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
    }

    @Override
    public String toString(){ 
        return "B" + String.format("%03d", bookNo)+ "\t" + bookTitle + "\t" + bookAuthor + "\t" + bookPrice + "\t" + bookYear + "\t" + bookPublisher;
    }
    
}

class Magazine extends Book {
    int month;

    Magazine() {}

    Magazine(int bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher, int month){
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
        this.month = month;
    }

    @Override
    public String toString(){ 
        return "M" + String.format("%03d", bookNo)+ "\t" + bookTitle + "\t" + bookAuthor + "\t" + bookPrice + "\t"  + bookYear + "\t" + bookPublisher + "\t" + month;
    }

}