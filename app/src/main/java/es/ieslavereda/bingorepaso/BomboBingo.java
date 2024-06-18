package es.ieslavereda.bingorepaso;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BomboBingo extends Bombo{


    public BomboBingo() {
        this.bolas = new LinkedHashSet<>();
        for (int i = 1; i <=90 ; i++) {
            bolas.add(new Bola(i,((i%2==0)? 0x41FF33:0x33F6FF)));
        }
        girarBonbo();

    }

    public Bola sacarBola(){
        List<Bola> listaBolas = getBolas()
                .stream().collect(Collectors.toList());
        Bola bola = null;
        if(getBolas().size()%5==0)
            Collections.shuffle(listaBolas);
        if (!listaBolas.isEmpty()){
             bola = listaBolas.remove(0);

        }
        setBolas(new LinkedHashSet<>(listaBolas));

        return bola;

    }

    public void girarBonbo(){
    List<Bola> bolas1 = new ArrayList<>(bolas);
    Collections.shuffle(bolas1);
    bolas.clear();
    bolas.addAll(bolas1);
}

}

