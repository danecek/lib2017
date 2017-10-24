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
public class BinOp implements Expr {

    char op;
    Expr left;
    Expr right;

    public BinOp(char op, Expr left, Expr right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public int eval() {
        switch (op) {
            case '+': return left.eval() + right.eval();
            case '-': return left.eval() - right.eval();
            case '*': return left.eval() * right.eval();
            case '/': return left.eval() / right.eval();
            default: throw new RuntimeException("unknown operation");
        }
    }

    @Override
    public String toString() {
        return left.toString() + op + right.toString();
    }
    
    

}
