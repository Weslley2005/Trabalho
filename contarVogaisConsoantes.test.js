const contarVogaisConsoantes = require('./contarVogaisConsoantes');

test('Contagem de vogais e consoantes em uma string', () => {
    const resultado = contarVogaisConsoantes('Hello World!');
    expect(resultado).toEqual({ vogais: 3, consoantes: 7 });
});

test('Contagem de vogais e consoantes em uma string vazia', () => {
    const resultado = contarVogaisConsoantes('');
    expect(resultado).toEqual({ vogais: 0, consoantes: 0 });
});
