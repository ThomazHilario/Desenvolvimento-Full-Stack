import { NextApiRequest, NextApiResponse } from 'next';
import ControleLivros from '../../../classes/controle/controleLivro';

// instancia do controleLivro
const controleLivros = new ControleLivros

export default(req:NextApiRequest, res:NextApiResponse) =>{
    try{
        if(req.method === 'GET'){
            const livros = controleLivros.obterLivros()
            res.status(200).json(livros)
        } else if(req.method === 'POST'){
            const novoLivro = req.body
            controleLivros.incluir(novoLivro)
            res.status(200).json({message:'Seu livro foi adicionado'})
        } else{
            res.status(405).end()
        }
    }catch(e){
        res.status(500).json({e:'erro no server'})
    }
}