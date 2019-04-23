
package chem.ristorante.objects;
public class DetalleProductoJoinObj 
{

    private int m_iIdDetalle;
    private int m_iOrdenId;
    private int m_iIdProducto;
    private int m_iCantidad;
    private int m_iIdProductoT2;
    private int m_iIdCategoria;
    private String m_strNombreProd;
    private double m_dPrecioProd;
    private String m_strDesc;

    public DetalleProductoJoinObj(int m_iIdDetalle, int m_iOrdenId, int m_iIdProducto, int m_iCantidad, int m_iIdProductoT2, int m_iIdCategoria, String m_strNombreProd, double m_dPrecioProd, String m_strDesc) {
        this.m_iIdDetalle = m_iIdDetalle;
        this.m_iOrdenId = m_iOrdenId;
        this.m_iIdProducto = m_iIdProducto;
        this.m_iCantidad = m_iCantidad;
        this.m_iIdProductoT2 = m_iIdProductoT2;
        this.m_iIdCategoria = m_iIdCategoria;
        this.m_strNombreProd = m_strNombreProd;
        this.m_dPrecioProd = m_dPrecioProd;
        this.m_strDesc = m_strDesc;
    }

    public int getM_iIdDetalle() {
        return m_iIdDetalle;
    }

    public void setM_iIdDetalle(int m_iIdDetalle) {
        this.m_iIdDetalle = m_iIdDetalle;
    }

    public int getM_iOrdenId() {
        return m_iOrdenId;
    }

    public void setM_iOrdenId(int m_iOrdenId) {
        this.m_iOrdenId = m_iOrdenId;
    }

    public int getM_iIdProducto() {
        return m_iIdProducto;
    }

    public void setM_iIdProducto(int m_iIdProducto) {
        this.m_iIdProducto = m_iIdProducto;
    }

    public int getM_iCantidad() {
        return m_iCantidad;
    }

    public void setM_iCantidad(int m_iCantidad) {
        this.m_iCantidad = m_iCantidad;
    }

    public int getM_iIdProductoT2() {
        return m_iIdProductoT2;
    }

    public void setM_iIdProductoT2(int m_iIdProductoT2) {
        this.m_iIdProductoT2 = m_iIdProductoT2;
    }

    public int getM_iIdCategoria() {
        return m_iIdCategoria;
    }

    public void setM_iIdCategoria(int m_iIdCategoria) {
        this.m_iIdCategoria = m_iIdCategoria;
    }

    public String getM_strNombreProd() {
        return m_strNombreProd;
    }

    public void setM_strNombreProd(String m_strNombreProd) {
        this.m_strNombreProd = m_strNombreProd;
    }

    public double getM_dPrecioProd() {
        return m_dPrecioProd;
    }

    public void setM_dPrecioProd(double m_dPrecioProd) {
        this.m_dPrecioProd = m_dPrecioProd;
    }

    public String getM_strDesc() {
        return m_strDesc;
    }

    public void setM_strDesc(String m_strDesc) {
        this.m_strDesc = m_strDesc;
    }
    
    
    
    
}
