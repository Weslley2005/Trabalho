function ordenarLista(lista, ordem = 'crescente') {
    if (ordem.toLowerCase() === 'crescente') {
        return lista.sort((a, b) => a - b);
    } else if (ordem.toLowerCase() === 'decrescente') {
        return lista.sort((a, b) => b - a);
    } else {
        throw new Error("A ordem deve ser 'crescente' ou 'decrescente'.");
    }
}

module.exports = ordenarLista;
