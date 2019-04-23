
package chem.ristorante.objects;

public class ProductoDetalleOrdenMesaJoinObj {
    private int m_iProductoId;
    private int m_iCategoriaId;
    private String m_strNombre;
    private double m_dPrecio;
    private String m_strDescripcion;
    
    private int m_iDetalleId;
    private int m_iOrdenId;
    private int m_iProductIdT2;
    private int m_iCantidad;
    private int m_iOrdenIdT2;
    private int m_iPagoId;
    private int m_iEmpleadoId;
    private String m_strFecha;
    private int m_iMesaId;
    private int m_iMesaIdT2;
    private int m_iEstado;


    public ProductoDetalleOrdenMesaJoinObj(int m_iProductoId, int m_iCategoriaId, String m_strNombre, double m_dPrecio, String m_strDescripcion ,int m_iDetalleId, int m_iOrdenId, int m_iProductIdT2, int m_iCantidad, int m_iOrdenIdT2, int m_iPagoId, int m_iEmpleadoId, String m_strFecha, int m_iMesaId,int m_iMesaIdT2, int m_iEstado) {
        this.m_iProductoId = m_iProductoId;
        this.m_iCategoriaId = m_iCategoriaId;
        this.m_strNombre = m_strNombre;
        this.m_dPrecio = m_dPrecio;
        this.m_strDescripcion = m_strDescripcion;
        this.m_iDetalleId = m_iDetalleId;
        this.m_iOrdenId = m_iOrdenId;
        this.m_iProductIdT2 = m_iProductIdT2;
        this.m_iCantidad = m_iCantidad;
        this.m_iOrdenIdT2 = m_iOrdenIdT2;
        this.m_iPagoId = m_iPagoId;
        this.m_iEmpleadoId = m_iEmpleadoId;
        this.m_strFecha = m_strFecha;
        this.m_iMesaId = m_iMesaId;
        this.m_iMesaIdT2 = m_iMesaIdT2;
        this.m_iEstado = m_iEstado;
    }

    public ProductoDetalleOrdenMesaJoinObj(int m_iOrdenIdT2) {
        this.m_iOrdenIdT2 = m_iOrdenIdT2;
    }

    public String getM_strDescripcion() {
        return m_strDescripcion;
    }

    public void setM_strDescripcion(String m_strDescripcion) {
        this.m_strDescripcion = m_strDescripcion;
    }
    
    public int getM_iProductoId() {
        return m_iProductoId;
    }

    public void setM_iProductoId(int m_iProductoId) {
        this.m_iProductoId = m_iProductoId;
    }

    public int getM_iCategoriaId() {
        return m_iCategoriaId;
    }

    public void setM_iCategoriaId(int m_iCategoriaId) {
        this.m_iCategoriaId = m_iCategoriaId;
    }

    public String getM_strNombre() {
        return m_strNombre;
    }

    public void setM_strNombre(String m_strNombre) {
        this.m_strNombre = m_strNombre;
    }

    public double getM_dPrecio() {
        return m_dPrecio;
    }

    public void setM_dPrecio(double m_dPrecio) {
        this.m_dPrecio = m_dPrecio;
    }
    
    

    public int getM_iDetalleId() {
        return m_iDetalleId;
    }

    public void setM_iDetalleId(int m_iDetalleId) {
        this.m_iDetalleId = m_iDetalleId;
    }

    public int getM_iOrdenId() {
        return m_iOrdenId;
    }

    public void setM_iOrdenId(int m_iOrdenId) {
        this.m_iOrdenId = m_iOrdenId;
    }

    public int getM_iProductIdT2() {
        return m_iProductIdT2;
    }

    public void setM_iProductIdT2(int m_iProductIdT2) {
        this.m_iProductIdT2 = m_iProductIdT2;
    }

    public int getM_iCantidad() {
        return m_iCantidad;
    }

    public void setM_iCantidad(int m_iCantidad) {
        this.m_iCantidad = m_iCantidad;
    }

    public int getM_iOrdenIdT2() {
        return m_iOrdenIdT2;
    }

    public void setM_iOrdenIdT2(int m_iOrdenIdT2) {
        this.m_iOrdenIdT2 = m_iOrdenIdT2;
    }

    public int getM_iPagoId() {
        return m_iPagoId;
    }

    public void setM_iPagoId(int m_iPagoId) {
        this.m_iPagoId = m_iPagoId;
    }

    public int getM_iEmpleadoId() {
        return m_iEmpleadoId;
    }

    public void setM_iEmpleadoId(int m_iEmpleadoId) {
        this.m_iEmpleadoId = m_iEmpleadoId;
    }

    public String getM_strFecha() {
        return m_strFecha;
    }

    public void setM_strFecha(String m_strFecha) {
        this.m_strFecha = m_strFecha;
    }

    public int getM_iMesaId() {
        return m_iMesaId;
    }

    public void setM_iMesaId(int m_iMesaId) {
        this.m_iMesaId = m_iMesaId;
    }

    public int getM_iEstado() {
        return m_iEstado;
    }

    public void setM_iEstado(int m_iEstado) {
        this.m_iEstado = m_iEstado;
    }
    
     public int getM_iMesaIdT2() {
        return m_iMesaIdT2;
    }

    public void setM_iMesaIdT2(int m_iMesaIdT2) {
        this.m_iMesaIdT2 = m_iMesaIdT2;
    }









}
