import java.util.Scanner;

public class Main {
    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;

    // Gran parte de la lógica cambia por consecuencia de las firmas
    /**
     * Posibles estados: Contento, Triste, Cansado, Hambriento, Fin del juego
     */

    private static int menuPrincipal(){
        Scanner sc = new Scanner (System.in);
        int input;

        String[] opciones = {
                "1. Estado",
                "2. Comer",
                "3. Jugar",
                "4. Dormir",
                "----------------",
                "0. Salir\n",
                "Seleccione una opción del menú: "
        };

        while (true){

            for (int i = 0; i < opciones.length; i++){
                if (i < opciones.length - 1){
                    System.out.println(opciones[i]);
                } else {
                    System.out.print(opciones[i]);
                }
            }

            try {
                input = Integer.parseInt(sc.nextLine());
                if (input > 4 || input < 0){
                    System.out.println("Introduce un valor válido.\n");
                    continue;
                }

                return input;
            } catch (Exception e) {
                System.out.println("Introduce un valor válido.\n");
                continue;
            }
        }
    }

    private static void mostrarEstado(){
        System.out.println("(saciedad: " + saciedad + ", energía: " + energia + ", diversión: " + diversion + ")");

        String[] contento = {
                "\t   .--.      .--.",
                "\t  |    |____|    |",
                "\t  |              |",
                "\t   \\\\   ^    ^   /",
                "\t    \\\\    w    /",
                "\t     '.______.'",
                "\t     _/      \\\\_",
                "\t    (   /  \\\\   )"
        };

        String[] triste = {
                "\t   .--.      .--.",
                "\t  |    |____|    |",
                "\t  |              |",
                "\t   \\\\   T    T   /",
                "\t    \\\\    ~    /",
                "\t     '.______.'",
                "\t       /      \\\\",
                "\t      / |  | \\\\"
        };

        String[] cansado = {
                "\t   .--.      .--.",
                "\t  |    |____|    |   Zzz...",
                "\t  |              |",
                "\t   \\\\   -    -   /",
                "\t    \\\\    o    /",
                "\t     '.______.'",
                "\t       /      \\\\",
                "\t      /   ||   \\\\"
        };

        String[] hambriento = {
                "\t   .--.      .--.",
                "\t  |    |____|    |",
                "\t  |              |",
                "\t   \\\\   O    O   /",
                "\t    \\\\    ~    /  ",
                "\t     '.______.'",
                "\t       /      \\\\",
                "\t      / /  \\\\ \\\\"
        };

        String[] finDelJuego = {
                "\t   .--.      .--.",
                "\t  |    |____|    |",
                "\t  |              |",
                "\t   \\\\   X    X   /",
                "\t    \\\\    -    /",
                "\t     '.______.'",
                "\t       /      \\\\",
                "\t     _/__/\\\\__\\\\_"
        };

        if (saciedad > 5 && energia > 5 && diversion > 5){
            for(String i: contento){
                System.out.println(i);
            }
        } else if (diversion <= 4) {
            for(String i: triste){
                System.out.println(i);
            }
        } else if (energia <= 4) {
            for(String i: cansado){
                System.out.println(i);
            }
        } else if (saciedad <= 4) {
            for(String i: hambriento){
                System.out.println(i);
            }
        } else if (saciedad == 0 || energia == 0 || diversion == 0) {
            for(String i: finDelJuego){
                System.out.println(i);
            }
        } else {
            System.out.println("¡Logro oculto!");
        }
    }

    private static void comer(){
        if (saciedad < 10){
            saciedad += 3;
            diversion -= 1;
            if (saciedad > 10){
                saciedad = 10;
            }
            mostrarEstado();
        } else {
            System.out.println("\nNo tengo hambre.");
        }
    }

    public static void main(String[] args){
        // Cambio de la estructura a una estática (por los métodos)
        int input = menuPrincipal();

        switch (input) {
            case (1):
                mostrarEstado();
                break;
            case (2):
                comer();
                break;
            case (3):
                // jugar();
                break;
            case (4):
                // dormir();
                break;
            case (0):
                // salir();
                break;
        }
    }
}
