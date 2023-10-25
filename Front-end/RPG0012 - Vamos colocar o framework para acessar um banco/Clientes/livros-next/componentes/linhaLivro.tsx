import React from 'react';
// importar classe
import controleEditora from '../classes/controle/controleEditora'
import Livro from '../classes/modelo/livro';


// instanciando
const ControleEditora = new controleEditora

// interface
interface LinhaLivroProps {
  livro: Livro;
  excluir: (codigo:number) => void;
}

// Componente exportável LinhaLivro
const LinhaLivro: React.FC<LinhaLivroProps> = (props) => {
  const nomeEditora = ControleEditora.getNomeEditora(props.livro.codEditora);

  return (
    <tr className=''>
      {/* titulo do livro + button */}
      <td>{props.livro.titulo} <button className="btn btn-danger rounded-1 mt-1 d-block text-white"onClick={() => props.excluir(props.livro.codigo)}>Excluir</button></td>

      {/* resumo do livro */}
      <td><p>{props.livro.resumo}</p></td>

      {/* Editorado livro */}
      <td id="editoras">{nomeEditora}</td>

      {/* Autores do livro */}
      <td><ul>{props.livro.autores.map((item,idx) => <li key={idx}>{item}</li>)}</ul></td>
    </tr>
  );
  };

  export default LinhaLivro