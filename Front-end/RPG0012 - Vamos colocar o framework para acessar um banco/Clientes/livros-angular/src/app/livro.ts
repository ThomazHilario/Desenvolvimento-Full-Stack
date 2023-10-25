export default class Livro {
    // Definindo as propriedades
    codigo:string;
    codEditora:number;
    titulo:string;
    resumo:string;
    autores:string[];

    // Constructor
    constructor(codigo:string,codEditora:number,titulo:string,resumo:string,autores:string[]){
        this.codigo = codigo
        this.codEditora = codEditora
        this.titulo = titulo
        this.resumo = resumo
        this.autores = autores
    }

    
}
