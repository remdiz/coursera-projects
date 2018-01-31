

function QuestionBlock(props) {
    
    return (
            <div className = 'list-group-item list-group-item-info'>
                <h5>
                    What is {props.firstNum} X {props.secondNum}
                </h5>
            </div>
            );
    
}

function QButton(props) {
    
    return (
            <div>
                <button onClick = {() => props.handleClick(props.title)} className = 'btn btn-primary'>
                    {props.title}
                </button>
            </div>
    );
    
}

function ButtonsBlock(props) {
    
    var buttons = [];
    for(let idx = 0; idx < 4; idx++) {
        buttons.push(<QButton title = {props.items[idx]} handleClick = {props.handleClick}/>);
    }
    
    return (
            <div className = 'list-group-item'>
                {buttons}
            </div>
    );
    
}

function AnswersBlock(props) {
    
    return (
            <div className = 'list-group-item'>
                <h5>
                    Correct: <span className = 'correct badge badge-success badge-pill'>{props.correct}</span> Incorrect: <span className = 'badge badge-danger badge-pill'>{props.incorrect}</span>
                </h5>
            </div>
    );
    
}

class QuestionsApp extends React.Component {
    
    constructor(props) {
        super(props);
        var questions = [
            {first: 2, second: 3, variants:[4, 5, 6, 7], answer: 6},
            {first: 1, second: 7, variants:[6, 7, 8, 9], answer: 7},
            {first: 6, second: 4, variants:[23, 24, 25, 26], answer: 24},
            {first: 3, second: 2, variants:[5, 6, 7, 8], answer: 6},
            {first: 9, second: 4, variants:[35, 36, 37, 38], answer: 36}
        ];
        this.state = {
            questions: questions,
            current: 0,
            correct: 0,
            incorrect: 0
        };
        this.handleClick = this.handleClick.bind(this);
    }
    
    handleClick(num) {
        console.log("clicked: ", num);
        var currentQuestion = this.state.questions[this.state.current];
        if(num === currentQuestion.answer) {
            this.state.correct++;
        } else {
            this.state.incorrect++;
        }
        var current = this.state.current === (this.state.questions.length - 1) ? 0 : this.state.current + 1;
        this.setState({current: current});
    }
    
    render() {
        
            var currentQuestion = this.state.questions[this.state.current];
            return (
                <div className = 'list-group'>
                    <QuestionBlock firstNum = {currentQuestion.first} secondNum = {currentQuestion.second}/>
                    <ButtonsBlock items = {currentQuestion.variants} handleClick = {this.handleClick}/>
                    <AnswersBlock correct = {this.state.correct} incorrect = {this.state.incorrect}/>
                </div>
            );
        
    }
    
}


ReactDOM.render(
        <QuestionsApp/>,
    document.getElementById("root")
);


