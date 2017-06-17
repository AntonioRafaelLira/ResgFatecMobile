package br.com.fatec.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.fatec.modelos.ContatoBean;
import java.util.ArrayList;
import java.util.List;

public class BancoContato {
    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;
    
    public BancoContato(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }
    
    public String inserir(ContatoBean con) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", con.getNome());
        valores.put("RG", con.getRg());
        valores.put("CPF", con.getCpf());
        valores.put("END", con.getEnd());
        resultado = db.insert(BancoHelper.TABELA3, null, valores);
        db.close();
        
        if (resultado == -1) {
           retorno = "Erro ao inserir registro";
        } else {
           retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }
    
    public String excluir(ContatoBean con) {
        String retorno = "Registro Excluido com Sucesso";
        String where = "ID = " + con.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA3,where,null);
        db.close();
        return retorno;
    }
    
    public String alterar(ContatoBean con) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + con.getId();
        valores = new ContentValues();
        valores.put("NOME", con.getNome());
        valores.put("RG", con.getRg());
        valores.put("CPF", con.getCpf());
        valores.put("END", con.getEnd());
        db.update(BancoHelper.TABELA3, valores,where,null);
        db.close();
        return retorno;
    }
    
    public List<ContatoBean> listarContatos() {
        List<ContatoBean> contatos = new ArrayList<ContatoBean>();
        String selectQuery = "SELECT * FROM CONTATOS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ContatoBean con = new ContatoBean();
                con.setId(""+cursor.getInt(0));
                con.setNome(cursor.getString(1));
                con.setRg(cursor.getString(2));
                con.setCpf(cursor.getString(3));
                con.setEnd(cursor.getString(4));
                contatos.add(con);
            } while (cursor.moveToNext());
        }
        return contatos;
    }
    
    public List<ContatoBean> listarContatos(ContatoBean conEnt) {
        List<ContatoBean> contatos = new ArrayList<ContatoBean>();
        String parametro = conEnt.getNome()  ;
        /*String where = "NOME LIKE ?";
        String[] whereArgs = new String[] { "'%" + parametro + "%'" };
        String[] query = {"ID, NOME, RG, CPF, END"};
        String table = "CONTATOS";*/
        String selectQuery = "SELECT ID, NOME, RG, CPF, END FROM CONTATOS WHERE NOME LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        //Cursor cursor = db.query(true, table, query, null, whereArgs, where, null, null, null);
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                ContatoBean con = new ContatoBean();
                con.setId(""+cursor.getInt(0));
                con.setNome(cursor.getString(1));
                con.setRg(cursor.getString(2));
                con.setCpf(cursor.getString(3));
                con.setEnd(cursor.getString(4));
                contatos.add(con);
            } while (cursor.moveToNext());
        }
        return contatos;
    }
}
