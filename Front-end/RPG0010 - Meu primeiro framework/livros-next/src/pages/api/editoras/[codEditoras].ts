import { NextApiRequest, NextApiResponse } from 'next';
import { useRouter } from 'next/router'
import ControleEditora from '../../../../classes/controle/controleEditora';
import { userAgent } from 'next/server';

let controleEditora = new ControleEditora()
export default (req: NextApiRequest, res: NextApiResponse) => {
  try {
    if (req.method === 'GET') {
      const codEditora = Number(req.query.codEditoras); // Converte o parâmetro para número
      const nomeEditora = controleEditora.getNomeEditora(codEditora); // Supondo que o método getNomeEditora esteja disponível em controleEditora
      if (nomeEditora) {
        res.status(200).json({ nome: nomeEditora });
      } else {
        res.status(404).json({ error: 'Editora não encontrada' });
      }
    } else {
      res.status(405).end(); // Método não permitido
    }
  } catch (error) {
    res.status(500).json({ error: 'Erro interno do servidor' });
    
  }
};