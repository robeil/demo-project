import React,{FC} from "react";

inteface TestProps {
    message: String;
}

const Test:FC<TestProps> = ({message}){
    return <h1>{message}</h1>;
}

export default Test;