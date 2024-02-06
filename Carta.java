public class Carta
{
    //campos de la clase
    private int numero; //cada carta posee un valor numerico
    private char valorLiteral; //cada carta posee una letra del abecedario
    private boolean numEsPar;
    
    private boolean seMuestra; //indica si la carta se puede mostrar o si no

    private char abecedario[]; //contiene un abecedario [A,Z]

    //constructor que inicializa
    public Carta(){
        numero = (int)(1+Math.random()*10); //le da un valor de 1 a 10 aleatorio

        abecedario = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int numRandom = (int)(0+Math.random()*27); //va del indice 0 al 26
        valorLiteral = abecedario[numRandom]; //asigna al valor literal un indice aleatorio del vector abecedario

        seMuestra = false;
        if((valorLiteral % 2)==0){
            numEsPar=true;
        }
        else{numEsPar=false;}
    }

    //metodos get (acceso)
    public int getNumero(){
        return numero;
    }

    public char getValorLiteral(){
        return valorLiteral;
    }

    public boolean getNumEsPar(){
        return numEsPar;
    }

    public boolean getSeMuestra(){
        return seMuestra;
    }

    //metodo toString()
    public String toString(){
        String respuesta = valorLiteral + "," + numero;
        return respuesta;
    }

    //unico controlador universal
    public static void main(String a[]){
        Carta c1 = new Carta();
        System.out.println(c1.toString()); 
    }
}
