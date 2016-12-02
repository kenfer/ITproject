/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kennethMain;

import NationalBookStore.Author;
import NationalBookStore.Book;
import kenneth.sales.Receipt.Reciept;

/**
 *
 * @author C
 */
public class Main {

    public static void main(String[] args) {
        Author johngreen = new Author("kenneth", 17, "male", "kenFer");
        johngreen.read();
        Book newchap = new Book("DragonSlayer", "kenneth", 30, 14);
        newchap.open();
        Reciept check = new Reciept("Dragon Slayer", (float) 100.0, "10/12/16", "kenneth");
        check.print();

    }

}
