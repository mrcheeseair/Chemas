package chem.ristorante.objects;

public class OrdenObj 
{
    private int m_iId;
    private int m_iPagoId;
    private int m_iEmpleadoId;
    private String m_strFecha;
    private int m_iMesaId;

    public OrdenObj(int p_iId, int p_iPagoId, int p_iEmpleadoId, String p_strFecha, int p_iMesaId) 
    {
        setId(p_iId);
        setPagoId(p_iPagoId);
        setEmpleadoId(p_iEmpleadoId);
        setFecha(p_strFecha);
        setMesaId(p_iMesaId);
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public int getPagoId() 
    {
        return m_iPagoId;
    }

    private void setPagoId(int p_iPagoId) 
    {
        m_iPagoId = p_iPagoId;
    }
    
    public int getEmpleadoId() 
    {
        return m_iEmpleadoId;
    }

    private void setEmpleadoId(int p_iEmpleadoId) 
    {
        m_iEmpleadoId = p_iEmpleadoId;
    }

    public String getFecha() 
    {
        return m_strFecha;
    }

    private void setFecha(String p_strFecha) 
    {
        m_strFecha = p_strFecha;
    }
    
     public int getMesaId() 
    {
        return m_iMesaId;
    }

    private void setMesaId(int p_iMesaId) 
    {
        m_iMesaId = p_iMesaId;
    }
    
}
