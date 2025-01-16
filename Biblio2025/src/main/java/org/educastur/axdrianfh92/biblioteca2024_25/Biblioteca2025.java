// Archivo: Biblioteca2025.java
package org.educastur.axdrianfh92.biblioteca2024_25;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca2025 {
    private final ArrayList <Libro> libros;
    private final ArrayList <Usuario> usuarios;
    private final ArrayList <Prestamo> prestamos;
    private final ArrayList <Prestamo> prestamosHist;
//Prueba
    public Biblioteca2025() {
        this.libros = new ArrayList();
        this.usuarios =new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();
    }
    
    public static void main(String[] args) {
        Biblioteca2025 b= new Biblioteca2025();
        b.cargaDatos();
        b.fueraPlazo();
        b.menu();
    }
   
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    
     public void menu() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para escoger la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tBiblioteca\n");
            System.out.println("\t\t\t\t1 - LIBROS");
            System.out.println("\t\t\t\t2 - USUARIOS");
            System.out.println("\t\t\t\t3 - PRESTAMOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    menuLibros();
                    break;
                }
                case 2: {
                    menuUsuarios();
                    break;
                }
                case 3: {
                    menuPrestamos();
                    break;
                }
            }
        }while (opcion !=9);
    }

    private void menuLibros() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para recojer la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tLIBROS\n");
            System.out.println("\t\t\t\t1 - NUEVO LIBRO");
            System.out.println("\t\t\t\t2 - ELIMINAR LIBRO");
            System.out.println("\t\t\t\t3 - MODIFICAR LIBRO");
            System.out.println("\t\t\t\t4 - LISTADOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    nuevoLibro();
                    break;
                }
                case 2: {
                    eliminarLibro();
                    break;
                }
                case 3: {
                    modificarLibros();
                    break;
                }
                case 4: {
                   listaLibros();
                    break;
                }
            }
        }while (opcion !=9);
    }
    

    private void menuUsuarios() {
       Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para escoger la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tUSUARIOS\n");
            System.out.println("\t\t\t\t1 - NUEVO USUARIO");
            System.out.println("\t\t\t\t2 - ELIMINAR USUARIO");
            System.out.println("\t\t\t\t3 - MODIFICAR USUARIO");
            System.out.println("\t\t\t\t4 - LISTADOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    nuevoUsuario();
                    break;
                }
                case 2: {
                    eliminarUsuario();
                    break;
                }
                case 3: {
                    modificarUsuario();
                    break;
                }
                case 4: {
                   listaUsuarios();
                    break;
                }
            }
        }while (opcion !=9);
    }
    

    private void menuPrestamos() {
       Scanner sc= new Scanner(System.in);
        int opcion=0;//una variable entera para recojer la opción
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tPRESTAMOS\n");
            System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
            System.out.println("\t\t\t\t2 - ELIMINAR PRESTAMO");
            System.out.println("\t\t\t\t3 - PRROROGAR PRESTAMO");
            System.out.println("\t\t\t\t4 - LISTADOS PRESTAMOS");
            System.out.println("\t\t\t\t5 - LISTADOS PRESTAMOS HISTORICOS");
            System.out.println("\t\t\t\t6 - LISTADOS PRESTAMOS LIBRO(USUARIOS QUE LO LEEN");
            System.out.println("\t\t\t\t7 - LIBRO MAS LEIDO");
            System.out.println("\t\t\t\t8 - USUARIO MAS LECTOR");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion= sc.nextInt();
            switch(opcion) {
                case 1: {
                    nuevoPrestamo();
                    break;
                }
                case 2: {
                    devolucion();
                    break;
                }
                case 3: {
                    prorroga();
                    break;
                }
                case 4: {
                   listaPrestamos();
                    break;
                }
                case 5: {
                   listaPrestamosUsu();
                    break;
                }
                case 6: {
                   listaPrestamosLibro();
                    break;
                }
                case 7: {
                    libroMasLeido();
                    break;
                }
                case 8:{
                    usuarioMasLector();
                    break;
                }
            }
        }while (opcion !=9);
    }
    
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
    
       private void nuevoLibro() {    
           String isbn, titulo, autor, genero;
           int ejemplares;
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Nuevo usuario.");
        System.out.println("ISBN:");
        isbn=sc.nextLine();
        System.out.println("Titulo:");
        titulo=sc.nextLine();
        System.out.println("Autor:");
        autor=sc.nextLine();
        System.out.println("Genero:");
        genero=sc.nextLine();
        System.out.println("Numero Ejemplares:");
        ejemplares=sc.nextInt();
        libros.add(new Libro(isbn,titulo,autor,genero,ejemplares));
        
    }

    private void eliminarLibro() { 
        Scanner sc=new Scanner (System.in);
        System.out.println("ISBN del libro a Borrar: ");
        String isbn=sc.nextLine();
        int pos=buscaIsbn(isbn);
        if (pos==-1){
            System.out.println("El libro que buscas no está registrado"); 
        }else{
            libros.remove(pos);
        }
    }

    private void modificarLibros() {
        
    }

    private void listaLibros() {   
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
 
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION USUARIOS">
        private void nuevoUsuario() {
           
        String dni, nombre, email, telefono;
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Nuevo usuario.");
        System.out.println("Dni:");
        dni=sc.nextLine();
        System.out.println("Nombre:");
        nombre=sc.nextLine();
        System.out.println("Email:");
        email=sc.nextLine();
        System.out.println("Telefono:");
        telefono=sc.nextLine();
        usuarios.add(new Usuario(dni,nombre,email,telefono));
        }

    private void eliminarUsuario() {
       Scanner sc=new Scanner (System.in);
        System.out.println("DNI del usuario a Borrar: ");
        String dni=sc.nextLine();
        int pos=buscaDni(dni);
        if (pos==-1){
            System.out.println("El nombre que buscas no está registrado"); 
        }else{
            usuarios.remove(pos);
        }
    }
        
    

    private void modificarUsuario() {
        /*Scanner sc=new Scanner (System.in);
        System.out.println("Nombre del usuario a modificar: ");
        String nombre=sc.nextLine();
        int pos=buscaDni(nombre);
        if (pos==-1){
            System.out.println("El nombre que buscas no está registrado"); 
        }else{
            System.out.println("Teclea el nuevo teléfono:)");
            contactos.get(pos).setTelefono(sc.nextLine());
        
        } Hacer el finde en casa*/
    }

    private void listaUsuarios() {
         for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
    
     private void buscarUsuarioPorEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el email del usuario:");
        String email = sc.nextLine();
        boolean encontrado = false;
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Usuario encontrado: " + u);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún usuario con ese email.");
        }
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION PRESTAMOS">
    
    private void nuevoPrestamo() {
        System.out.println("Identificación del usuario:"); 
        String dni =solicitaDni();
        int posUsuario=buscaDni(solicitaDni());
        if (posUsuario==-1){
            System.out.println("No es aún usuario de la biblioteca");
        } else {// si, se puede hacer el prestamo
            System.out.println("Identificación del libro:");
            String isbn=solicitaIsbn();
            int posLibro= buscaIsbn(solicitaIsbn());
            if (posLibro==-1) {
                System.out.println("El ISBN pertenece a un libro inexistente");                
            } else if(libros.get(posLibro).getEjemplares()>0) {//podemos hacer el prestamo, tenemos el usuario y el libro
               if ((buscaPrestamo(dni,isbn))==-1){
                LocalDate hoy= LocalDate.now();
                prestamos.add(new Prestamo(libros.get(posLibro), usuarios.get(posUsuario), hoy, hoy.plusDays(15)));               
                libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
                } else {
                   System.out.println("Ese usuario ya tiene ese mismo libro en prestamo");
                }
        }       else{
                System.out.println("No quedan unidades disponibles del libro");
            }
    }
 }

    private void devolucion() {
        System.out.println("Identificación del usuario");
        String isbnLibro=solicitaIsbn();
         int pos=buscaPrestamo(solicitaDni(),isbnLibro);
        if (pos==-1){
            System.out.println("No es aún usuario de la biblioteca");
        } else {// si, se puede devolver
          prestamos.get(pos).setFechaDev(LocalDate.now());
          libros.get(buscaIsbn(isbnLibro))
                  .setEjemplares(libros.get(buscaIsbn(isbnLibro)).getEjemplares()+1);
          prestamosHist.add(prestamos.get(pos));
          prestamos.remove(pos);
    }
        }
    
    
    
        
    private void prorroga() {
        System.out.println("Datos para prorrogar el prestamo: ");
        String dni= solicitaDni();
        String isbnLibro=solicitaIsbn();
        int pos=buscaPrestamo(solicitaDni(),isbnLibro);
        if (pos==-1){
            System.out.println("No hay ningún prestamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(prestamos.get(pos).getFechaDev().plusDays(15));
            prestamos.get(pos).setFechaPrest(LocalDate.now());
        }
    }

    private void listaPrestamos() {
        System.out.println("Prestamos activos");
        for (Prestamo p : prestamos) {
         if (p.getFechaDev().isBefore(LocalDate.now())){
                    System.out.print("Libro fuera de plazo: ");
                }
            System.out.println(p);
        }
        System.out.println("Prestamos historicos");
        for (Prestamo p : prestamosHist) {
            System.out.println(p);
         }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="LISTADOS DE LAS AMPLIACIONES 1-2-3-4">
    
      private void libroMasLeido(){
        ArrayList <Integer> contadoresLibros=new ArrayList();
        int contador;
        for (Libro l : libros) {
            contador=0;
            for (Prestamo p:prestamos) {
                if (l==p.getLibroPrest()){
                    contador++;
                }
            }
            for (Prestamo p:prestamosHist) {
                if (l==p.getLibroPrest()){
                    contador++;
                }
            }
            contadoresLibros.add(contador);
        }
        
        int max=0;
        for (int c:contadoresLibros){
            if (c>max){
                max=c;
            }
        }
        System.out.println("El libro/s mas leido/s con " + max + " prestamos es/son: " );
               
        for (int i = 0; i < contadoresLibros.size(); i++) {
            if (contadoresLibros.get(i)==max){
                System.out.println(libros.get(i));
            }
        }
    }
    
    private void usuarioMasLector(){
        ArrayList <Integer> contadoresUsuarios=new ArrayList();
        int contador;
        for (Usuario u : usuarios) {
            contador=0;
            for (Prestamo p:prestamos) {
                if (u==p.getUsuarioPrest()){
                    contador++;
                }
            }
            for (Prestamo p:prestamosHist) {
                if (u==p.getUsuarioPrest()){
                    contador++;
                }
            }
            contadoresUsuarios.add(contador);
        }
        
        int max=0;
        for (int c:contadoresUsuarios){
            if (c>max){
                max=c;
            }
        }
        System.out.println("Los usuarios/as mas lectores/as con " + max + " prestamos son: " );
               
        for (int i = 0; i < contadoresUsuarios.size(); i++) {
            if (contadoresUsuarios.get(i)==max){
                System.out.println(usuarios.get(i));
            }
        }
    }
    private void listaPrestamosUsu(){
        String dni=solicitaDni();
        int pos= buscaDni(solicitaDni());
        if (pos==-1) {
            System.out.println("No hay nadie con ese DNI");
        } else {
        System.out.println("Prestamos activos de: "
            +usuarios.get(pos).getNombre());
        for (Prestamo p : prestamos) {
            if (p.getUsuarioPrest().getDni().equals(dni)){
                if (p.getFechaDev().isBefore(LocalDate.now())){
                    System.out.print("Libro fuera de plazo: ");
                }
            
                System.out.println(p);  
        }
        }
        
        System.out.println("Prestamos devueltos por: "
            +usuarios.get(pos).getNombre());
                for (Prestamo p : prestamosHist) {
            if (p.getUsuarioPrest().getDni().equals(dni)){
                System.out.println(p); 
            }
            }
        }
    }
    
    private void listaPrestamosLibro(){
        String isbn= solicitaIsbn();
        int pos= buscaIsbn(isbn);
        if(pos==-1){
            System.out.println("No tengo ningun libro con ese Isbn");
        }else{
            System.out.println("Usuarios que lo estan leyendo: ");
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
            }
            }
             System.out.println("Usuarios que lo han leido: ");
            for (Prestamo p : prestamosHist) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
        }
    }
            
        }
    }
            
        
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
    
    /**
     * Método para solicitar por teclado el dni del usuario. Pendiente la validación.
     * @return(String)dni del usuario teclado
     */
     public void fueraPlazo(){
        System.out.println("Prestamos fuera de plazo: ");
        for (Prestamo p: prestamos) {
            if(p.getFechaDev().isBefore(LocalDate.now())){
                    System.out.println(p);
            }
        }
    }
     public String solicitaDni() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Teclea el dni del usuario:");
        String dni = sc.next();
        return dni;       
    }
    
     public String solicitaNombre() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Teclea el nombre del usuario:");
        String nombre = sc.next();
        return nombre;       
    }
     
     public String solicitaTelefono() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Teclea el telefono del usuario:");
        String telefono = sc.next();
        return telefono;       
    }
    
    /**
     * Método para solicitar por teclado el isbn del libro. Pendiente la validación.
     * @return isbn (String) del libro teclado
     */
    public String solicitaIsbn() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Teclea el isbn del libro:");
        String isbn = sc.next();
        return isbn;       
    }
    
    /**
     * Método para buscar un dni en la colleción usuarios
     * @param dni dni (String) del usuario a buscar en la colección
     * @return posición (int) del usuario en el ArrayList, -1 si no se encuentra
     */
    public int buscaDni(String dni) {
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)){//si encontramos, pos=i
                pos=i;
                break;
            }           
        }
        return pos;       
    }
    
    public int buscaNombre(String nombre) {
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals(nombre)){//si encontramos, pos=i
                pos=i;
                break;
            }           
        }
        return pos;       
    }
    
    public int buscaTelefono(String telefono) {
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getTelefono().equals(telefono)){//si encontramos, pos=i
                pos=i;
                break;
            }           
        }
        return pos;       
    }
    
    public int buscaPrestamo(String dni, String isbn)//Necesito prestamo que tenga dni e isbn
    {
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni)
                    && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)){//si encontramos, pos=i
                pos=i;
                break;
            }           
        }
        return pos;       
    }
    
    /**
     * Método para buscar un libro en la colleción libros
     * @param isbn (String) del libro a buscar en la colección
     * @return posición (int) del libro en el ArrayList, -1 si no se encuentra
     */
    public int buscaIsbn(String isbn) {
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)){//si encontramos, pos=i
                pos=i;
                break;
            }           
        }
        return pos;       
    }
    
    private void cargaDatos() {//leer los archivos de libros/usuarios/prestamos
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-33","El Médico","N. Gordon","Aventuras",4)); 
        libros.add(new Libro("1-44","Chamán","N. Gordon","Aventuras",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
        libros.add(new Libro("1-66","Paraíso inhabitado","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudú","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-88","El último barco","D.Villar","Novela Negra",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",2)); 

        usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
        usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
        usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
        usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
        usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
        usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(8),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(1), hoy,hoy.plusDays(15)));
    
        prestamosHist.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(5),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(1),usuarios.get(1), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(2), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(6),usuarios.get(3), hoy.minusDays(20),hoy.minusDays(5)));
        
        libros.add(new Libro("1-11", "El Hobbit", "J.R.R. Tolkien", "Aventuras", 3));
        usuarios.add(new Usuario("11", "Ana", "ana@email.com", "621111111"));
        prestamos.add(new Prestamo(libros.get(0), usuarios.get(0), LocalDate.now().minusDays(10), LocalDate.now().plusDays(5)));
    }

//</editor-fold>

    private void totalLibros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void totalUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void totalPrestamosActivos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
