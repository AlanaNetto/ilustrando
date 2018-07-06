import React from 'react';
// import { Button } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap';

export default class Menu extends React.Component {
	render() {
		var itens = []
		if (this.props.user) {
			itens = [
				<LinkContainer key='arecadacao' to="/arecadacao">
					<div className='menu-item'>Arrecadação e Destinação</div>
				</LinkContainer>,
				<LinkContainer key='categorias' to="/categorias">
					<div className='menu-item'>Categorias e Itens</div>
				</LinkContainer>,
				<LinkContainer key='receitas' to="/receitas">
					<div className='menu-item'>Fonte de Receitas</div>
				</LinkContainer>
			]
		}
		else {
			itens = []
		}

		return (
			<div>
				<div className='menu-item' onClick={this.props.user? this.props.logoutUser:this.props.loginUser}>{this.props.user ? 'Log Out':'Log In'}</div>
				<LinkContainer exact to="/">
					<div className='menu-item'>Home</div>
				</LinkContainer>
				{itens}
			</div>
		);
	}
}
