import { useState, useEffect } from 'react';
import Head from 'next/head';
import Menu  from '../../componentes/menu';
import  Livro  from '../../classes/modelo/livro';
import LinhaLivro  from '../../componentes/linhaLivro';
import styles from '../styles/Home.module.css';
import ControleLivros from '../../classes/controle/controleLivro'

// instanciando classe
const controleLivros = new ControleLivros()

// url componente LivroLista
const LivroLista: React.FC = () => {
  // States
  const [livros, setLivros] = useState([]);
  const [carregado, setCarregado] = useState(false);

 
  // userEffect
  useEffect(() => {
    controleLivros.obterLivros().then((livros)=> setLivros(livros))
  }, [carregado]);

  // function excluir
  const excluir = (codigo:string) => {
    controleLivros.excluir(codigo).then(() => {
      setCarregado(true)
    })
    setCarregado(false)
  };

  // Componente
  return (
    // container
    <div className={styles.container}>
      {/* Head */}
      <Head>
        <title>Loja Next - Lista de Livros</title>
      </Head>

      {/* Menu */}
      <Menu />

      {/* Main */}
      <main className="mt-1 px-5">

        {/* h1 */}
        <h1 className={styles.title}>Lista de Livros</h1>

        {/* table */}
        <table className='container-fluid'>

          {/* thead */}
          <thead>
            <tr className="bg-dark text-white text-center">
              <th>Titulo</th>
              <th>Resumo</th>
              <th>Editora</th>
              <th>Autores</th>
            </tr>
          </thead>

          {/* tbody */}
          <tbody>
            {/* Percorrendo cada livro e listando */}
            {livros.map((livro,index) => {
              return(
                <LinhaLivro key={index} livro={livro} excluir={() => excluir(livro.codigo)} />
              )
            })}
          </tbody>
        </table>
      </main>
    </div>
  );
};


export default LivroLista