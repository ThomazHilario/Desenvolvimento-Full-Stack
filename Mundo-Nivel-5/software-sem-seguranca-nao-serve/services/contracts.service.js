// Repositories
// Classe fake emulando um script externo, responsável pela execução de queries no banco de dados
import { Repository } from '../repositories/contracts.repositories.js'

// Validators
import { sanitizeInput } from '../validators/validators.js'

// Recupera, no banco de dados, os dados dos contratos
// Metodo não funcional, servindo apenas para fins de estudo
export function getContracts(empresa, inicio){

   if (!sanitizeInput(empresa) || !sanitizeInput(inicio)) {
    throw new Error("Parâmetros inválidos detectados.")
  }

  const repository = new Repository()

  const query = `Select * from contracts Where empresa = ? And data_inicio = ?`

  const result = repository.execute(query, { empresa, inicio })

  return result;

}