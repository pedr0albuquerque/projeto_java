package appviagem;

import java.util.Scanner;

public class AppViagem {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String opcaoTransporte, opcaoHospedagem;
        Transporte transporteEscolhido = null; // vamos usar uma variavel para guardar o transporte escolhido para manipularmos fora do escopo
        Hospedagem hospedagemEscolhida = null; // o mesmo para hospedagem
        boolean statusTrans = false, statusHosp = false; //esta variavel vai garantir que os dados estejam preechidos para seguirmos
        PacoteViagem pacoteViagem = null; // assim como transporte e hospedagem, adicionamos uma variavel para manipular o pacote em outro escopo
        
        System.out.println("Qual o meio de transporte? (A = Aéreo / R = Rodoviário / M = Marítimo)");
        opcaoTransporte = entrada.nextLine();
        
        switch (opcaoTransporte){
            case "A":
                System.out.println("Qual o valor da passagem aérea?");
                float precoAviao = Float.parseFloat(entrada.nextLine());
                Transporte aviao = new Transporte("aéreo",precoAviao);
                System.out.println(aviao.getValor()+" "+aviao.getTipo());
                transporteEscolhido = aviao;
                statusTrans = true;
                break;
                
            case "R":
                System.out.println("Qual o valor da passagem rodoviária?");
                float precoOnibus = Float.parseFloat(entrada.nextLine());
                Transporte onibus = new Transporte("rodoviário",precoOnibus);
                System.out.println(onibus.getValor()+" "+onibus.getTipo());
                transporteEscolhido = onibus;
                statusTrans = true;
                break;
                
            case "M":
                System.out.println("Qual o valor da passagem marítima?");
                float precoNavio = Float.parseFloat(entrada.nextLine());
                Transporte navio = new Transporte("marítimo",precoNavio);
                System.out.println(navio.getValor()+" "+navio.getTipo());
                transporteEscolhido = navio;
                statusTrans = true;
                break;
        }
        
        
        
        System.out.println("Escolha uma hospedagem (C = Casa / H = Hotel)");
        opcaoHospedagem = entrada.nextLine();
        switch (opcaoHospedagem){
            case "C":
                System.out.println("Qual o valor da diaria da casa?");
                float valorCasa = Float.parseFloat(entrada.nextLine());
                Hospedagem casa = new Hospedagem("2 Quarto, Sala, Banheiro e Garagem",valorCasa);
                System.out.println(casa.getDescricao()+" "+casa.getValorDiaria());
                hospedagemEscolhida = casa;
                statusHosp = true;
                break;
                
            case "H":
                System.out.println("Qual o valor da diaria da hotel?");
                float valorHotel = Float.parseFloat(entrada.nextLine());
                Hospedagem hotel = new Hospedagem("1 Quarto, Banheiro",valorHotel);
                System.out.println(hotel.getDescricao()+" "+hotel.getValorDiaria());
                hospedagemEscolhida = hotel;
                statusHosp = true;
                break;
        }
        
        if(statusTrans == true && statusHosp == true){
            System.out.println("Muito bem! Agora informe destino");
            String destino = entrada.nextLine();
            
            System.out.println("Agora informe a quantidade de dias");
            byte quantidadeDias = (byte) Integer.parseInt(entrada.nextLine());
            
            PacoteViagem viagem = new PacoteViagem(transporteEscolhido,hospedagemEscolhida,destino,quantidadeDias);
            
            viagem.calcularTotalHospedagem();//calcular imediatamente o valor da hospedagem
            
            System.out.println("Qual a porcentagem de lucro?");
            float porcentagem = Float.parseFloat(entrada.nextLine());
            viagem.calcularLucro(porcentagem);
            
            System.out.println("Adicione o valor das taxas adicionais");
            float taxas = Float.parseFloat(entrada.nextLine());
            viagem.calcularTotal(taxas);
            
            viagem.getTodosDados();
            pacoteViagem = viagem;
        }
        
        System.out.println("Pacote criado");
        
        System.out.println("Vamos registrar uma venda"+"\nEscreva o nome do cliente");
        String nomeCliente = entrada.nextLine();
        
        System.out.println("Insira a forma de pagamento");
        String formaPag = entrada.nextLine();
        
        Venda venda = new Venda(nomeCliente, formaPag, pacoteViagem);
        
        System.out.println("Informe a cotação do dolar para convertermos o valor para R$");
        float cotacao = Float.parseFloat(entrada.nextLine());
        venda.converterValor(cotacao);
        venda.getDadosVenda();
        
    }
}
