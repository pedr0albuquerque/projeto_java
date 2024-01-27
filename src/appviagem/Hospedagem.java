package appviagem;
public class Hospedagem {
    private String descricao;
    private float valorDiaria;
    
    public Hospedagem(String descricao, float valorDiaria){
        this.descricao=descricao;
        this.valorDiaria=valorDiaria;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public float getValorDiaria(){
        return valorDiaria;
    }
}