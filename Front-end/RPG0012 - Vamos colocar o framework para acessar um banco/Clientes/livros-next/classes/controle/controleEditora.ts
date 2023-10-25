// ControleEditora.ts
import Editora from '../modelo/editora';

// array de editoras
const editoras: Editora[] = [
  new Editora(1, 'Alta Books'),
  new Editora(2, 'Pearson'),
  new Editora(3, 'Addison Wesley'),
];

// Class controleEditora
class ControleEditora {

  // metodo getEditoras
  getEditoras(): Editora[] {
    return editoras;
  }

  // metodo getNomeEditora
  getNomeEditora(codEditora: number): string {
    const editora = editoras.find((e) => e.codEditora === codEditora);
    return editora ? editora.nome : '';
  }
}

export default ControleEditora;