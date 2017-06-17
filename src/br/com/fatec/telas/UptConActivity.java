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
import br.com.fatec.dbs.BancoContato;
import br.com.fatec.modelos.ContatoBean;

/**
 *
 * @author MARCIO
 */
public class UptConActivity extends Activity {
    Button uptCon, delCon;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uptcon);
        final BancoContato ge = new BancoContato(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nome2);
        final EditText rg = (EditText)findViewById(R.id.rg);
        final EditText cpf = (EditText)findViewById(R.id.cpf);
        final EditText end = (EditText)findViewById(R.id.end);
        Intent it = getIntent();
        final ContatoBean recuperado = (ContatoBean) it.getSerializableExtra("Contato");
        nome.setText(recuperado.getNome());
        rg.setText(recuperado.getRg());
        cpf.setText(recuperado.getCpf());
        end.setText(recuperado.getEnd());
        uptCon = (Button) findViewById(R.id.btalterar3);
        uptCon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String rgString = rg.getText().toString();
                String cpfString = cpf.getText().toString();
                String endString = end.getText().toString();
                recuperado.setNome(nomeString);
                recuperado.setRg(rgString);
                recuperado.setCpf(cpfString);
                recuperado.setEnd(endString);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delCon = (Button) findViewById(R.id.btexcluir3);
        delCon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        

    }
}
