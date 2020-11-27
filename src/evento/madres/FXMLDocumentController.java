package evento.madres;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.Hijo;
import model.Madre;

public class FXMLDocumentController implements Initializable {
    
    private ArrayList<Madre> madres = new ArrayList<Madre>();
    private ArrayList<Hijo> hijos = new ArrayList<Hijo>();
    
    //Controles CRUD Madres
    @FXML
    private TextField tfIdMadre;
    @FXML
    private TextField tfNombreMadre;    
    @FXML
    private TextField tfDireccionMadre;    
    @FXML
    private TextField tfProfesionMadre;    
    @FXML
    public ListView listMadres;    
    @FXML
    public Button btnGuardarMadre;    
    @FXML 
    public Button btnEliminarMadre;    
    @FXML 
    public Button btnnuevoMadre;
    
    //Controles CRUD Hijos
    @FXML
    private TextField tfIdHijo;
    @FXML
    private TextField tfNombreHijo;    
    @FXML
    private TextField tfColegio;    
    @FXML
    private TextField tfcedMadre;
    @FXML
    public ListView listHijos;
    @FXML
    public Button btnGuardarHijo;    
    @FXML 
    public Button btnEliminarHijo;    
    @FXML 
    public Button btnnuevoHijo;
    @FXML
    private ComboBox<Integer> cbGrado;
    private ObservableList listaGrado;
    
    //Controles Consultas
    @FXML
    private TextField tfidHijoConsulta;
    @FXML
    private TextField tfidMadreConsulta; 
    @FXML
    public ListView consulta;
    @FXML
    public Button btnConsultaHijo;    
    @FXML 
    public Button btnConsultaMadre;    
    
    //Crud Madres
        
    @FXML
    private void handleGuardarMadreAction(ActionEvent event) {
        if (validarVaciosMadre()) {
            if (btnGuardarMadre.getText().equals("Guardar")) {


                if (!validarDuplicadoMadre()) {

                    Madre madre = new Madre(
                    tfProfesionMadre.getText(), 
                    tfDireccionMadre.getText(), 
                    tfIdMadre.getText(),
                    tfNombreMadre.getText()
                    );
                    madres.add(madre);
                    System.out.println(madres);
                    listMadres.getItems().add(madre.mostrar());

                    JOptionPane.showMessageDialog(null, "Registro guardado.");
                }            


            } else {
                int index = listMadres.getSelectionModel().getSelectedIndex();

                madres.get(index).setIdentificacion(tfIdMadre.getText());
                madres.get(index).setNombre(tfNombreMadre.getText());
                madres.get(index).setDireccion(tfDireccionMadre.getText());
                madres.get(index).setProfesion(tfProfesionMadre.getText());

                btnGuardarMadre.setText("Guardar");
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente.");
                
                listMadres.getItems().set(index, madres.get(index).mostrar());
                //listMadres.getItems().add(index, madres.get(index).mostrar());
                listMadres.refresh();
                
            }

            limpiarCamposMadre();
            toogleFields(true);
            btnEliminarMadre.disableProperty().set(true);
            btnnuevoMadre.requestFocus();
        }
    }
    
    private boolean validarVaciosMadre() {
        boolean validar;
        
        if (tfIdMadre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la identificación.");
            tfIdMadre.requestFocus();
            validar = false;
        } else if (tfNombreMadre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre.");
            tfNombreMadre.requestFocus();
            validar = false;
        } else if (tfProfesionMadre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la profesión.");
            tfProfesionMadre.requestFocus();
            validar = false;
        } else if (tfDireccionMadre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la dirección.");
            tfDireccionMadre.requestFocus();
            validar = false;
        } else {
            validar = true;
        }
        
        return validar;
    }
    
    private boolean validarDuplicadoMadre() {
        boolean duplicado = false;
        for (Madre m : madres) {
            if (tfIdMadre.getText().equals(m.getIdentificacion())) {
                JOptionPane.showMessageDialog(null, "Identificación ya existe.");
                tfIdMadre.requestFocus();
                duplicado = true;
            } else {
                duplicado = false;
            }
        }
        
        return duplicado;
    }
    
    private void limpiarCamposMadre() {
        tfIdMadre.setText("");
        tfNombreMadre.setText("");
        tfProfesionMadre.setText("");
        tfDireccionMadre.setText("");
        tfIdMadre.requestFocus();
    }
    
    private void toogleFields(boolean opt) {
        btnGuardarMadre.disableProperty().set(opt);
        btnEliminarMadre.disableProperty().set(opt);
        tfIdMadre.disableProperty().set(opt);
        tfDireccionMadre.disableProperty().set(opt);
        tfNombreMadre.disableProperty().set(opt);
        tfProfesionMadre.disableProperty().set(opt);
    }
    
    @FXML
    private void handleNuevoAction(ActionEvent event) {
        limpiarCamposMadre();
        toogleFields(false);
        btnEliminarMadre.disableProperty().set(true);
        btnGuardarMadre.setText("Guardar");
        tfIdMadre.requestFocus();
        
    }
    
    @FXML
    private void handleEliminarAction(ActionEvent event) {
        int index = listMadres.getSelectionModel().getSelectedIndex();
        
        madres.remove(index);
        listMadres.getItems().remove(index);
        listMadres.refresh();
        
        JOptionPane.showMessageDialog(null, "Registro eliminado.");
        
        limpiarCamposMadre();
        
        toogleFields(true);
        btnEliminarMadre.disableProperty().set(true);
        btnGuardarMadre.setText("Guardar");
        btnnuevoMadre.requestFocus();
    }
    
    
    @FXML
    private void handleListViewAction(MouseEvent event) {
        int selectedIndex = listMadres.getSelectionModel().getSelectedIndex();
        
        tfIdMadre.setText(madres.get(selectedIndex).getIdentificacion());
        tfNombreMadre.setText(madres.get(selectedIndex).getNombre());
        tfDireccionMadre.setText(madres.get(selectedIndex).getDireccion());
        tfProfesionMadre.setText(madres.get(selectedIndex).getProfesion());
        
        btnGuardarMadre.setText("Editar");
        btnEliminarMadre.disableProperty().set(false);
        
         toogleFields(false);
         tfIdMadre.requestFocus();
         
    }
    
    // Fin Crud Madres
    
    // CRUD Hijos
    
    @FXML
    private void handleNuevoHijoAction(ActionEvent event) {
        limpiarCamposHijo();
        toogleFieldsHijo(false);
        btnEliminarHijo.disableProperty().set(true);
        btnGuardarHijo.setText("Guardar");
        tfIdHijo.requestFocus();
    }
    
    @FXML
    private void handleGuardarHijoAction(ActionEvent event) {
        if (validarVaciosHijo()) {
            if (btnGuardarHijo.getText().equals("Guardar")) {


                if (!validarDuplicadoHijo()) {

                    Hijo hijo = new Hijo(
                    tfColegio.getText(), 
                    Integer.valueOf(cbGrado.getSelectionModel().getSelectedItem()), 
                    tfcedMadre.getText(),
                    tfIdHijo.getText(),
                    tfNombreHijo.getText()
                    );
                    hijos.add(hijo);
                    listHijos.getItems().add(hijo.mostrar());

                    JOptionPane.showMessageDialog(null, "Registro guardado.");
                }            


            } else {
                int index = listHijos.getSelectionModel().getSelectedIndex();

                hijos.get(index).setIdentificacion(tfIdHijo.getText());
                hijos.get(index).setNombre(tfNombreHijo.getText());
                hijos.get(index).setColegio(tfColegio.getText());
                hijos.get(index).setGrado(Integer.valueOf(cbGrado.getSelectionModel().getSelectedItem()));
                hijos.get(index).setCedMad(tfcedMadre.getText());

                btnGuardarHijo.setText("Guardar");
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente.");
                
                listHijos.getItems().set(index, hijos.get(index).mostrar());
                listHijos.refresh();
                
            }

            limpiarCamposHijo();
            toogleFieldsHijo(true);
            btnEliminarHijo.disableProperty().set(true);
            btnnuevoHijo.requestFocus();
        }
    }
    
    private boolean validarVaciosHijo() {
        boolean validar;
        
        if (tfIdHijo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la identificación.");
            tfIdHijo.requestFocus();
            validar = false;
        } else if (tfNombreHijo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre.");
            tfNombreHijo.requestFocus();
            validar = false;
        } else if (tfColegio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el colegio.");
            tfColegio.requestFocus();
            validar = false;
        } else if (cbGrado.getSelectionModel().getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el grado.");
            cbGrado.requestFocus();
            validar = false;
        } if (tfcedMadre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la identificación de la madre.");
            tfcedMadre.requestFocus();
            validar = false;
        } else {
            validar = true;
        }
        
        return validar;
    }
    
    private boolean validarDuplicadoHijo() {
        boolean duplicado = false;
        for (Hijo h : hijos) {
            if (tfIdHijo.getText().equals(h.getIdentificacion())) {
                JOptionPane.showMessageDialog(null, "Identificación ya existe.");
                tfIdHijo.requestFocus();
                duplicado = true;
            } else {
                duplicado = false;
            }
        }
        
        return duplicado;
    }
    
    private void limpiarCamposHijo() {
        tfIdHijo.setText("");
        tfNombreHijo.setText("");
        tfColegio.setText("");
        tfcedMadre.setText("");
        tfIdHijo.requestFocus();
    }
    
    private void toogleFieldsHijo(boolean opt) {
        btnGuardarHijo.disableProperty().set(opt);
        btnEliminarHijo.disableProperty().set(opt);
        tfIdHijo.disableProperty().set(opt);
        tfNombreHijo.disableProperty().set(opt);
        tfColegio.disableProperty().set(opt);
        cbGrado.disableProperty().set(opt);
        tfcedMadre.disableProperty().set(opt);
    }
    
    @FXML
    private void handleEliminarHijoAction(ActionEvent event) {
        int index = listHijos.getSelectionModel().getSelectedIndex();
        
        hijos.remove(index);
        listHijos.getItems().remove(index);
        listHijos.refresh();
        
        JOptionPane.showMessageDialog(null, "Registro eliminado.");
        
        limpiarCamposHijo();
        
        toogleFields(true);
        btnEliminarHijo.disableProperty().set(true);
        btnGuardarHijo.setText("Guardar");
        btnnuevoHijo.requestFocus();
    }
    
    @FXML
    private void handleListHijoViewAction(MouseEvent event) {
        int selectedIndex = listHijos.getSelectionModel().getSelectedIndex();
        
        tfIdHijo.setText(hijos.get(selectedIndex).getIdentificacion());
        tfNombreHijo.setText(hijos.get(selectedIndex).getNombre());
        tfColegio.setText(hijos.get(selectedIndex).getColegio());
        cbGrado.getItems().get(selectedIndex);
        tfcedMadre.setText(hijos.get(selectedIndex).getCedMad());
        
        btnGuardarHijo.setText("Editar");
        btnEliminarHijo.disableProperty().set(false);
        
         toogleFieldsHijo(false);
         tfIdHijo.requestFocus();
         
    }
    
    // Fin CRUD Hijos
    
    // Inicio consultas
    @FXML
    private void handleConsultaMadreAction(ActionEvent event) {
        String id = tfidHijoConsulta.getText();
        String idMadre = null;
        boolean encontradoHijo = false;
        boolean encontradoMadre = false;
        consulta.getItems().clear();
        for (Hijo h : hijos) {
            if (h.getIdentificacion().equals(id)) {
                idMadre = h.getCedMad();
                encontradoHijo = true;
            }
        }
        
        if (!encontradoHijo) {
            JOptionPane.showMessageDialog(null, "Identificacion no encontrada.");
        } else {
            for (Madre m : madres) {
                if (m.getIdentificacion().equals(idMadre)) {
                    consulta.getItems().add(m.mostrar());
                    encontradoMadre = true;
                }
            }
            
            if (!encontradoMadre) {
                JOptionPane.showMessageDialog(null, "Madre no registrada, por favor validar.");
            }
        }       
        
    }
    
    @FXML
    private void handleConsultaHijoAction(ActionEvent event) {
        String id = tfidMadreConsulta.getText();
        boolean encontradoMadre = false;
        consulta.getItems().clear();
        for (Hijo h : hijos) {
            if (h.getCedMad().equals(id)) {
                consulta.getItems().add(h.mostrar());
                encontradoMadre = true;
            }
        }
        
        if (!encontradoMadre) {
                JOptionPane.showMessageDialog(null, "Esta Madre no tiene hijos registrados.");
        }
    }
    
    // Fin consultas
    
    public void rellenarComboGrado() {
        listaGrado.clear();
        listaGrado.addAll(1,2,3,4,5,6,7,8,9,10,11);
        cbGrado.getItems().addAll(listaGrado);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaGrado = FXCollections.observableArrayList();
        rellenarComboGrado();
    }    
    
}
