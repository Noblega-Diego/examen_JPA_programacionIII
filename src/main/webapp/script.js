
const id = id => document.getElementById(id);

let tabla = id("tabla")
let in_timeFabricacion = id("in_timeFabricacion");
let in_denominacion = id("in_denominacion");
let in_codigo = id("in_codigo");
let in_precioVenta = id("in_precioVenta");
let in_margenGanancia = id("in_margenGanancia");
let in_rubros = [id("rub_agricola"),
              id("rub_metalMecanica"),
              id("rub_alimentaria")];

let productosCargados = [];


const validarEsInteger = (value) => {
    if(isNaN(parseInt( value, 10))){
        return false;
    }else{
        return true;
    }
}; 

const validarEsFloat = (value) => {
    if(isNaN(parseFloat(value))){
        return false;
    }else{
        return true;
    }
};

const esMargenGananciaValido = (value) => {
    let valor = parseFloat(value);
    return (valor >= 0);
};

const esCodigoValido = (value) => {
    let valor = value;
    return !(valor.includes(" "));
};

const validarEsVacio = (value) => {
    if( value === ""){
        return true;
    }else{
        return false;
    }
};

const radioSeleccionado = (radios) => {
    for (const i in radios) {
        if(radios[i].checked)
            return radios[i];
    }
    return null;
};

const validarProducto = (codigo) => {
    for (const i in productosCargados) {
        if(productosCargados[i] === codigo){
            return false;
        }
    }
    return true;
}

const createColumna = (value) => {
    let campo = document.createElement("td");
    campo.innerText = value;
    return campo;
}

const agregarProducto = (tiempoFabricacion, denominacion, codigo, precioVenta, margenGanancia, rubro) => {
    productosCargados.push(codigo)
    let fila = document.createElement("tr")
    fila.appendChild(createColumna(tiempoFabricacion))
    fila.appendChild(createColumna(denominacion))
    fila.appendChild(createColumna(codigo))
    fila.appendChild(createColumna(precioVenta))
    fila.appendChild(createColumna(margenGanancia))
    fila.appendChild(createColumna(rubro))
    tabla.appendChild(fila);
}


const cargarDatos = () => {
    
    let tiempoFabricacion = in_timeFabricacion.value;
    let denominacion = in_denominacion.value;
    let codigo = in_codigo.value;
    let precioVenta = in_precioVenta.value;
    let margenGanancia = in_margenGanancia.value;
    let rubro;
    
    if(!validarEsInteger(tiempoFabricacion)){
        alert("el tiempo de fabricacion no es valido");
        return;
    }

    if(validarEsVacio(denominacion)){
        alert("el campo denominacion no puede estar vacio");
        return;
    }

    if(validarEsVacio(codigo) || 
            !esCodigoValido(codigo)){
        alert("el codigo ingresado no puede contener espacio");
        return;
    }
    
    if(!validarEsFloat(precioVenta)){
        alert("el precio de venta no es valido");
        return;
    }

    if( !validarEsFloat(margenGanancia) ||
        !esMargenGananciaValido(margenGanancia)){
        alert("no es un margen de ganancia valido");
        return;
    }
    
    if( radioSeleccionado(in_rubros) === null){
        alert("por favor seleccione un rubro");
        return;
    }
    rubro =  radioSeleccionado(in_rubros).value
    if(validarProducto(codigo))
        agregarProducto(tiempoFabricacion, denominacion, codigo, precioVenta, margenGanancia, rubro);
    else{
        alert("el codigo ingresado ya se encuentra");
    }
};