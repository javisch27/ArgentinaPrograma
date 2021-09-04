package parqueDeAtracciones;

public interface Ofertable {
	
	public double getDuracion();
	//Es necesario un m�todo para getTipoDeAtraccion en la interfaz? O s�lo en clase Atraccion?
	//No s� como getTipoDeAtraccion en clase Promocion que tiene un array de Atraccion
	public TipoDeAtraccion getTipoDeAtraccion();

	public boolean esPromocion();
	public boolean puedeSerOfertada(Usuario usuario);
}