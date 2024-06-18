package es.ieslavereda.bingorepaso;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<JugadorBingo> jugadores;
    private BomboBingo bomboBingo;
    private Bola bolabombo;
    TextView bolasacada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bolasacada = findViewById(R.id.bolasacada);
        RecyclerView recyclerView = findViewById(R.id.recicler);
        TextView jugador1 = findViewById(R.id.jugador1);
        TextView jugador2 = findViewById(R.id.jugador2);
        TextView jugador3 = findViewById(R.id.jugador3);
        TextView jugador4 = findViewById(R.id.jugador4);
        RadioButton sortPosition = findViewById(R.id.sortposition);
        RadioButton sortColor = findViewById(R.id.sortbycolor);
        RadioButton sortNumber = findViewById(R.id.sortbynumber);

        jugadores = new ArrayList<>();
        Cartones carton1 = findViewById(R.id.carton1);
        jugadores.add(new JugadorBingo("dasdas","dasdasdadas",10,
                new ArrayList<>(List.of(carton1))));
        Cartones carton2 = findViewById(R.id.carton2);
        jugadores.add(new JugadorBingo("pepe","dasdadasdsdadas",10,
                new ArrayList<>(List.of(carton2))));
        Cartones carton3 = findViewById(R.id.carton3);
        jugadores.add(new JugadorBingo("juan","dasdas",10,
                new ArrayList<>(List.of(carton3))));
        Cartones carton4 = findViewById(R.id.carton4);
        jugadores.add(new JugadorBingo("marcos","dada",10,
                new ArrayList<>(List.of(carton4))));


        jugador1.setText(jugadores.get(0).getNombre());
        jugador2.setText(jugadores.get(1).getNombre());
        jugador3.setText(jugadores.get(2).getApellidos());
        jugador4.setText(jugadores.get(3).getNombre() + " " + jugadores.get(3).getApellidos());

        bomboBingo = new BomboBingo();

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bolasacada.setOnClickListener(v -> {
            bolabombo = bomboBingo.sacarBola();
            if (bolabombo==null){
                Toast.makeText(this,"No hay mas bolas",Toast.LENGTH_LONG).show();
            }else {
                bolasacada.setText(String.valueOf(bolabombo.getNumero()));
                //bolasacada.setBackground(getDrawable(bolabombo.getColor()));
                adapter.add(bolabombo);
                checkPlayer(bolabombo.getNumero());
            }
        });

        sortPosition.setOnClickListener(v -> adapter.sortPosition());
        sortNumber.setOnClickListener(v-> adapter.sortNumber());
        sortColor.setOnClickListener(v-> adapter.sortColor());




    }

    private void checkPlayer(int numero){
        for (JugadorBingo jugadorBingo : jugadores){
            for (Cartones cartones : jugadorBingo.getCartones()){
                if (cartones.checK(numero)){
                    bolasacada.setVisibility(View.INVISIBLE);
                    Toast.makeText(this,"GANADOR: " + jugadorBingo.getNombre() + " "
                    + jugadorBingo.getApellidos(), Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}