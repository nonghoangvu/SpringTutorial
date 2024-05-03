import axios from "axios";

export const getStudents = async () => {
    return await axios.get("http://localhost:8080/api/student")
}
export const addStudent = async (student) => {
    return await axios.post("http://localhost:8080/api/student", student)
}
export const deleteStudent = async (id) => {
    return await axios.delete(`http://localhost:8080/api/student/${id}`)
}
export const getStudent = async (id) => {
    return (await axios.get(`http://localhost:8080/api/student/${id}`)).data
}
export const updateStudent = async (data) => {
    return await axios.put("http://localhost:8080/api/student", data)
}