# Classe para representar cada processo
class Processo:
    def __init__(self, pid, tempo_total):
        self.pid = pid
        self.tempo_total = tempo_total
        self.tp = 0  # Total de ciclos já executados
        self.cp = 1  # Contador de programa, começa em 1 (TP + 1)
        self.estado = "PRONTO"  # Estado inicial
        self.nes = 0  # Número de vezes que realizou E/S
        self.n_cpu = 0  # Número de vezes que usou a CPU

    def atualizar_linha_tabela(self, posicao_linha):
        """Atualiza a linha correspondente ao processo no arquivo de tabela"""
        with open("tabela_processos.txt", "r+") as f:
            linhas = f.readlines()
            # Formata os dados do processo na linha correspondente
            linhas[posicao_linha] = (f"PID: {self.pid}, TP: {self.tp}, CP: {self.cp}, "
                                     f"Estado: {self.estado}, NES: {self.nes}, N_CPU: {self.n_cpu}\n")
            f.seek(0)  # Vai para o início do arquivo
            f.writelines(linhas)  # Sobrescreve todo o conteúdo