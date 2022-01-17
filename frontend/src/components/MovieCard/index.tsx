import MovieScore from 'components/MovieScore'
import { Link } from 'react-router-dom'
import { Movie } from 'types/movie'

type Props = {
  movie: Movie
}

function MovieCard({ movie }: Props) {
  // const movie = {
  //   id: 1,
  //   image: 'https://pbs.twimg.com/media/DkRxmnBW4AEztYG.jpg',
  //   title: 'Ursos Grandes, Peludos e Mansos',
  //   count: 2,
  //   score: 4.5
  // }
  return (
    <div>
      <img
        className="dsmovie-movie-card-image"
        src={movie.image}
        alt={movie.title}
      />
      <div className="dsmovie-card-bottom-container">
        <h3>{movie.title}</h3>
        <MovieScore count={movie.count} score={movie.score} />
        <Link to={`/form/${movie.id}`}>
          <div className="btn btn-primary dsmovie-btn">Avaliar</div>
        </Link>
      </div>
    </div>
  )
}

export default MovieCard
