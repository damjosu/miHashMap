import java.util.ArrayList;
/**
 * Clase MiHashMap que recrea los métodos del HashMap 
 * sin el uso de la clase HashMap. 
 * @author (Josu) 
 * @version (25/02/2015)
 */
public class MiHashMap
{
    private ArrayList<String> claves;
    private int valores[];
    
    /**
     * Constructor de la clase MiHashMap
     */
    public MiHashMap() {
        claves = new ArrayList<>();
        valores = new int[0];
    }
    
    /**
     * Asocia el valor especificado con la clave especificada. 
     * Si la clave existía, entonces sobreescribe su valor y 
     * devuelve el valor antiguo. Si no existía devuelve -1.
     * @param clave La clave.
     * @param valor El valor.
     * @return el valor antiguo.
     */
    public int put(String clave, int valor) {        
        int valorAntiguo = -1;
        boolean existe = false;
        int i = 0;
        int cont;
        int temp[];
        while ((i < claves.size()) && !(existe)) {
            if (clave == claves.get(i)) {
                valorAntiguo = valores[i];
                valores[i] = valor;              
                existe = true;
            }
            i++;            
        }  
        
        if (!existe) {          
                claves.add(clave);
                temp = new int[valores.length + 1];
                if (valores.length == 0) {
                    valores = new int[1];
                    valores[0] = valor;
                }
                else {
                    for(cont = 0; cont < valores.length; cont++) {
                        temp[cont] = valores[cont];
                    }
                    temp[cont] = valor;
                    valores = temp;    
                }     
        }
        return valorAntiguo;        
    }
    
   
}
