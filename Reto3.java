import java.util.HashMap;
import java.util.Scanner;

 class Reto3 {

    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return this.scanner.nextLine();
    }

    public void run() {

        BaseDatosProductos base = new BaseDatosProductos();

        String operacion = read();
        String[] datos = read().split(" ");

        Producto producto = new Producto(
                Integer.parseInt(datos[0]),
                datos[1],
                Double.parseDouble(datos[2]),
                Integer.parseInt(datos[3]));

        if (operacion.equals("AGREGAR")) {
            if (base.verificarExistencia(producto.getCodigo())) {
                System.out.println("ERROR");
            } else {
                base.agregar(producto);
                base.generarInforme();
            }

        } else if (operacion.equals("ACTUALIZAR")) {
            if (base.verificarExistencia(producto.getCodigo())) {
                base.actualizar(producto);
                base.generarInforme();
                
            } else {       
                System.out.println("ERROR");

            }

        } else if (operacion.equals("BORRAR")) {
            if (base.verificarExistencia(producto.getCodigo())) {
                base.borrar(producto.getCodigo());
                base.generarInforme();
            } else {
                System.out.println("ERROR");
            }
        } else {
            System.out.println("ERROR");

        }
    }
}

class BaseDatosProductos {

    @SuppressWarnings("unchecked")
    HashMap<Integer, Producto> listaProductos;

    @SuppressWarnings("unchecked")
    public BaseDatosProductos() {
        this.listaProductos = new HashMap();

        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));

    }

    public void agregar(Producto prod) {
        listaProductos.put(prod.getCodigo(), prod);
    }

    public void actualizar(Producto prod) {
        listaProductos.replace(prod.getCodigo(), prod);
    }

    public void borrar(Integer codigo) {
        listaProductos.remove(codigo);

    }
    public String productoPrecioMayor(){
        String nombreMayor = listaProductos.values().iterator().next().getNombre();
        double precioMayor = listaProductos.values().iterator().next().getPrecio();
        /*int conta= 0;
        
        for (Producto pd: listaProductos.values()){
            if (conta ==0){
                String nombre = pd.getNombre();
                double precio = pd.getPrecio();
            }
         conta +- 1;   
        }*/
     for (Producto pd :listaProductos.values()){
         if (pd.getPrecio() > precioMayor){
             nombreMayor =pd.getNombre();
         }
     }   
        
     return nombreMayor;     
    }
    
    
    public  String productoPrecioMenor(){
        String nombreMenor = listaProductos.values().iterator().next().getNombre();
        double precioMenor = listaProductos.values().iterator().next().getPrecio();
        
     for (Producto pd :listaProductos.values()){
         if (pd.getPrecio() < precioMenor){
             nombreMenor = pd.getNombre();
         }
     }   
        
     return nombreMenor;     
    }
    
    public double promedioprecios(){
        double suma =0;
        for (Producto pd: listaProductos.values()){
            suma += pd.getPrecio();
        }
      return suma /(listaProductos.size());
    }
    
    
    

    public boolean verificarExistencia(Integer codigo) {
        return listaProductos.containsKey(codigo);

    }

    public void generarInforme() {
        String nombrePrecioMayor = productoPrecioMayor();
        String nombrePrecioMenor = productoPrecioMenor();
        double promedioPrecios = promedioprecios();
       
     System.out.println(nombrePrecioMayor+ " " +nombrePrecioMenor+ " " +String.format("%.1f", promedioPrecios));   
       
    }
}

class Producto {

    private Integer codigo;
    private String nombre;
    private Double precio;
    private Integer inventario;

    public Producto(Integer codigo, String nombre, Double precio, Integer inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;

    }

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getInventario() {
        return inventario;
    }
    public void setInventario(Integer inventarioNuevo) {
        inventario = inventarioNuevo;

    }

}
