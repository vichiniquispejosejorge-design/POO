
package archivosobjetos;


public class Cliente {
    private String NombreCompleto,Nrcedula;
    private TarjetaCliente tarjeta;
    
     public void mostrarcliente(){
      System.out.println("nombre"+this.NombreCompleto);
       System.out.println("nro.cedula"+this.Nrcedula);
         if (tarjeta!=null) {
             tarjeta.mostrartarjeta();
         }
  }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getNrcedula() {
        return Nrcedula;
    }

    public void setNrcedula(String Nrcedula) {
        this.Nrcedula = Nrcedula;
    }
    
    
}
