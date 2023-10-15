import { Injectable } from '@angular/core';
import Livro from './livro'
@Injectable({
  providedIn: 'root'
})
export default class ControleLivrosService {
  // Definindo propriedades
  livros:Livro[] = [
    new Livro(1, 1, 'Use a cabeça java', 'Java é uma experiência completa de aprendizado em POO', ['Bert Bates', 'Kathy Sierra']),
    new Livro(2, 2, 'Java: Como programar', 'Milhões de alunos e profissionais aprenderam programação e desenvolvimento de software com os livros Deitel', ['Paul Deitel', 'Harvey Deitel']),
    new Livro(3, 3, 'Core Java For The Impatient', 'Eaders familiar with Hostmann original, two-volume Core Java books who are lookin for ...', ['Cay Horstmann']),
  ]
  
  // obterLivro
  obterLivros(){
    return this.livros
  }

  // incluir livro
  incluir(livro:Livro){
    const nextCodigo = Math.max(...this.livros.map((item) => item.codigo), 0) + 1;
    livro.codigo = nextCodigo;
    this.livros.push(livro);
  }

  // excluir livro
  excluir(codigo:number){
    const index = this.livros.findIndex(item => item.codigo === codigo)
    this.livros.splice(index,1)
  }

}
