const ordenarLista = require('./ordenarLista');

test('Ordenação crescente', () => {
    let lista = [5, 3, 9, 1, 7];
    let listaOrdenada = ordenarLista(lista);
    expect(listaOrdenada).toEqual([1, 3, 5, 7, 9]);
});

test('Ordenação decrescente', () => {
    let lista = [8, 2, 6, 4, 0];
    let listaOrdenada = ordenarLista(lista, 'decrescente');
    expect(listaOrdenada).toEqual([8, 6, 4, 2, 0]);
});

test('Ordem inválida deve gerar erro', () => {
    expect(() => ordenarLista([1, 2, 3], 'invalida')).toThrowError("A ordem deve ser 'crescente' ou 'decrescente'.");
});
