package examen.fac.manofacturera.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "sucursalesEmpresa")
public class SucursalEmpresa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idInsumo;
    
    @Column(name = "razonSocial")
    private String razonSocial;
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "telefono")
    private long telefono;
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "empresas", cascade = {CascadeType.PERSIST})
    private List<ProductoManufacturado> productos;

    public SucursalEmpresa(String razonSocial, String cuit, long telefono, String email) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.telefono = telefono;
        this.email = email;
    }

    public SucursalEmpresa() {
    }
    
    
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductoManufacturado> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoManufacturado> productos) {
        this.productos = productos;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
    
    
    public List<ProductoManufacturado> getProductosXTiempoFabricacion(int tiempoMaximo){
        List<ProductoManufacturado> productosFiltrados = new ArrayList<>();
        for (ProductoManufacturado producto : getProductos()) {
            if(producto.getTiempoFabricacion() <= tiempoMaximo)
                productosFiltrados.add(producto);
        }
        return productosFiltrados;
    }
    
}
