import { Component, OnInit } from '@angular/core';
import Livro from '../livro';
import Editora from '../editora';
import ControleEditoraService from '../controle-editora.service';
import ControleLivrosService from '../controle-livros.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-livro-dados',
  templateUrl: './livro-dados.component.html',
  styleUrls: ['./livro-dados.component.css']
})
export class LivroDadosComponent implements OnInit{
  // Definindo propriedades
  livro: Livro = new Livro('',0,'','',[]);
  autoresForm: string = '';
  editoras: Editora[] = [];

  // constructor
  constructor(
    private servEditora: ControleEditoraService,
    private servLivros: ControleLivrosService,
    private router: Router
  ) {}

  // oninit
  ngOnInit(): void {
    this.editoras = this.servEditora.getEditoras();
  }

  // incluindo livro
  incluir = (): void => {
    this.livro.autores = this.autoresForm.split('\n').map((author) => author.trim())
    
    this.servLivros.incluir(this.livro).then(() => {
      this.router.navigateByUrl('/lista');
    })
  };
}
