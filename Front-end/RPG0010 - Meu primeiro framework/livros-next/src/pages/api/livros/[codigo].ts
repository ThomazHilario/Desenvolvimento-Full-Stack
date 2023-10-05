import { NextApiRequest, NextApiResponse } from 'next';
import ControleLivros from '../../../../classes/controle/controleLivro';

// instancia do controleLivro
const controleLivros = new ControleLivros

export default(req:NextApiRequest, res:NextApiResponse) =>{
    try{
        if(req.method === 'DELETE'){
            const codigo = Number(req.query.codEditoras)
            controleLivros.excluir(codigo)
            res.status(200).json({ message: 'Livro excluído' })
        }  else{
            res.status(405).end()
        }
    }catch(e){
        res.status(500).json({e:'erro no server'})
    }
}