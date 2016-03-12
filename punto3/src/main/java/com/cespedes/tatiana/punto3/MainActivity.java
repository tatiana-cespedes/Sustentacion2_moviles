package com.cespedes.tatiana.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbcuadro, rbtriangulo, rbrectangulo, rbcirculo;
    private TextView targumento1, targumento2, tresultado3;
    private EditText eargumento1, eargumento2;
    private Button bcalculararea;
    private double cuad=0, trian=0, rect=0, circ=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punto_3);
        rbcuadro=(RadioButton) findViewById(R.id.rbcuadro);
        rbtriangulo=(RadioButton) findViewById(R.id.rbtriangulo);
        rbrectangulo=(RadioButton) findViewById(R.id.rbrectangulo);
        rbcirculo=(RadioButton) findViewById(R.id.rbcirculo);
        targumento1=(TextView) findViewById(R.id.targumento1);
        targumento2=(TextView) findViewById(R.id.targumento2);
        eargumento1=(EditText) findViewById(R.id.eargumento1);
        eargumento2=(EditText) findViewById(R.id.eargumento2);
        tresultado3=(TextView) findViewById(R.id.tresultado3);
        bcalculararea=(Button) findViewById(R.id.bcalculararea);

        bcalculararea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                double term1,term2;
                term1= Double.valueOf(eargumento1.getText().toString());
                term2= Double.valueOf(eargumento2.getText().toString());
                double resul=0;

                if(cuad==1){
                    resul=term1*term1;
                    tresultado3.setText(""+resul);
                }else if(trian==1){
                    resul=(term1*term2)/2;
                    tresultado3.setText(String.valueOf(resul));
                }else if(rect==1){
                    resul=term1*term2;
                    tresultado3.setText(String.valueOf(resul));
                }else if(circ==1){
                    resul=(term1*term1)*3.14;
                    tresultado3.setText(String.valueOf(resul));
                }else{
                    tresultado3.setText("No ha seleccionado operación");
                }
            }
        });
    }

    public void OnRadioButtomAreas(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbcuadro:
                if (checked)
                    targumento1.setText("Lado");
                targumento1.setEnabled(true);
                targumento2.setText("");
                targumento2.setEnabled(false);
                eargumento1.setEnabled(true);
                eargumento2.setEnabled(false);
                eargumento2.setText("0");
                cuad=1; trian=0; rect=0; circ=0;
                break;
            case R.id.rbtriangulo:
                if (checked)
                    targumento1.setText("Base");
                targumento1.setEnabled(true);
                targumento2.setText("Altura");
                targumento2.setEnabled(true);
                eargumento1.setEnabled(true);
                eargumento2.setEnabled(true);
                cuad=0; trian=1; rect=0; circ=0;
                break;
            case R.id.rbrectangulo:
                if (checked)
                    targumento1.setText("Base");
                targumento1.setEnabled(true);
                targumento2.setText("Altura");
                targumento2.setEnabled(true);
                eargumento1.setEnabled(true);
                eargumento2.setEnabled(true);
                cuad=0; trian=0; rect=1; circ=0;
                break;
            case R.id.rbcirculo:
                if (checked)
                    targumento1.setText("Radio");
                targumento1.setEnabled(true);
                targumento2.setText("");
                targumento2.setEnabled(false);
                eargumento1.setEnabled(true);
                eargumento2.setEnabled(false);
                eargumento2.setText("0");
                cuad=0; trian=0; rect=0; circ=1;
                break;
            default:
                targumento1.setEnabled(false);
                targumento2.setEnabled(false);
                eargumento1.setEnabled(false);
                eargumento2.setEnabled(false);
                cuad=0; trian=0; rect=0; circ=0;
                break;
        }
    }


}
