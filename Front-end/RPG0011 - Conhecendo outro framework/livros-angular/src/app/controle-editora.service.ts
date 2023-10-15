import { Injectable } from '@angular/core';
import Editora from './editora'

@Injectable({
  providedIn: 'root'
})

export default class ControleEditoraService {
  // Definindo propriedades
  editoras:Editora[] = [
    new Editora(1, 'Alta Books'),
    new Editora(2, 'Pearson'),
    new Editora(3, 'Addison Wesley'),
  ]

  getEditoras():Editora[]{
    return this.editoras
  }

  getNomeEditora(codEditora:number){
    const nomeEditora = this.editoras.filter(item => item.codEditora === codEditora)
    return nomeEditora
  }
  
}
