package Ahorcado;
import java.util.Scanner;
public class AhorcadoMain {

    public static void main(String[] args) {
        
        int opcion;
        String letra;
        
        
        Scanner leer = new Scanner(System.in);
        Ahorcado ahorcado = new Ahorcado();

        System.out.println("Bienvenido al juego ahorcado!");
        do{
            System.out.println("Seleccioná la dificultad que querés\n1. Fácil (15 intentos)\n2. Medio (10 intentos) \n3. Difícil (7 intentos)");
            opcion = leer.nextInt();
            if (opcion<1 || opcion>3){
                System.out.println("La opción ingresada es incorrecta, ingresa una opción correcta.");
            }
        }while(opcion<1 || opcion>3);
        
        
        ahorcado.set_cantidad_intentos(opcion);
        ahorcado.set_palabra_a_buscar();
        
        System.out.println("Muy bien! Tendrás "+ahorcado.get_cantidad_intentos()+" intentos. "
                + "te recordamos que no se usarán tildes en las palabras, aunque lleven. A jugar!");
        
        //System.out.println("La palabra a buscar es "+ ahorcado.get_palabra_a_buscar());
        System.out.println("La palabra a buscar tiene "+ahorcado.longitud_palabra()+" letras.");
        
        do{
        do{
            System.out.println("");
            System.out.println("**********************************");
            System.out.println("Ingresa una letra");
            letra = leer.next();
            if (letra.length()<1 || letra.length()>1){
               System.out.println("Has ingresado una cantidad equivocada de letras, sólo tienes que ingresar una.");
            }
            
            
        }while (letra.length()<1 || letra.length()>1);
        
        ahorcado.comprobar_letra(letra);
        System.out.println(ahorcado.get_acierto_error());
        System.out.println("Te quedan "+ahorcado.get_cantidad_intentos()+" intentos.");
        System.out.print("La palabra está quedando: ");
        ahorcado.get_vector_soporte();
        System.out.println("");
        ahorcado.set_palabra_completa();
        



        }while (ahorcado.get_cantidad_intentos()>0 && ahorcado.get_guiones()==true);
        
        ahorcado.set_palabra_completa();
        if (ahorcado.get_guiones()==false){
            System.out.println("Felicitaciones! Has encontrado la palabra "+ahorcado.get_palabra_a_buscar()+"!");
        }
        else {
            System.out.println("No encontraste la palabra :( La palabra era: "+ahorcado.get_palabra_a_buscar());
        }
        
        
        
    }
}