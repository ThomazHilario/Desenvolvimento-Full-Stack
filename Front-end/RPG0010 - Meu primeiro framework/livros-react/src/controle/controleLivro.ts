import {Livro} from "../modelo/livro"

let livros:Livro[] = [
    new Livro(1,1,'jujutsu kaisen','Anime shonen',['Gege','Akutami']),
    new Livro(2,2,'Haikyuu','Anime Sports',['Haruichi','Furudachi']),
    new Livro(3,3,'Attack on Titan','Anime sobre titans',['Hajime','Isayama']),
]

export class ControleLivro{
    obterLivros(){
        return livros
    }

    incluir(livro:Livro){
        let newCode = Math.max(...livros.map((element) => element.codigo),0) + 1
        livro.codigo = newCode
        livros.push(livro)
    }

    excluir(codigo:number){
        let livroIdx = livros.findIndex((element) => element.codigo == codigo)
        livros.splice(livroIdx,1)
    }
}
