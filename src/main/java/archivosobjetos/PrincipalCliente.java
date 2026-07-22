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
            System.out.println("______________2. salir__________________________");
            System.out.println("========================Digite una opcion=========================1");
            opc=leer.nextInt();
            switch(opc){
                case 1: obj.registrarclientenuevo();
                        obj.mostrarcliente();
                break;
                default: continuar=false; break;
            }
        }while(continuar);
       
    
    }
    
}
