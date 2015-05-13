package com.jonaxel.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    TextView myTextView, myTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v1 = findViewById(R.id.myTextView);
        myTextView = (TextView) v1;
        myTextView.setText("");

        View v2 = findViewById(R.id.myTextView2);
        myTextView2 = (TextView) v2;
        myTextView2.setText("");

        View boton1 = findViewById(R.id.btnUno);
        boton1.setOnClickListener(this);

        View boton2 = findViewById(R.id.btnDos);
        boton2.setOnClickListener(this);

        View boton3 = findViewById(R.id.btnTres);
        boton3.setOnClickListener(this);

        View boton4 = findViewById(R.id.btnCuatro);
        boton4.setOnClickListener(this);

        View boton5 = findViewById(R.id.btnCinco);
        boton5.setOnClickListener(this);

        View boton6 = findViewById(R.id.btnSeis);
        boton6.setOnClickListener(this);

        View boton7 = findViewById(R.id.btnSiete);
        boton7.setOnClickListener(this);

        View boton8 = findViewById(R.id.btnOcho);
        boton8.setOnClickListener(this);

        View boton9 = findViewById(R.id.btnNueve);
        boton9.setOnClickListener(this);

        View boton0 = findViewById(R.id.btnCero);
        boton0.setOnClickListener(this);

        View botonSumar = findViewById(R.id.btnSumar);
        botonSumar.setOnClickListener(this);

        View botonRestar = findViewById(R.id.btnRestar);
        botonRestar.setOnClickListener(this);

        View botonMult = findViewById(R.id.btnMult);
        botonMult.setOnClickListener(this);

        View botonDiv = findViewById(R.id.btnDiv);
        botonDiv.setOnClickListener(this);

        View botonClear = findViewById(R.id.btnClear);
        botonClear.setOnClickListener(this);

        View botonPunto = findViewById(R.id.btnPunto);
        botonPunto.setOnClickListener(this);

        View botonIgual = findViewById(R.id.btnIgual);
        botonIgual.setOnClickListener(this);
    }

    double result, m1=0, m2=0;
    char op1='+';

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUno) {
            myTextView.append("1");
        } else if (v.getId() == R.id.btnDos) {
            myTextView.append("2");
        } else if (v.getId() == R.id.btnTres) {
            myTextView.append("3");
        } else if (v.getId() == R.id.btnCuatro) {
            myTextView.append("4");
        } else if (v.getId() == R.id.btnCinco) {
            myTextView.append("5");
        } else if (v.getId() == R.id.btnSeis) {
            myTextView.append("6");
        } else if (v.getId() == R.id.btnSiete) {
            myTextView.append("7");
        } else if (v.getId() == R.id.btnOcho) {
            myTextView.append("8");
        } else if (v.getId() == R.id.btnNueve) {
            myTextView.append("9");
        } else if (v.getId() == R.id.btnCero) {
            myTextView.append("0");
        } else if (v.getId() == R.id.btnPunto) {
            myTextView.append(".");
        } else if (v.getId() == R.id.btnClear) {
            myTextView.setText("");
            myTextView2.setText("");
            m1 = 0;
            op1 = '+';
        }

        else if (v.getId() == R.id.btnSumar) calcula('+');
        else if (v.getId() == R.id.btnRestar) calcula('-');
        else if (v.getId() == R.id.btnMult) calcula('*');
        else if (v.getId() == R.id.btnDiv) calcula('/');
        else if (v.getId() == R.id.btnIgual) calcula('=');
    }

    public void calcula(char op) {
        double result = m1;
        String cadena = myTextView.getText().toString();
        try {
            m2 = Double.parseDouble(cadena);
            if (op1 == '+') result = m1 + m2;
            else if (op1 == '-') result = m1 - m2;
            else if (op1 == '*') result = m1 * m2;
            else if (op1 == '/') result = m1 / m2;
            m1 = result;
            op1 = op;
            if (op == '=') {
                myTextView.setText("" + m1);
                myTextView2.setText("" + m1);
            } else {
                myTextView.setText("");
                myTextView2.setText("" + m1 + op1); //Imprime lo que apretaste
            }
        } catch (NumberFormatException e ) {
            Toast.makeText(this, "Numero incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
