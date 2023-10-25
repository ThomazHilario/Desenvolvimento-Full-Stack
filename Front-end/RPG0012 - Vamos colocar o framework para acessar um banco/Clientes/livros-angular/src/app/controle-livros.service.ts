import { Injectable } from '@angular/core';
import Livro from './livro'
// url
const baseUrl = 'http://localhost:3030/livros'

interface LivroMongo{
  _id:string | null,
  codEditora:number,
  titulo:string,
  resumo:string,
  autores:string[]
}
@Injectable({
  providedIn: 'root'
})
export default class ControleLivrosService {
  
  // obterLivro
  async obterLivros(){
    try {
      const response = await fetch(baseUrl,{method: 'GET'})
      const livros = await response.json()
      return livros.map((livro:any) => new Livro(livro._id,livro.codEditora,livro.titulo,livro.resumo,livro.autores))
    } catch (error) {
      console.log(error)
    }
  }

  // incluir livro
  async incluir(livro:Livro){
    // Estrutura do mongoDb
    const novoLivro:LivroMongo = {
      _id:null,
      codEditora:livro.codEditora,
      titulo:livro.titulo,
      resumo:livro.resumo,
      autores:livro.autores
    }

    // requisitando o post
    const response = await fetch(baseUrl,{
      method:'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(novoLivro),
    })

    return response.ok
  }

  // excluir livro
  async excluir(codigo:string){
    try {
      const response = await fetch(`${baseUrl}/${codigo}`, { method: 'DELETE' });
    } catch (error) {
      console.log(error)
    }
  }

}
