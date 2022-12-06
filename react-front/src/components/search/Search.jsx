import {Input, InputGroup, InputLeftElement} from "@chakra-ui/react";
import {Search2Icon} from "@chakra-ui/icons";
import './search.css'


export default function Search({searchByCategory}) {


    const handle = msg => {
        searchByCategory(msg.target.value)
    }

    return (
        <div className="search-container">
            <InputGroup width="50rem">
                <InputLeftElement
                    pointerEvents='none'
                    children={<Search2Icon color='gray.300'/>}
                />
                <Input type='text' placeholder='Categoria del libro' onChange={handle}/>
                {/*<InputRightElement width="4.5rem">*/}
                {/*    <Button onClick={searchByCategory(v)}>Buscar</Button>*/}
                {/*</InputRightElement>*/}
            </InputGroup>

        </div>
    )
}