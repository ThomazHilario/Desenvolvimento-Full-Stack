export class Repository{

  execute(query, params){
    
    // Visualizar a query
    console.log("Query executada:", query)

    return [
      { id: 1, empresa: params.empresa, data_inicio: params.inicio, contrato: 'Contrato A' }
    ]

  }

}