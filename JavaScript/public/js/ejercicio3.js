function contarAnas(entrada) {
	let contador = 0;
	let posicion = 0;
	for (let i = 0; i < entrada.length; i++) {
		if (entrada.indexOf("ana", posicion) > -1) {
			contador++;
			posicion = entrada.indexOf("ana", posicion) + 1;
		} else {
			return contador;
		}
	}
	return contador;

	/*
	let Paso1FormacionAna = false;
	let Paso2FormacionAna = false;
	let contadorAnas = 0;
	for (let i = 0; i < entrada.length; i++) {
		let caracter = entrada[i];
		if (Paso1FormacionAna) {
			if (Paso2FormacionAna) {
				if (caracter === "a") {
					contadorAnas ++;
					Paso1FormacionAna = false;
					paso2FormacionAna = false;
				}
			}
		}
		if (caracter === "a") {
			paso1FormacionAna = true;
		}else if (caracter === "n") {
			paso2FormacionAna = true;
		} else {
			paso1FormacionAna = false;
			paso2FormacionAna = false;
		}
	}
	return contadorAnas;*/
}

console.log(contarAnas("qwertyanasd"));

console.log(contarAnas("banana y anana son frutas"));

console.log(contarAnas("Anana"));

console.log(contarAnas("El ananá es una fruta que le gusta a ana, pero la banana no les gusta a Ana"));