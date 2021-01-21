package com.example.calculargorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editvalorPaga ;
    private TextView textPorcentagem;
    private TextView textGojeta;
    private TextView textTotal;
    private SeekBar  SekBarGojeta;
    private double porcentagem =0;
    private ImageView icoIfon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active);

    editvalorPaga   = findViewById(R.id.edittGojeta);
    textPorcentagem = findViewById( R.id.textPorcentagem);
    textGojeta      = findViewById( R.id.textGojeta);
    textTotal       = findViewById( R.id.textTotal);
    SekBarGojeta    = findViewById( R.id.seekBarGojeta);
    icoIfon         = findViewById(R.id.id_info);

    SekBarGojeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            porcentagem = progress;
            textPorcentagem.setText( Math.round(porcentagem) + "%");
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



    public void informaçoes (View view){
        // class do alerta
        AlertDialog.Builder alertaInfomaçoes = new AlertDialog.Builder(this);
        // titulo do alerta
        alertaInfomaçoes.setTitle(" Informaçoes");
        //messagem a ser exubirda
        alertaInfomaçoes.setMessage("Digite o valor referente a conta do cliente." +
                " Selecione o valor da porcentagem pro garson");
        //selecionar o icone
        alertaInfomaçoes.setIcon(android.R.drawable.ic_menu_info_details);
        //alerta Positiva com o botao Ok
        alertaInfomaçoes.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertaInfomaçoes.create();
        alertaInfomaçoes.show();
    }



    public void calcular(){
        String calcularVlorPo =  editvalorPaga.getText().toString();
        if (calcularVlorPo == null || calcularVlorPo.equals("")){
            Toast.makeText(getApplicationContext(),
                    "Nem um valor Digitado"
                    ,Toast.LENGTH_SHORT
                ).show();
        }else {

             // valor da gogeta
             double valorGojetaDoble = Double.parseDouble(calcularVlorPo);
             double resultadoValorGojeta = porcentagem * (valorGojetaDoble/100);
             textGojeta.setText("R$"+Math.round( resultadoValorGojeta  ));

             // valor Total
             double valorTotalApagarComgojeta = resultadoValorGojeta + valorGojetaDoble;
             textTotal.setText( "R$"  + Math.round(valorTotalApagarComgojeta));

            }
        }
}
