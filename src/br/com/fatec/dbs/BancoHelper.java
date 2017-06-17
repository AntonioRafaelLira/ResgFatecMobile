/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author ProfAlexandre
 */
public class BancoHelper extends SQLiteOpenHelper{
    
    private static final String NOME_BANCO = "RESGATFATEC.db";
    public static final String TABELA = "USUARIOS";
    public static final String TABELA2 = "COLABORADORES";
    public static final String TABELA3 = "CONTATOS";

    private static final int VERSAO_SCHEMA = 1;
    private final String S_CREATE;
    private final String S_CREATE2;
    private final String S_CREATE3;

    public BancoHelper(Context context) {
	super(context, NOME_BANCO, null, VERSAO_SCHEMA);		
        this.S_CREATE = "CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,LOGIN TEXT,SENHA TEXT,STATUS TEXT,TIPO TEXT);";
        this.S_CREATE2 = "CREATE TABLE COLABORADORES (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,TIPO TEXT);";
        this.S_CREATE3 = "CREATE TABLE CONTATOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,RG TEXT,CPF TEXT,END TEXT);";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
	db.execSQL(S_CREATE);
        db.execSQL(S_CREATE2);
        db.execSQL(S_CREATE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA2);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA3);
        onCreate(db);
    }
    
}
