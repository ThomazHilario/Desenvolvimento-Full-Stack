import { users } from '../mocks/index.js'
import jwt from 'jsonwebtoken'
import 'dotenv/config'

export function authMiddleware(req, res, next){
  try{
    const token = req.headers.authorization?.split(' ')[1]
    
    if(!token){
        return res.status(401).json({ error: 'Token não fornecido' })
    }
    
    // Validando token
    const isValidToken = verifyToken(token)
    
    // Validando usuário
    const user = users.find(user => user.id === isValidToken.data.userId)
    
    if(isValidToken.value === false){
        return false
    }

    if(!user){
        return res.status(404).json({
            message: 'O usuário associado a este token não foi encontrado!'
        });
    }

    req.token = token
    req.userData = user
    next()
  } catch(e){
    if (e instanceof jwt.TokenExpiredError) {
      return res.status(401).json({
        message: 'O token de autenticação expirou!'
      });
    }

    if (e instanceof jwt.JsonWebTokenError) {
      return res.status(401).json({
        message: 'Token inválido!'
      });
    }
  }
}

function verifyToken(token){
  const result = jwt.verify(token, process.env.SECRETKEY)

  if(result){
    return {
        value: true,
        data: result
    }
  }

  return {
        value: false,
    }
}