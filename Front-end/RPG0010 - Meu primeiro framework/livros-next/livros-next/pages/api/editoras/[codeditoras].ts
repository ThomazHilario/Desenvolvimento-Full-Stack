import { NextApiRequest, NextApiResponse } from 'next';
import controleEditora from '../../../classes/controle/controleEditora'

//instanciando controleEditora
const ControleEditora = new controleEditora


export default(req:NextApiRequest, res:NextApiResponse) => {
    try{
        if(req.method == 'GET'){
            const codEditora = Number(req.query.codEditora)
            const nomeEditora = ControleEditora.getNomeEditora(codEditora)
    
            if(nomeEditora){
                res.status(200).json({nome:nomeEditora})
            } else{
                res.status(400).json({erro:'editora nao encontrada'})
            }
        } else{
            res.status(405).end()
        } 
    }catch(e){
        res.status(500).json({e:'Erro no server'})
    }
}