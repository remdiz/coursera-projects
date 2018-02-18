function TextInput(props) {
    
    return(
            <div className="form-group">
                <label>
                    {props.title}
                    <input className="form-control" onChange={props.handleChange} value={props.value} name={props.name} type="text"/>        
                </label>
            </div>
    );
    
}

function SelectInput(props) {
    var options = props.options.map((item) =>
                <option value = {item}>{item}</option>
            );
       
        return(
                <div className="form-group">
                    <label>
                        {props.title} 
                        <select className="form-control"  name="activity" value={props.value} onChange={props.handleChange}>
                            {options}
                        </select>
                    </label>
                </div>
        );
}

function Checkbox(props) {
        return (
                <div className="form-check">
                    <label className="form-check-label">
                        <input className="form-check-input" type = "checkbox" checked = {props.checked} onChange={props.handleChange} name={props.name}/>
                            {props.title}
                    </label>
                </div>

        );
}

function SubmitButton(props) {
    return(
                <div className="form-group">
                    <button className="btn btn-primary" type="button" onClick={props.handleSubmit}>{props.title}</button>
                </div>
                
    );
}

function Registered(props) {
    var rows = props.list.map((row, idx) => {
        return(
                <tr>
                    <td>
                        <button className="btn btn-danger btn-sm" id={idx} onClick={props.handleDelete}>
                            X
                        </button>
                    </td>
                    <td>
                        {row.firstName}
                    </td>
                    <td>
                        {row.lastName}
                    </td>
                    <td>
                        {row.activity}
                    </td>
                    <td>
                        {row.restrictions}
                    </td>
                </tr>
        );
    });
    return(
            <div>
                <table className="table">
                    <thead className="thead-dark">
                        <tr>
                            <th scope="col">
                                Remove
                            </th>
                            <th scope="col">
                                First Name
                            </th>
                            <th scope="col">
                                Last Name
                            </th>
                            <th scope="col">
                                Activity
                            </th>
                            <th scope="col">
                                Restrictions
                            </th>
                        </tr>
                    </thead>                
                    <tbody>
                        {rows}
                    </tbody>    
                </table>
            </div>
    );
}

class CourseRegistration extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {
                fName: "",
                lName: "",
                activity: "Science Lab",
                checkboxA: false,
                checkboxB: false,
                checkboxC: false,
                registered: []
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
    }
    
    handleDelete(event) {
        var tableRows = this.state.registered.slice();
        tableRows.splice(event.target.id, 1);
        this.setState({registered: tableRows});
    }
    
    handleSubmit(event) {
        this.register();
        this.setState({
                fName: "",
                lName: "",
                activity: "Science Lab",
                checkboxA: false,
                checkboxB: false,
                checkboxC: false
            });
    }
    
    register() {
        var tableRows = this.state.registered.slice();
        var restrictions = '';
        restrictions += this.state.checkboxA ? 'a' : '';
        restrictions += this.state.checkboxB ? 'b' : '';
        restrictions += this.state.checkboxC ? 'c' : '';
        var row = {firstName: this.state.fName, lastName: this.state.lName, activity: this.state.activity, restrictions: restrictions};
        tableRows.push(row);
        this.setState({registered: tableRows});
    }
    
    handleChange(event){
        this.setState({[event.target.name]: event.target.type === "checkbox" ? event.target.checked : event.target.value});
    }
    
    render() {
        var options = ["Science Lab", "Swimming", "Cooking", "Painting"];
        return(
                <div>
                    <TextInput name="fName" title="First Name" value={this.state.fName} handleChange = {this.handleChange}/>
                    <TextInput name="lName" title="Last Name" value={this.state.lName} handleChange = {this.handleChange}/>
                    <SelectInput title="Select activity" options={options} value={this.state.activity} handleChange = {this.handleChange}/>
                    <fieldset className="form-group">
                        <label>
                            Check all that apply:
                            <Checkbox checked={this.state.checkboxA} name="checkboxA" title="a) Dietary Restrictions" handleChange = {this.handleChange}/>
                            <Checkbox checked={this.state.checkboxB} name="checkboxB" title="b) Physical Disabilities" handleChange = {this.handleChange}/>
                            <Checkbox checked={this.state.checkboxC} name="checkboxC" title="c) Medical Needs" handleChange = {this.handleChange}/>
                        </label>    
                    </fieldset>
                    
                    <SubmitButton title="Submit" handleSubmit = {this.handleSubmit}/>
                    <Registered list={this.state.registered} handleDelete = {this.handleDelete}/>        
                </div>
        );
    }
    
}

ReactDOM.render(
        <CourseRegistration/>,
    document.getElementById("root")
);



