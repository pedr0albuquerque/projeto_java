package appviagem;
public class Venda {
    private String nome;
    private String formaPagamento;
    private PacoteViagem pacoteViagem;
    private float valorReal;
    
    public Venda(String nome, String formaPagamento, PacoteViagem pacoteViagem){
        this.nome=nome;
        this.formaPagamento=formaPagamento;
        this.pacoteViagem=pacoteViagem;
    }
    
    public float converterValor(float cotacao){
        valorReal = pacoteViagem.getTotal()*cotacao;
        return valorReal;
    }
    
    public void getDadosVenda(){
        System.out.println("Nome cliente: "+nome+"\nForma de pagamento: "+formaPagamento+
                            "\nValor em dólar: "+pacoteViagem.getTotal()+
                            "\nValor em real: "+valorReal);
    }
}
