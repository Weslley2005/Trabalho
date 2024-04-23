const validaSenha = require('./validaSenha');

test('Senha válida atende aos critérios de segurança', () => {
    expect(validaSenha('Senha@123')).toBe(true);
});

test('Senha inválida não atende aos critérios de segurança', () => {
    expect(validaSenha('senhafraca')).toBe(false);
});

test('Senha inválida não possui letras maiúsculas', () => {
    expect(validaSenha('senhafraca123')).toBe(false);
});

test('Senha inválida não possui números', () => {
    expect(validaSenha('SenhaForte@')).toBe(false);
});

test('Senha inválida não possui caracteres especiais', () => {
    expect(validaSenha('SenhaForte123')).toBe(false);
});

test('Senha inválida possui comprimento menor que o mínimo', () => {
    expect(validaSenha('S@1')).toBe(false);
});
