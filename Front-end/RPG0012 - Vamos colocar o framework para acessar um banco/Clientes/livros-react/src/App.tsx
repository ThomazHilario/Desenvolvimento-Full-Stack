import React from 'react';
import {BrowserRouter, Route, Routes,Link} from 'react-router-dom'
import './App.css';
import LivroLista from './livroLista';
import LivroDados from './livroDados';

function App() {
  return (
    
    <BrowserRouter>
    <nav className="navbar navbar-expand-lg navbar-light bg-light bg-dark">
          <div className="container">
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <Link className="nav-link text-light" to="/">Catalogo</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link text-light" to="/dados">Novo</Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        
        <div className="App">
            <Routes>
              <Route path='/' element={<LivroLista/>}/>
              <Route path="/dados" element={<LivroDados/>} />
            </Routes>
        </div>
    </BrowserRouter>
    
  );
}

export default App;
