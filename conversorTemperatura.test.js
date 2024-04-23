const conversorTemperatura = require('./conversorTemperatura.js')

test ('Temperatura convertida', ()=>{
    expect(conversorTemperatura.celsiusParaFahrenheit(35)).toBe(95)
})
test ('Temperatura convertida', ()=>{
    expect(conversorTemperatura.fahrenheitParaCelsius(95)).toBe(35)
})