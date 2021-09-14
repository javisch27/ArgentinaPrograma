package parqueDeAtracciones;

import java.util.Comparator;

public class OrdenOfertable implements Comparator<Ofertable> {
	TipoDeAtraccion atraccionFavorita;

	public OrdenOfertable(TipoDeAtraccion atraccionFavorita) {
		this.atraccionFavorita = atraccionFavorita;
	}

	@Override
	public int compare(Ofertable o1, Ofertable o2) {
		// Prioridad atracción favorita
		if (o1.getTipoDeAtraccion() == this.atraccionFavorita && o2.getTipoDeAtraccion() != this.atraccionFavorita) {
			return -1;
		} else if (o1.getTipoDeAtraccion() != this.atraccionFavorita
				&& o2.getTipoDeAtraccion() == this.atraccionFavorita) {
			return 1;
		}
		// Prioridad Promoción
		if (o1.esPromocion() && !o2.esPromocion()) {
			return -1;
		}else if (!o1.esPromocion() && o2.esPromocion()) {
			return 1;
		}
		// Prioridad por oro
		if (o1.getCosto() > o2.getCosto()) {
			return -1;
		} else if (o1.getCosto() < o2.getCosto()) {
			return 1;
		}
		// Prioridad por tiempo
		if (o1.getDuracion() > o2.getDuracion()) {
			return -1;
		} else if (o1.getDuracion() < o2.getDuracion()) {
			return 1;
		}
		return 0;
	}
}