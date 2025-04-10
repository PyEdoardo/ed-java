/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pyedoardo.ed_java;

import com.pyedoardo.ed_java.collections.LinkedList;
import com.pyedoardo.ed_java.collections.List;
import java.util.ArrayList;

/**
 *
 * @author edoar
 */
public class ED_Java {

    public static void main(String[] args) {
        List lds = new List(10);
        LinkedList llds = new LinkedList();
        ArrayList alds = new ArrayList();
        lds.append("Edoardo", true, 1L, 1.1213132, 's');
        lds.show();
    }
}
