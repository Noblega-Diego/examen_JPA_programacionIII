<%-- 
    Document   : index
    Created on : 5 oct. 2021, 22:27:29
    Author     : diego
--%>

<%@page import="javax.persistence.EntityManager"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="examen.fac.manofacturera.persistencia.ConfigHibernate"%>
<%@page import="examen.fac.manofacturera.modelo.Rubro"%>
<%@page import="examen.fac.manofacturera.modelo.ProductoManufacturado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>producto manufacturado</title>
    </head>
    <body>
        <main>
            <h1>Ingeso de productos</h1>
            <form id="form1" style="display: flex; flex-direction: column; width: 330px;">
                <label for="in_timeFabrica">Tiempo de Fabricacion:</label>
                <input name="timeFab" type="text" id="in_timeFabricacion">
                <label for="">Denomincacion:</label>
                <input name="denominacion" type="text" id="in_denominacion">
                <label for="">Codigo:</label>
                <input name="codigo" type="text" id="in_codigo">
                <label for="">Precio venta:</label>
                <input name="precioVenta" type="number" step="0.01" id="in_precioVenta">
                <label for="">Margen ganancia:</label>
                <input name="margenGan" type="number" step="0.001" id="in_margenGanancia">
                <div class="content-radio">
                    <label for="rub_agricola">Agricola:</label>
                    <input type="radio" name="rubro" value="agricola" id="rub_agricola"/>
                    <label for="rub_metalMecanica">Metalmecanica:</label>
                    <input type="radio" name="rubro" value="metalMecanica" id="rub_metalMecanica"/>
                    <label for="rub_alimentaria">Alimentaria:</label>
                    <input type="radio" name="rubro" value="alimentaria" id="rub_alimentaria"/>
                </div>
                <button type="button" onclick="cargarDatos()">confirmar</button> 
            </form>
            
            <table  style="border: 2px solid blue">
                <thead>
                    <tr>
                        <th>TiempoFabricacion</th>
                        <th>denominacion</th>
                        <th>codigo</th>
                        <th>precio de venta</th>
                        <th>margen de ganancia</th>
                        <th>rubro</th>
                    </tr>
                </thead>
                <tbody id="tabla">
                </tbody>
            </table>
        </main>
        <script src="script.js"></script>
    </body>
</html>
