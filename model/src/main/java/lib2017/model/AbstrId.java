/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.model;

import java.io.Serializable;

public class AbstrId<T extends AbstrId> implements Comparable<T>, Serializable {

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public AbstrId(int id) {
        this.id = id;
    }

    public AbstrId() {
    }

    private int id;

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }
        T bookId = (T) that;
        return compareTo(bookId) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public int compareTo(T that) {
        return this.id - that.getId();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

}
