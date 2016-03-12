package com.cespedes.tatiana.punto4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private EditText eloggin, epassword, ereppass, ecorreo;
    private RadioButton rbfem, rbmas;
    private Spinner sciudades;
    private CheckBox cdeportes, cpeliculas, cviajes,cotro;
    private Button baceptar, bfechanac;
    private TextView tresultado;
    int year_x, month_x, day_x, feme, masc, contador;
    static final int DIALOG_ID =0;
    String Loggin, password, password2, correo;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punto_4);

        tresultado=(TextView) findViewById(R.id.tresultado);
        eloggin =(EditText) findViewById(R.id.eloggin);
        epassword=(EditText) findViewById(R.id.epassword);
        ereppass=(EditText) findViewById(R.id.ereppass);
        ecorreo=(EditText) findViewById(R.id.ecorreo);

        rbfem=(RadioButton) findViewById(R.id.rbfem);
        rbmas=(RadioButton) findViewById(R.id.rbmas);

        sciudades=(Spinner) findViewById(R.id.sciudades);

        cdeportes=(CheckBox)findViewById(R.id.cdeportes);
        cpeliculas=(CheckBox)findViewById(R.id.cpeliculas);
        cviajes=(CheckBox)findViewById(R.id.cviajes);
        cotro=(CheckBox)findViewById(R.id.cotro);

        baceptar=(Button)findViewById(R.id.baceptar);
        bfechanac=(Button)findViewById(R.id.bfechanac);
        showDialogOnButtonClick();

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.Ciudades,android.R.layout.simple_spinner_item);

        sciudades.setAdapter(adapter);
        sciudades.setOnItemSelectedListener(this);
        ClikAceptar();



    }

    private void showDialogOnButtonClick() {
        bfechanac = (Button)findViewById(R.id.bfechanac);
        bfechanac.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }


                }
        );
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
        return null;


    }
    private  DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x=year;
            month_x=monthOfYear+1;
            day_x=dayOfMonth;
            Toast.makeText(MainActivity.this, day_x+" / "+ month_x +" / "+ year_x, Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        texto=(TextView) view;
        //Toast.makeText(this, "Ciudad de nacimiento:  "+texto.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void ClikAceptar() {
        baceptar.setOnClickListener(new View.OnClickListener() {
                                        @Override

                                        public void onClick(View v) {
                                            StringBuffer result = new StringBuffer();
                                            String result2 = new String();

                                            result2 = String.valueOf(tresultado.getText().toString());

                                            Loggin = String.valueOf(eloggin.getText().toString());
                                            password = String.valueOf(epassword.getText().toString());
                                            password2 = String.valueOf(ereppass.getText().toString());
                                            correo = String.valueOf(ecorreo.getText().toString());


                                            contador = 0;

                                            if (Loggin.matches("")) {
                                                Toast.makeText(MainActivity.this, "Falta el campo Loggin", Toast.LENGTH_LONG).show();
                                                contador++;
                                            }
                                            if (password.matches("")) {
                                                Toast.makeText(MainActivity.this, "Falta el campo Password", Toast.LENGTH_LONG).show();
                                                contador++;
                                            }
                                            if (password2.matches("")) {
                                                Toast.makeText(MainActivity.this, "Falta el campo Repetir Password", Toast.LENGTH_LONG).show();
                                                contador++;
                                            }
                                            if (correo.matches("")) {
                                                Toast.makeText(MainActivity.this, "Falta el campo Correo Electrónico", Toast.LENGTH_LONG).show();
                                                contador++;
                                            }

                                            if (password.equals(password2) ) {}else{
                                                Toast.makeText(MainActivity.this, "Las contraseñas no son iguales", Toast.LENGTH_LONG).show();
                                                contador++;
                                            }

                                            if (contador == 0) {

                                                result.append("Loggin                              :  " + Loggin);
                                                result.append("\nCorreo:                              :  " + correo);
                                                if (feme == 1) {
                                                    result.append("\nSexo                                  :  Femenino");
                                                } else {
                                                    result.append("\nSexo                                  :  Masculino");
                                                }
                                                result.append("\nFecha de nacimiento    :  " + day_x + " / " + month_x + " / " + year_x);
                                                result.append("\nCiudad de nacimiento  :  " + texto.getText());
                                                result.append("\nDeportes                          :  ").append(cdeportes.isChecked());
                                                result.append("\nPeliculas                          :  ").append(cpeliculas.isChecked());
                                                result.append("\nViajes                                :  ").append(cviajes.isChecked());
                                                result.append("\nOtro                                   :  ").append(cotro.isChecked());

                                                Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_LONG).show();
                                                tresultado.setText("" + result2 + " \n \n \n" + result.toString());

                                            }

                                        }
            }
        );
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbfem:
                if (checked)
                    feme=1;
                    masc=0;
                    break;
            case R.id.rbmas:
                if (checked)
                    feme=0;
                    masc=1;
                    break;
            default:
                feme=1;
                masc=0;
                break;
        }
    }
}

