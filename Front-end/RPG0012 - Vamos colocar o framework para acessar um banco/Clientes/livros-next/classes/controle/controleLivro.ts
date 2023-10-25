// ControleLivros.ts
import Livro from '../modelo/livro';
// Api do banco de dados
const url = 'http://localhost:3030/livros'

interface LivroMongo{
  _id:string,
  codEditora:number,
  titulo:string,
  resumo:string,
  autores:string[]
}


class ControleLivros {
  async obterLivros() {
    try {
      const response = await fetch(url,{method:'GET'})
      if(response.ok){
        const livros = await response.json()
        return livros.map((livro:any) => new Livro(livro._id,livro.codEditora,livro.titulo,livro.resumo,livro.autores))
      }else{
        throw Error('Erro ao obter os livros da url')
      }
    } catch (error) {
      console.log(error)
    }
  }

  async incluir(livro: Livro) {
    try {

      // estrutura mongodb
      const livroIncluir:LivroMongo = {
        _id:livro.codigo,
        codEditora:livro.codEditora,
        titulo:livro.titulo,
        resumo:livro.resumo,
        autores:livro.autores
      }

      // requisitando o post
      const response = await fetch(url,{
        method:'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(livroIncluir),
      })

      return response.ok
    } catch (error) {
      console.log(error)
    }
  }

  async excluir(codigo: string) {
    try {
      const response = await fetch(`${url}/${codigo}`, { method: 'DELETE' });
      return response.ok;
    } catch (error) {
      console.log(error)
    }
  }
}

export default ControleLivros;