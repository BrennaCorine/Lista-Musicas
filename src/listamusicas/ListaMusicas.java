package listamusicas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaMusicas {

    static Musica novo = new Musica();
    static Musica atual = new Musica();
    static Musica inicio = new Musica();
    static Musica termino = new Musica();
    
    public static void main(String[] args) {
        

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
            System.out.println("8 - Sair");
            opcao = pedeOpcao();
            switch (opcao) {
                case 1:
                    novo.nome = pedeMusica();
                    // se a lista não existe adiciona o "novo" como primeiro da lista (e como fim)
                    novo.proximo = inicio;
                    inicio = novo;
                    if (termino == null) {
                        termino = novo;
                        // se a lista existe e o novo será o primeiro, o próximo deste será o resto da lista (inicio)   
                    }
                    System.out.println("Musica adicionada com sucesso: " + inicio.nome);
                    break;

                case 2:
                    novo.nome = pedeMusica();
                    novo.proximo = null;
                    termino.proximo = novo;

                    termino = novo;
                    if (inicio == null) {
                        inicio = novo;
                    }

                    System.out.println("Musica adicionada com sucesso: " + termino.nome);
                    break;

                case 3:
                    novo.nome = pedeMusica();
                    atual = inicio;
                    boolean achado = false;
                    if (inicio == null) {
                        System.out.println("a lista está vazia!");
                    } else {
                        while (atual != null) {
                            if (atual.nome.equals(novo.nome)) {
                                System.out.println("Musica encontrada!");
                                System.out.println("Musica: " + atual.nome);
                                achado = true;
                                break;
                            }
                            if (atual == termino) {
                                atual = termino;
                            }
                            atual = atual.proximo;
                        }
                        if (!achado) {
                            System.out.println("Essa musica não foi encontrada!");
                        }
                    }
                    break;

                case 4:
                    novo.nome = pedeMusica();
                    achado = false;
                    atual = inicio;
                    if (inicio == null) {
                        System.out.println("A lista está vazia!");
                    } else {
                        if (novo.nome.equals(inicio.nome)) {
                            inicio = inicio.proximo;
                            if (inicio == null) {

                                termino = null;

                            }
                            System.out.println("Música removida com sucesso!");
                            achado = true;
                        } else if (novo.nome.equals(termino.nome)) {
                            while (true) {
                                if (atual.proximo.nome.equals(termino.nome)) {
                                    atual.proximo = null;
                                    break;
                                }

                            }
                            termino = null;
                        } else {
                            while (atual != null) {
                                if (atual.nome.equals(novo.nome)) {
                                    Musica anterior = procAnterior(atual.nome);
                                    anterior.proximo = atual.proximo;
                                    System.out.println("Música removida com sucesso!");
                                    break;
                                }
                                atual = atual.proximo;
                            }
                        }
                    }
                    break;

                case 5:
                    if (inicio == null) {
                        System.out.println("A lista está vazia!");
                    } else {
                        inicio = inicio.proximo;
                        if (inicio == null) {
                            termino = null;
                        }
                    }

                    break;

                case 6:

                    break;

                case 7:

                    break;
            }

        } while (opcao != 8);

    }

    public static Musica procAnterior(String nome){
        Musica ret = null;
        Musica atual = inicio;
        while(atual != null){
            if(atual.proximo.nome.equals(nome)){
                ret = atual;
                break;
            }
        }
        
        return ret;
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
