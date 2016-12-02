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
public class Author {

    private String Name;
    private int age;
    private String penName;
    private String gender;

    public Author() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void write() {

        System.out.println("THE Author is writing");

    }

    public Author(String Name, int age, String gender, String pN) {
        this.Name = Name;
        this.age = age;
        this.gender = gender;
        this.penName = pN;

    }

    public void read() {

        System.out.println(this.Name + ", " + this.age + "," + this.gender + "," + this.penName + "," + "is reading");

    }

    public void manyReading(int time) {
        for (int count = 0; count < time; count++) {
            this.read();

        }

    }

}
