import {
    Accordion, AccordionButton, AccordionIcon, AccordionItem, AccordionPanel, Badge, Box, Button,
    Card,
    CardBody,
    CardFooter, Center,
    Divider,
    Heading,
    Image, Modal, ModalBody, ModalCloseButton, ModalContent, ModalFooter, ModalHeader, ModalOverlay, Spacer,
    Stack,
    Text, Textarea, useDisclosure
} from "@chakra-ui/react";
import {FiMessageCircle} from "react-icons/all";
import './book.css';
import {useState} from "react";
import Comment from "../comments/comment";
import {motion} from "framer-motion";

export default function Book({onSendMessage, img, description, title, reviews, author, category, show, id, receiveId}) {
    const user = window.location.pathname
    const user2 = user.replace('/', '')


    const {isOpen, onOpen, onClose} = useDisclosure()
    const [msg, setMsg] = useState("")
    let newComment = null
    const rv = reviews.map(r => <Comment key={r.id} fecha={r.date} mensaje={r.message} usuario={r.user}/>)

    const comentar = () => {
        if (user2 !== "") {
            onSendMessage(msg, id, user2)
        } else {
            alert('Debes iniciar sesión para comentar')
        }
        onClose()
    }


    if (receiveId === id) {
        newComment = show && <motion.div
            className='alert'
            initial={{x: -100, opacity: 0}}
            animate={{x: 0, opacity: 1}}
            transition={{type: "spring", bounce: 0.4, duration: 1.5}}>Nuevo Comentario</motion.div>
    }


    function handleMessage(msg) {
        setMsg(msg.target.value)
    }

    return (
        <div className="book-container">
            <Card maxW='sm' className='card'>
                <Badge colorScheme='red'>{category}</Badge>
                <CardBody>
                    <Center>
                        <Image
                            src={img}
                            alt='ddd'
                            borderRadius='lg'
                        />
                    </Center>
                    <Stack mt='6' spacing='3'>
                        <Heading size='md'>{title}</Heading>
                        <Text>{author}</Text>
                        <Spacer/>
                        <Accordion allowToggle>
                            <AccordionItem>
                                <h2>
                                    <AccordionButton>
                                        <Box flex='1' textAlign='left'>
                                            Comentarios
                                            {newComment}
                                        </Box>
                                        <AccordionIcon/>
                                    </AccordionButton>
                                </h2>
                                <AccordionPanel pb={4}>
                                    {rv}
                                </AccordionPanel>
                            </AccordionItem>
                        </Accordion>
                    </Stack>
                </CardBody>
                <Spacer/>
                <Divider/>
                <CardFooter>
                    <Button flex='1' variant='ghost' leftIcon={<FiMessageCircle color='red'/>} onClick={onOpen}>
                        Comentar
                    </Button>
                </CardFooter>
            </Card>

            <Modal isOpen={isOpen} onClose={onClose}>
                <ModalOverlay/>
                <ModalContent>
                    <ModalHeader>Realizar un comentario</ModalHeader>
                    <ModalCloseButton/>
                    <ModalBody>
                        <Textarea placeholder='Inserte el comentario' onChange={handleMessage}/>
                    </ModalBody>
                    <ModalFooter>
                        <Button colorScheme='blue' mr={3} onClick={comentar}>Comentar</Button>
                        <Button variant='ghost' onClick={onClose}>Cancelar</Button>
                    </ModalFooter>
                </ModalContent>
            </Modal>
        </div>
    )
}