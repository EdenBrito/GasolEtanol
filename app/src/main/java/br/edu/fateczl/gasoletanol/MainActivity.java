/*
    Nome:   Éden Vieira Brito
    RA:     1110482213006
*/

package br.edu.fateczl.gasoletanol;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValorGasolina;
    private EditText etValorEtanol;
    private TextView tvRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValorGasolina = findViewById(R.id.etValorGasolina);
        etValorGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etValorEtanol = findViewById(R.id.etValorEtanol);
        etValorEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        String res;
        float vGasolina = Float.parseFloat(etValorGasolina.getText().toString());
        float vEtanol = Float.parseFloat(etValorEtanol.getText().toString());
        float porcentagem = vEtanol*100/vGasolina;
        if (porcentagem > 70){
            res = getString(R.string.utilizar) + porcentagem + "%, utilize gasolina!";
        }else {
            res = getString(R.string.utilizar) + porcentagem + "%, utilize etanol!";
        }
        tvRes.setText(res);
    }
}