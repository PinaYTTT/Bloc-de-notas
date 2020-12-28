package bloc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Funciones extends javax.swing.JFrame {

    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Documento de texto (.txt)","txt");
    public String FuncAbrir(File archivo) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci=entrada.read())!=-1){
                char caracter=(char)ascci;
                documento+=caracter;
            }
        } catch (Exception e) {

        }
        return documento;
    }
    
    public String FuncGuardar(File archivo,String documento){
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            seleccionar.setFileFilter(filter);
            byte[] bytxt=documento.getBytes();
            salida.write(bytxt);
           // this.setName(archivo.getName());
            mensaje="Archivo Guardado Con exito";
        } catch (Exception e){
            
        }
        return mensaje;
    }

}
