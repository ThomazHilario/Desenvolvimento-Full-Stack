// importando conexao com o banco
const banco = require('./conexao.js')

const LivroSchema = new banco.Schema ({
    titulo: String,
    codEditora:Number, 
    resumo:String,
    autores:[String]
})

// Crie um modelo a partir do esquema definido
const Livro = banco.model('Livro', LivroSchema);

// Exporte o modelo para uso em outros lugares do aplicativo
module.exports = Livro;
