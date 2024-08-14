import React, { useState } from 'react';



function MyForm(props) {

    const [user, setUser] = useState({
        firstName: '',
        lastName: '',
        email: ''
    });

const handleEvent = (event) => {
    setUser({...user,[event.target.name]: event.target.value
    });
}

const handleSubmit = (event) => {
   
    alert(`You typed: ${user.firstName} ${user.lastName} ${user.email}`);
    console.log(`The input saved is: ${user.firstName} ${user.lastName} ${user.email}`);
    event.preventDefault();
}

    return (
        <div>
            <form onSubmit={handleSubmit}>
            <label>First name </label>
                <input type="text" name = "fristName" value={user.firstName} onChange={handleEvent} placeholder='FirstName' />
                <label>Last name </label>
                <input type="text" name = "lastName" value={user.lastName} onChange={handleEvent} placeholder='LastName' />
                <label>Email </label>
                <input type="text" name = "email" value={user.email} onChange={handleEvent} placeholder='Email' />
                <label>Submit</label>
                <button type="submit" value="submit">Submit</button>
            </form>
        </div>
    );
}

export default MyForm;