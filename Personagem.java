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
        this.vida = 100; // Vida inicial padrão
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Método para verificar se o personagem está vivo
    public boolean Estado() {
        return vida > 0;
    }

    // Sobrescrevendo o toString para mostrar as informações do personagem
    @Override
    public String toString() {
        return nome + " (" + tipo + ") | Vida: " + vida
                + " | Ataque: " + ataque + " | Defesa: " + defesa
                + " | Status: " + (Estado() ? "Vivo" : "Morto");
    }
}
