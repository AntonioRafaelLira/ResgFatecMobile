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
import br.com.fatec.dbs.BancoColaborador;
import br.com.fatec.modelos.ColaboradorBean;
import java.util.List;

public class ListColActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView ListaDeCols;
    List<ColaboradorBean> colaboradores;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcol);
        final BancoColaborador ge = new BancoColaborador(getBaseContext());
        ListaDeCols = (ListView) findViewById(R.id.listacol); 
        colaboradores = ge.listarColaboradores();
        ArrayAdapter<ColaboradorBean> adapter = new ArrayAdapter<ColaboradorBean>(this,android.R.layout.simple_list_item_1,colaboradores);
        ListaDeCols.setAdapter(adapter);
        ListaDeCols.setOnItemClickListener(this); // Clique no item
        ListaDeCols.setOnItemLongClickListener(this); // Pressão sobre o item
    }
    
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ColaboradorBean col = (ColaboradorBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListColActivity.this, UptColActivity.class);
        it.putExtra("Colaborador",col);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + col.getId(),Toast.LENGTH_LONG).show(); 
        return true;
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ColaboradorBean col = (ColaboradorBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListColActivity.this, UptColActivity.class);
        it.putExtra("Colaborador",col);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + col.getId(),Toast.LENGTH_LONG).show(); 
    }
}
