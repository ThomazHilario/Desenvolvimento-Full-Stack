import e from 'express'
import bodyParser from 'body-parser'

// Middlewares
import { authMiddleware } from './middlewares/authMiddleware.js'
import { authRbacMiddleware } from './middlewares/authRbacMiddleware.js'

// Mocks
import { users } from './mocks/index.js'

// Services
import { doLogin, encrypt, decrypt } from './services/auth.service.js'
import { getContracts } from './services/contracts.service.js'

const app = e()

app.use(bodyParser.json())

const port = process.env.PORT || 3000

app.listen(port, () => {

  console.log(`Server is running on port ${port}`)

})

app.get('/', (req, res) => {
  res.json('Hello World')
})

// Recuperar as informações do usuário logado com base no token
app.get('/api/auth/me', authMiddleware, (req, res) => {
  return res.json(req.userData)
})

// Realizar login e criar um token para o usuário
app.post('/api/auth/login', (req, res) => {

  const credentials = req.body

  let userData = doLogin(credentials)

  if(userData){

    const token = encrypt(userData.id)

    res.json({ token })
    return
  }

  res.json({
    message: 'User not found!'
  })

})

// Decodificação do token no qual retorna somente o id do usuario - privilégios de RBAC(Quem pode fazer a requisição)
app.post('/api/auth/decrypt', authMiddleware, authRbacMiddleware, (req, res) => {
  const tokenDecrypted = decrypt(req.token)

  res.json({ userId: tokenDecrypted.userId })
})

// Endpoint para recuperação dos dados - privilégios de RBAC(Quem pode fazer a requisição)
app.get('/api/users', authMiddleware, authRbacMiddleware, (req, res) => {

  res.status(200).json({ data: users })
})

//Endpoint para recuperação dos contratos existentes - privilégios de RBAC(Quem pode fazer a requisição)
app.get('/api/contracts/:empresa/:inicio/', authMiddleware, authRbacMiddleware, (req, res) => {

  const empresa = req.params.empresa;

  const dtInicio = req.params.inicio;

  const result = getContracts(empresa, dtInicio);

  if(result)

    res.status(200).json({ data: result })

  else

    res.status(404).json({data: 'Dados Não encontrados'})

})