// importando conexao com o banco
const banco = require('./conexao')

const LivroSchema = new banco.Schema ({
    _id:{
        type:banco.Schema.Types.ObjectId,
        require:true
    },
    titulo:{
        type:String,
        require:true
    },
    codEditora:{
        type:Number,
        require:true
    },
    resumo:{
        type:String,
        require:true
    },
    autores:{
        type:[String],
        require:true
    }
})

// Crie um modelo a partir do esquema definido
const Livro = banco.model('Livro', LivroSchema);

// Exporte o modelo para uso em outros lugares do aplicativo
module.exports = Livro;
