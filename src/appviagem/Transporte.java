package appviagem;
public class Transporte {
    private String tipo;
    private float valor;
    
    public Transporte(String tipo, float valor){
        this.tipo=tipo;
        this.valor=valor;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public float getValor(){
        return valor;
    }
}