package parqueDeAtracciones;

import java.util.Comparator;

public class OrdenOfertable implements Comparator <Ofertable>  {
	TipoDeAtraccion atraccionFavorita;
	
	public OrdenOfertable(TipoDeAtraccion atraccionFavorita) {
		this.atraccionFavorita = atraccionFavorita;
	}
	
	@Override
	public int compare(Ofertable o1, Ofertable o2) {
		//Prioridad atracción favorita
		if(o1.getTipoDeAtraccion() == atraccionFavorita && o2.getTipoDeAtraccion() != atraccionFavorita) {
			return 1;
		} else if (o1.getTipoDeAtraccion() != atraccionFavorita && o2.getTipoDeAtraccion() == atraccionFavorita) {
			return -1;
		}
		
		//Prioridad Promoción
		if(o1.esPromocion() && !o2.esPromocion()) {
			return 1;
		} else if (!o1.esPromocion() && o2.esPromocion()) {
			return -1;
		}
		
		//Prioridad por oro
		
		//Prioridad por tiempo
		return (int) (o1.getDuracion() - o2.getDuracion());
	}
}
