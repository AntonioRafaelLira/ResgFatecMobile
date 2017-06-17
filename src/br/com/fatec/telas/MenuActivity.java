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
import br.com.fatec.R;

/**
 *
 * @author ProfAlexandre
 */
public class MenuActivity extends Activity {
    
    Button addUsu, listUsu, listCol, listCon, listUsuPar, listColPar, listConPar, addCol, addCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        listUsu = (Button) findViewById(R.id.btlistusu);
        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });
        
        listCol = (Button) findViewById(R.id.btlistcol);
        listCol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListColActivity.class);
                startActivity(it);
            }
        });
        
        listCon = (Button) findViewById(R.id.btlistcon);
        listCon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListConActivity.class);
                startActivity(it);
            }
        });

        listUsuPar = (Button) findViewById(R.id.btlistusuParam);
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });
        
        listColPar = (Button) findViewById(R.id.btlistcolParam);
        listColPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListColParamActivity.class);
                startActivity(it);
            }
        });
        
        listConPar = (Button) findViewById(R.id.btlistconParam);
        listConPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListConParamActivity.class);
                startActivity(it);
            }
        });

        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });
        
        
        addCol = (Button) findViewById(R.id.btnovocol);
        addCol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddColActivity.class);
                startActivity(it);
            }
        });
        
        addCon = (Button) findViewById(R.id.btnovocon);
        addCon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddConActivity.class);
                startActivity(it);
            }
        });
        


    }

}
