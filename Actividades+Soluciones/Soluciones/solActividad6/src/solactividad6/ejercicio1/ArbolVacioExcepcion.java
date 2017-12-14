
package solactividad6.ejercicio1;

public class ArbolVacioExcepcion extends RuntimeException
{
    public ArbolVacioExcepcion()
    {
        super();
    }
    
    public ArbolVacioExcepcion(String mensaje)
    {
        super(mensaje);
    }
}
