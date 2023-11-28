package com.example.sistema_ventas.controlers;

import com.example.sistema_ventas.modelo.clases.*;
import com.example.sistema_ventas.modelo.conexionBD.actualizarBD.actualizarBD_cant_stock;
import com.example.sistema_ventas.modelo.conexionBD.guardarBD.guardarBD_registro_caja;
import com.example.sistema_ventas.modelo.conexionBD.guardarBD.guardarBD_venta_producto;
import com.example.sistema_ventas.modelo.conexionBD.seleccionarBD.*;

import com.example.sistema_ventas.aplicacion;
import com.example.sistema_ventas.modelo.conexionBD.guardarBD.guardarBD_venta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class VentanaInicioController implements Initializable {

    @FXML
    public TextField txtUsuario;
    public PasswordField txtContraseña;
    public TableView<producto_tabla_venta> tabla;
    public TableColumn<producto_tabla_venta,String> c_producto;
    public ChoiceBox CBproducto;
    public ChoiceBox CBcaja;
    public ChoiceBox CBempleado;
    public TableColumn c_cantida;
    public TableColumn c_precio;
    public TableColumn c_total;
    public Label totalVenta;
    public TextField t_producto;
    public Button añadir_producto;
    public ChoiceBox tipoPago;
    public TableColumn c_unidad_medida;

    @FXML
    public TableView<producto> tabla_productos;
    public TableColumn<producto, Integer> columna_codigo, columna_precio;
    public TableColumn<producto, Double> columna_stock;
    public TableColumn<producto, String>  columna_nombre, columna_marca, columna_unidad;
    public Button nuevo_producto;
    public Button modificar_producto;
    public Button borrar_producto;


    ObservableList<producto_tabla_venta> lista_producto = FXCollections.observableArrayList();

    ObservableList<producto_tabla_venta> lista_productos = seleccionarBD_producto.getListaVenta();

    ObservableList<caja> lista_caja = seleccionarBD_caja.getLista();

    ObservableList<empleado> lista_empleado = seleccionarBD_empleado.getLista();

    ObservableList<producto> listaproductoStock = seleccionarBD_productoStock.getLista();

    ObservableList<producto> listaproducto = seleccionarBD_producto.seleccionarBD();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
        c_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        c_unidad_medida.setCellValueFactory(new PropertyValueFactory<>("unidad_medida"));
        c_total.setCellValueFactory(new PropertyValueFactory<>("total"));

        tabla.setItems(lista_producto);

        columna_codigo.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        columna_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columna_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columna_unidad.setCellValueFactory(new PropertyValueFactory<>("unidad_medida"));
        columna_stock.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        tabla_productos.setItems(listaproductoStock);

        calcularTotal();
    }

    public void actualizar () throws IOException {

        producto productoActual =  tabla_productos.getSelectionModel().getSelectedItem();

        if (productoActual == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("error");
            alert.setHeaderText("seleccione un producto");
            alert.show();

        } else {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(aplicacion.class.getResource("agregar_producto.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Actualizar");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);

            AgregarProductoControler controlador = fxmlLoader.getController();
            controlador.parametros(productoActual);

            stage.showAndWait();

            tabla_productos.refresh();
        }
    }

    public void agregarProducto() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(aplicacion.class.getResource("agregar_producto.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("agregar");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        AgregarProductoControler controlador = fxmlLoader.getController();

        stage.showAndWait();

        if (controlador.obtenerNuevo() != null) {
            listaproducto.add(controlador.obtenerNuevo());
        }

        tabla_productos.setItems(listaproductoStock);
        tabla_productos.refresh();
    }

    private void calcularTotal() {
        AtomicReference<Double> total= new AtomicReference<>(0.0);
        lista_producto.forEach(producto -> {
            total.updateAndGet(v -> v + producto.getTotal());
        });
        totalVenta.setText(String.valueOf(total));
    }

    public void guardarProducto(){

        String error = "";

        try{

            Double producto =  Double.valueOf(t_producto.getText());

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

            producto_tabla_venta nuevo = new producto_tabla_venta(nuevoProducto.getId_producto(),nombre,nuevoProducto.getPrecio(),nuevoProducto.getMarca(),nuevoProducto.getUnidad_medida(), (double) nuevoProducto.getCantidad());
            nuevo.setCantidad(Double.valueOf(t_producto.getText()));

            if(nuevo.getCantidad()>seleccionarBD_cant_stock_id.cantidad(nuevo.getId_producto())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("no queda stock disponible del producto seleccionado");
                alert.showAndWait();

            }else {
                //se hace un filtro para ver si el producto ya esta en la lista y si esta se cambia la cantidad de la venta y si no se agrega el producto
                if (lista_producto.filtered(productoTablaVenta -> productoTablaVenta.getNombre().contains(nombre)).size()!=0){
                    lista_producto.filtered(producto -> producto.getNombre().contains(nombre)).get(0).setCantidad(Double.valueOf(t_producto.getText()));
                }else {lista_producto.add(nuevo);}
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
                cant_stock stock = new cant_stock(producto.getId_producto(),producto.getPrecio(),producto.getCantidad());
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
    public void btnIngresar(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(aplicacion.class.getResource("inicio-administrador-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("ventana administrador");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnEmpleado(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(aplicacion.class.getResource("inicio-empleado-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("ventana empleado");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}