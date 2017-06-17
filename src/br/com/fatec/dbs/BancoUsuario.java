/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.fatec.modelos.UsuarioBean;
import java.util.ArrayList;
import java.util.List;

public class BancoUsuario {
    
    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;
	
    public BancoUsuario(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }
	
    public String inserir(UsuarioBean usu) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("LOGIN", usu.getLogin());
        valores.put("SENHA", usu.getSenha());
        valores.put("STATUS", usu.getStatus());
        valores.put("TIPO", usu.getTipo());
        resultado = db.insert(BancoHelper.TABELA, null, valores);
        db.close();
        
        if (resultado == -1) {
           retorno = "Erro ao inserir registro";
        } else {
           retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(UsuarioBean usu) {
        String retorno = "Resgistro Excluir com Sucesso";
        String where = "ID = " + usu.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA,where,null);
        db.close();
        return retorno;
    }
    
    public String alterar(UsuarioBean usu) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + usu.getId();
        valores = new ContentValues();
        valores.put("LOGIN", usu.getLogin());
        valores.put("SENHA", usu.getSenha());
        valores.put("STATUS", usu.getStatus());
        valores.put("TIPO", usu.getTipo());
        db.update(BancoHelper.TABELA, valores,where,null);
        db.close();
        return retorno;
    }

    public List<UsuarioBean> listarUsuarios() {
        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        String selectQuery = "SELECT * FROM USUARIOS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                UsuarioBean usu = new UsuarioBean();
                usu.setId(""+cursor.getInt(0));
                usu.setLogin(cursor.getString(1));
                usu.setSenha(cursor.getString(2));
                usu.setStatus(cursor.getString(3));
                usu.setTipo(cursor.getString(4));
                usuarios.add(usu);
            } while (cursor.moveToNext());
        }
        return usuarios;
    }

    public List<UsuarioBean> listarUsuarios(UsuarioBean usuEnt) {
        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        String parametro = usuEnt.getLogin()  ;
        /*String where = "LOGIN LIKE ?";
        String[] whereArgs = new String[] { "'%" + parametro + "%'" };
        String[] query = {"ID, LOGIN, SENHA, STATUS, TIPO"};
        String table = "USUARIOS";*/
        String selectQuery = "SELECT ID, LOGIN, SENHA, STATUS, TIPO FROM USUARIOS WHERE LOGIN LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        //Cursor cursor = db.query(true, table, query, null, whereArgs, where, null, null, null);
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                UsuarioBean usu = new UsuarioBean();
                usu.setId(""+cursor.getInt(0));
                usu.setLogin(cursor.getString(1));
                usu.setSenha(cursor.getString(2));
                usu.setStatus(cursor.getString(3));
                usu.setTipo(cursor.getString(4));
                usuarios.add(usu);
            } while (cursor.moveToNext());
        }
        return usuarios;
    }

    public List<UsuarioBean> listarUsuariosTeste() {
	List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        for (int i = 0; i < 10; i++ ) {
                UsuarioBean usu = new UsuarioBean();
                usu.setId(" Id " + i);
                usu.setLogin(" Login " + i);
                usu.setSenha(" Senha " + i);
                usu.setStatus(" Status " + i);
                usu.setTipo(" Tipo " + i);
                usuarios.add(usu);
        }
        return usuarios;
    }
}

