import { useState } from 'react';
import Head from 'next/head';
import Menu from '../../componentes/menu';
import ControleEditora from '../../classes/controle/controleEditora';
import styles from '../styles/Home.module.css';
import { useRouter } from 'next/router';

// instanciando a classe
const controleEditora = new ControleEditora();

// url
const baseURL = 'http://localhost:3000/api/livros';
// Componente LivroDados
const LivroDados: React.FC = () => {
  // states
  const [titulo, setTitulo] = useState<string>('');
  const [resumo, setResumo] = useState<string>('');
  const [autores, setAutores] = useState<string>('');
  const [codEditora, setCodEditora] = useState<number>(0);

  // opcoes 
  const opcoes = controleEditora.getEditoras().map((editora) => ({
    value: editora.codEditora.toString(),
    text: editora.nome,
  }));

  // usando useRouter aoinves de useNavigate
  const router = useRouter();

  const tratarCombo = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setCodEditora(Number(event.target.value));
  };

  // incluir livro
  const incluir = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const livro = {
      codigo: 0,
      titulo,
      resumo,
      autores: autores.split('\n'),
      codEditora,
    };

    //request
    const sucesso = await incluirLivro(livro);

    // caso a mensaagem retorne sucesso
    if (sucesso) {
      router.push('/LivroLista');
    }
  };

  // incluindo livro
  const incluirLivro = async (livro: any) => {
    try {
      const response = await fetch(baseURL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(livro),
      });

      return response.ok;
    } catch (error) {
      console.error('Erro ao incluir o livro:', error);
      return false;
    }
  };

  // return
  return (
    // div container
    <div className={styles.container}>
      {/* head */}
      <Head>
        <title>Loja Next - Dados do Livro</title>
      </Head>

    {/* menu */}
      <Menu />

      {/* Main */}
      <main className="mt-5 d-flex justify-content-center align-items-center flex-column">
        {/* h1 */}
        <h1 className={styles.title}>Dados do Livro</h1>

        {/*Formulario */}
        <form onSubmit={incluir} className={styles.form}>

          {/* titulo */}
          <div className="mb-3">
            <label htmlFor="titulo" className="form-label">Título</label>
            <input type="text" className="form-control" id="titulo" value={titulo} onChange={(e) => setTitulo(e.target.value)} required />
          </div>

          {/* Resumo */}
          <div className="mb-3">
            <label htmlFor="resumo" className="form-label">Resumo</label>
            <textarea className="form-control" id="resumo" rows={3} value={resumo} onChange={(e) => setResumo(e.target.value)} required />
          </div>

          {/* Autores */}
          <div className="mb-3">
            <label htmlFor="autores" className="form-label">Autores (um por linha)</label>
            <textarea className="form-control" id="autores" rows={3} value={autores} onChange={(e) => setAutores(e.target.value)} required />
          </div>

          {/* Editora */}
          <div className="mb-3"><label htmlFor="codEditora" className="form-label">Editora</label>
          <select className="form-select"id="codEditora"value={codEditora}onChange={tratarCombo}required>
              {opcoes.map((opcao) => (
                <option key={opcao.value} value={opcao.value}>
                  {opcao.text}
                </option>
              ))}
            </select>
          </div>

          {/*Button */}
          <button type="submit" className="btn btn-primary">
            Incluir Livro
          </button>
        </form>
      </main>
    </div>
  );
};

export default LivroDados;