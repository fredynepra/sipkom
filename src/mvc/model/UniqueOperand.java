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
public class UniqueOperand {

    private int totalUnikOperand;
    private int countUnikOprn_x;

    private void setTotalUnikOprn(int totalUnikOperand) {
        this.totalUnikOperand = totalUnikOperand;
    }

    public void resetTotalUnikOprn() {
        this.totalUnikOperand = 0;
    }

    public int getTotalUnikOprn() {
        return this.totalUnikOperand;
    }

    public Object[] getUnikOprn(Object[] keys) {
        Object[] unikOpr = new Object[keys.length];
        unikOpr[0] = keys[0];
        int unikOprnIndex = 0;
        boolean oprAlreadyExist = false;
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < unikOprnIndex; j++) {
                if (keys[i].equals(unikOpr[j])) {
                    oprAlreadyExist = true;
                }

            }
            if (!oprAlreadyExist) {
                unikOpr[unikOprnIndex] = keys[i];
                unikOprnIndex++;
                setTotalUnikOprn(unikOprnIndex);
            }
            oprAlreadyExist = false;
        }
        return unikOpr;
    }

    public void hitungUnikOprn(List<String> lUnikOprn) {
        Object[] unique;
        unique = getUnikOprn(lUnikOprn.toArray());
        for (Object key : unique) {
            if (null == key) {
                break;
            }
            for (String s : lUnikOprn) {
                if (key.equals(s)) {
                    countUnikOprn_x++;
                }
            }
            System.out.println(key + " = " + countUnikOprn_x);
            countUnikOprn_x = 0;
        }
        System.out.println("\nUnik (n2) : " + getTotalUnikOprn());
    }

}
