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

// bubble_sort
let bubble_sort = (vetor) => {
    for(let i = 0; i< vetor.length;i++){
        for(let j = 0; j < vetor.length;j++){
            if(vetor[j] > vetor[j + 1]){
                swap(vetor,j,j + 1)
            }
        }
    }
}

// Selection_sort
let Selection_sort = (vetor) => {
    for(let i = 0; i < vetor.length;i++){
        let min = i
        for(let j = i + 1; j < vetor.length;j++){
            if(vetor[j] < vetor[min]){
                min = j
            }
        }
        swap(vetor,i,min)
    }
}

// quick_sort
let quick_sort = (vetor) => {
    if(vetor.length <= 1){
        return vetor
    }
    let pivo = vetor[0]
    let leftVetor = []
    let rightVetor = []

    for(let i = 1;i < vetor.length;i++){
        if(vetor[i] < pivo){
            leftVetor.push(vetor[i])
        } else{
            rightVetor.push(vetor[i])
        }
    }

    return [...quick_sort(leftVetor),pivo, ...quick_sort(rightVetor)]
}


// add
function add(){
    // valores
    let input = document.getElementById('valor')
    // lista
    let lista = document.getElementById('valores')

    let li = document.createElement('li')
    li.textContent = input.value

    lista.append(li)

    input.value = ``

}
// ordenar
function ordenar(){
    // lista
    let lista = document.getElementById('valores')
    // array vazio
    let vetor = []
    // Percorrendo cada elemento e adicionando no array
    for(let i = 0;i < lista.children.length; i++){
        vetor.push(parseInt(lista.children[i].textContent))
    }
    // Condicoes
    if(document.getElementById('selectedIndex').value == '0'){
        bubble_sort(vetor)
        let novoVetor = vetor.map(e => `<li>${e}</li>`)
        let novaLista = novoVetor.reduce((acumulador,elementos) => acumulador + elementos)
        lista.innerHTML = novaLista
    }
    if(document.getElementById('selectedIndex').value == '1'){
        Selection_sort(vetor)
        let novoVetor = vetor.map(e => `<li>${e}</li>`)
        let novaLista = novoVetor.reduce((acumulador,elementos) => acumulador + elementos)
        lista.innerHTML = novaLista
    }
    if(document.getElementById('selectedIndex').value == '2'){   
        let novoVetor = quick_sort(vetor)
        let novosLi = novoVetor.map(e => `<li>${e}</li>`)
        let novaLista = novosLi.reduce((acumulador,elementos) => acumulador+= elementos)
        lista.innerHTML = novaLista
    }
}
// misturar

function misturar(){
    let lista = document.getElementById('valores').children
    let vetor = []
    for(let i = 0;i < lista.length;i++){
        vetor.push(parseInt(lista[i].textContent))
    }

    shuffle(vetor)
    let novoVetor = vetor.map(e => e)
    
    for(let i =0;i < lista.length;i++){
        lista[i].innerHTML = novoVetor[i]
    }
    

}