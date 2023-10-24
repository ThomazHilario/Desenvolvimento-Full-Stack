// importando biblioteca moongose
const banco = require('mongoose');

// Definindo as opções de conexão
const options = {
    useUnifiedTopology: true,
    useNewUrlParser: true
};

// Conecte-se ao MongoDB
banco.connect('mongodb+srv://thomazhilario5:bnlucLW1oUK22LjN@livraria.gzgxzfi.mongodb.net/', options)
.then(() => {
    console.log('Conexão com o MongoDB estabelecida com sucesso');
})
.catch(err => {
    console.error('Erro ao conectar ao MongoDB:', err);
});

module.exports = banco;