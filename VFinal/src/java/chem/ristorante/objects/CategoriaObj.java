package chem.ristorante.objects;

public class CategoriaObj 
{
    private int m_iId;
    private String m_strName;
    private String m_strDescripcion;

    public CategoriaObj(int p_iId, String p_strName, String p_strDescripcion) 
    {
        setId(p_iId);
        setName(p_strName);
        setDescripcion(p_strDescripcion);
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }

    public String getName() 
    {
        return m_strName;
    }

    private void setName(String p_strName) 
    {
        m_strName = p_strName;
    }

    public String getDescripcion() 
    {
        return m_strDescripcion;
    }

    private void setDescripcion(String p_strDescripcion) 
    {
        m_strDescripcion = p_strDescripcion;
    }
    
}
