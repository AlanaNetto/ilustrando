import React from 'react'
import {
    Form,
    FormControl,
    Button,
}
from 'react-bootstrap'
export default class Destinacao extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            valor: 0,
            item: '',
            data: '',
            itens: [],
            destinacoes: []
        }
        this.addDestinacao = this.addDestinacao.bind(this)
    }
    componentDidMount() {
        fetch(this.props.serverPath + 'api/items')
            .then(result => {
                result.json().then(json => this.setState({ itens: json }))
            })
        fetch(this.props.serverPath + 'api/fundassignment')
            .then(result => {
                result.json().then(json => this.setState({ destinacoes: json }))
            })
    }
    addDestinacao(e) {
        e.preventDefault()
        if (this.state.valor < 1 || this.state.data.trim().length < 1 || this.state.item.length < 1)
            return;
        fetch(this.props.serverPath + 'api/fundassignment', {
                method: 'post',
                headers: {
                    'accept': '*/*',
                    'content-type': 'application/x-www-form-urlencoded'
                },
                body: "fundassignmentValue=" + this.state.valor +
                    "&itemName=" + this.state.item +
                    "&fundassignmentDate=" + this.state.data
            })
            .then(result => {
                result.json().then(json => this.setState({ destinacoes: json, valor: 0, data: '', item: '' }))
            })
    }
    render() {
        return (
            <div style={{height:'100%'}} className='info-block'>
                <h3 className='title'>Destinação</h3>
                <div style={{padding:'10px'}}>
                    <Form inline onSubmit={this.addDestinacao} className='text-center'>
                        <FormControl style={{width:'130px'}} type="number" placeholder="Digite o valor" value={this.state.valor} onChange={(e)=>{this.setState({valor:e.target.value})}}/>
                        {' '}
                        <FormControl style={{width:'135px'}} placeholder="Digite o mes/ano" value={this.state.data} onChange={(e)=>{this.setState({data:e.target.value})}}/>
                        {' '}
                        <select className='form-control' value={this.state.item} onChange={(e)=>{this.setState({item:e.target.value})}}>
                            <option defaultValue value=''>Selecione</option>
                            {
                                this.state.itens.map((item)=>{
                                    return <option value={item.nome} key={item.nome}>{item.nome}</option>
                                })
                            }
                        </select>
                        {' '}
                        <Button type="submit">Adicionar</Button>
                    </Form>
                    <div style={{paddingTop:'10px'}}>
                        {
                            this.state.destinacoes.map((destinacao,i)=>{
                                return <div key={'destinacao-'+i}>- {destinacao.valor + ' - ' + destinacao.itemName + ' ('+destinacao.data+')'}</div>
                            })
                        }
                    </div>
                </div>
            </div>
        )
    }
}
