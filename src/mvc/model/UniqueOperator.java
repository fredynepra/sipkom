/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.util.List;

/**
 *
 * @author Fredy Revolusioner
 */
public class UniqueOperator {

    private int totalUnikOperator;
    private int countUnikOprt_x;

    private void setTotalUnikOprt(int totalUnikOperator) {
        this.totalUnikOperator = totalUnikOperator;
    }

    public void resetTotalUnikOprt() {
        this.totalUnikOperator = 0;
    }

    public int getTotalUnikOprt() {
        return this.totalUnikOperator;
    }

    public Object[] getUnikOprt(Object[] keys) {
        Object[] unikOprt = new Object[keys.length];
        unikOprt[0] = keys[0];
        int unikOprtIndex = 0;
        boolean oprtAlreadyExist = false;
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < unikOprtIndex; j++) {
                if (keys[i].equals(unikOprt[j])) {
                    oprtAlreadyExist = true;
                }
            }
            if (!oprtAlreadyExist) {
                unikOprt[unikOprtIndex] = keys[i];
                unikOprtIndex++;
                setTotalUnikOprt(unikOprtIndex);
            }
            oprtAlreadyExist = false;
        }
        return unikOprt;
    }

    public void hitungUnikOprt(List<String> lUnikOprt) {
        Object[] unique;
        unique = getUnikOprt(lUnikOprt.toArray());
        for (Object key : unique) {
            if (null == key) {
                break;
            }
            for (String s : lUnikOprt) {
                if (key.equals(s)) {
                    countUnikOprt_x++;
                }
            }
            System.out.println(key + " = " + countUnikOprt_x);
            countUnikOprt_x = 0;
        }
        System.out.println("\nUnik (n1): " + getTotalUnikOprt());
    }
}
