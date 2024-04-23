function validaSenha(senha) {
    const comprimentoMinimo = 8;
    const possuiLetrasMinusculas = /[a-z]/.test(senha);
    const possuiLetrasMaiusculas = /[A-Z]/.test(senha);
    const possuiNumeros = /[0-9]/.test(senha);
    const possuiCaracteresEspeciais = /[^a-zA-Z0-9]/.test(senha);

    if (
        senha.length >= comprimentoMinimo &&
        possuiLetrasMinusculas &&
        possuiLetrasMaiusculas &&
        possuiNumeros &&
        possuiCaracteresEspeciais
    ) {
        return true;
    } else {
        return false;
    }
}

module.exports = validaSenha;
