/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.model;

public class AbstrId<T extends AbstrId> implements Comparable<T> {

    public AbstrId(int id) {
        this.id = id;
    }
    
     final int id;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
//        if (obj.getClass() != BookId.class) {
//            return false;
//        }
        T bookId = (T) obj;
        return compareTo(bookId) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public int compareTo(T o) {
        return id - o.id;
    }

    public int getId() {
        return id;
    }
    
}
