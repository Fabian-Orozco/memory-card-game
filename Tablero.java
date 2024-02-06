public class Tablero
{
    //campos de la clase
    private int largo; //le da un largo a la matriz (filas)
    private int ancho; //le da el ancho a la matriz (columnas)

    private Carta tablero[][]; //matriz del tablero

    //constructor que inicializa
    public Tablero(int largo,int ancho){
        this.largo = largo; //cantidad de filas
        this.ancho = ancho; //cantidad de columnas

        tablero = new Carta[largo][ancho]; //crea un tablero(matriz) con los valores proporcionados

        for(int indiceFila = 0 ; indiceFila < tablero.length ; indiceFila++){
            for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna = indiceColumna+2){
                Carta c = new Carta();
                if(indiceColumna < tablero[0].length-1){//si está antes de la última
                    tablero[indiceFila][indiceColumna] = c;
                    tablero[indiceFila][indiceColumna+1] = c;
                }
            }
        }
    }//final respuesta 2

    //metodos get (acceso)
    public int getLargo(){
        return largo;
    }

    public int getAncho(){
        return largo;
    }

    //metodos set (modificación)
    /**
     * Inicio respuesta 3
     * Responde al punto 3 del enunciado a calificar
     * utiliza un método enseñado por el profesor días antes de la prueba
     * guarda el dato de una carta aleatoria en una variable
     * cambia la posicion de esa carta por otra aleatoria
     * le devuelve el dato a la segunda carta
     */
    public void barajeCartas(){
        int carta1I;
        int carta1J;

        int carta2I;
        int carta2J;

        Carta temporal; //guarda fila y columna de una carta temporalmente

        for(int indiceFila = 0 ; indiceFila < tablero.length ; indiceFila++){
            for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna++){
                carta1I = (int) (Math.random()* tablero.length);
                carta1J = (int) (Math.random()* tablero[0].length);

                carta2I = (int) (Math.random()* tablero.length);
                carta2J = (int) (Math.random()* tablero[0].length);

                temporal = tablero[carta1I][carta1J];

                tablero[carta1I][carta1J] = tablero[carta2I][carta2J];
                tablero[carta2I][carta2J] = temporal;
            }
        }

    } //final respuesta 3

    /**
     * Inicio respuesta 4
     * Responde al punto 4 del enunciado, funciona con condicionales
     * Compara si una carta es par de otra dependiendo de el criterio de comparacion
     * inicializa esPar como falso y lo pasa por condicionales dependiendo 
     * del criterio de comparacion elegido 
     */
    public boolean esPar(String criterioComparacion, int filaC1, int columnaC1, int filaC2, int columnaC2){
        boolean esPar=false;
        //compara la carta dependiendo del valorLiteral(letra)
        if ( criterioComparacion.equalsIgnoreCase("Valor literal") ){
            if(tablero[filaC1][columnaC1].getValorLiteral() == tablero[filaC2][columnaC2].getValorLiteral())
                esPar=true;
        }

        //compara la carta dependiendo del numero
        if ( criterioComparacion.equalsIgnoreCase("Numero") ){
            if(tablero[filaC1][columnaC1].getNumero() == tablero[filaC2][columnaC2].getNumero())
                esPar=true;
        }

        //compara la carta dependiendo del valor literal y del numero
        if ( criterioComparacion.equalsIgnoreCase("Ambos") ){
            if(tablero[filaC1][columnaC1].getNumero() == tablero[filaC2][columnaC2].getNumero())
                if(tablero[filaC1][columnaC1].getValorLiteral() == tablero[filaC2][columnaC2].getValorLiteral())
                    esPar=true;
        }
        return esPar;
    } //final respuesta 4

    //metodo toString()
    public String toString(){
        String respuesta="";
        respuesta += "\t";
        for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna++){
            respuesta += " " + indiceColumna + "\t";
        }
        respuesta += "\n";
        respuesta += "\n";
        for(int indiceFila = 0 ; indiceFila < tablero.length ; indiceFila++){
            respuesta += indiceFila + "\t";
            for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna++){
                respuesta += tablero[indiceFila][indiceColumna] + "\t";
            }
            respuesta += "\n";
        }
        return respuesta;
    }

    /**
     * Funciona con condicionales para dar respuesta al punto 5
     * Si el usuario desea ver todas, debe pasar por parametro "Todas"
     * Si el usuario desea ver solamente las que se pueden mostrar debe pasar
     * por parámetro "Seleccionadas". 
     * Las seleccionadas solo funciona con un método(que no se pide en el enunciado)
     * que ponga las cartas en modo mostrar y ocultar.
     * Todas las cartas están en false por defecto.
     */
    public String muestreTablero(String cartasAMostrar){
        String respuesta="";
        if ( cartasAMostrar.equalsIgnoreCase("Todas") ){
            respuesta += "\t";
            for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna++){
                respuesta += " " + indiceColumna + "\t";
            }
            respuesta += "\n";
            respuesta += "\n";
            for(int indiceFila = 0 ; indiceFila < tablero.length ; indiceFila++){
                respuesta += indiceFila + "\t";
                for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna++){
                    respuesta += tablero[indiceFila][indiceColumna] + "\t";
                }
                respuesta += "\n";
            }
            System.out.println(respuesta);
        }

        else if( cartasAMostrar.equalsIgnoreCase("Seleccionadas") ){
            respuesta += "\t";
            for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna++){
                respuesta += " " + indiceColumna + "\t";
            }
            respuesta += "\n";
            respuesta += "\n";
            for(int indiceFila = 0 ; indiceFila < tablero.length ; indiceFila++){
                respuesta += indiceFila + "\t";
                for(int indiceColumna = 0 ; indiceColumna < tablero[0].length ; indiceColumna++){
                    if( (tablero[indiceFila][indiceColumna].getSeMuestra())==true )
                        respuesta += tablero[indiceFila][indiceColumna] + "\t";
                    else{
                        respuesta += "()\t";}
                }
                respuesta+="\n";
            }
        }
        return respuesta;
    }

    //unico controlador universal
    public static void main(String a[]){
        Tablero t1 = new Tablero(3,4); //para que todos tengan pareja, la cantidad de columnas debe ser par.

        //System.out.println(t1.getVectorCarta());
        System.out.println("tablero original:\n\n " + t1.toString());
        t1.barajeCartas();
        System.out.println("Despues de barajar:\n\n" + t1.toString());

        System.out.println("MuestreTablero: 'Todas'\n\n" + t1.muestreTablero("Todas"));

        //para que funcione se debe ir a carta y poner valor de seMuestra en true
        System.out.println("MuestreTablero: 'Seleccionadas'\n\n" + t1.muestreTablero("seleccionadas"));
    }
}
