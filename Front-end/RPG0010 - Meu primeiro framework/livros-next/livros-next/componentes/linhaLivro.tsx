import React from 'react';

// importar classe
import controleEditora from '../classes/controle/controleEditora'
import Livro from '../classes/modelo/livro';

// instanciando
const ControleEditora = new controleEditora
const livro = new Livro
// interface
interface LinhaLivroProps{
    livro:Livro,
    excluir: ()=> void
}

// Componente exportável LinhaLivro
export const LinhaLivro: React.FC<LinhaLivroProps> = (props) => {
    // Inicialize uma instância de ControleEditora
    const controleEditora = new ControleEditora();
  
    // Extraia os atributos do livro
    const { livro } = props;
  
    // Função para obter o nome da editora
    const obterNomeEditora = (codigoEditora: number) => {
      // Supondo que o método getNomeEditora esteja disponível em ControleEditora
      const nomeEditora = controleEditora.getNomeEditora(codigoEditora);
      return nomeEditora;
    };
  
    return (
      <tr>
        <td>{livro.titulo}</td>
        <td>{obterNomeEditora(livro.codEditora)}</td>
        <td>{livro.anoPublicacao}</td>
        <td>
          <button onClick={props.excluir} className="btn btn-danger">
            Excluir
          </button>
        </td>
      </tr>
    );
  };