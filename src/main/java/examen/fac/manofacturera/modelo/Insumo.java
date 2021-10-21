package examen.fac.manofacturera.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "insumos")
public class Insumo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idInsumo;
    
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precioCosto")
    private double precioCosto;
    @Column(name = "stockActual")
    private int stockActual;
    @Column(name = "unidadMedida")
    private String unidadMedida;
    @OneToMany(mappedBy = "insumo")
    private List<ProductoManufacturadoDetalle> detalles = new ArrayList<>();
    
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public List<ProductoManufacturadoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoManufacturadoDetalle> detalles) {
        this.detalles = detalles;
    }
    
    
}
