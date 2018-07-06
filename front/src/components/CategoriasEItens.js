import React from 'react'
import {
    Row,
    Col,
    Navbar,
}
from 'react-bootstrap'
import Categorias from './Categorias'
import Itens from './Itens'

export default class CategoriasEItens extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            categorias: [],
            itens: []
        }
        this.addCategory = this.addCategory.bind(this)
        this.addItem = this.addItem.bind(this)
    }
    componentDidMount() {
        fetch(this.props.serverPath + 'api/category')
            .then(result => {
                result.json().then(json => this.setState({ categorias: json }))
            })

        fetch(this.props.serverPath + 'api/items')
            .then(result => {
                result.json().then(json => this.setState({ itens: json }))
            })

    }

    addCategory(nome) {
        if (nome.trim().length < 1)
            return;

        fetch(this.props.serverPath + 'api/category', {
                method: 'post',
                headers: {
                    'accept': '*/*',
                    'content-type': 'application/x-www-form-urlencoded'
                },
                body: "categoryName=" + nome
            })
            .then(result => {
                result.json().then(json => this.setState({ categorias: json }))
            })
    }

    addItem(nome, category) {
        if (nome.trim().length < 1 || category.trim().length < 1)
            return;

        fetch(this.props.serverPath + 'api/items', {
                method: 'post',
                headers: {
                    'accept': '*/*',
                    'content-type': 'application/x-www-form-urlencoded'
                },
                body: "itemName=" + nome + "&categoryName=" + category
            })
            .then(result => {
                result.json().then(json => this.setState({ itens: json }))
            })
    }

    render() {
        return (
            <div style={{height:'100%'}}>
                <Navbar fluid className='header-subpanel'>
    				<Navbar.Text className='title'>
    				    categorias e itens
    				</Navbar.Text>
    			</Navbar>
                <Row style={{margin:'0px',padding:'20px',height:'calc(100% - 55px)'}}>
                    <Col sm={6} style={{height:'100%'}}>
                        <Categorias addCategory={this.addCategory} categorias={this.state.categorias}/>
                    </Col>
                    <Col sm={6} style={{height:'100%'}}>
                        <Itens addItem={this.addItem} itens={this.state.itens} categorias={this.state.categorias}/>
                    </Col>
                </Row>
            </div>
        );
    }
}
