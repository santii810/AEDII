
package solactividad6.ejercicio2;


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
