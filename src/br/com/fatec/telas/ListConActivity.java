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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
public class ListConActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView ListaDeCons;
    List<ContatoBean> contatos;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcon);
        final BancoContato ge = new BancoContato(getBaseContext());
        ListaDeCons = (ListView) findViewById(R.id.listacon); 
        contatos = ge.listarContatos();
        ArrayAdapter<ContatoBean> adapter = new ArrayAdapter<ContatoBean>(this,android.R.layout.simple_list_item_1,contatos);
        ListaDeCons.setAdapter(adapter);
        ListaDeCons.setOnItemClickListener(this); // Clique no item
        ListaDeCons.setOnItemLongClickListener(this); // Pressão sobre o item
    }
    
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ContatoBean con = (ContatoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListConActivity.this, UptConActivity.class);
        it.putExtra("Contato",con);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + con.getId(),Toast.LENGTH_LONG).show(); 
        return true;
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ContatoBean con = (ContatoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListConActivity.this, UptConActivity.class);
        it.putExtra("Contato",con);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + con.getId(),Toast.LENGTH_LONG).show(); 
    }
}
