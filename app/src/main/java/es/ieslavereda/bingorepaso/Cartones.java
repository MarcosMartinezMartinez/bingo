package es.ieslavereda.bingorepaso;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cartones extends LinearLayout {
    private Map<Integer, Boolean> numeroEnCartones;
    private Map<Integer, TextView> views;

    public Cartones(Context context) {
        super(context);
        inicializar();
    }

    public Cartones(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inicializar();
    }

    public Cartones(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializar();
    }

    public Cartones(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inicializar();
    }

    public void inicializar(){
        numeroEnCartones = new TreeMap<>();
        views = new HashMap<>();
        while (numeroEnCartones.size()<10){
            numeroEnCartones.put((int)(Math.random()*90 +1),false);
        }
        int i =0;
        for (Integer numero : numeroEnCartones.keySet()){
            TextView textView = createTextView(numero, i);
            views.put(numero,textView);
            addView(textView);
        }
    }

    private TextView createTextView(Integer numero, int addEven) {
        Context context = getContext();
        TextView textView = new TextView(context);
        textView.setText(""+numero);
        textView.setWidth(36);
        textView.setGravity(TEXT_ALIGNMENT_CENTER);
        textView.setBackground((addEven%2==0)?context.getDrawable(R.color.blue):
                context.getDrawable(R.color.yellow));
        textView.setTextSize(10);
        return textView;
    }
public boolean checK(int numero){
        if (numeroEnCartones.keySet().contains(numero)){
            numeroEnCartones.put(numero,true);
            views.get(numero).setBackground(getContext().getDrawable(R.color.orange));
            return checkWin();
        }
        return false;
}

public boolean checkWin(){
        for (Boolean g : numeroEnCartones.values()){
            if (!g){
                return false;
            }
        }
    return true;
    }



}
