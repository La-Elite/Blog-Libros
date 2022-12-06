import {Divider} from "@chakra-ui/react";
import './comment.css'

export default function Comment({fecha, mensaje, usuario}) {
    return (
        <div className='comment-container'>
            <div className='comment-header'>
                <h1>{usuario.id}</h1>
                <p>{fecha}</p>
            </div>
            <p className='comment-body'>{mensaje}</p>
            <Divider mt={5}/>
        </div>
    )
}