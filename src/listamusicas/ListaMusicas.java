package listamusicas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaMusicas {

    public static void main(String[] args) {
        Musica inicio = new Musica();
        Musica termino = new Musica();
        Musica novo = new Musica();
        Musica atual = new Musica();

        int opcao;
        do {
            System.out.println("Digite a opção que você deseja realizar: ");
            System.out.println("1 - Incluir um objeto no início na lista");
            System.out.println("2 - Incluir um objeto no final da lista");
            System.out.println("3 - Verificar se um objeto específico está na lista");
            System.out.println("4 - Remover um objeto específico da lista");
            System.out.println("5 - Remover o primeiro objeto da lista");
            System.out.println("6 - Remover o último objeto da lista");
            System.out.println("7 - Mostrar todos os objetos da lista na ordem do primeiro para o último");
            System.out.println("8 - Mostrar todos os objetos da lista na ordem do último para o primeiro");
            System.out.println("9 - Sair");
            opcao = pedeOpcao();
            switch (opcao) {
                case 1:
                    novo.nome = pedeMusica();
                    // se a lista não existe adiciona o "novo" como primeiro da lista (e como fim)
                    if (inicio == null) {
                        novo.proximo = null;
                        inicio = novo;
                        termino = novo;
                        // se a lista existe e o novo será o primeiro, o próximo deste será o resto da lista (inicio)   
                    } else {
                        novo.proximo = inicio;
                        inicio = novo;
                    }

                    break;
                case 2:
                    novo.nome = pedeMusica();
                    if (inicio == null) {
                        novo.proximo = null;
                        inicio = novo;
                        termino = novo;
                    } else {
                        termino.proximo = novo;
                        termino = novo;
                    }
                    break;

                case 3:
                    String busca = pedeMusica();
                    atual = inicio;
                    boolean achou = false;
                    do {

                        if (atual.nome.equals(busca)) {
                            System.out.println("Musica: " + atual.nome);
                            achou = true;
                            break;

                        }
                        atual = atual.proximo;

                    } while (atual != null);
                    
                    if (!achou){
                        System.out.println("Não foi encontada uma música correspondente!");
                    }

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
            }

        } while (opcao != 9);

    }

    public static int pedeOpcao() {
        boolean erro;
        Scanner leia;
        int retorno = 0;

        do {
            leia = new Scanner(System.in);
            erro = false;

            try {
                retorno = leia.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Deu Ruim!!");
                erro = true;
                continue;
            }
            if (retorno > 9 || retorno < 1) {
                erro = true;
                System.out.println("Ta errado");
            }

        } while (erro);
        return retorno;
    }

    public static String pedeMusica() {
        String nome;
        Scanner leia;

        do {
            System.out.println("Digite o nome da música:");
            leia = new Scanner(System.in);
            nome = leia.nextLine();
            if (nome.equals("")) {
                System.out.println("Ta vazio, não pode");

            }

        } while (nome.equals(""));
        return nome;
    }

}
