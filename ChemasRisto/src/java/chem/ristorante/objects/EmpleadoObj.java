package chem.ristorante.objects;

public class EmpleadoObj 
{
    private int m_iId;
    private String m_strName;
    private String m_strApellido;
    private String m_strFechaNac;
    private String m_strSexo;
    private String m_strEmail;
    private String m_strDUI;
    private String m_strUsuario;
    private String m_strContrasenia;

    public EmpleadoObj(int p_iId, String p_strName, String p_strApellido, String p_strFechaNac, String p_strSexo, String p_strEmail, String p_strDUI, String p_strUsuario, String p_strContrasenia) 
    {
        setId(p_iId);
        setName(p_strName);
        setApellido(p_strApellido);
        setFechaNac(p_strFechaNac);
        setSexo(p_strSexo);
        setEmail(p_strEmail);
        setDUI(p_strDUI);
        setUsuario(p_strUsuario);
        setContrasenia(p_strContrasenia);
    }
    
    public EmpleadoObj(String p_strContrasenia){
        setContrasenia(p_strContrasenia);
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

    public String getApellido() 
    {
        return m_strApellido;
    }

    private void setApellido(String p_strApellido) 
    {
        m_strApellido = p_strApellido;
    }
    
    public String getFechaNac() 
    {
        return m_strFechaNac;
    }

    private void setFechaNac(String p_strFechaNac) 
    {
        m_strFechaNac = p_strFechaNac;
    }
    
    public String getSexo() 
    {
        return m_strSexo;
    }

    private void setSexo(String p_strSexo) 
    {
        m_strSexo = p_strSexo;
    }
    
    public String getEmail() 
    {
        return m_strEmail;
    }

    private void setEmail(String p_strEmail) 
    {
        m_strEmail = p_strEmail;
    }
    
    public String getDUI() 
    {
        return m_strDUI;
    }

    private void setDUI(String p_strDUI) 
    {
        m_strDUI = p_strDUI;
    }
    
    public String getUsuario() 
    {
        return m_strUsuario;
    }

    private void setUsuario(String p_strUsuario) 
    {
        m_strUsuario = p_strUsuario;
    }
    
    public String getContrasenia() 
    {
        return m_strContrasenia;
    }

    private void setContrasenia(String p_strContrasenia) 
    {
        m_strContrasenia = p_strContrasenia;
    }
    
}
