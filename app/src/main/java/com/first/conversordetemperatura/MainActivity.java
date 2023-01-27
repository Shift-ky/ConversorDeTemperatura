package com.first.conversordetemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText entrada;
    TextView saida;
    RadioGroup escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        entrada = findViewById(R.id.entrada);
        saida = findViewById(R.id.saida);
        escolha = findViewById(R.id.RgEscolha);
    }

    public void converter(View view){
        DecimalFormat arredondar = new DecimalFormat("#.#");
        if(TextUtils.isEmpty(entrada.getText().toString())){
            Toast.makeText(MainActivity.this,"Informe algum valor para ser convertido!",Toast.LENGTH_LONG).show();
        }else{
            double celcius = Double.parseDouble(entrada.getText().toString());
            String formatado;
            int vlrRecebido = escolha.getCheckedRadioButtonId();

            switch (vlrRecebido){
                case R.id.RbFah:
                    formatado = arredondar.format((celcius * 9/5) +32);
                    saida.setText(formatado);
                    break;
                case R.id.RbKevin:
                    formatado = arredondar.format(celcius + 273.15);
                    saida.setText(formatado);
                    break;
                default:
                    Toast.makeText(MainActivity.this,"Escolha uma opção para realizar a conversão",Toast.LENGTH_LONG).show();
                    break;

            }
        }



    }
}