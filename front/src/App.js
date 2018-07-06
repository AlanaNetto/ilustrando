import React from 'react'
import { Route } from 'react-router-dom'
import './App.css'

import {
	Row,
	Col,
}
from 'react-bootstrap'

import NavBar from './components/NavBar'
import Menu from './components/Menu'
import Index from './components/Index'
import Receitas from './components/Receitas'
import CategoriasEItens from './components/CategoriasEItens'
import ArrecadacaoEDestinacao from './components/ArrecadacaoEDestinacao'

export default class App extends React.Component {
	constructor() {
		super();
		this.state = {
			user: null,
			serverPath: window.location.origin + ':8081/back/'
		}
		this.loginUser = this.loginUser.bind(this)
		this.logoutUser = this.logoutUser.bind(this)
	}

	loginUser() {
		console.log('login')
		this.setState({
			user: {
				name: 'Alana'
			}
		})
	}

	logoutUser() {
		console.log('logout')
		this.setState({
			user: null
		})
	}

	render() {
		return (
			<div className="App">
					<NavBar/>
					<Row>
						<Col sm={1} className='menu'>
							<Menu user={this.state.user} loginUser={this.loginUser} logoutUser={this.logoutUser}/>
						</Col>
						<Col sm={11} className='content'>
							<Route exact path='/' render={(props) => <Index {...props} serverPath={this.state.serverPath}/>}/>
							<Route path='/receitas' render={(props) => <Receitas {...props} serverPath={this.state.serverPath}/>}/>
							<Route path='/categorias' render={(props) => <CategoriasEItens {...props} serverPath={this.state.serverPath}/>}/>
							<Route path='/arecadacao' render={(props) => <ArrecadacaoEDestinacao {...props} serverPath={this.state.serverPath}/>}/>
						</Col>
					</Row>
				</div>

		);
	}
}
