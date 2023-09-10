package br.unigran.trabalho.persistence;

import java.util.List;

import br.unigran.trabalho.model.Dados;


public interface DadosDAO {
    public void salvar(Dados d);

    public void editar(Dados d);
    public void remove(Dados d);
    public List listagem();
}
