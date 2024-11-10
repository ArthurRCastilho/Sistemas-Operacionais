import random
import time

from processo import Processo

# Definindo o Quantum e os tempos de execução para cada PID
QUANTUM = 1000
TEMPOS_EXECUCAO = {0: 10000, 1: 5000, 2: 7000, 3: 3000, 4: 3000,
                   5: 8000, 6: 2000, 7: 5000, 8: 4000, 9: 10000}

# Inicializa o arquivo com os cabeçalhos e estrutura vazia para cada processo
with open("tabela_processos.txt", "w") as f:
    f.write("Tabela de Processos:\n")
    for pid in TEMPOS_EXECUCAO.keys():
        f.write(f"PID: {pid}, TP: 0, CP: 1, Estado: PRONTO, NES: 0, N_CPU: 0\n")

# Inicializando processos
processos = [Processo(pid, tempo) for pid, tempo in TEMPOS_EXECUCAO.items()]

# Loop principal para simulação dos processos
while any(p.tempo_total > p.tp for p in processos):  # Continua enquanto algum processo não terminou
    for index, processo in enumerate(processos):
        if processo.tp >= processo.tempo_total:
            continue  # Pula processos que já finalizaram
        
        # Execução do processo
        processo.estado = "EXECUTANDO"
        processo.n_cpu += 1  # Incrementa N_CPU ao iniciar a execução
        processo.atualizar_linha_tabela(index + 1)
        quantum_restante = QUANTUM
        
        while quantum_restante > 0:
            time.sleep(0.0005)  # Pausa de 0.5 milissegundos 
            
            # Simula o uso da CPU
            processo.tp += 1
            processo.cp = processo.tp + 1  # CP = TP + 1
            quantum_restante -= 1
            
            # Chance de realizar operação de E/S
            if random.random() <= 0.01:  # 1% de chance de entrar no estado BLOQUEADO
                processo.nes += 1
                processo.estado = "BLOQUEADO"
                processo.atualizar_linha_tabela(index + 1)
                
                # Simulação de saída do estado bloqueado
                if random.random() <= 0.3:  # 30% de chance de sair do estado de bloqueado
                    processo.estado = "PRONTO"
                processo.atualizar_linha_tabela(index + 1)
                break
            
            # Checa se terminou o tempo total
            if processo.tp >= processo.tempo_total:
                processo.estado = "FINALIZADO"
                processo.atualizar_linha_tabela(index + 1)
                print(f"Processo PID {processo.pid} terminou com TP={processo.tp}, CP={processo.cp}, NES={processo.nes}, N_CPU={processo.n_cpu}")
                break
        
        # Troca de contexto se o quantum acabar e o processo não foi bloqueado nem finalizado
        if quantum_restante == 0 and processo.estado == "EXECUTANDO":
            processo.estado = "PRONTO"
            processo.atualizar_linha_tabela(index + 1)
