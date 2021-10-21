
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
@Table(name = "productosManufacturados")
public class ProductoManufacturado implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "tiempoFabricacion")
    private int tiempoFabricacion;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precioVenta")
    private double precioVenta;
    @Column(name = "margenGanancia")
    private double margenGanancia;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "rubroId")
    private Rubro rubro; 
    
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ProductoManufacturadoDetalle> detalles = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "prodManofacturado_empresa",
            joinColumns = @JoinColumn(name = "prodManoFacturado_id"),
            inverseJoinColumns = @JoinColumn(name = "sucEmpresa_id"))
    private List<SucursalEmpresa> empresas = new ArrayList<>();

    
    
    public ProductoManufacturado() {
    }
    
    public ProductoManufacturado(String codigo, int tiempoFabricacion, String denominacion, double precioVenta, double margenGanancia, Rubro rubro) {
        this.codigo = codigo;
        this.tiempoFabricacion = tiempoFabricacion;
        this.denominacion = denominacion;
        this.precioVenta = precioVenta;
        this.margenGanancia = margenGanancia;
        this.rubro = rubro;
    }

    
    
    
    public int getTiempoFabricacion() {
        return tiempoFabricacion;
    }

    public void setTiempoFabricacion(int tiempoFabricacion) {
        this.tiempoFabricacion = tiempoFabricacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public List<ProductoManufacturadoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoManufacturadoDetalle> detalles) {
        this.detalles = detalles;
    }

    public List<SucursalEmpresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<SucursalEmpresa> empresas) {
        this.empresas = empresas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    public void getPrecioVentaCalculado() {
        double costoBasico = 0;
        double precioVenta = 0;
        List<ProductoManufacturadoDetalle> detalles = getDetalles();
        for (ProductoManufacturadoDetalle detalle : detalles) {
            costoBasico += detalle.getInsumo().getPrecioCosto();
        }
        precioVenta = costoBasico + (costoBasico * margenGanancia);
        this.precioVenta = precioVenta;
    }
}
