
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int tamanhoMapa;
        int mod;
        int incremento;
        int chave;
        int menu = 0;

        Scanner ler = new Scanner(System.in);
        System.out.printf("Informe o tamanho do mapa: ");
        tamanhoMapa = ler.nextInt();
        System.out.printf("Informe o imcremento: ");
        incremento = ler.nextInt();
        Hash hash = new Hash(tamanhoMapa, incremento);
        System.out.printf("\n**************Menu**************");
        System.out.printf("\n1 - Encerrar");
        System.out.printf("\n2 - Inserir chave");
        System.out.printf("\n3 - Buscar chave");
        System.out.printf("\n4 - Remover chave");
        System.out.printf("\n5 - Imprimir mapa");
        System.out.printf("\n********************************");
        while (menu != 1) {
            System.out.printf("\nInforme a operação: ");
            menu = ler.nextInt();
            if (menu == 1) {
                System.out.println("\nPrograma encerrado!");
                break;
            }
            if (menu == 2) {
                System.out.printf("\nInforme uma chave para ser inserida: ");
                chave = ler.nextInt();
                hash.insereChave(chave);
            }
            if (menu == 3) {
                System.out.printf("\nInforme uma chave para ser buscada: ");
                chave = ler.nextInt();
                if(hash.buscaChave(chave) == null){
                    System.out.println("\nChave nao encontrada!");
                }else{
                    System.out.println("\nChave na posição "+ hash.buscaChave(chave) +".");
                }
            }
            if (menu == 4) {
                System.out.printf("\nInforme uma chave para removida: ");
                chave = ler.nextInt();
                if(hash.buscaChave(chave) == null){
                    System.out.println("\nChave nao encontrada!");
                }else{
                    hash.removeChave(chave);
                    System.out.println("\nChave removida ");
                }
            }
            if (menu == 5) {
                Object mapa[] = hash.getMapa();
                for (int i = 0; i < mapa.length; i++) {
                    //System.out.println("");
                    System.out.println(i + "-->" + mapa[i]);
                }
                
            }

        }

    }

}
