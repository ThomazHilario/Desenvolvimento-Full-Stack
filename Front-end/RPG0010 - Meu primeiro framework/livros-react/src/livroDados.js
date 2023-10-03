import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import ControleEditora from './controle/controleEditora';
import ControleLivros from './controle/controleLivro';

// Instanciando classes
const controleEditora = new ControleEditora
const controleLivro = new ControleLivros

const LivroDados = () => {
    const [titulo, setTitulo] = useState('');
    const [resumo, setResumo] = useState('');
    const [autores, setAutores] = useState('');
    const [codEditora, setCodEditora] = useState(0); // Inicializada com a posição zero de opcoes
    const navigate = useNavigate();
  
    const opcoes = controleEditora.getEditoras().map(editora => ({
      value: editora.codEditora,
      text: editora.nome,
    }));
  
    const tratarCombo = (event) => {
      setCodEditora(Number(event.target.value));
    };
  
    const incluir = (event) => {
      event.preventDefault();
      const autoresArray = autores.split('\n');
      const novoLivro = {
        codigo: 0, // Código inicializado com zero
        titulo,
        resumo,
        autores: autoresArray,
        codEditora,
      };
      controleLivro.incluir(novoLivro);
      navigate('/');
    };
  
    return (
        // main
      <main >
        <h2>Incluir Livro</h2>

        {/* formulario */}
        <form onSubmit={incluir} className='w-50'>

            {/* input */}
          <div className="form-group">
            <label>Título:</label>
            <input type="text" className="form-control " value={titulo} onChange={(e) => setTitulo(e.target.value)} required/>
          </div>

          {/* textarea */}
          <div className="form-group">
            <label>Resumo:</label>
            <textarea className="form-control" value={resumo} onChange={(e) => setResumo(e.target.value)} required ></textarea>
          </div>

          {/* Autores */}
          <div className="form-group">
            <label>Autores:</label>
            <textarea className="form-control" value={autores} onChange={(e) => setAutores(e.target.value)} required ></textarea>
          </div>

          {/* Select editoras */}
          <div className="form-group">
            <label>Editora:</label>
            <select
              className="form-control"
              value={codEditora}
              onChange={tratarCombo}
            >
              {opcoes.map((opcao) => (
                <option key={opcao.value} value={opcao.value}>{opcao.text}</option>
              ))}
            </select>
          </div>

          {/* button incluir */}
            <button className="bg-primary px-4">Incluir</button>
        </form>
      </main>
    );
  };

export default LivroDados