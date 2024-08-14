import React, {useState, useEffect, useRef} from 'react';
import { flushSync} from 'react-dom'
import useTitle from './useTitle'
function Counter(props) {

    const [counter, setCounter] = useState(0);
    const [count2, setCount2] = useState(0);
    const inputRef = useRef(null);
   useTitle(`You clicked ${counter} times`)

    useEffect(() => {
        console.log('Hello from useEffect!')
        return() => {
            console.log("Clean up function")
        }
    })

    const incerement = () => {
        flushSync(() => {
            setCounter(counter + 1);
        })

        setCount2(count2 + 1);
    }
    return (
        <div>
         
            <input ref={inputRef} />
            <button onClick={() => inputRef.current.focus()}>
                Focus input
            </button>
            <p>Counter = {counter} Count2 = {count2}</p>
            <button onClick={incerement}>
                Incerement
            </button>
        </div>
    );
}

export default Counter;