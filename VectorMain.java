/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Q2_ktr1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.util.List;

public class VectorMain {
    public static void main(String[] args) {
        List l=new ArrayList<>();
        Vector<Integer> v=new Vector<>(3, 3);
        System.out.println(v.capacity());//3
        v.add(34);
        v.add(34);
        v.add(34);
        v.add(34);
        System.out.println(v.capacity());//6
        Enumeration e=v.elements();
        while(e.hasMoreElements())
            System.out.println(e.nextElement());
    }
}
