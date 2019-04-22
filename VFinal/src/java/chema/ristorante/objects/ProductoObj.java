package chema.ristorante.objects;

public class ProductoObj 
{
    private int m_iId;
    private int m_iIdCategoria;
    private String m_strNombre;
    private double m_dPrecio;
    private String m_strDescripcion;

    public ProductoObj(int p_iId, int p_iIdCategoria, String p_strNombre, double p_dPrecio, String p_strDescripcion) {
        setId(p_iId);
        setIdCategoria(p_iIdCategoria);
        setNombre(p_strNombre);
        setPrecio(p_dPrecio);
        setDescripcion(p_strDescripcion);
        
    }

    

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getIdCategoria() {
        return m_iIdCategoria;
    }

    private void setIdCategoria(int p_iIdCategoria) {
        m_iIdCategoria = p_iIdCategoria;
    }

    public String getNombre() {
        return m_strNombre;
    }

    private void setNombre(String p_strNombre) {
        m_strNombre = p_strNombre;
    }

    public double getPrecio() {
        return m_dPrecio;
    }

    private void setPrecio(double p_dPrecio) {
        m_dPrecio = p_dPrecio;
    }

    public String getDescripcion() {
        return m_strDescripcion;
    }

    private void setDescripcion(String p_strDescripcion) {
        m_strDescripcion = p_strDescripcion;
    }

    
    
}
