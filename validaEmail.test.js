const validaEmail = require('./validaEmail');

test('E-mail válido deve retornar true', () => {
    expect(validaEmail('weslley@gmail.com')).toBe(true);
});

test('E-mail inválido deve retornar false', () => {
    expect(validaEmail('email_invalido')).toBe(false);
});
