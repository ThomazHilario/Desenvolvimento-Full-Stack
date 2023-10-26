// ControleEditora.ts
import Editora from '../modelo/editora';

const editoras: Editora[] = [
  new Editora(1, 'Alta Books'),
  new Editora(2, 'Pearson'),
  new Editora(3, 'Addison Wesley'),
];

class ControleEditora {
  getEditoras(): Editora[] {
    return editoras;
  }

  getNomeEditora(codEditora: number){
    const editora = editoras.filter((e) => e.codEditora === codEditora);
    return editora.map(item => item.nome)
  }
}

export default ControleEditora;