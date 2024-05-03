import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Navbar} from "./template/Navbar";
import {Home} from "./template/Home";
import {Student_Add} from "./template/Student_Add";
import {Student_Edit} from "./template/Student_Edit";

function App() {
    return (
        <BrowserRouter>
            <Navbar/>
            <div className="container">
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/add" element={<Student_Add/>}/>
                    <Route path="/edit/:id" element={<Student_Edit/>}/>
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
