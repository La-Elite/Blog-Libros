import NavigationBar from "./components/navbar/NavigationBar";
import Search from "./components/search/Search";
import Book from "./components/books/Book";
import './app.css';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import {useEffect, useState} from "react";
import {delay} from "framer-motion";

function App() {

    const [data, setData] = useState([])
    const [filtrado, setFiltrado] = useState(data)
    const [buscado, setBuscado] = useState("")
    const [show, setShow] = useState(false)
    const [rId, setRId] = useState('')
    const sock = new SockJS('http://localhost:8080/library')
    const stompClient = Stomp.over(sock)
    stompClient.debug = null

    useEffect(() => {
        fetch('http://localhost:8080/book', {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(r => r.json())
            .then(d => createArray(d))
    }, [rId, show])

    const createArray = d => {
        setData(d)
    }

    useEffect(() => {
        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/topic/mensaje', function (message) {
                let respuesta = JSON.parse(message.body)
                let id = respuesta.bookIsbn
                setRId(id)
                setShow(true)
                delay(() => {
                    setShow(false)
                }, 5000)
            })
        })
    }, [])

    const handleMessage = (msg, id, user) => {
        stompClient.send('/app/receive', {},
            JSON.stringify({
                'user': user,
                'bookIsbn': id,
                'message': msg
            }))
    }

    let books =
        filtrado.map(b => <Book
            key={b.id}
            id={b.id}
            onSendMessage={handleMessage}
            img={b.image}
            title={b.title}
            author={b.author}
            receiveId={rId}
            show={show}
            description={b.description}
            category={b.category}
            reviews={b.reviews}/>
        )

    const handleSearch = categoria => {
        setBuscado(categoria)
    }

    useEffect(() => {
        setFiltrado(data.filter(d => d.category.toLowerCase().includes(buscado)))
    }, [data, buscado])

    return (
        <>
            <NavigationBar/>
            <Search searchByCategory={handleSearch}/>
            <div className="app-grid">
                {books}
            </div>
        </>
    )
}

export default App
