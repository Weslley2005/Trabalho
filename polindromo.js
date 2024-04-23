function polindromo(palavra){
    palavra = palavra.toLowerCase().replace(/[^A-Za-z0-9]/g, '');
    for(i=0;i<palavra.length/2;i++){
        if(palavra[i] !== palavra[palavra.length - 1 - i]){
            return false;
        }
    }
    return true

}
module.exports = {polindromo};