const validarNumeroCartaoCredito = require('./validaCartao');

test('Número de cartão de crédito válido', () => {
    expect(validarNumeroCartaoCredito('4539 1488 0343 6467')).toBe(true);
});

test('Número de cartão de crédito inválido', () => {
    expect(validarNumeroCartaoCredito('4539 1488 0343 6466')).toBe(false);
});

test('Número de cartão de crédito com menos de dois dígitos', () => {
    expect(validarNumeroCartaoCredito('4')).toBe(false);
});

test('Número de cartão de crédito com caracteres não numéricos', () => {
    expect(validarNumeroCartaoCredito('4539-1488-0343-6467')).toBe(true);
});
