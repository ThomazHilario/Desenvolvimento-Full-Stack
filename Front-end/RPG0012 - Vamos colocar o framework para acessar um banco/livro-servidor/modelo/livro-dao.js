// import livro schema
const Livro = require('./livro-schema.js')

// obtendo livros
const obterLivros = async () => {
    try {
        const livros = await Livro.find()
        return livros
    } catch (error) {
        console.log(error)
    }
}

// incluir livro
const incluir = async (livro) =>{
    try {
        const livroInserido = await Livro.create(livro)
        return livroInserido
    } catch (error) {
        console.log(error)
    }
}

// excluindo livro
const excluir = async (codigo) => {
    try {
        await Livro.deleteOne({ _id: codigo })
    } catch (error) {
        console.log(error)
    }
}

// exportando 
module.exports = { obterLivros, incluir, excluir };