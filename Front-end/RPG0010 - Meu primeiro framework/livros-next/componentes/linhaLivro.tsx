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
    <tr>
      {/* titulo do livro + button */}
      <td className='p-3'>{props.livro.titulo} <button className="btn bg-danger text-white mt-1 d-block"onClick={() => props.excluir(props.livro.codigo)}>Excluir</button></td>

      {/* resumo do livro */}
      <td className='p-3'><p>{props.livro.resumo}</p></td>

      {/* Editorado livro */}
      <td id="editoras" className='text-center p-3'>{nomeEditora}</td>

      {/* Autores do livro */}
      <td className='p-3'><ul>{props.livro.autores.map((item,idx) => <li key={idx}>{item}</li>)}</ul></td>
    </tr>
  );
  };

  export default LinhaLivro