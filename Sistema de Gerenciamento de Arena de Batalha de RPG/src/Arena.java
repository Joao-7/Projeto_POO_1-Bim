import java.util.Scanner;
import java.util.ArrayList;

public class Arena {

    public static int batalhas = 0;
    public static int qtnPersonagens = 0;

    Scanner ler = new Scanner(System.in);
    // Lista que armazena todos os personagens criados
    ArrayList<Personagem> personagens = new ArrayList<>();

    public void Iniciar() {
        int opcao;
        do {
            // Exibe o menu
            System.out.println("");
            System.out.println("---- MENU ----");
            System.out.println("1 - Cadastrar personagem");
            System.out.println("2 - Listar personagens");
            System.out.println("3 - Iniciar batalha");
            System.out.println("4 - Estatísticas");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPersonagem();
                    break;
                case 2:
                    listarPersonagens();
                    listarPersonagens(true);
                    break;
                case 3:
                    iniciarBatalha();
                    break;
                case 4:
                    mostrarEstatisticas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    public void cadastrarPersonagem() {
        System.out.println("");
        System.out.print("Digite o nome do jogador: ");
        String nome = ler.nextLine();

        System.out.println("");
        System.out.print("Digite o tipo ex:(Guerreiro, Mago, Arqueiro): ");
        String tipo = ler.nextLine();

        System.out.println("");
        System.out.println("Escolha uma arma. Digite o número correspondente a arma:");
        System.out.println("1 - Espada (+50 de ataque)");
        System.out.println("2 - Magia (+42 de ataque)");
        System.out.println("3 - Arco e flecha (+35 de ataque)");
        System.out.print("Arma: ");
        int opAtaque = ler.nextInt();

        int ataque;
        switch (opAtaque) {
            case 1:
                ataque = 50;
                break;
            case 2:
                ataque = 42;
                break;
            case 3:
                ataque = 35;
                break;
            default:
                System.out.println("Opção inválida. Ataque padrão de 20 aplicado.");
                ataque = 20;
        }

        System.out.println("");
        System.out.println("Escolha uma defesa. Digite o número correspondente à defesa:");
        System.out.println("1 - Escudo (+20 de defesa)");
        System.out.println("2 - Armadura (+15 de defesa)");
        System.out.println("3 - Desviar (+10 de defesa)");
        System.out.print("Defesa: ");
        int opDefesa = ler.nextInt();
        ler.nextLine();

        int defesa;
        switch (opDefesa) {
            case 1:
                defesa = 20;
                break;
            case 2:
                defesa = 15;
                break;
            case 3:
                defesa = 10;
                break;
            default:
                System.out.println("Opção inválida. Defesa padrão de 5 aplicada.");
                defesa = 5;
        }

        // Cria e adiciona o novo personagem à lista de array
        personagens.add(new Personagem(nome, tipo, ataque, defesa));
        qtnPersonagens++;
        System.out.println("Personagem cadastrado!");
    }

    public void listarPersonagens() {
        if (personagens.isEmpty()) {
            System.out.println("Nenhum personagem cadastrado.");
            return;
        }

        System.out.println("");
        System.out.println("Personagens vivos cadastrados:");
        for (int i = 0; i < personagens.size(); i++) {
            if (personagens.get(i).Estado()) {
                System.out.println((i + 1) + " - " + personagens.get(i));
            }
        }
    }

    // Sobrecarga do método listarPersonagens
    public void listarPersonagens(boolean mortos) {
        System.out.println("");
        System.out.println("Personagens mortos:");

        boolean encontrouMortos = false;

        for (int i = 0; i < personagens.size(); i++) {
            if (!personagens.get(i).Estado()) {
                System.out.println((i + 1) + " - " + personagens.get(i));
                encontrouMortos = true;
            }
        }

        if (!encontrouMortos) {
            System.out.println("Nenhum personagem morto encontrado.");
        }
    }

    public void iniciarBatalha() {
        if (personagens.size() < 2) {
            System.out.println("Para iniciar uma batalha, cadastre pelo menos 2 personagens.");
            return;
        }

        System.out.println("");
        listarPersonagens();
        System.out.println("");

        System.out.print("Jogador 1, escolha um número correspondente ao seu personagem: ");
        int i1 = ler.nextInt() - 1;

        System.out.print("Jogador 2, escolha um número correspondente ao seu personagem: ");
        int i2 = ler.nextInt() - 1;
        ler.nextLine();

        // Verifica se os índices são válidos e diferentes
        if (i1 == i2 || i1 < 0 || i2 < 0 || i1 >= personagens.size() || i2 >= personagens.size()) {
            System.out.println("Seleção inválida. Personagens devem ser diferentes e válidos.");
            return;
        }

        Personagem p1 = personagens.get(i1);
        Personagem p2 = personagens.get(i2);

        System.out.println("");
        System.out.println("Personagens escolhidos:");
        System.out.println("Jogador 1: " + p1);
        System.out.println("Jogador 2: " + p2);

        // Enquanto os personagens estiverem vivos
        while (p1.Estado() && p2.Estado()) {
            System.out.println("");
            System.out.println("--- Nova Rodada ---");
            System.out.print("Joguem a moeda! Digite 1 se " + p1.nome + " venceu, ou 2 se " + p2.nome + " venceu: ");
            int vcc = ler.nextInt();
            ler.nextLine();

            switch (vcc) {
                case 1:
                    System.out.println(p1.nome + " atacará!");
                    int dano1 = p1.ataque - p2.defesa;
                    if (dano1 < 0)
                        dano1 = 0;
                    p2.vida -= dano1;
                    if (p2.vida < 0)
                        p2.vida = 0;
                    System.out.println(p1.nome + " causou " + dano1 + " de dano em " + p2.nome);
                    break;

                case 2:
                    System.out.println(p2.nome + " atacará!");
                    int dano2 = p2.ataque - p1.defesa;
                    if (dano2 < 0)
                        dano2 = 0;
                    p1.vida -= dano2;
                    if (p1.vida < 0)
                        p1.vida = 0;
                    System.out.println(p2.nome + " causou " + dano2 + " de dano em " + p1.nome);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("");
            System.out.println("Status atual dos jogadores:");
            System.out.println(p1);
            System.out.println(p2);
        }

        System.out.println("");
        System.out.println("---- Batalha encerrada! ----");
        if (p1.Estado()) {
            System.out.println(p1.nome + " venceu!");
        } else if (p2.Estado()) {
            System.out.println(p2.nome + " venceu!");
        }

        batalhas++;
    }

    public void mostrarEstatisticas() {
        System.out.println("---- Estatísticas da Arena ----");
        System.out.println("Total de personagens criados: " + qtnPersonagens);
        System.out.println("Total de batalhas realizadas: " + batalhas);
    }
}
