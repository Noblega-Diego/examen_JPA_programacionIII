
package examen.fac.manofacturera.modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "rubros")
public class Rubro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRubro;
    
    @Column(name = "denominacion")
    private String denominacion;
    @OneToMany(mappedBy = "rubro")
    private List<ProductoManufacturado> productos = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rubro> subRubros = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "rubroPadre_id")
    private Rubro rubroPadre;

    public Rubro() {
    }

    public Rubro(String denominacion) {
        this.denominacion = denominacion;
    }

    public Rubro(String denominacion, Rubro rubroPadre) {
        this.denominacion = denominacion;
        this.rubroPadre = rubroPadre;
    }
    
    
    
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<ProductoManufacturado> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoManufacturado> productos) {
        this.productos = productos;
    }

    public List<Rubro> getSubRubros() {
        return subRubros;
    }

    public void setSubRubros(List<Rubro> subRubros) {
        this.subRubros = subRubros;
    }

    public Rubro getRubroPadre() {
        return rubroPadre;
    }

    public void setRubroPadre(Rubro rubroPadre) {
        this.rubroPadre = rubroPadre;
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }
    
    
    
    
    public List<ProductoManufacturado> getProductosXRubro(){
        List<ProductoManufacturado> productos = new ArrayList<>();
        productos.addAll(this.productos);
        for (Rubro subRubro : this.subRubros) {
            productos.addAll(subRubro.getProductosXRubro());
        }
        return productos;
    } 
    
    public ProductoManufacturado getProductoManufacturado(){
        ProductoManufacturado productoMayorPrecio = null;
        for(ProductoManufacturado producto: this.getProductos()){
            producto.getPrecioVentaCalculado();
            if(productoMayorPrecio == null || producto.getPrecioVenta() > productoMayorPrecio.getPrecioVenta())
                productoMayorPrecio = producto;
        }
        return productoMayorPrecio;
    } 
}
