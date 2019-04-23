package chem.ristorante.objects;

public class DetalleObj 
{
    private int m_iId;
    private int m_iOrdenId;
    private int m_iProductoId;
    private int m_iCantidad;
    

    public DetalleObj(int p_iId, int p_iOrdenId, int p_iProductoId, int p_iCantidad) 
    {
        setId(p_iId);
        setOrdenId(p_iOrdenId);
        setProductoId(p_iProductoId);
        setCantidad(p_iCantidad);
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public int getOrdenId() 
    {
        return m_iOrdenId;
    }

    private void setOrdenId(int p_iOrdenId) 
    {
        m_iOrdenId = p_iOrdenId;
    }

    public int getProductoId() 
    {
        return m_iProductoId;
    }

    private void setProductoId(int p_iProductoId) 
    {
        m_iProductoId = p_iProductoId;
    }
    
    public int getCantidad() 
    {
        return m_iCantidad;
    }

    private void setCantidad(int p_iCantidad) 
    {
        m_iCantidad = p_iCantidad;
    }
    
}
