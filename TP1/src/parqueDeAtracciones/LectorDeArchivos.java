package parqueDeAtracciones;

import java.io.*;

public abstract class LectorDeArchivos {

	public static Atraccion[] obtenerAtraccionesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Atraccion[] atracciones = null;

		try {
			archivo = new File("entrada/Atracciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			atracciones = new Atraccion[cantidad];
			int indice = 0;

			String linea = br.readLine();
			while (linea != null) {
				String[] datosAtracciones = linea.split(",");
				String nombre = datosAtracciones[0];
				int costo = Integer.parseInt(datosAtracciones[1]);
				double duracion = Double.parseDouble(datosAtracciones[2]);
				int cupo = Integer.parseInt(datosAtracciones[3]);
				String tipoDeAtraccion = datosAtracciones[4];
				atracciones[indice++] = new Atraccion(nombre, costo, duracion, cupo,
						TipoDeAtraccion.valueOf(tipoDeAtraccion.toUpperCase()));
				linea = br.readLine();
			}

			return atracciones;

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

		return atracciones;
	}

	public static Usuario[] obtenerUsuariosDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Usuario[] usuarios = null;

		try {
			archivo = new File("entrada/Usuarios.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			usuarios = new Usuario[cantidad];
			int indice = 0;

			String linea = br.readLine();
			while (linea != null) {
				String[] datosUsuarios = linea.split(",");
				String nombre = datosUsuarios[0];
				String preferencia = datosUsuarios[1];
				int presupuestoInicial = Integer.parseInt(datosUsuarios[2]);
				double tiempoInicial = Double.parseDouble(datosUsuarios[3]);
				usuarios[indice++] = new Usuario(nombre, TipoDeAtraccion.valueOf(preferencia.toUpperCase()),
						presupuestoInicial, tiempoInicial);
				linea = br.readLine();
			}

			return usuarios;

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

		return usuarios;
	}

	public static Promocion[] obtenerPromosDesdeArchivo(ParqueDeAtraccion parqueDeAtraccion) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Promocion[] promociones = null;

		try {
			archivo = new File("entrada/Promociones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			promociones = new Promocion[cantidad];
			int indice = 0;

			String linea = br.readLine();
			while (linea != null) {
				String[] datosPromos = linea.split(";");
				String tipoPromocion = datosPromos[0];
				String nombre = datosPromos[1];

				String[] atraccionesString = datosPromos[2].split(",");
				Atraccion[] atracciones = new Atraccion[atraccionesString.length];
				for (int i = 0; i < atraccionesString.length; i++) {
					atracciones[i] = parqueDeAtraccion.obtenerAtraccionPorNombre(atraccionesString[i]);
				}

				if (tipoPromocion.equals("PromocionPorcentual")) {
					int descuento = Integer.parseInt(datosPromos[3]);
					promociones[indice++] = new PromocionPorcentual(nombre, atracciones, descuento);
				} else if (tipoPromocion.equals("PromocionAbsoluta")) {
					int costo = Integer.parseInt(datosPromos[3]);
					promociones[indice++] = new PromocionAbsoluta(nombre, atracciones, costo);
				} else if (tipoPromocion.equals("PromocionAxB")) {
					Atraccion atraccionGratuita = parqueDeAtraccion.obtenerAtraccionPorNombre(datosPromos[3]);
					promociones[indice++] = new PromocionAxB(nombre, atracciones, atraccionGratuita);
				}

				linea = br.readLine();
			}
			return promociones;

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

		return promociones;
	}
}
