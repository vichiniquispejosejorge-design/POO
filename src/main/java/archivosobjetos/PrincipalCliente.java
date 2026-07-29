/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivosobjetos;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class PrincipalCliente {

    public static void main(String[] args) {
        OperacionesClienteTarjeta obj=new OperacionesClienteTarjeta();
        Scanner leer=new Scanner(System.in);
        int opc;
        boolean continuar=true;
        do{
            System.out.println("=========================MENU DE OPCIONES=========================");
            System.out.println("______________1. Registrar cliente nuevo_________________________");
            System.out.println("______________2. mostrar todos los clientes__________________________");
            System.out.println("______________3. depocitar de dinero __________________________");
            System.out.println("______________4. Retiro de dinero __________________________");
            System.out.println("______________5. Bloqueo de targeta __________________________");
            System.out.println("______________6. Desbloqueo de targeta __________________________");
            System.out.println("========================Digite una opcion=========================1");
            opc=leer.nextInt();
            switch(opc){
                case 1: obj.registrarclientenuevo();
                        obj.guardarobjetos();  
                case 2: obj.leercliente();
                        obj.mostrarcliente(); 
                        case 3: obj.depocito();
                break;
                        case 4: obj.extraccion();break;
                        case 5: obj.bloqueartargeta();break;
                        case 6: obj.desbloqueartargeta();break;
                default: continuar=false; break;
            }
        }while(continuar);
       
    
    }
    
}
