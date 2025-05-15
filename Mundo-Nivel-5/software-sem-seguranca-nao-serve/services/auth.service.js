import jwt from 'jsonwebtoken'
import { users } from "../mocks/index.js";
import 'dotenv/config'

// Responsável de verificar se o usuário existe e retorna-lo
export function doLogin(credentials){

  let userData = users.find(item => {
    if(credentials?.username === item.username && credentials?.password === item.password)
      return item;
  });

  return userData;

}

// Responsável em criptografar o id do usuário utilizando o jwt
export function encrypt(id) {

   const token = jwt.sign({
      userId: id
    }, process.env.SECRETKEY, { expiresIn:'180s' });

  return token;

}

// Responsável decodificar o token
export function decrypt(token) {
  const result = jwt.verify(token, process.env.SECRETKEY)

  return result
}