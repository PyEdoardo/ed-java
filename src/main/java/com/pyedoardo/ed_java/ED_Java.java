/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pyedoardo.ed_java;

import com.pyedoardo.ed_java.collections.DoubleLinkedListC;
import com.pyedoardo.ed_java.collections.LinkedList;
import com.pyedoardo.ed_java.collections.List;
import java.util.ArrayList;

/**
 *
 * @author edoar
 */
public class ED_Java {

    public static void main(String[] args) {
        //List<Object> lds = new List<>(10);
        //lds.append("Edoardo", true, 1L, 1.1213132, 's');
        //lds.show();

        DoubleLinkedListC<Object> ldl = new DoubleLinkedListC<>();

        ldl.append(1,2,3,4,5,6,7,8,9);
        //ldl.show();
        ldl.reverseShow();
    }
}
