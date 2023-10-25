// ControleLivros.ts
import Livro from '../modelo/livro';

// variavel livro que recebe a tipagem da class Livro
const livros: Livro[] = [
  new Livro(1, 1, 'Use a cabeça java', 'Java é uma experiência completa de aprendizado em POO', ['Bert Bates', 'Kathy Sierra']),
  new Livro(2, 2, 'Java: Como programar', 'Milhões de alunos e profissionais aprenderam programação e desenvolvimento de software com os livros Deitel', ['Paul Deitel', 'Harvey Deitel']),
  new Livro(3, 3, 'Core Java For The Impatient', 'Eaders familiar with Hostmann original, two-volume Core Java books who are lookin for ...', ['Cay Horstmann']),
];

// Class controleLivros
class ControleLivros {

  // obterLivros
  obterLivros(): Livro[] {
    return livros;
  }

  // incluindo livros
  incluir(livro: Livro): void {
    const novoCodigo = Math.max(...livros.map((l) => l.codigo), 0) + 1;
    livro.codigo = novoCodigo;
    livros.push(livro);
  }

  // excluindo livros
  excluir(codigo: number): void {
    const index = livros.findIndex((l) => l.codigo === codigo);
    if (index !== -1) {
      livros.splice(index, 1);
    }
  }
}

export default ControleLivros;