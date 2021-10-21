package examen.fac.manofacturera.controlador;

import examen.fac.manofacturera.persistencia.ConfigHibernate;
import javax.persistence.EntityManager;

/**
 *
 * @author diego
 */
public class Main {
    public static void main(String[] args) {
        EntityManager entity = new ConfigHibernate().getSessionFactory().openSession();
        entity.close();
    }
}
