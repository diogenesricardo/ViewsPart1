package com.example.diogenes.aula06;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static  final String[] CANDIDATOS = new String[] {"Bolsonabo", "Marina Melancia", "Cirão da Massa", "ManuStalin"};
    private static  final String[] REGIOES = new String[] {"NE", "N", "S", "SE","CO"};
    private String candidato;
    private AutoCompleteTextView candidatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;

        TextView t = (TextView) findViewById(R.id.tvHello);
        t.setText(R.string.ola_fafica);

        t.setTextColor(getResources().getColor(R.color.vermelho,this.getTheme()));

        EditText edEmail = (EditText) findViewById(R.id.etEmail);
        edEmail.requestFocus();


        candidatos = (AutoCompleteTextView) findViewById(R.id.autoCandidatos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, CANDIDATOS);
        candidatos.setAdapter(adapter);

        final Spinner combo = (Spinner) findViewById(R.id.sRegiao);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,REGIOES);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo.setAdapter(adapter1);




    }

    public void votou(View view) {
        Toast.makeText(this, "Votou em "+candidatos.getText().toString(),Toast.LENGTH_LONG).show();

        Intent intent =  new Intent("br.com.fafica.intents.TESTE");
        startActivity(intent);
    }
}
