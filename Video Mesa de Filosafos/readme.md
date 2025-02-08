# Jantar dos Filósofos 

## Código
[Filosofo.java]()<br>
[Gargo.java]()<br>
[JantarDosFilosofos]()<br>

## Descrição do Problema
Fazer um program em Java, utilizando Threads, para solucionar o problema dos filósofos Glutões. Faça um vídeo de 10 a 15 min. apresentando o código, a explicação do problema e a execução do programa.

Imagem com uma mesa redonda onde há 5 filósofos sentados em frente à 5 pratos de espaguete e 5 garfos disponíveis. A imagem ilustra o problema do Jantar dos filôsofos

O Jantar dos filósofos foi proposto por Dijkstra em 1965 como um problema de sincronização. A partir de então todos os algoritmos propostos como soluções de sincronização acabaram sendo relacionados ou testados contra o problema do Jantar dos filósofos.

DEFINIÇÃO DO PROBLEMA DO JANTAR DOS FILÓSOFOS

Cinco filósofos estão sentados em uma mesa redonda para jantar. Cada filósofo tem um prato com espaguete à sua frente. Cada prato possui um garfo para pegar o espaguete. O espaguete está muito escorregadio e, para que um filósofo consiga comer, será necessário utilizar dois garfos. 

Lembre-se que é apenas uma analogia. Nesse sentido, cada filósofo alterna entre duas tarefas: comer ou pensar. Quando um filósofo fica com fome, ele tenta pegar os garfos à sua esquerda e à sua direita; um de cada vez, independente da ordem. Caso ele consiga pegar dois garfos, ele come durante um determinado tempo e depois recoloca os garfos na mesa. Em seguida ele volta a pensar.

Por definição, o problema em questão é:

Você é capaz de propor um algoritmo que implemente cada filósofo de modo que ele execute as tarefas de comer e pensar sem nunca ficar travado?