/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.com.fatec.R;
import br.com.fatec.dbs.BancoContato;
import br.com.fatec.modelos.ContatoBean;
import java.util.List;

/**
 *
 * @author MARCIO
 */
public class ListConParamActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView ListaDeAlunos;
    List<ContatoBean> contatos;
    Button pesqUsu;
    ArrayAdapter<ContatoBean> adapter = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcon_param);
        final Context con = getBaseContext();
        final BancoContato ge = new BancoContato(con);
        ListaDeAlunos = (ListView) findViewById(R.id.listacon); 
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); //
        final EditText nome2 = (EditText)findViewById(R.id.nome2);
    
        pesqUsu = (Button) findViewById(R.id.btpesquisar3);
        pesqUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome2.getText().toString();
                ContatoBean co = new ContatoBean();
                co.setNome(nomeString);
                contatos = ge.listarContatos(co);
                adapter = new ArrayAdapter<ContatoBean>(con,android.R.layout.simple_list_item_1,contatos);
                ListaDeAlunos.setAdapter(adapter);
            }
        });
    }
    
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ContatoBean con = (ContatoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListConParamActivity.this, UptConActivity.class);
        it.putExtra("Contato",con);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + con.getId(),Toast.LENGTH_LONG).show(); 
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ContatoBean con = (ContatoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListConParamActivity.this, UptConActivity.class);
        it.putExtra("Contato",con);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + con.getId(),Toast.LENGTH_LONG).show(); 
    }
}
