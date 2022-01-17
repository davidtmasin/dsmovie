import CommentCard from 'components/CommentCard'
import { useParams } from 'react-router-dom'

function Comments() {
  const params = useParams()
  return <CommentCard movieId={`${params.movieId}`} />
}

export default Comments
