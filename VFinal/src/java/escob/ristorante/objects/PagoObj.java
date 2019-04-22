
package escob.ristorante.objects;


public class PagoObj {
    private int m_iId;
    private int m_iClienteId;
    private String m_strTipo;
    private int m_iNumero;

    public PagoObj(int p_iId, int p_iClienteId, String p_strTipo, int p_iNumero) {
        setId(p_iId);
        setClienteId(p_iClienteId);
        setNumero(p_iNumero);
        setTipo(p_strTipo);
    }

    public int getId() {
        return m_iId;
    }

    private void setId(int p_iId) {
        m_iId = p_iId;
    }

    public int getClienteId() {
        return m_iClienteId;
    }

    private void setClienteId(int p_iClienteId) {
        m_iClienteId = p_iClienteId;
    }

    public String getTipo() {
        return m_strTipo;
    }

    private void setTipo(String p_strTipo) {
        m_strTipo = p_strTipo;
    }

    public int getNumero() {
        return m_iNumero;
    }

    private void setNumero(int p_iNumero) {
        m_iNumero = p_iNumero;
    }
    
}
