import { NextApiRequest, NextApiResponse } from 'next';
import  ControleEditora  from '../../../../classes/controle/controleEditora';

const controleEditora = new ControleEditora();

export default (req: NextApiRequest, res: NextApiResponse) => {
  try {
    if (req.method === 'GET') {
      const { codEditora } = req.query;
      const codigo = Number(codEditora);

      if (isNaN(codigo)) {
        res.status(400).json({ error: 'Código de editora inválido' });
      } else {
        const nomeEditora = controleEditora.getNomeEditora(codigo);
        if (nomeEditora) {
          res.status(200).json({ nomeEditora });
        } else {
          res.status(404).json({ error: 'Editora não encontrada' });
        }
      }
    } else {
      res.status(405).end();
    }
  } catch (error) {
    res.status(500).json({ error: 'Ocorreu um erro interno no servidor' });
  }
};