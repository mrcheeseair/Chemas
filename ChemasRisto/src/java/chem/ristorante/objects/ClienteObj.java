package chem.ristorante.objects;

public class ClienteObj 
{
    private int m_iId;
    private String m_strNombre;
    private String m_strApellido;
    private String m_strDui;

    public ClienteObj(int p_iId, String p_strNombre, String p_strApellido, String p_strDui) 
    {
        setId(p_iId);
        setNombre(p_strNombre);
        setApellido(p_strApellido);
        setDui(p_strDui);
    }

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public String getNombre() {
        return m_strNombre;
    }

    private void setNombre(String p_strNombre) {
        m_strNombre = p_strNombre;
    }

    public String getApellido() {
        return m_strApellido;
    }

    private void setApellido(String p_strApellido) {
        m_strApellido = p_strApellido;
    }
    
     public String getDui() {
        return m_strDui;
    }

    private void setDui(String p_strDui) {
        m_strDui = p_strDui;
    }

   

   

    
    
}
