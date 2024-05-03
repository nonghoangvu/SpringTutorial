import {useForm} from "react-hook-form";
import {addStudent} from "../service/Student_API";
import {useNavigate} from "react-router-dom";
import swal from "sweetalert";

export const Student_Add = () => {
    const navigator = useNavigate()
    const {
        register,
        handleSubmit,
        formState: {errors},
    } = useForm()

    const handlePost = async (data) => {
        await addStudent(data)
        navigator("/")
        await swal("Success", "Student Added", "success")
    }
    return (
        <div>
            <h1 className="text-center">New Student</h1>
            <form onSubmit={handleSubmit(handlePost)}>
                {
                    (errors.fullName || errors.gender || errors.age) &&
                    <div className="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Warning!</strong> Please fill out the form below.
                        <button type="button" className="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                }
                <div className="row m-3">
                    <div className="form-floating mb-3 col-6">
                        <input type="text" className="form-control" {...register("fullName", {required: true})}/>
                        <label>Full name</label>
                    </div>
                    <div className="form-floating mb-3 col-6">
                        <input type="text" className="form-control" {...register("age", {required: true, min: 18})}/>
                        <label>Age</label>
                    </div>
                    <div className="form-floating mb-3">
                        <div className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="gender" id="male"
                                   value="true" {...register("gender", {required: true})}/>
                            <label className="form-check-label" htmlFor="male">Male</label>
                        </div>
                        <div className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="gender" id="female"
                                   value="false" {...register("gender", {required: true})}/>
                            <label className="form-check-label" htmlFor="female">Female</label>
                        </div>
                    </div>
                    <button className="btn btn-outline-secondary">Submit</button>
                </div>
            </form>
        </div>
    )
}