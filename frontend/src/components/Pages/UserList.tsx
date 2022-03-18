import {Link, useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";

const UserList = (props:any) =>  {
    const location = useLocation();
    const [users, setUsers] = useState([{
        id: props.user ? props.user.id : '',
        firstname: props.user ? props.user.firstname : '',
        lastname: props.user ? props.user.lastname : '',
        email: props.user ? props.user.email : ''
    },])
    const [error, setError] = useState(null)
    const [fetched, setFetched] = useState(false);

    const fetchUsers = () => {
        fetch("http://localhost:8080/user")
            .then(res => res.json())
            .then(users => setUsers(users))
            .catch(e => setError(e))
            .finally(() => setFetched(true))
    };

    useEffect(() => {
        fetchUsers()
    }, [location])

    if(!fetched){
            return <p>Loading...</p>
        }
    if (error){
        return <div>Error: {error}</div>;
    }else{
        return (
            <Container>
                <Table className="infocard  rounded-3">
                    <thead>
                        <tr>
                            <th scope="col"><h4>Name</h4></th>
                            <th scope="col"><h4>E-mail</h4></th>
                        </tr>
                    </thead>
                    <tbody>
                    {users
                        .map(user => (
                        <tr key={user.id}>
                            <td>{user.firstname} {user.lastname} </td>
                            <td>{user.email}</td>
                            <td>
                                <Link to={`/user/details/${user.id}`}>
                                    <Button className="btn btn-warning">Details</Button>
                                </Link>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </Table>
            </Container>
        )
    }
}
export default UserList;