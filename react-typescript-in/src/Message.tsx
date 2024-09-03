import React, { useContext } from 'react';
import { UserContext } from './UserContext';


const Message: React.FC = () => {

    const context = useContext(UserContext);
    if(!context){
        throw new Error("useContext must be inside a Provider with a value");
    }
    return (
        <div>
            <p>{context.name},{context.message}</p>
        </div>
    );
}

export default Message;