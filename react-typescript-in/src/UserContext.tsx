import React from 'react';


interface UserContextInterface {
    name: string;
    message: string;
}
 
export const UserContext = React.createContext<UserContextInterface | undefined> (undefined);