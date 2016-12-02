/*/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kenneth.sales.Receipt;

import NationalBookStore.Book;

/**
 *
 * @author C
 */
public class Reciept {
    
    private final String book;
    private final float amount;
    private final String date;
    private final String cashierName;
    
    public Reciept(String book, float amount, String date, String CashierName) {
        this.book = book;
        this.amount = amount;
        this.date = date;
        this.cashierName = CashierName;
        
    }
    
    public void print() {
        
        System.out.println(this.book + this.amount + this.date + this.cashierName + "bepp-bepph-bephhh");
        
    }
    
    public void laksi() {
        System.out.println("krakkrakkrak");
        
    }
    
}