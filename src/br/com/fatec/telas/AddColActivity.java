/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import android.app.Activity;
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
 * @author MARCIO
 */
public class AddColActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcol);
        final BancoColaborador co = new BancoColaborador(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir2);
        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome = (EditText)findViewById(R.id.nome);
                EditText tipo = (EditText)findViewById(R.id.tipo2);
   
                String nomeString = nome.getText().toString();
                String tipoString = tipo.getText().toString();

                ColaboradorBean col = new ColaboradorBean();
                col.setId("");
                col.setNome(nomeString);
                col.setTipo(tipoString);
                String msg = co.inserir(col);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        
    }
}
