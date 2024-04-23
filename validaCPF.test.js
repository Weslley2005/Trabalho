const validaCPF = require('./validaCPF.js')

test('CPF Valido', () => {
    expect(validaCPF.validaCPF('11144477735')).toBe(true);
  });