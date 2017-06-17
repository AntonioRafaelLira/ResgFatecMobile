package br.com.fatec.telas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.fatec.R;

public class LoginActivity extends Activity {

    EditText login,senha;
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);
        
        entrar = (Button) findViewById(R.id.btentrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(login.getText().toString().equals("adm")){
                    Toast.makeText(getApplication(), "Autorizado", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(it);
                }else{
                    Toast.makeText(getApplication(), "Login Inválido", Toast.LENGTH_LONG).show();
                    login.setText("");
                    senha.setText("");
                }
            }
        });
    }
}
