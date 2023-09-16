// funções de ordenação

//swap
let swap = (vetor,idx1,idx2) => {
    const elementTemporario = vetor[idx1]
    vetor[idx1] = vetor[idx2]
    vetor[idx2] = elementTemporario
}

//shuffle
let shuffle = (vetor) => {
    // Armazenando o total de elementos de um array
    let currentIndex = vetor.length
    // Criando um for para percorrer um array
    for(let i = 0; i < vetor.length;i++){
        let randomIndex = Math.floor(Math.random() * currentIndex)
        currentIndex--
        // Chamando a função swap
        swap(vetor,currentIndex,randomIndex)
    }

}


