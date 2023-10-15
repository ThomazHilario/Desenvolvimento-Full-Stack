export default class Livro {
    // Definindo as propriedades
    codigo:number;
    codEditora:number;
    titulo:string;
    resumo:string;
    autores:string[];

    // Constructor
    constructor(codigo:number,codEditora:number,titulo:string,resumo:string,autores:string[]){
        this.codigo = codigo
        this.codEditora = codEditora
        this.titulo = titulo
        this.resumo = resumo
        this.autores = autores
    }

    
}
