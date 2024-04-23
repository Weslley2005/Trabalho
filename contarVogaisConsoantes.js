function contarVogaisConsoantes(str) {
    const vogais = str.match(/[aeiou]/gi) || [];
    const consoantes = str.match(/[bcdfghjklmnpqrstvwxyz]/gi) || [];
    return { vogais: vogais.length, consoantes: consoantes.length };
}

module.exports = contarVogaisConsoantes;
