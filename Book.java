/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NationalBookStore;

/**
 *
 * @author C
 */
public class Book {

    private final String Title;
    private final String Author;
    private final int pages;
    private final int chapters;

    public Book(String Title, String Author, int pages, int chapters) {
        this.Title = Title;
        this.Author = Author;
        this.pages = pages;
        this.chapters = chapters;

    }

    public void open() {
        System.out.println(this.Title + this.Author + this.pages + this.chapters + "The Book is opening....");

    }

    public void close() {

        System.out.println("The book is close");

    }

}
