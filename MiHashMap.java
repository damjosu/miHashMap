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
     * @param clave La clave a introducir.
     * @param valor El valor a introducir.
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
    
    /**
     * Devuelve el valor asociado con la clave especificada 
     * o -1 en caso de que la clave no exista. 
     * @param clave La clave a introducir.
     * @return el valor.
     */
    public int get(String clave) {
        int valor = -1;
        if (claves.contains(clave)) {
            valor = valores[claves.indexOf(clave)];
        }
        return valor;
    } 
   
    /**
     * Devuelve true si el mapa no contiene elementos. 
     */
    public boolean isEmpty() {
        return ((claves.size() == 0) && (valores.length == 0));
    }
    
    /**
     * Devuelve el número de elementos del mapa.
     */
    public int size() {
        return claves.size();
    }
    
    /**
     * Elimina del mapa el elemento con la clave dada y devuelve su valor.
     * Si no hay esa clave en el mapa devuelve -1.
     * @param clave La clave a introducir.
     * @return valor El valor a devolver.
     */
    public int remove(String clave) {
        int valor = -1;
        int temp[];
        int i = 0;
        int cont = 0;
        boolean existe = false;
        while ((i < claves.size()) && !(existe)) {
            if (clave == claves.get(i)) {
                valor = valores[i];
                claves.remove(i);
                temp = new int[valores.length - 1];                
                for (; cont < i; cont++) {
                    temp[cont] = valores[cont];
                }                
                for (; cont < temp.length; cont++) {
                    temp[cont] = valores[cont + 1];
                }                
                valores = temp;
                existe = true;
            }
            i++;            
        } 
        return valor;
    }
    
    /**
     * Vacía el mapa.
     */
    public void clear() {
        claves.clear();
        valores = new int[0];
    }
    
}
