import java.util.Scanner;

public class ValidacionDeContraseña {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String password = "123456";
        String usuario;

        System.out.println("Ingrese su contraseña: ");
        usuario = teclado.nextLine();
        
        if (password.equals(usuario)) {
            System.out.println("¡Acceso permitido!");
        } else {
            System.out.println("¡Acceso denegado!");
        }
    }
}
