/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.fatec.R;
import br.com.fatec.dbs.BancoColaborador;
import br.com.fatec.modelos.ColaboradorBean;

/**
 *
 * @author ProfAlexandre
 */
public class UptColActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    
     Button uptCol, delCol;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uptcol);
        final BancoColaborador ge = new BancoColaborador(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nome);
        final EditText tipo = (EditText)findViewById(R.id.tipo2);
        Intent it = getIntent();
        final ColaboradorBean recuperado = (ColaboradorBean) it.getSerializableExtra("Colaborador");
        nome.setText(recuperado.getNome());
        tipo.setText(recuperado.getTipo());
        uptCol = (Button) findViewById(R.id.btalterar2);
        uptCol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String tipoString = tipo.getText().toString();
                recuperado.setNome(nomeString);
                recuperado.setTipo(tipoString);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delCol = (Button) findViewById(R.id.btexcluir2);
        delCol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        

    }
    
     
    
}
