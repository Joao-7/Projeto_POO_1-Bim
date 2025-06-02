# 🛡️ Arena de Batalha em Java

Projeto simples feito em Java que simula batalhas entre personagens personalizados. 

## 🎮 Funcionalidades

- **Cadastrar personagem**  
  O usuário informa o nome, tipo (Guerreiro, Mago ou Arqueiro), escolhe uma arma (que define o ataque) e uma defesa.

- **Listar personagens**  
  Mostra todos os personagens cadastrados, com nome, tipo, vida, ataque, defesa e status (Vivo ou Morto).

- **Iniciar batalha**  
  Dois personagens são escolhidos para lutar. A cada rodada, uma moeda é “jogada” (simulada) para decidir quem ataca. A batalha continua até que um dos personagens tenha a vida zerada.

- **Estatísticas**  
  Exibe o total de personagens cadastrados e o total de batalhas realizadas.

- **Sair**  
  Encerra o programa.

## 💡 Conceitos utilizados

- Programação orientada a objetos (POO)
- Uso de `ArrayList` para armazenar objetos
- Classe `Scanner` para entrada de dados
- Estruturas de repetição (`while`, `do while`) e decisão (`if`, `switch`)
- Métodos e modularização de código

## 🧱 Estrutura

- `Main.java` → Inicia o sistema
- `Arena.java` → Contém o menu e todas as funcionalidades (cadastro, batalha, estatísticas, etc.)
- `Personagem.java` → Classe que representa o personagem com atributos e métodos

