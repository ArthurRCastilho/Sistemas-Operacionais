def first_fit(memoria, tamanho):
    for i in range(len(memoria) - tamanho + 1):
        # Verifica se todos os blocos no intervalo são iguais a 0
        if all(bloco == 0 for bloco in memoria[i:i + tamanho]):
            for j in range(tamanho):
                memoria[i + j] = 1
            return i  # Retorna o índice de início da alocação
    return -1  # Não há espaço disponível

# Algoritmo Next Fit
def next_fit(memoria, tamanho, inicio=0):
    n = len(memoria)
    for offset in range(n):
        i = (inicio + offset) % n  # Busca cíclica
        if all(bloco == 0 for bloco in memoria[i:i + tamanho]):
            for j in range(tamanho):
                memoria[i + j] = 1
            return i  # Retorna o índice de início da alocação
    return -1  # Não há espaço disponível

# Algoritmo Best Fit
def best_fit(memoria, tamanho):
    melhor_index = -1
    menor_sobra = float('inf')
    for i in range(len(memoria)):
        j = i
        while j < len(memoria) and memoria[j] == 0:
            j += 1
        espaco_livre = j - i
        if espaco_livre >= tamanho and espaco_livre < menor_sobra:
            melhor_index = i
            menor_sobra = espaco_livre
        i = j  # Avança para o próximo bloco livre
    if melhor_index != -1:
        for j in range(tamanho):
            memoria[melhor_index + j] = 1
    return melhor_index

# Algoritmo Quick Fit - usa dicionário para armazenar tamanhos
def quick_fit(memoria, tamanho, buracos):
    if tamanho in buracos and buracos[tamanho]:
        inicio = buracos[tamanho].pop(0)
        for j in range(tamanho):
            memoria[inicio + j] = 1
        return inicio
    return -1

# Algoritmo Worst Fit
def worst_fit(memoria, tamanho):
    pior_index = -1
    maior_espaco = -1
    for i in range(len(memoria)):
        j = i
        while j < len(memoria) and memoria[j] == 0:
            j += 1
        espaco_livre = j - i
        if espaco_livre >= tamanho and espaco_livre > maior_espaco:
            pior_index = i
            maior_espaco = espaco_livre
        i = j  # Avança para o próximo bloco livre
    if pior_index != -1:
        for j in range(tamanho):
            memoria[pior_index + j] = 1
    return pior_index

# Função para desalocar processo
def desalocar(memoria, inicio, tamanho):
    for i in range(inicio, inicio + tamanho):
        memoria[i] = 0

processos = [
    (1, 5), (2, 4), (3, 2), (4, 5), (5, 8),
    (6, 3), (7, 5), (8, 8), (9, 2), (10, 6)
]

# Testando os algoritmos com processos
memoria = [0] * 32  # Reinicia a memória

# Testando todos os algoritmos com o Processo 2
testes = {
    "First Fit": first_fit(memoria, processos[1][1]),
    "Next Fit": next_fit(memoria, processos[1][1]),
    "Best Fit": best_fit(memoria, processos[1][1]),
    "Worst Fit": worst_fit(memoria, processos[1][1])
}
memoria, testes

# Função para exibir a memória de forma legível
def mostrar_memoria(memoria):
    print("Estado atual da memória:")
    print("".join(str(bloco) for bloco in memoria))

# Testando todos os algoritmos com o Processo 2
processo = processos[1]  # Processo 2 (ID = 2, Tamanho = 4)
tamanho_processo = processo[1]

# Reinicia a memória
memoria = [0] * 32

print(f"Testando com Processo {processo[0]} (Tamanho {tamanho_processo}):\n")

# Testando First Fit
indice_first_fit = first_fit(memoria[:], tamanho_processo)  # Copia a memória para preservar estado
print(f"First Fit - Índice de início: {indice_first_fit}")
mostrar_memoria(memoria[:])

# Testando Next Fit
indice_next_fit = next_fit(memoria[:], tamanho_processo)
print(f"\nNext Fit - Índice de início: {indice_next_fit}")
mostrar_memoria(memoria[:])

# Testando Best Fit
indice_best_fit = best_fit(memoria[:], tamanho_processo)
print(f"\nBest Fit - Índice de início: {indice_best_fit}")
mostrar_memoria(memoria[:])

# Testando Worst Fit
indice_worst_fit = worst_fit(memoria[:], tamanho_processo)
print(f"\nWorst Fit - Índice de início: {indice_worst_fit}")
mostrar_memoria(memoria[:])
