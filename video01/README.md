# Video 01 - Simulador de processos de um Sistema Operacional

## Arquivos
[processo.py](https://github.com/ArthurRCastilho/Sistemas-Operacionais/blob/main/video01/processo.py) - Classe Processo com Atributos e metodos
<br>
[simulacao_processos.py](https://github.com/ArthurRCastilho/Sistemas-Operacionais/blob/main/video01/simulacao_processos.py) - Arquivo "Main" onde faz toda a simulação solicitada na atividade

# Descrição da Atividade

Criar uma aplicação em (Qualquer Linguagem),  para simular a mudança de estados dos processos num SO. Nesse sistema operacional, estão em execução 10 processos que são colocados para a execução em ordem do seu PID (Identificador de processo que vai de 0 a 9) com tempo de duração distintos. 

Somente um processo por vez pode estar no estado de EXECUTANDO. O SO definiu um Quantum de execução para cada processo de 1000 ciclos. Em cada ciclo o processo tem 1% de chances de realizar uma operação de E/S, ficando então bloqueado. Uma vez que ele realizar uma operação de E/S, na sua próxima vez, ele terá 30% de chances para sair do estado de Bloqueado e ir para o estado de Pronto. 

Caso o quantum do processo termine sem ele realizar uma operação de E/S (término dos 1000 ciclos), o processo sofrerá uma Troca de Contexto, modificando seu estado de executando  para Pronto.

Cada processo possui como dados: IDENTIFICADOR DE PROCESSO (PID), TEMPO DE PROCESSAMENTO (TP), CONTADOR DE PROGRAMA (CP), ESTADO DO PROCESSO (EP), NÚMERO DE VEZES QUE REALIZOU UMA OPERAÇÃO DE E/S (NES) e NÚMERO DE VEZES QUE USOU A CPU (N_CPU)  Logo, sempre que um processo sofrer uma Troca de Contexto, esses dados devem ser  guardados na Tabela de Processos (gravar os dados num arquivo TXT e atualizar esses dados em cada troca de contexto).

Cada vez que um processo passar do estado de PRONTO para EXECUTANDO, os dados do processo devem ser restaurados.

O tempo de execução de cada processo segue a seguinte Tabela:

PID  |   Tempo de Execução para terminar a execução (Em ciclos)

0     |     10000

1     |     5000

2     |    7000

3     |    3000

4     |    3000

5     |    8000

6    |     2000

7    |     5000

8    |     4000

9    |     10000

 ----->>>>> Obs 1.: O parâmetro TP da nossa simulação vai armazenar o total de ciclos já executados pelo processo.

 ----->>>>> Obs 2.: O parâmetro CP vai sempre indicar qual é a próxima instrução que o processo vai executar, assim por questões de simplificação, o CP será definido como CP = TP + 1, o que simula processos sequenciais sem laços de repetição ou chamadas de desvio de função.

 ----->>>>> Obs 3.: Toda vez que o processo retornar para o estado de EXECUTANDO, ele recebe do SO a quantidade completa de quantum (1000 ciclos).

 ----->>>>> Obs 4.: Quando um processo realizar uma Troca de Contexto, Todos seus dados deverão ser impressos, além da informação para qual estado o processo está indo: Ex.: (PID) EXECUTANDO >>> PRONTO ou (PID) EXECUTANDO >>>> BLOQUEADO. 

 ----->>>>> Obs 5.: Quando um processo termina sua execução ele deve imprimir todos os seus parâmetros na tela.

## Link do Vídeo
[Link Youtube da Explicação do Código](https://youtu.be/NRNuyoVaq-4)
