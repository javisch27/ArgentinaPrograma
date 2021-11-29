function parsearNumero(entrada) {
	// Si la entrada no es un string, devolver vacio
	if (typeof entrada != typeof "") {
		return "";
	}
	let coma = false;
	for (let i = 0; i < entrada.length; i++) {
		let caracter = entrada[i];
		if (caracter === ",") {
			if (coma) {
				return "";
			} else {
				coma = true;
			}
		} else if (caracter.charCodeAt() < 48 || caracter.charCodeAt() > 57) {
			return "";
		}
	}
	return mitrim(entrada, 0);
}

console.log(parsearNumero("00,45"));

/*const boton = document.querySelector("#fede2");

boton.addEventListener("click", function() {
	const resultado = parsearNumero(document.querySelector('#fede').value);
	alert(resultado ? resultado : "ERROR");
})*/