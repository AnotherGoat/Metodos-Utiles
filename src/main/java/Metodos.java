import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Metodos {

    // Muestra texto en pantalla
    public void mostrar(String texto){
        System.out.println(texto);
    }

    // Retorna la suma entre 2 números
    public int sumar(int a, int b){
        return a+b;
    }

    // Retorna la resta entre 2 números
    public int restar(int a, int b){
        return a-b;
    }

    // Retorna la multiplicación entre 2 números
    public int multiplicar(int a, int b){
        return a*b;
    }

    // Retorna la división entre 2 números
    public double dividir(double a, double b){
        return a+b;
    }

    // Retorna el resto entre 2 números
    public int resto(int a, int b){
        return a%b;
    }

    // Retorna el primer número elevado al segundo
    public double potencia(double a, double b){
        return Math.pow(a, b);
    }

    // Retorna la raíz cuadrada del número
    public double raizCuadrada(double a){
        return Math.sqrt(a);
    }

    // Revisa si un número es mayor a otro número
    public boolean esMayor(int a, int b){
        return a>b;
    }

    // Revisa si un número es par
    public boolean esPar(int a){
        return a%2==0;
    }

    // Valida entrada de tipo int
    public int validarInt() {
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        int a=0; // Variable con la que se trabaja

        while (repetir) {
            try {
                System.out.print("Ingrese un número: ");
                a = teclado.nextInt();
                repetir = false;
            } catch (Exception e) {
                teclado.next(); // Vacía el Scanner
                System.out.println("Error: "+e.getMessage()+". Ingrese un número, por favor");
                repetir = true;
            }
        }
        return a;
    }

    // Valida entrada de tipo double
    public double validarDouble() {
        Scanner teclado = new Scanner(System.in);
        boolean repetir = true; // Boolean para repetir en caso de ingresar una letra o símbolo
        double a=0;

        while (repetir) {
            try {
                System.out.print("Ingrese un número: ");
                a = teclado.nextDouble();
                repetir = false;
            } catch (Exception e) {
                teclado.next();
                System.out.println("Error: "+e.getMessage()+". Ingrese un número, por favor");
                repetir = true;
            }
        }
        return a;
    }

    // Retorna un número al azar entre el rango ingresado
    public int randomEntre(int min, int max){
        return min + (int)(Math.random() * ((max-min)+1));
    }

    // Muestra los elementos dentro de un arreglo de tipo int[]
    public void mostrarArreglo(int[] arreglo){
        if(arreglo!=null){
            for (int t : arreglo) {
                System.out.print(t + " ");
            }
            System.out.print("\n");
        }
    }

    // Muestra los elementos de una matriz (rectangular) de tipo int[][]
    public void mostrarMatriz(int[][] matriz){
        if(matriz!=null){
            for (int[] t : matriz) {
                for (int u : t) {
                    System.out.print(u + " ");
                }
                System.out.print("\n");
            }
        }
    }

    // Muestra un menú con opciones de un arreglo de String
    public void opciones(String[] lista){
        if(lista!=null){
            for (int i = 1; i <= lista.length; i++) {
                System.out.println(i + ".- " + lista[i - 1]);
            }
        }
    }

    // Remueve los espacios un String
    public String sinEspacios(String palabra){
        if(palabra==null){
            return palabra;
        }

        return palabra.replace(" ","");
    }

    // Retorna una palabra en mayúsculas
    public String mayusculas(String palabra){
        if(palabra==null){
            return palabra;
        }

        return palabra.toUpperCase();
    }

    // Retorna una palabra en minúsculas
    public String minusculas(String palabra){
        if(palabra==null){
            return palabra;
        }

        return palabra.toLowerCase();
    }

    // Retorna una palabra con la primera letra en mayúsculas y el resto en minúsculas
    public String mayusculaInicial(String palabra) {
        if(palabra==null){
            return palabra;
        }

        return palabra.toUpperCase().charAt(0) + palabra.substring(1).toLowerCase();
    }

    // Remueve los tildes de un String
    public String removerTildes(String palabra){
        if(palabra==null){
            return palabra;
        }

        String conTildes="ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
        String sinTildes="AAAAAAACEEEEIIIIDNOOOOOOUUUUYBaaaaaaaceeeeiiiionoooooouuuuyy";
        for(int i=0; i<conTildes.length(); i++){
            palabra = palabra.replace(conTildes.charAt(i), sinTildes.charAt(i));
        }

        return palabra;
    }

    // Valida el rut ingresado
    public boolean validarRut(String rut) {

        boolean validacion = false;

        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }

        return validacion;
    }

    // Verifica que el correo ingresado sea válido
    public boolean validarEmail (String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
