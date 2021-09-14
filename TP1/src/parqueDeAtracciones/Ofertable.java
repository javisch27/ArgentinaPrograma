package parqueDeAtracciones;

public interface Ofertable {
	
	public double getDuracion();
	public TipoDeAtraccion getTipoDeAtraccion();
	public int getCosto();

	public boolean esPromocion();
	public boolean puedeSerOfertada(Usuario usuario);
	
	public void restarCupo();
}