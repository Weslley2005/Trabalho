package br.unigran.trabalho.persistence;

import java.util.ArrayList;
import java.util.List;

import br.unigran.trabalho.model.Dados;


public class DadosImpl  implements DadosDAO{

    private List lista;
    public DadosImpl(){
        lista = new ArrayList();
    }
    @Override
    public void salvar(Dados d){
        lista.add(d);
    }

    @Override
    public void editar(Dados d){
        if(lista.contains(d)){
            lista.add(lista.indexOf(d),d);
        }
    }

    @Override
    public void remove(Dados d) {
        lista.remove(d);
    }

    @Override
    public List listagem(){
        return  lista;
    }
}
