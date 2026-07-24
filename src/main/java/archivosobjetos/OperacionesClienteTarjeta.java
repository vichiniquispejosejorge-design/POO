
package archivosobjetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class OperacionesClienteTarjeta {
  List<Cliente>listacliente;    
  
  Scanner leer=new Scanner(System.in);

    public OperacionesClienteTarjeta() {
        listacliente=new ArrayList<>();
    }
    public void registrarclientenuevo(){
        Cliente cli=new Cliente();
        System.out.println("digite nombre completo");
        cli.setNombreCompleto(leer.nextLine());
        System.out.println("dijite el nro.de cedula");
        cli.setNrcedula(leer.nextLine());
        TarjetaCliente tarjeta=new TarjetaCliente();
        System.out.println("dijite nro. cuenta");
        tarjeta.setNrocuenta(leer.nextInt());
        System.out.println("dijite nro. tarjeta");
        tarjeta.setNrotarjeta(leer.nextInt());
        System.out.println("dijite el saldo de inicial de la cuenta");
        tarjeta.setSaldo(leer.nextDouble());
        tarjeta.setEstado("activo");
        //agregar la tarjeta de debito
        cli.setTarjeta(tarjeta);
        //adicionar de objetos 
        listacliente.add(cli);
        System.out.println("--DATOS REGISTRADOS DEL CLIENTE Y LA TARJETA DE DEBITO CORRECTAMENTE --");
        
    }
  public void mostrarcliente(){
       if(!listacliente.isEmpty()){
            for(Cliente clint:listacliente){
                clint.mostrarcliente();
            }
        }else{
            System.out.println("no se tiene clientes registrados");
        }
  }
  public void guardarobjetos(){
        String ruta="C::\\programacionSISAN:\\cliente.txt";
        try { 
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listacliente);
            
            oos.close();
            archivo.close();
            System.out.println("datos guardados");
        }catch (FileNotFoundException e){
            e.printStackTrace();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
  }
    public void leercliente(){
         String ruta="C::\\programacionSISAN:\\cliente.txt";
        try { 
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream oos=new ObjectInputStream(archivo);
            listacliente=(List<Cliente>)oos.readObject();
         
            System.out.println("datos guardados");
        }catch (FileNotFoundException e){
            e.printStackTrace();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    } 
    public void depocito(){
        int sw=0;
        String cl;
        double monto;
        if (!listacliente.isEmpty()) {
            System.out.println("dijite el monto del dopocito");
            cl=leer.nextLine();
            for (Cliente c:listacliente) {
                if (c.getNrcedula().equalsIgnoreCase(cl)) {
                    sw=1;
                    do {
                        System.out.println("dijite monto a depocitar");
                        monto=leer.nextDouble();
                    } while (monto<=0);
                    c.getTarjeta().setSaldo(c.getTarjeta().getSaldo()+monto);
                    System.out.println("depocito realisado");
                    System.out.println("saldo actual"+c.getTarjeta().getSaldo());
                }
            }if (sw==0) {
                System.out.println("nose encontro el cliente");
                
            }
        }else{
            System.out.println("nose tiene registrado cliente");
        }
    }
}
