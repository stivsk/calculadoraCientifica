package scientificccalculator;

/**
 *
 * @author calle
 */
public class ScientificCalculator {
        
    //Variables que almacenan los valores a operar
    //@data representa los digitos de la pantalla
    private static float result;
    private static String data, operation;
    
    //GETERS Y SETERS
    
    public ScientificCalculator(){
        data = "";
        result = 0;
        operation = "";
    }

    public String getData() {
        return data;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        ScientificCalculator.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        ScientificCalculator.operation = operation;
    }
    
    public void setData(String data) {
        ScientificCalculator.data = data;   
    }
    
    //METODOS Y FUNCIONES
    
    //Concatena las entradas de txtEntrada (Agrega digitos a la pantalla)
    protected void NumPresionado(Object x){
        setData(getData()+x);
    }   
    
    //Se encaraga de manejar las llamadas a las diferentes operaciones
    //donde x es la ultima entrada de txtEntrada
    protected void opPresionada(String op, String x){
        //Setea el resultado como el dato recibido 
        setResult(Float.parseFloat(x));
        //Reinicia Data que es la encargada de almacenar las entradas previas a la operacion
        setData("");
        
        switch(op){
            case "+":
                setOperation("suma");
                break;
            case "-":
                setOperation("resta");
                break;
            case "*":
                setOperation("producto");
                break;
            case "/":
                setOperation("cociente");
                break;
            case "%":
                setOperation("modulo");
                break;
            case "v/":
                setOperation("raiz");
                break;
            case "CE":
                setOperation("CE");
                break;
        }
                          
    }
    
    //Obtiene el tipo de operacion a realizar seteada en el metodo "opPresionada" y la ejecuta
    //Donde x es la entrada de txtEntrada posterior a la seleccion de la operacion
    protected double total(String x){
        double total = 0;
        double nuevo = Double.parseDouble(x);
        
        switch(getOperation()){
            case "suma":
                total = getResult() + nuevo;
                break;
            case "resta":
                total = getResult() - nuevo;
                break;
            case "producto":
                total = getResult() * nuevo;
                break;
            case "cociente":
                total = getResult() / nuevo;
                break;
            case "modulo":
                total = getResult() % nuevo;
                break;
            case "raiz":
                total = Math.pow(result, 1/nuevo);
                break;
            //Reinicia Toda la calculadora
            case "CE":
                setData("0");
                break;
        }
        
        return total;
    }
    //Elimina la ultima entrada ingresada
    protected void C(String x){
        setData("");
    }
    
}
