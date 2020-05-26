package com.mycompany.foodstudiesconnection;

import java.util.Comparator;

public class ComparadorDeNick implements Comparator<Usuario> {

    @Override
    public int compare(Usuario o1, Usuario o2) {
        return o1.nick.compareTo(o2.nick);
    }

}
