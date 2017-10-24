/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.expr;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {
        Const c1 = new Const(1);
        Const c3 = new Const(3);
        BinOp mlt13 = new BinOp('+', c1, c3);
        Const c4 = new Const(4);
        Expr finalexpr = new BinOp('*', mlt13, c4);
        System.out.println(finalexpr);
    }

}
