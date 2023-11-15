package com.example.sistema_ventas.controladores;

import com.example.sistema_ventas.modelo.clases.*;
import com.example.sistema_ventas.modelo.conexionBD.actualizarBD.actualizarBD_cant_stock;
import com.example.sistema_ventas.modelo.conexionBD.guardarBD.guardarBD_registro_caja;
import com.example.sistema_ventas.modelo.conexionBD.guardarBD.guardarBD_venta;
import com.example.sistema_ventas.modelo.conexionBD.guardarBD.guardarBD_venta_producto;
import com.example.sistema_ventas.modelo.conexionBD.seleccionarBD.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ventaControlador implements Initializable {
    @FXML
    public TableView<producto_tabla_venta> tabla;
    public TableColumn<producto_tabla_venta,String> c_producto;
    public ChoiceBox CBproducto,CBcaja,CBempleado,tipoPago;
    public TableColumn c_cantida,c_precio, c_total;
    public Label totalVenta;
    public TextField t_producto;
    public Button añadir_producto;

    ObservableList<producto_tabla_venta> lista_producto = FXCollections.observableArrayList();

    ObservableList<producto> lista_productos = seleccionarBD_producto.getLista();

    ObservableList<caja> lista_caja = seleccionarBD_caja.getLista();

    ObservableList<empleado> lista_empleado = seleccionarBD_empleado.getLista();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> listaProductos = FXCollections.observableArrayList();
        lista_productos.forEach(producto -> {
                    listaProductos.add(producto.getNombre());
                }
        );
        CBproducto.setItems(listaProductos);

        ObservableList<String> listacajas = FXCollections.observableArrayList();
        lista_caja.forEach(caja -> {
                    listacajas.add(String.valueOf(caja.getId()));
                }
        );
        CBcaja.setItems(listacajas);

        ObservableList<String> listaempleado = FXCollections.observableArrayList();
        lista_empleado.forEach(empleado -> {
                    listaempleado.add(String.valueOf(empleado.getId()));
                }
        );
        CBempleado.setItems(listaempleado);

        ObservableList<String> pagos = FXCollections.observableArrayList();
        pagos.add("pago virtual");
        pagos.add("efectivo");
        pagos.add("tarjeta");
        tipoPago.setItems(pagos);

        c_producto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        c_cantida.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        c_precio.setCellValueFactory(new PropertyValueFactory<>("precio_x_unidad"));
        c_total.setCellValueFactory(new PropertyValueFactory<>("total"));

        tabla.setItems(lista_producto);

        calcularTotal();

    }

    private void calcularTotal() {
        AtomicInteger total = new AtomicInteger();
        lista_producto.forEach(producto -> {
            total.addAndGet(producto.getTotal());
        });
        totalVenta.setText(String.valueOf(total.get()));
    }


    public void guardarProducto(){

        String error = "";

        try{

            int producto = Integer.parseInt(t_producto.getText());

        } catch (Exception e) {

            error = "solo se aceptan numeros";
        }

        if (!error.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(error);
            alert.showAndWait();
        }else {



            String nombre =CBproducto.getValue().toString();
            producto nuevoProducto = lista_productos.filtered(producto -> producto.getNombre().contains(nombre)).get(0);
            //se crea un nuevo producto a partir del ChoiceBox
            producto_tabla_venta nuevo = new producto_tabla_venta(nuevoProducto.getId_producto(),nombre,nuevoProducto.getPrecio_x_unidad(),nuevoProducto.getMarca());
            nuevo.setCantidad(Integer.valueOf(t_producto.getText()));

            if(nuevo.getCantidad()>seleccionarBD_cant_stock_id.cantidad(nuevo.getId_producto())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("no queda stock disponible del producto seleccionado");
                alert.showAndWait();

            }else {
                //se hace un filtro para ver si el producto ya esta en la lista y si esta se cambia la cantidad de la venta y si no se agrega el producto
                if (lista_producto.filtered(productoTablaVenta -> productoTablaVenta.getNombre().contains(nombre)).size()!=0){
                    lista_producto.filtered(producto -> producto.getNombre().contains(nombre)).get(0).setCantidad(Integer.valueOf(t_producto.getText()));
                }else {
                    lista_producto.add(nuevo);
                }
            }
            tabla.refresh();
            calcularTotal();
        }
    }

    public void venta(){


        if(lista_producto.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("no selecciono ningun producto");
            alert.showAndWait();
        }
        if(tipoPago.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("no selecciono ningun tipo de pago");
            alert.showAndWait();
        }

        if (CBcaja.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("seleccione la caja");
            alert.showAndWait();
        }else if (CBempleado.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("seleccione el empleado");
            alert.showAndWait();
        }else {
            int idcaja = Integer.parseInt(CBcaja.getValue().toString());
            int idempleado = Integer.parseInt(CBempleado.getValue().toString()) ;
            String tipoDePago = (String) tipoPago.getValue();
            Double total = Double.valueOf(totalVenta.getText());
            venta ventaaa = new venta(0,idcaja,idempleado,tipoDePago,total);
            guardarBD_venta ventaa = new guardarBD_venta(ventaaa);
            ventaa.guardarBD();
            lista_producto.forEach(producto -> {
                venta_producto newventa = new venta_producto(ventaa.getVenta().getId(),producto.getId_producto(),producto.getCantidad(),producto.getTotal());
                guardarBD_venta_producto guardar = new guardarBD_venta_producto(newventa);
                guardar.guardarBD();
                //actualizar stock -
                cant_stock stock = new cant_stock(producto.getId_producto(),producto.getPrecio_x_unidad(),producto.getCantidad());
                seleccionarBD_cant_stock mostrar =  new seleccionarBD_cant_stock();
                mostrar.seleccionarBD();
                stock.setCantidad(seleccionarBD_cant_stock_id.cantidad(producto.getId_producto()) - stock.getCantidad());
                actualizarBD_cant_stock actualizar = new actualizarBD_cant_stock(stock);
                actualizar.ActualizarBD();
                //actualizar la caja +
                Double totalventa = Double.valueOf(totalVenta.getText());
                registro_caja registro = new registro_caja(0,idcaja,seleccionarBD_registro_caja.seleccionarBD()+totalventa);
                guardarBD_registro_caja guardarBDRegistroCaja = new guardarBD_registro_caja(registro);
                guardarBDRegistroCaja.guardarBD();

            });
            lista_producto.clear();
            tabla.refresh();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("la venta se realizo correctamente");
            alert.showAndWait();
        }
    }
}
