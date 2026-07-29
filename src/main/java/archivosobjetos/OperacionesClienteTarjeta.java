
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
     public void extraccion(){
        int sw=0;
        String cl;
        double monto;
        if (!listacliente.isEmpty()) {
            leer.nextLine();
            System.out.println("dijite el numero de carnet");
            cl=leer.nextLine();
            for (Cliente c:listacliente) {
                if (c.getNrcedula().equalsIgnoreCase(cl)) {
                    sw=1;
                    if (c.getTarjeta().getEstado().equalsIgnoreCase("ACTIVO")) {
                        
                    
                    do {
                        System.out.println("dijite monto a sacar");
                        monto=leer.nextDouble();
                    } while (monto<=0);
                    c.getTarjeta().setSaldo(c.getTarjeta().getSaldo()-monto);
                    
                    System.out.println("Retiro realisado");
                    System.out.println("saldo actual"+c.getTarjeta().getSaldo());
                    }else{
                        System.out.println("La targeta esta INACTIVA ,comuniquece al banco");
                    }
                }
            }if (sw==0) {
                System.out.println("nose encontro el cliente");
                
            }
        }else{
            System.out.println("nose tiene registrado cliente");
        }
    }
     public void  bloqueartargeta(){
         String ci,res;
         int sw=0;
         if (!listacliente.isEmpty()) {
             System.out.println("Digite el numero de celula del cliente");
             ci=leer.nextLine();
             for (Cliente c:listacliente) {
                 if (c.getNrcedula().equalsIgnoreCase(ci)) {
                     sw=1;
                     if (c.getTarjeta().getEstado().equalsIgnoreCase("Activo")) {
                         System.out.println("Desea bloquear su targeta de credito? S/N");
                         res=leer.nextLine();
                         if (res.equalsIgnoreCase("s")) {
                             c.getTarjeta().setEstado("INACTIVO");
                             System.out.println("Targeta:"+c.getTarjeta().getNrotarjeta()+ "BLOqueADO");
                         }else{
                             System.out.println("Operacion Cancelada");
                         }
                     }else{
                         System.out.println("LA targeta ya esta bloqueada");
                     }
                 }
             }
         }else{
             System.out.println("Clientes vacios");
         }
     }
       public void  desbloqueartargeta(){
         String ci,res;
         int sw=0,nnt;
         if (!listacliente.isEmpty()) {
             System.out.println("Digite el numero de celula del cliente");
             ci=leer.nextLine();
             for (Cliente c:listacliente) {
                 if (c.getNrcedula().equalsIgnoreCase(ci)) {
                     sw=1;
                     if (c.getTarjeta().getEstado().equalsIgnoreCase("inactivo")) {
                         System.out.println("Desea crear su targeta de credito? S/N");
                         res=leer.nextLine();
                         if (res.equalsIgnoreCase("s")) {
                             System.out.println("Cual es su nuevo numero de targeta:");
                             nnt=leer.nextInt();
                             c.getTarjeta().setNrotarjeta(nnt);
                               c.getTarjeta().setEstado("ACTIVO");
                             System.out.println("Targeta:"+c.getTarjeta().getNrotarjeta()+ " Asignada");
                         }else{
                             System.out.println("Operacion Cancelada");
                         }
                     }else{
                         System.out.println("LA targeta ya esta bloqueada");
                     }
                 }System.out.println("Cliente no encontrado");
             }
         }else{
             System.out.println("Clientes vacios");
         }
     }
}
