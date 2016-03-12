package com.cespedes.tatiana.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etermino1, etermino2;
    private Button bcalcular;
    private RadioButton rbsuma, rbresta, rbmultiplicacion, rbdivision;
    private TextView tresultado, toperador;
    private double sum=0, res=0, mul=0, div=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punto_2);

        etermino1= (EditText) findViewById(R.id.etermino1);
        etermino2= (EditText) findViewById(R.id.etermino2);
        bcalcular=(Button) findViewById(R.id.bcalcular);
        rbsuma= (RadioButton) findViewById(R.id.rbsuma);
        rbresta= (RadioButton) findViewById(R.id.rbresta);
        rbmultiplicacion= (RadioButton) findViewById(R.id.rbmultiplicacion);
        rbdivision= (RadioButton) findViewById(R.id.rbdivision);
        tresultado= (TextView) findViewById(R.id.tresultado);
        toperador= (TextView) findViewById(R.id.toperador);


        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double term1 = Double.valueOf(etermino1.getText().toString());
                double term2 = Double.valueOf(etermino2.getText().toString());
                double resul = 0;

                if (sum == 1) {
                    resul = term1 + term2;
                    tresultado.setText("" + resul);
                } else if (res == 1) {
                    resul = term1 - term2;
                    tresultado.setText("" + resul);
                } else if (mul == 1) {
                    resul = term1 * term2;
                    tresultado.setText("" + resul);
                } else if (div == 1) {
                    resul = term1 / term2;
                    tresultado.setText("" + resul);
                } else {
                    tresultado.setText("No ha seleccionado operación");
                }
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbsuma:
                if (checked)
                    sum=1;
                res=0;
                mul=0;
                div=0;
                toperador.setText("+");
                break;
            case R.id.rbresta:
                if (checked)
                    sum=0;
                res=1;
                mul=0;
                div=0;
                toperador.setText("-");
                break;
            case R.id.rbmultiplicacion:
                if (checked)
                    sum=0;
                res=0;
                mul=1;
                div=0;
                toperador.setText("*");
                break;
            case R.id.rbdivision:
                if (checked)
                    sum=0;
                res=0;
                mul=0;
                div=1;
                toperador.setText("/");
                break;
            default:
                sum=0;
                res=0;
                mul=0;
                div=0;
                toperador.setText(" ");
                break;
        }
    }

}
