package br.unigran.trabalho.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "dbAtividade", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuffer sql = new StringBuffer();
        sql.append("create table dados(" +
                "id integer primary key," +
                "titulo varchar(100)," +
                "descricao varchar(300)," +
                "ctarefa varchar(50)" +
                ");");

        sqLiteDatabase.execSQL(sql.toString());
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}