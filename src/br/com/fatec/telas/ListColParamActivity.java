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
import br.com.fatec.dbs.BancoColaborador;
import br.com.fatec.modelos.ColaboradorBean;
import java.util.List;

/**
 *
 * @author MARCIO
 */
public class ListColParamActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView ListaDeAlunos;
    List<ColaboradorBean> colaboradores;
    Button pesqUsu;
    ArrayAdapter<ColaboradorBean> adapter = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcol_param);
        final Context con = getBaseContext();
        final BancoColaborador ge = new BancoColaborador(con);
        ListaDeAlunos = (ListView) findViewById(R.id.listacol); 
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); //
        final EditText tipo2 = (EditText)findViewById(R.id.tipo2);
    
        pesqUsu = (Button) findViewById(R.id.btpesquisar2);
        pesqUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String tipoString = tipo2.getText().toString();
                ColaboradorBean col = new ColaboradorBean();
                col.setTipo(tipoString);
                colaboradores = ge.listarColaboradores(col);
                adapter = new ArrayAdapter<ColaboradorBean>(con,android.R.layout.simple_list_item_1,colaboradores);
                ListaDeAlunos.setAdapter(adapter);
            }
        });
    }
    
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ColaboradorBean col = (ColaboradorBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListColParamActivity.this, UptColActivity.class);
        it.putExtra("Colaborador",col);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + col.getId(),Toast.LENGTH_LONG).show(); 
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ColaboradorBean col = (ColaboradorBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListColParamActivity.this, UptColActivity.class);
        it.putExtra("Colaborador",col);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + col.getId(),Toast.LENGTH_LONG).show(); 
    }
}
