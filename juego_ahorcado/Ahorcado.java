package Ahorcado;

public class Ahorcado {
    private String [] vector1 = {"oftalmologia", "diatonico", "piano", "visible", "gallina", "cuatrocientos", "renunciar", "oscilar", "abismal",
        "redondear", "chocolate", "vainilla", "corsario", "exagerar", "rueda", "abaco", "aperitivo", "naranja", "salvaje", "decapitar", "europa",
        "agricultura", "caminos", "budismo", "imperio", "senado", "pesca", "piscina", "caleidoscopio", "demonio", "duende", "vampiro", "fantasma",
        "caramelo", "murcielago", "cordillera", "queso", "agarrar", "fascinar", "admirar", "estaticos", "dinamicos", "programacion", "navidad",
        "guitarra", "aguinaldo", "sueldo", "conductor", "magnetico", "reservada", "caracter"};
    private String [] vector_palabra;
    private String [] vector_soporte;
    private int intentos;
    private String palabra;
    private int longpalabra;
    private String letra;
    private boolean acierto;
    private int guiones=0;
    private boolean x=false;
    private boolean letra_encontrada=false;
    
    
    //Constructor vacío    
    public Ahorcado(){ 
        
    }
    
    //Elijo una posición aleatoria del vector 1 que establezca la palabra que está en esa posición y la guardo en la variable palabra
    //además paso la palabra a un vector.
    public void set_palabra_a_buscar(){ //SETTER
        palabra = vector1[((int)((Math.random()*vector1.length+1)))]; //Elijo una posición random del vector con las palabras ya ingresadas para elegir la palabra
        vector_palabra = new String [palabra.length()]; //le doy dimension al vector según la cantidad de letras de la palabra
        vector_soporte = new String [palabra.length()]; //le doy la misma dimensión al vector de soporte
        set_longitud_palabra(); //Inicializo el método de la longitud de la palabra
        
        for (int i=0;i<palabra.length();i++){
            vector_palabra[i]=Character.toString(palabra.charAt(i)); //paso las letras por separado al vector palabra
            vector_soporte[i]="_ "; //al vector de soporte le paso guiones bajos según la cantidad de letras de la palabra
            //System.out.print(vector_palabra[i]+ " ");
            //System.out.println(" ");
            //System.out.print(vector_soporte[i]+ " ");
        }
    }
    
    //Informo de la palabra elegida al azar para control propio
    public String get_palabra_a_buscar(){
        return palabra;
    }
    
    /*Según la dificultad que puso el usuario 1.Fácil 2.Medio 3.Difícil
    es la cantidad de intentos que le seteo a la variable de clase intentos
    */
    public void set_cantidad_intentos(int dificultad){ //SETTER
        if (dificultad==1){             //Depende la dificultad el seteo de la cantidad de intentos.
            intentos=15;
        }
        else if (dificultad==2){
            intentos=10;
        }
        else{
            intentos=7;
        }
    }
        
    //Informo de la cantidad de intentos que tendrá el usuario según el nivel de dificultad elegido.
    public int get_cantidad_intentos(){ //GETTER
        return intentos;
    }
    
    //Seteo la longitud de la palabra.
    public void set_longitud_palabra(){ //SETTER
        longpalabra=palabra.length();
    }
    
    //Informo de la longitud de la palabra.
    public int longitud_palabra(){ //GETTER
        return longpalabra;
    }
    
    //Desde el main mando a este método la letra a buscar
    public void comprobar_letra(String letra){
        this.letra=letra;
        letra_encontrada=false; //seteo en false por las dudas que en ejecución pasada haya quedado en true.
        x=false; //la variable x sirve para saber si la letra ingresada ya se ingresó antes (lo comprueba en el vector de soporte)
        for (int i=0;i<palabra.length();i++){
            if (letra.equalsIgnoreCase(vector_palabra[i])){ //Acá comprueba si la letra coincide con alguna letra de la palabra
                if (letra.equalsIgnoreCase(vector_soporte[i])){ //Si la letra ya fue ingresada antes (por estar en el vector de soporte):
                    letra_encontrada=true; //true por encontrar una letra pero...
                    x=false; //false en x porque ya se ingresó antes
                    break;
                }
                else{ //Entra acá si la letra se encontró y no está en el vector de soporte (primera vez que ha sido ingresada)
                    vector_soporte[i]=vector_palabra[i]; //Se pasa la letra al vector de soporte que tiene las letras que se van encontrando
                    letra_encontrada=true; //Se encontró una letra de la palabra
                    x = true; //La letra que se encontró no se había ingresado antes
                }
            }
        }
    }
    
    public String get_acierto_error(){
        if (letra_encontrada==true && x==true){ //Si la letra se encontró en la palabra
            intentos--; //Se le descuenta un intento
            return "La letra "+letra+" pertenece a la palabra!"; //Mensaje de letra encontrada
        }
        else if (letra_encontrada==true && x==false){ //Si la letra se encontró en la palabra pero ya había sido ingresada antes (no se le descuenta intentos)
            return "Ya has ingresado la letra "+letra+" pero no te preocupes, no se te descontará este intento.";
        }
        else { //Si la letra no está en la palabra
            intentos--; //Se le resta un intento
            return "La letra "+letra+" no pertenece a la palabra :(";
        }
    }
    
    public void get_vector_soporte(){ //Sirve para mostrar las letras que se van encontrando con cada intento
        for (String elementos:vector_soporte){
            System.out.print(elementos);
        }
    }

    public void set_palabra_completa(){ //Acá se pasa la palabra elegida al azar por el programa al vector principal que contiene todas las letras.
        guiones=0;
        for (int i=0;i<palabra.length();i++){
            if (vector_soporte[i].equals("_ ")) {
                guiones++;
            }
        }
    }
    
    public boolean get_guiones(){ //Acá comprueba los guiones en el vector soporte (recordar que lo seteamos al principio con tantos guiones
        if (guiones!=0){          //como letras tiene la palabra escogida al azar). Si tiene algún guion es que no se han encontrado todas
            return true;          //las letras. Esto sirve para comprobar si se encontró la palabra completa (cuando ya no queda ningún guion
        }                         //ya que todos fueron reemplazados por letras encontradas). De esta forma por un lado, si no queda ningún guion no sigue
        else{                     //pidiendo letras y dice que uno ganó, o para cuando se terminan los intentos, si queda alguno, decir que se perdió.
            return false;
        } 
    }


}
    
    

