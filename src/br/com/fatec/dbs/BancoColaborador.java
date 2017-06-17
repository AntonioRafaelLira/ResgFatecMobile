package br.com.fatec.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.fatec.modelos.ColaboradorBean;
import java.util.ArrayList;
import java.util.List;

public class BancoColaborador {
    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;
    
    public BancoColaborador(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }
    
    public String inserir(ColaboradorBean col) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", col.getNome());
        valores.put("TIPO", col.getTipo());
        resultado = db.insert(BancoHelper.TABELA2, null, valores);
        db.close();
        
        if (resultado == -1) {
           retorno = "Erro ao inserir registro";
        } else {
           retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }
    
    public String excluir(ColaboradorBean col) {
        String retorno = "Registro Excluido com Sucesso";
        String where = "ID = " + col.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA2,where,null);
        db.close();
        return retorno;
    }
    
    public String alterar(ColaboradorBean col) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + col.getId();
        valores = new ContentValues();
        valores.put("NOME", col.getNome());
        valores.put("TIPO", col.getTipo());
        db.update(BancoHelper.TABELA2, valores,where,null);
        db.close();
        return retorno;
    }
    
    public List<ColaboradorBean> listarColaboradores() {
        List<ColaboradorBean> colaboradores = new ArrayList<ColaboradorBean>();
        String selectQuery = "SELECT * FROM COLABORADORES" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ColaboradorBean col = new ColaboradorBean();
                col.setId(""+cursor.getInt(0));
                col.setNome(cursor.getString(1));
                col.setTipo(cursor.getString(2));
                colaboradores.add(col);
            } while (cursor.moveToNext());
        }
        return colaboradores;
    }
    
    public List<ColaboradorBean> listarColaboradores(ColaboradorBean colEnt) {
        List<ColaboradorBean> colaboradores = new ArrayList<ColaboradorBean>();
        String parametro = colEnt.getTipo()  ;
        /*String where = "TIPO LIKE ?";
        String[] whereArgs = new String[] { "'%" + parametro + "%'" };
        String[] query = {"ID, NOME, TIPO"};
        String table = "COLABORADORES";*/
        String selectQuery = "SELECT ID, NOME, TIPO FROM COLABORADORES WHERE TIPO LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        //Cursor cursor = db.query(true, table, query, null, whereArgs, where, null, null, null);
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                ColaboradorBean col = new ColaboradorBean();
                col.setId(""+cursor.getInt(0));
                col.setNome(cursor.getString(1));
                col.setTipo(cursor.getString(2));
                colaboradores.add(col);
            } while (cursor.moveToNext());
        }
        return colaboradores;
    }
}
