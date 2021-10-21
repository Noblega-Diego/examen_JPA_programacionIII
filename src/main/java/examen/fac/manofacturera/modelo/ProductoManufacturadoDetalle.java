package examen.fac.manofacturera.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "ProductoManufacturadoDetalles")
public class ProductoManufacturadoDetalle implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProductoDetalle;
    
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "insumoId")
    private Insumo insumo;
    @ManyToOne
    @JoinColumn(name = "productoManofacturadoID")
    private ProductoManufacturado producto;
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public ProductoManufacturado getProducto() {
        return producto;
    }

    public void setProducto(ProductoManufacturado producto) {
        this.producto = producto;
    }

    public int getIdProductoDetalle() {
        return idProductoDetalle;
    }

    public void setIdProductoDetalle(int idProductoDetalle) {
        this.idProductoDetalle = idProductoDetalle;
    }
    
    
}
