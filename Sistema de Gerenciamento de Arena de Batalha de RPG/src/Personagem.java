public class Personagem {
    String nome;
    String tipo;
    int vida;
    int ataque;
    int defesa;

    // Construtor 
    public Personagem(String nome, String tipo, int ataque, int defesa) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = 100;// Vida inicial padrão
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
    