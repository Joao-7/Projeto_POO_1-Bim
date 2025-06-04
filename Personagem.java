// Classe que representa um personagem em um jogo de batalha simples.
// Guarda informações de nome, tipo (classe ou categoria), pontos de vida
// e atributos de combate (ataque e defesa).
public class Personagem {
    // Atributos
    // Nome do personagem (ex.: "Artemis")
    String nome;
    String tipo;
    int vida;
    int ataque;
    int defesa;

    // Construtor 
    // Cria um personagem com nome, tipo e atributos de combate informados.
    // A vida inicial é fixada em 100 pontos por padrão.
    public Personagem(String nome, String tipo, int ataque, int defesa) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = 100; // Vida inicial padrão
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Método que verifica se o personagem ainda está vivo. 
    public boolean Estado() {
        return vida > 0; // true se vida > 0, false caso contrário.
    }

    // Representação legível do objeto. Inclui todos os atributos principais e o status (vivo/morto).
    @Override
    public String toString() {
        return nome + " (" + tipo + ") | Vida: " + vida
                + " | Ataque: " + ataque + " | Defesa: " + defesa
                + " | Status: " + (Estado() ? "Vivo" : "Morto");
    }
}
