import {useEffect, useState} from "react";
import {deleteStudent, getStudents} from "../service/Student_API";
import {Link} from "react-router-dom";

export const Home = () => {
    const [students, setStudents] = useState([])
    const loadStudents = async () => {
       const response = await getStudents()
        setStudents(response.data)
    }
    useEffect(() => {
        loadStudents()
    }, []);

    const handleDelete = async (id) => {
        await deleteStudent(id)
        loadStudents()
    }
    return (
        <div>
            <h1 className="text-center">Student Management</h1>
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">FullName</th>
                    <th scope="col">Age</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                {
                    students.map((item, index) => (
                        <tr key={index}>
                            <th scope="row">{index + 1}</th>
                            <td>{item.fullName}</td>
                            <td>{item.age}</td>
                            <td>{item.gender ? "Male" : "Female"}</td>
                            <td>
                                <button onClick={() => handleDelete(item.id)} className="btn btn-outline-danger">Delete</button>
                                <Link to={`/edit/${item.id}`} className="btn btn-outline-secondary m-2">Edit</Link>
                            </td>
                        </tr>
                    ))
                }

                </tbody>
            </table>
        </div>
    )
}