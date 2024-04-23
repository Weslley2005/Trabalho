const soma = require('./soma.js')

test ('A soma esta correta', ()=>{
    expect(soma.soma(1,2)).toBe(3)
})
test ('A soma esta correta', ()=>{
    expect(soma.sub(3,2)).toBe(1)
})
test ('A soma esta correta', ()=>{
    expect(soma.dividir(4,2)).toBe(2)
})
test ('A soma esta correta', ()=>{
    expect(soma.mult(1,2)).toBe(2)
})
