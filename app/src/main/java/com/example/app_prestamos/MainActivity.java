package com.example.app_prestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnContinuar;
    EditText txtNombre;
    EditText txtTelefono;
    EditText txtCedula;
    EditText txtDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContinuar = findViewById(R.id.btnContinuar);
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCedula = findViewById(R.id.txtCedula);
        txtDireccion = findViewById(R.id.txtDireccion);

        btnContinuar.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (txtNombre.getText().toString().isEmpty()
                && txtTelefono.getText().toString().isEmpty()
                && txtCedula.getText().toString().isEmpty()
                && txtDireccion.getText().toString().isEmpty()
        )
        {
            txtNombre.setError("");
            txtTelefono.setError("");
            txtCedula.setError("");
            txtDireccion.setError("");
            Toast.makeText(this, "Revise los Campos", Toast.LENGTH_SHORT).show();
        }
        else if (txtNombre.getText().toString().isEmpty())
        {
            txtNombre.setError("Campo Obligatorio");
        }
        else if (txtTelefono.getText().toString().isEmpty())
        {
            txtTelefono.setError("Campo Obligatorio");
        }
        else if (txtCedula.getText().toString().isEmpty())
        {
            txtCedula.setError("Campo Obligatorio");
        }
        else if (txtDireccion.getText().toString().isEmpty())
        {
            txtDireccion.setError("Campo Obligatorio");
        }
        else
        {
            Intent intent = new Intent(this,SegundoActivity.class);
            startActivity(intent);
        }
    }
}
