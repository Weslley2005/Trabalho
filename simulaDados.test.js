const simularLancamentoDados = require('./simulaDados');

test('Lançamento de dados retorna um número entre 1 e 6', () => {
    const resultado = simularLancamentoDados();
    expect(resultado).toBeGreaterThanOrEqual(1);
    expect(resultado).toBeLessThanOrEqual(6);
});

test('Lançamento de dados retorna um número inteiro', () => {
    const resultado = simularLancamentoDados();
    expect(Number.isInteger(resultado)).toBe(true);
});
