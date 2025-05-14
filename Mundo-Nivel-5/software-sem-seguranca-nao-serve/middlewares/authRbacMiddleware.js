export function authRbacMiddleware(req, res, next){
  try {
    if(req.userData.perfil !== "admin") {
      return res.status(401).json({ message: 'Você não tem autorização necessária!' })
    }

    next() 
  } catch (e) {
    return res.status(401).json({ message: 'Token Expirado ou inválido!' })
  }
}