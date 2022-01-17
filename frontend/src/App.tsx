import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Listing from 'pages/Listing'
import Form from 'pages/Form'
import Navbar from 'components/Navbar'
import Footer from 'components/Footer'
import Comments from 'pages/Comments'

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Listing />} />
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
        <Route path="/comments">
          <Route path=":movieId" element={<Comments />} />
        </Route>
      </Routes>
      <Footer />
    </BrowserRouter>
  )
}

export default App
