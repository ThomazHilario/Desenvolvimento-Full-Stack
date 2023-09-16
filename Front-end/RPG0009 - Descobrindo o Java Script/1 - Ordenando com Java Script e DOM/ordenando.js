// funções de ordenação

let swap = (vetor,idx1,idx2) => {
    const elementTemporario = vetor[idx1]
    vetor[idx1] = vetor[idx2]
    vetor[idx2] = elementTemporario
}

