import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();

        // Crear y agregar libros
        Libro libro1 = new Libro(1, "1984", "George Orwell", 1949);
        Libro libro2 = new Libro(2, "El Principito", "Antoine de Saint-Exupéry", 1943);
        libroDAO.agregarLibro(libro1);
        libroDAO.agregarLibro(libro2);

        // Obtener y mostrar todos los libros
        List<Libro> libros = libroDAO.obtenerTodosLosLibros();
        System.out.println("Lista de libros:");
        libros.forEach(System.out::println);

        // Actualizar un libro
        Libro libroActualizado = new Libro(1, "1984", "George Orwell", 1950);
        libroDAO.actualizarLibro(libroActualizado);
        System.out.println("\nDespués de actualizar:");
        System.out.println(libroDAO.obtenerLibro(1));

        // Eliminar un libro
        libroDAO.eliminarLibro(2);
        System.out.println("\nLista de libros después de eliminar 'El Principito':");
        libros = libroDAO.obtenerTodosLosLibros();
        libros.forEach(System.out::println);
    }
}
