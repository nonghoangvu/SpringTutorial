export const Create = () => {
    return (
        <div>
            <h1 className="text-center text-uppercase text-secondary mb-3">New Student</h1>
            <form action="#" className="row">
                <div className="col-6">
                    <div className="form-floating mb-3">
                        <input type="text" className="form-control"/>
                        <label htmlFor="floatingInput">Full name</label>
                    </div>
                </div>
                <div className="col-6">
                    <div className="form-floating mb-3">
                        <input type="number" className="form-control"/>
                        <label htmlFor="floatingInput">Age</label>
                    </div>
                </div>
                <div className="col">
                    <div className="form-floating mb-3">
                        <div className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="gender" id="male"
                                   value="true"/>
                            <label className="form-check-label" htmlFor="male">Male</label>
                        </div>
                        <div className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="gender" id="female"
                                   value="false"/>
                            <label className="form-check-label" htmlFor="female">Female</label>
                        </div>
                    </div>
                </div>
                <button className="btn btn-outline-secondary">Save</button>
            </form>
        </div>
    )
}