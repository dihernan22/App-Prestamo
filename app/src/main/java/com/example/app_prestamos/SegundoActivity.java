package com.example.app_prestamos;

import android.R.layout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SegundoActivity extends AppCompatActivity implements View.OnClickListener {

    int monto = 0, interes, plazo = 1;

    EditText txtMonto, txtPlazo;

    TextView txtMontoPagar, txtMontoCuota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        txtMonto = findViewById(R.id.txtMontoCredito);
        txtPlazo = findViewById(R.id.txtPlazo);

        txtMontoPagar = findViewById(R.id.txtMontoPagar);
        txtMontoCuota = findViewById(R.id.txtMontoCuota);

        EditText txtFecha = findViewById(R.id.txtFecha);

        Button btnFinalizar = findViewById(R.id.btnFinalizar);

        //Fecha Inicio
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha.setText(formateador.format(new Date()));

        Spinner cbInteres = findViewById(R.id.cbInteres);
        cbInteres.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                interes = Integer.parseInt(parent.getSelectedItem().toString());

                ActualizarDatos();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty())
                {
                    if (txtMonto.getText().hashCode() == s.hashCode()) {
                        monto = Integer.parseInt(s.toString());
                    }
                    else if (txtPlazo.getText().hashCode() == s.hashCode())
                    {
                        plazo = Integer.parseInt(s.toString());
                    }

                    ActualizarDatos();
                }
                else
                {
                    if (txtMonto.getText().hashCode() == s.hashCode()) {
                        monto = 0;

                        ActualizarDatos();
                    }

                    if (txtPlazo.getText().hashCode() == s.hashCode()) {
                        plazo = 1;

                        ActualizarDatos();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        txtMonto.addTextChangedListener(textWatcher);

        txtPlazo.addTextChangedListener(textWatcher);

        btnFinalizar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public void ActualizarDatos()
    {
        EditText txtFechaFinal = findViewById(R.id.txtFechaFinal);

        double total = (double) monto + ((monto * interes / 100) * plazo);
        double cuota = total / plazo;

        SimpleDateFormat fechaEnd = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,plazo);
        txtFechaFinal.setText(fechaEnd.format(calendar.getTime()));

        txtMontoPagar.setText(String.valueOf(total));
        txtMontoCuota.setText(String.valueOf(cuota));
    }
}
