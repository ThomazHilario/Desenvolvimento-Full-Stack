import { useState, useEffect } from 'react';
import Head from 'next/head';
import Menu  from '../../componentes/menu';
import  Livro  from '../../classes/modelo/livro';
import LinhaLivro  from '../../componentes/linhaLivro';
import styles from '../styles/Home.module.css';

// url
const baseURL = 'http://localhost:3000/api/livros';

// url componente LivroLista
const LivroLista: React.FC = () => {
  // States
  const [livros, setLivros] = useState<Array<Livro>>([]);
  const [carregado, setCarregado] = useState<boolean>(false);

  // Function obterLivros
  const obterLivros = async () => {
    try {
      const response = await fetch(baseURL);
      const data = await response.json();
      setLivros(data);
    } catch (error) {
      console.error('Erro ao obter a lista de livros:', error);
    }
  };

  //function exluirLivro - request
  const excluirLivro = async (codigo: number) => {
    try {
      const response = await fetch(`${baseURL}/${codigo}`, { method: 'DELETE' });
      return response.ok;
    } catch (error) {
      console.error(`Erro ao excluir o livro com código ${codigo}:`, error);
      return false;
    }
  };

  // userEffect
  useEffect(() => {
    obterLivros().then(() => setCarregado(true));
  }, [carregado]);

  // function excluir
  const excluir = async (codigo: number) => {
    const sucesso = await excluirLivro(codigo);
    if (sucesso) {
      setCarregado(false);
    }
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
      <main className="mt-5">

        {/* h1 */}
        <h1 className={styles.title}>Lista de Livros</h1>

        {/* table */}
        <table className="table">

          {/* thead */}
          <thead>
            <tr className={styles.hello}>
              <th>Código</th>
              <th>Título</th>
              <th>Autor</th>
              <th>Ano de Publicação</th>
            </tr>
          </thead>

          {/* tbody */}
          <tbody>
            {/* Percorrendo cada livro e listando */}
            {livros.map((livro) => (
              <LinhaLivro key={livro.codigo} livro={livro} excluir={excluir} />
            ))}
          </tbody>
        </table>
      </main>
    </div>
  );
};


export default LivroLista