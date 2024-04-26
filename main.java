import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
  {
        Scanner scanner = new Scanner(System.in);
        String apiKey = "18cd09bcd21ed27ac6140fed";
        Convertidor convertidor = new Convertidor();
        System.out.println("Bienvenido al Convertidor de divisas de GabScosmos, gracias por estar aquí. :3 ");

        do 
        {
            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            System.out.print("Ingrese la divisa de origen (código de 3 letras): ");
            String divisaOrigen = scanner.next().toUpperCase();
            System.out.print("Ingrese la divisa de destino (código de 3 letras): ");
            String divisaDestino = scanner.next().toUpperCase();

            double convertedAmount = convertidor.conversor(cantidad, divisaOrigen, divisaDestino);
            System.out.println("Resultado de la conversión: " + convertedAmount + " " + divisaDestino);

            System.out.print("¿Desea hacer otra conversión? (s/n): ");
            String respuesta = scanner.next().toLowerCase();
            if (!respuesta.equals("s")) 
            {
                break;
            }
        } while (true);
        scanner.close();
    }
}
