function validarNumeroCartaoCredito(numeroCartao) {
    const numeroLimpo = numeroCartao.replace(/\D/g, '');

    if (numeroLimpo.length < 2) {
        return false;
    }

    const numeroInvertido = numeroLimpo.split('').reverse().join('');

    let soma = 0;
    for (let i = 0; i < numeroInvertido.length; i++) {
        let digito = parseInt(numeroInvertido[i], 10);

        if (i % 2 !== 0) {
            digito *= 2;
            if (digito > 9) {
                digito -= 9;
            }
        }

        soma += digito;
    }

    return soma % 10 === 0;
}

module.exports = validarNumeroCartaoCredito;
