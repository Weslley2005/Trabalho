package br.unigran.trabalho;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

import javax.net.ssl.SSLEngineResult;

import br.unigran.trabalho.model.Dados;
import br.unigran.trabalho.persistence.DadosDAO;
import br.unigran.trabalho.persistence.DadosImplBD;

public class MainActivity extends AppCompatActivity {
    private TextView titulo;
    private TextView descricao;
    private TextView msg;
    private Button botao;
    private ListView listagem;
    private List<Dados> dados;
    private DadosDAO dao;
    private Dados d ;
    private TextView ctarefa;
    private boolean Concluir = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mapeamentoXML();
        consulta();
        vinculaAdapterALista();
        acoes();

    }

    private void mapeamentoXML(){
        setContentView(R.layout.activity_main);

        titulo=findViewById(R.id.idTitulo);
        descricao = findViewById(R.id.idDescricao);
        ctarefa = findViewById(R.id.idCtarefa);

        botao=findViewById(R.id.idOk);
        listagem=findViewById(R.id.idListagem);


        Button buttonConcluir = findViewById(R.id.idConcluir);

        buttonConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Concluir) {
                    ctarefa.setText("Tarefa Concluída:)");
                    Concluir = true;
                } else {

                }
            }
        });
    }


    private void consulta(){
        if(dao==null)
            dao= new DadosImplBD(this);
        dados=dao.listagem();
    }

    private void vinculaAdapterALista() {

        listagem.setAdapter(
                new ArrayAdapter(getApplicationContext(),
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        dados)
        );
    }


    private void acoes() {
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(titulo.getText().toString().isEmpty())
                    titulo.setError("ERRO! Adicionar Titulo");

                if(descricao.getText().toString().isEmpty())
                    descricao.setError("ERRO! Adicionar Descrição");

                if(d==null)
                    d = new Dados();
                d.setTitulo(titulo.getText().toString());
                d.setDescricao(descricao.getText().toString());
                d.setCtarefa(ctarefa.getText().toString());
                if(d.getId()==null)
                    dao.salvar(d);
                else dao.editar(d);
                limpaCampos();
                atualizaDados();
            }
        });

        listagem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int indice, long l) {
                new  AlertDialog.Builder(listagem.getContext())
                        .setTitle("Realmente deseja excluir")
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).
                        setNeutralButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dao.remove(dados.get(indice));
                                atualizaDados();
                            }
                        })
                        .create().show();

                return false;
            }
        });

        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                d=dados.get(i);
                titulo.setText(d.getTitulo());
                descricao.setText(d.getDescricao());
                ctarefa.setText(d.getCtarefa());
            }
        });
    }

    private void atualizaDados() {
        dados.clear();
        dados.addAll(dao.listagem());
        ((ArrayAdapter) listagem.getAdapter()
        ).notifyDataSetChanged();
    }

    private void limpaCampos() {
        titulo.setText("");
        descricao.setText("");
        ctarefa.setText("");
        d=null;
    }

    public void cancelar(View view){
        AlertDialog.Builder acao = new AlertDialog.Builder(this);
        acao.setTitle("Você quer sair");
        acao.setItems(new CharSequence[]{"Sair"},new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        acao.create().show();
    }
}