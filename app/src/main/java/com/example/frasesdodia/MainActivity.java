package com.example.frasesdodia;

        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.SeekBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText textV;
    private TextView textP;
    private TextView textG;
    private TextView textTot;
    private SeekBar seekBarGorj;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textV = findViewById(R.id.textValor);
        textP = findViewById(R.id.textPorcentagem);
        textG = findViewById(R.id.textGorjeta);
        textTot = findViewById(R.id.textTotal);
        seekBarGorj = findViewById(R.id.seekBarGorjeta);

        seekBarGorj.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textP.setText(Math.round(porcentagem) + " %");
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

    public void calcular(){

        String valorRecuperado = textV.getText().toString();

        if(valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(

                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG


            ).show();

        }else{
            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorjeta = valorDigitado * (porcentagem/100);

            double total = gorjeta + valorDigitado;

            textG.setText("R$ " + Math.round(gorjeta));
            textTot.setText("R$ " + Math.round(total));
        }
    }


}
