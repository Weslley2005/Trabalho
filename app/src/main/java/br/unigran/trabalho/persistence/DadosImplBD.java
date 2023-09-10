package br.unigran.trabalho.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.unigran.trabalho.model.Dados;


public class DadosImplBD implements DadosDAO{
    DBHelper db;
    @Override
    public void salvar(Dados d) {
        ContentValues dados = new ContentValues();
        dados.put("titulo",d.getTitulo());
        dados.put("descricao",d.getDescricao());
        dados.put("ctarefa",d.getCtarefa());
        db.getWritableDatabase().insertOrThrow("dados",null,dados);
        db.close();
    }
    @Override
    public void editar(Dados d) {
        ContentValues dados = new ContentValues();
        dados.put("titulo",d.getTitulo());
        dados.put("descricao",d.getDescricao());
        dados.put("ctarefa",d.getCtarefa());
        db.getWritableDatabase().
                update("dados",dados,"id=?",new String[]{d.getId()+""});
        db.close();


    }

    @Override
    public void remove(Dados d) {
        db.getWritableDatabase()
                .delete("dados","id=?",new String[]{d.getId()+""} );
        db.close();

    }

    public DadosImplBD(Context context){
        this.db=new DBHelper(context);
    }



    @Override
    public List listagem() {
        List retorno = new ArrayList();
        String colunas[]= {"id","titulo","descricao","ctarefa"};
        Cursor cursor = db.getReadableDatabase().
                query("dados", colunas, null,
                        null, null, null, "titulo"
                );

        final int COLUMN_ID=0, COLUMN_NOME=1, COLUMN_DES=2, COLUMN_CTA = 3;
        while (cursor.moveToNext()){
            Dados d = new Dados();
            d.setId(cursor.getInt(COLUMN_ID));
            d.setTitulo(cursor.getString(COLUMN_NOME));
            d.setDescricao(cursor.getString(COLUMN_DES));
            d.setCtarefa(cursor.getString(COLUMN_CTA));
            retorno.add(d);
        }
        db.close();

        return retorno;
    }
}
