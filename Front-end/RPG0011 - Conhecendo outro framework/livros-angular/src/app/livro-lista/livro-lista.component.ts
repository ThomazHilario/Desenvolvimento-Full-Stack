import { Component, OnInit } from '@angular/core';
import ControleEditoraService from '../controle-editora.service';
import ControleLivrosService from '../controle-livros.service';
import Editora from '../editora'
import Livro from '../livro'

@Component({
  selector: 'app-livro-lista',
  templateUrl: './livro-lista.component.html',
  styleUrls: ['./livro-lista.component.css']
})
export class LivroListaComponent implements OnInit{
  // Definindo propriedades
  editoras: Editora[] = [];
  livros: Livro[] = [];

  // constructor
  constructor(
    private servEditora: ControleEditoraService,
    private servLivros: ControleLivrosService
  ) {}

  // Oninit
  ngOnInit(): void {
    this.editoras = this.servEditora.getEditoras();
    this.livros = this.servLivros.obterLivros();
  }

  // Excluir
  excluir(codigo: number): void {
    this.servLivros.excluir(codigo);
    this.livros = this.servLivros.obterLivros();
  }

  // Obtendo nome
  obterNome(codEditora: number) {
    return this.servEditora.getNomeEditora(codEditora).map(item => item.nome);
    
  }
  
}
