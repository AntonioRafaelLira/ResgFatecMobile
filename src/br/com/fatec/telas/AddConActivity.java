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
import br.com.fatec.dbs.BancoContato;
import br.com.fatec.modelos.ContatoBean;

/**
 *
 * @author MARCIO
 */
public class AddConActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcon);
        final BancoContato co = new BancoContato(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir3);
        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome = (EditText)findViewById(R.id.nome2);
                EditText rg = (EditText)findViewById(R.id.rg);
                EditText cpf = (EditText)findViewById(R.id.cpf);
                EditText end = (EditText)findViewById(R.id.end);
   
                String nomeString = nome.getText().toString();
                String rgString = rg.getText().toString();
                String cpfString = cpf.getText().toString();
                String endString = end.getText().toString();

                ContatoBean con = new ContatoBean();
                con.setId("");
                con.setNome(nomeString);
                con.setRg(rgString);
                con.setCpf(cpfString);
                con.setEnd(endString);
                String msg = co.inserir(con);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        
    }
}
