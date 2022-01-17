import './styles.css'
import { Link } from 'react-router-dom'

function Footer() {
  return (
    <footer>
      <div className="container">
        <div className="dsmovie-footer-content">
          <p>
            Projeto desenvolvido por{' '}
            <strong>
              <Link to="https://linktr.ee/davidtmasin">David Teixeira</Link>
            </strong>{' '}
            durante a Semana Spring React da escola Dev Superior.
          </p>
        </div>
      </div>
    </footer>
  )
}

export default Footer
