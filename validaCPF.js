function validaCPF(cpf) {
    cpf = String(cpf).replace(/[^\d]+/g, ''); // Converte para string e remove caracteres não numéricos
    if (cpf.length !== 11 || !!cpf.match(/(\d)\1{10}/)) {
      return false; // Verifica o tamanho e sequências iguais
    }
  
    let soma;
    let resto;
    soma = 0;
  
    // Validação do primeiro dígito verificador
    for (let i = 1; i <= 9; i++) {
      soma += parseInt(cpf.substring(i - 1, i)) * (11 - i);
    }
    resto = (soma * 10) % 11;
    if ((resto === 10) || (resto === 11)) {
      resto = 0;
    }
    if (resto !== parseInt(cpf.substring(9, 10))) {
      return false;
    }
  
    soma = 0;
    // Validação do segundo dígito verificador
    for (let i = 1; i <= 10; i++) {
      soma += parseInt(cpf.substring(i - 1, i)) * (12 - i);
    }
    resto = (soma * 10) % 11;
    if ((resto === 10) || (resto === 11)) {
      resto = 0;
    }
    if (resto !== parseInt(cpf.substring(10, 11))) {
      return false;
    }
  
    return true; // O CPF é válido
  }

  module.exports = {validaCPF};