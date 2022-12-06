import './navigationBar.css'
import {
    Button, Input, Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalFooter,
    ModalHeader,
    ModalOverlay,
    useDisclosure
} from "@chakra-ui/react";
import {useState} from "react";

export default function NavigationBar() {
    const user = window.location.pathname
    const user2 = user.replace('/', '')
    const {isOpen, onOpen, onClose} = useDisclosure()
    let info
    const [username, setUsername] = useState("")
    const [pass, setPass] = useState("")

    const botones = <><Button colorScheme='red'><a href="http://localhost:8080/register">Registrar</a></Button>
        <Button colorScheme='red' variant="outline" onClick={onOpen}>Iniciar Sesión</Button></>

    if (user2 !== "") {
        info = <p>{user2}</p>
    } else {
        info = botones
    }
    const handleUsername = (e) => {
        setUsername(e.target.value)
    }
    const handlePass = (e) => {
        setPass(e.target.value)
    }

    const iniciarSesion = () => {
        if (username !== "" && pass !== "") {
            fetch('http://localhost:8080/signup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    'id': username,
                    'pass': pass,
                })
            }).then(response => {
                if (response.status === 200) {
                    window.location.href = `http://localhost:5173/${username}`
                } else {
                    alert('Usuario o contraseña incorrectos')
                }
            })
        } else {
            alert('Debes llenar todos los campos')
        }
    }


    return (
        <>
            <div className="navigationBar">
                <p className="logo">Libreria</p>
                <div className="buttons">
                    {info}
                </div>
            </div>
            <Modal isOpen={isOpen} onClose={onClose}>
                <ModalOverlay/>
                <ModalContent>
                    <ModalHeader>Introduce tus credenciales</ModalHeader>
                    <ModalCloseButton/>
                    <ModalBody>
                        <Input placeholder='Usuario' onChange={handleUsername}/>
                        <Input placeholder='Contraseña' onChange={handlePass}/>
                    </ModalBody>
                    <ModalFooter>
                        <Button colorScheme='blue' mr={3} onClick={iniciarSesion}>Iniciar Sesión</Button>
                        <Button variant='ghost' onClick={onClose}>Cancelar</Button>
                    </ModalFooter>
                </ModalContent>
            </Modal>
        </>
    )
}