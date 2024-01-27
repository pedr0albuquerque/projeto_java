package appviagem;
public class PacoteViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private byte quantidadeDias;
    private float totalComLucro;
    private float totalPacoteViagem;
    
    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, byte quantidadeDias){
        this.transporte=transporte;
        this.hospedagem=hospedagem;
        this.destino=destino;
        this.quantidadeDias=quantidadeDias;
    }
    
    public float calcularTotalHospedagem(){
        return hospedagem.getValorDiaria() * quantidadeDias;
    }
    
    public float calcularLucro(float porcentagemLucro){
        float total = calcularTotalHospedagem() + transporte.getValor();
        totalComLucro = total +(total * porcentagemLucro)/100;
        return totalComLucro;
    }
    
    // aqui vai calcular o valor + lucro + taxas
    public float calcularTotal(float taxasAdicionais){
        totalPacoteViagem = taxasAdicionais+totalComLucro;
        return totalPacoteViagem;
    }
    
    public float getTotal(){
        return totalPacoteViagem;
    }
    
    public void getTodosDados(){
        System.out.println("\nDestino: "+destino+"\nQuantidade de dias: "+quantidadeDias+
                            "\nHospedagem: "+hospedagem.getDescricao()+"\nTransporte: "+transporte.getTipo()+
                            "\nPreço com lucro adicionado: "+totalComLucro+"\nTotal + Taxas: "+totalPacoteViagem);
    }
}