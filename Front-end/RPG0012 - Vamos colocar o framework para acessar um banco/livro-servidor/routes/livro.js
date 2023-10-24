// importando livro dao
const {obterLivros, excluir , incluir } = require('../modelo/livro-dao')
const Livro = require('../modelo/livro-schema')

// variavel express
const express = require('express')

// router
const router = express.Router()

// pegando os livros
router.get('/', async (req, res) => {
    try {
      const livros = await obterLivros();
      res.json(livros);
    } catch (error) {
      res.status(500).json({ error: error.message });
    }
});

// incluindo livro
router.post('/', async (req, res) => {
    try {
        const novoLivro = req.body
        const livroInserido = Livro.create(novoLivro)
        res.json({ message: 'Livro incluído com sucesso', livro:  livroInserido});
    } catch (error) {
      res.status(500).json({ error: error.message });
    }
});

// excluindo livro
router.delete('/:codigo', async (req, res) => {
    const codigoLivro = req.params.codigo;
    try {
      await excluir(codigoLivro);
      res.json({ message: 'Livro excluído com sucesso' });
    } catch (error) {
      res.status(500).json({ error: error.message });
    }
});


module.exports = router;