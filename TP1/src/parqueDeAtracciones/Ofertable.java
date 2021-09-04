package parqueDeAtracciones;

public interface Ofertable {
	
	public double getDuracion();
	//Es necesario un método para getTipoDeAtraccion en la interfaz? O sólo en clase Atraccion?
	//No sé como getTipoDeAtraccion en clase Promocion que tiene un array de Atraccion
	public TipoDeAtraccion getTipoDeAtraccion();

	public boolean esPromocion();
	public boolean puedeSerOfertada(Usuario usuario);
}