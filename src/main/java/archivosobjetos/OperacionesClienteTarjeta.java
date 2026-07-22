
package archivosobjetos;

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
}
