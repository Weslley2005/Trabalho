const ehPrimo = require('./numeroPrimo.js')

test('É primo', () => {
    expect(ehPrimo.ehPrimo(1)).toBe(false); 
  })