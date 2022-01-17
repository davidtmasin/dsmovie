import { validateEmail } from 'utils/validate'
import './styles.css'
import axios, { AxiosRequestConfig } from 'axios'
import { Link, useNavigate } from 'react-router-dom'
import { Movie } from 'types/movie'
import { useEffect, useState } from 'react'
import { BASE_URL } from 'utils/requests'

type Props = {
  movieId: string
}

function CommentCard({ movieId }: Props) {
  // const movie = {
  //   id: 1,
  //   image: 'https://pbs.twimg.com/media/DkRxmnBW4AEztYG.jpg',
  //   title: 'Ursos Grandes, Peludos e Mansos',
  //   count: 2,
  //   score: 4.5
  // }

  const navigate = useNavigate()

  const [movie, setMovie] = useState<Movie>()
  useEffect(() => {
    axios.get(`${BASE_URL}/movies/${movieId}`).then(response => {
      setMovie(response.data)
    })
  }, [movieId])

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault()
    const email = (event.target as any).email.value
    const comment = (event.target as any).comment.value
    // const score = (event.target as any).score.value

    if (!validateEmail(email)) {
      return
    }

    const config: AxiosRequestConfig = {
      baseURL: BASE_URL,
      method: 'PUT',
      url: '/comments',
      data: {
        email: email,
        movieId: movieId,
        comment: comment
        // score: score
      }
    }

    axios(config).then(response => {
      // console.log(response.data)
      navigate('/')
    })
  }

  return (
    <div className="dsmovie-form-container">
      <img
        className="dsmovie-movie-card-image"
        src={movie?.image}
        alt={movie?.title}
        title={movie?.title}
      />
      <div className="dsmovie-card-bottom-container">
        <h3>{movie?.title}</h3>
        <form className="dsmovie-form" onSubmit={handleSubmit}>
          <div className="form-group dsmovie-form-group">
            <label htmlFor="email">Informe seu email</label>
            <input
              type="email"
              className="form-control"
              id="email"
              name="email"
              autoComplete="off"
              required
            />
          </div>
          <div className="form-group dsmovie-form-group">
            <label htmlFor="comment">
              Registre seu comentário (240 caracteres)
            </label>
            <textarea
              rows={6}
              maxLength={240}
              className="form-control"
              id="comment"
              name="comment"
              autoComplete="off"
              required
            />
          </div>
          <div className="dsmovie-form-btn-container">
            <button type="submit" className="btn btn-primary dsmovie-btn">
              Salvar
            </button>
          </div>
        </form>
        <Link to="/">
          <button className="btn btn-primary dsmovie-btn mt-3">Cancelar</button>
        </Link>
      </div>
      <div className="dsmovie-container-comments">
        <h6>
          <strong>example@example.com</strong> diz:
        </h6>
        <p>
          Aqui é um comentário de exemplo para poder simular o comentário do
          usuário.
        </p>
        <hr />
        <h6>
          <strong>example@example.com</strong> diz:
        </h6>
        <p>
          Aqui é um comentário de exemplo para poder simular o comentário do
          usuário.
        </p>
        <hr />
        <h6>
          <strong>example@example.com</strong> diz:
        </h6>
        <p>
          Aqui é um comentário de exemplo para poder simular o comentário do
          usuário.
        </p>
        <hr />
        <h6>
          <strong>example@example.com</strong> diz:
        </h6>
        <p>
          Aqui é um comentário de exemplo para poder simular o comentário do
          usuário.
        </p>
        <hr />
        <h6>
          <strong>example@example.com</strong> diz:
        </h6>
        <p>
          Aqui é um comentário de exemplo para poder simular o comentário do
          usuário.
        </p>
        <hr />
      </div>
    </div>
  )
}

export default CommentCard
