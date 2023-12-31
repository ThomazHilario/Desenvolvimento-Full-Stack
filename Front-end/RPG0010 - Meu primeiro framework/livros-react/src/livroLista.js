import React, { useState, useEffect } from 'react';
import ControleLivros from './controle/controleLivro';
import ControleEditora from './controle/controleEditora';

const controleLivro = new ControleLivros();
const controleEditora = new ControleEditora();

function LinhaLivro(props) {
  const nomeEditora = controleEditora.getNomeEditora(props.livro.codEditora);

  return (
    <tr>
      <td>{props.livro.titulo} <br></br><button className="btn btn-danger"onClick={() => props.excluir(props.livro.codigo)}>Excluir</button></td>
      <td><p>{props.livro.resumo}</p></td>
      <td id="editoras">{nomeEditora}</td>
      <td><ul>{props.livro.autores.map((item,key) => <li key={key}>{item}</li>)}</ul></td>
    </tr>
  );
}

function LivroLista() {
  const [livros, setLivros] = useState([]);
  const [carregado, setCarregado] = useState(false);

// pegando os livros e carregando na state
  useEffect(() => {
    const fetchLivros = () => {
      const livros = controleLivro.obterLivros();
      setLivros(livros);
      setCarregado(true);
    };

    fetchLivros();
  }, [carregado]);

  // excluir
  const excluir = (codigo) => {
    controleLivro.excluir(codigo);
    setCarregado(false);
  };

  return (
    <div>
      <main className='container'>
        <h1>Catalogo de Livros</h1>
        <table>

          <thead>
            <tr className='bg-dark text-white'>
              <th>Título</th>
              <th>Resumo</th>
              <th>Editora</th>
              <th>Autor</th>
            </tr>
          </thead>
          
          <tbody>
            {livros.map((livro) => (
              <LinhaLivro key={livro.codigo} livro={livro} excluir={excluir} />
            ))}
          </tbody>
        </table>
      </main>
    </div>
  );
}

export default LivroLista;