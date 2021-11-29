package auto;

import java.io.*;

public abstract class ManejadorArchivos {

	public static Auto[] obtenerAutosDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Auto[] autos = null;

		try {
			archivo = new File("entrada/autos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			autos = new Auto[cantidad];
			int indice = 0;

			String linea = br.readLine();
			while (linea != null) {
				String[] datosAutos = linea.split(",");
				String marca = datosAutos[0];
				int costo = Integer.parseInt(datosAutos[1]);
				int km = Integer.parseInt(datosAutos[2]);
				autos[indice++] = new Auto(marca, costo, km);
				linea = br.readLine();
			}

			return autos;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return autos;
	}

	public static Promo[] obtenerPromosDesdeArchivo(Concesionaria concesionaria) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Promo[] promos = null;

		try {
			archivo = new File("entrada/promos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			promos = new Promo[cantidad];
			int indice = 0;

			String linea = br.readLine();
			while (linea != null) {
				String[] datosPromos = linea.split(",");
				String nombre = datosPromos[0];
				int costo = Integer.parseInt(datosPromos[1]);

				String[] autosString = datosPromos[2].split(";");
				Auto[] autos = new Auto[autosString.length];
				for (int i = 0; i < autosString.length; i++) {
					autos[i] = concesionaria.obtenerAutoPorMarca(autosString[i]);
				}

				promos[indice++] = new Promo(nombre, costo, autos);
				linea = br.readLine();
			}

			return promos;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return promos;
	}

}
