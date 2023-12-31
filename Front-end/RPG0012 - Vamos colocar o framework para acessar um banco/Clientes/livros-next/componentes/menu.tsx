import React from 'react';
import Link from 'next/link';
import {BrowserRouter,Routes} from 'react-router-dom'

// componente menu
const Menu: React.FC = () => {
  return (
    //menu via bootstrap
      <nav className="navbar navbar-expand-lg navbar-light bg-light bg-dark">
          <div className="container">
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                {/* Links */}
                  <li className="nav-item"><Link className="nav-link text-light" href="/">Inicio</Link></li>
                  <li className="nav-item"><Link className="nav-link text-light" href="LivroLista">Catalogo</Link></li>
                  <li className="nav-item"><Link className="nav-link text-light" href="LivroDados">Novo</Link></li>
              </ul>
            </div>
          </div>
      </nav>
  );
};


export default Menu




