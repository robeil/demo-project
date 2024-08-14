import React from 'react';
import LogOut from './LogOut'
import LogIn from './LogIn'
import AuthContext  from './ContextApi';


export default function MyComponent(props){
    const isLoggedIn = props.isLogedIn;
    const authContext = React.useContext(AuthContext);

    if(!isLoggedIn){
        return (
            <>
            <LogOut />
            Welcome {authContext}
            </>
        )
    }
    return (
        <LogIn />
    )
}

