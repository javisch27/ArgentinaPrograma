package app;

import imperio.Arquero;
import imperio.Caballero;
import imperio.Posicion;
import imperio.Soldado;

public class App {

	public static void main(String[] args) {
		
	Posicion p1 = new Posicion(0, 0);
	Arquero u1 = new Arquero(p1);
	Posicion p2 = new Posicion(5, 5);
	Soldado u2 = new Soldado(p2);
	u1.atacar(u2);
	Posicion p3 = new Posicion(6, 6);
	Caballero u3 = new Caballero(p3);
	u2.atacar(u3);
	System.out.println(u2.getSalud());
	System.out.println(u3.getSalud());
	u3.atacar(u2);
	System.out.println(u2.getSalud());
	System.out.println(u1.getCantidadFlechas());
	u1.atacar(u3);
	System.out.println(u1.getCantidadFlechas());
	u1.recargarFlechas();
	System.out.println(u1.getCantidadFlechas());
	}
}
