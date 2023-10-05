import { NextApiRequest, NextApiResponse } from 'next';
import ControleEditora from '../../../../classes/controle/controleEditora';

// instancia controleEditora
const controleEditora = new ControleEditora()

export default (req: NextApiRequest, res:NextApiResponse) => {
    try{
        if(req.method === 'GET'){
            const editoras = controleEditora.getEditoras()
            res.status(200).json(editoras)
        } else{
            // Tratando status 405
            res.status(405).end()
        }
    }catch(e){
        res.status(500).json({e:'Erro no server'})
    }
}