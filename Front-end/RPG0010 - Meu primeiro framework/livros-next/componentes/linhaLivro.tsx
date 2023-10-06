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
      <td>{props.livro.titulo} <button className="bg-danger border-0 rounded-1 mt-1 d-block"onClick={() => props.excluir(props.livro.codigo)}>Excluir</button></td>
      <td><p>{props.livro.resumo}</p></td>
      <td id="editoras">{nomeEditora}</td>
      <td><ul><li>{props.livro.autores}</li></ul></td>
    </tr>
  );
  };

  export default LinhaLivro