/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.expr;

public class Const implements Expr {

    int value;

    public int eval() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;  // Integer.toString(value)
    }
    
    

    public Const(int value) {
        this.value = value;
    }

}
