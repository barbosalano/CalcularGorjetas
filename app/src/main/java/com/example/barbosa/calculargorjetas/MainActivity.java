package com.example.barbosa.calculargorjetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvGorjeta, tvTotal, tvPorcentagem;
    private SeekBar seekGorjeta;
    private EditText editValor;
    private double porcentagem = 0; //porcentagem inicial da Gorjeta


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGorjeta = findViewById(R.id.tvGorjeta);
        tvTotal = findViewById(R.id.tvTotal);
        tvPorcentagem = findViewById(R.id.tvPorcentagem);
        editValor = findViewById(R.id.editValor);
        seekGorjeta = findViewById(R.id.seekGorjeta);

        //Controlar SeekBar
        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                tvPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular() {

        //Recuperar o valor digitado
        Double valorDigitado = Double.parseDouble(editValor.getText().toString());

        // Calcular a Gorjeta Total

        double gorjeta = valorDigitado * (porcentagem/100);
        double total = gorjeta + valorDigitado;

        //exibir a gorjeta total
        tvGorjeta.setText(" R$ " + Math.round(gorjeta) );
        tvTotal.setText( " R$ " + total);

    }

}
