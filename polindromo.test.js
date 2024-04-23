const polindromo = require('./polindromo.js')

test ('É um plindromo', ()=>{
    expect(polindromo.polindromo("race car")).toBe(true)
})