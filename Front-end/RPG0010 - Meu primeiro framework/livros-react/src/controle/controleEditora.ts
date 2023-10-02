import {Editora} from "../modelo/editora"

let editoras:Editora[] =[
    new Editora(1,'editora 1'),
    new Editora(2,'editora 2'),
    new Editora(3,'editora 3'),
]


export class ControleEditora{
    // Pegando o nome da editora
    getNomeEditora(codEditora:number):string{
        let editora = editoras.find((element) => element.codEditora === codEditora)
        return editora ? editora.nome : ''
    }

    // pegando o array editora
    getEditoras(){
        return editoras
    }
}

