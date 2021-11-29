function contarBooleans(entrada){
	let contador = 0;
	let ultimoBoolean = null;
	let maximo = 0;
	for (let i = 0; i < entrada.length; i++){
		if(entrada[i] === ultimoBoolean){
			contador ++;
		} else {
			contador = 1;
		}
		if(contador > maximo){
			maximo = contador;
		}
		ultimoBoolean = entrada[i];
	}
	return maximo;
}

console.log(contarBooleans([true, true, false, true, false, false]));

console.log(contarBooleans([]));

console.log(contarBooleans([true, true, true, true, true, false, true]));