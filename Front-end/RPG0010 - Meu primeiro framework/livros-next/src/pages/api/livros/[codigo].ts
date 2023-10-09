import { NextApiRequest, NextApiResponse } from 'next';
import ControleLivro  from '../../../../classes/controle/controleLivro';

const controleLivro = new ControleLivro();

// request delete e tratando status
export default (req: NextApiRequest, res: NextApiResponse) => {
  
  // caso seja DELETE
  try {
    if (req.method === 'DELETE') {
      const { codigo } = req.query;
      const codigoLivro = Number(codigo);

      if (isNaN(codigoLivro)) {
        res.status(400).json({ error: 'Código de livro inválido' });
      } else {
        controleLivro.excluir(codigoLivro);
        res.status(200).json({ message: 'Livro excluído com sucesso' });
      }
    } else {
      res.status(405).end();
    }
  } catch (error) {
    res.status(500).json({ error: 'Ocorreu um erro interno no servidor' });
  }
};