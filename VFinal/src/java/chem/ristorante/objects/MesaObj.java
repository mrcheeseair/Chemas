package chem.ristorante.objects;

public class MesaObj 
{
    private int m_iId;
    private int m_iEstado;
    

    public MesaObj(int p_iId, int p_iEstado) 
    {
        setId(p_iId);
        setEstado(p_iEstado);
       
    }

    public MesaObj(int iEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() 
    {
        return m_iId;
    }

    private void setId(int p_iId) 
    {
        m_iId = p_iId;
    }
    public int getEstado() 
    {
        return m_iEstado;
    }

    private void setEstado(int p_iEstado) 
    {
        m_iEstado = p_iEstado;
    }

    

   
    
}
