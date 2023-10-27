import Home from './Home/Home';
import { Component } from 'react';
import './App.css';
import Description from './player/description';
import MoviePage from './MovieFolder/moviePage';
import Player from './player/player';
import LoginHome from './login/login-home';

class App extends Component {

 constructor(props) {
    super(props);
    this.state = { currentPage: "origin", apiResponse: "" }; 
 };

 handleChangeForm(Form) {
    this.setState({ currentPage: Form });
 }

 callAPI() {
    fetch("http://localhost:9000/testAPI")
        .then(res => res.text())
        .then(res => this.setState({ apiResponse: res }));
 };

 componentWillMount() {
      this.callAPI();
 };
  
 render() {
    return (

      <Home changeForm={this.handleChangeForm}/>

      /*<div className='original-container'>
        {this.state.currentPage === "origin" ? (
          <div className='origin'>
            <button className='home' onClick={() => this.handleChangeForm("home")}> Home </button>
            <button className='home' onClick={() => this.handleChangeForm("home2")}> Home2 </button>
            <button className='home' onClick={() => this.handleChangeForm("description")}> description </button>
            <button className='home' onClick={() => this.handleChangeForm("player")}> player </button>
            <button className='home' onClick={() => this.handleChangeForm("login")}> login </button>
            <p className="App-intro">{this.state.apiResponse}</p>
          </div>
        ) : this.state.currentPage === "home" ? (
          <Home changeForm={this.handleChangeForm}/>
        ) : this.state.currentPage === "home2" ? (
          <MoviePage changeForm={this.handleChangeForm}/>
        ) : this.state.currentPage === "description" ? (
          <Description changeForm={this.handleChangeForm} />
        ) : this.state.currentPage === "player" ? (
          <Player changeForm={this.handleChangeForm} filmName={"The Mechanic"} />
        ) : this.state.currentPage === "login" ? (
          <LoginHome changeForm={this.handleChangeForm} />
        ) : null}
      </div>*/
    );
 }
}

export default App;