import React from 'react'
import {
    Form,
    FormControl,
    Button,
}
from 'react-bootstrap'

export default class Arrecadacao extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            valor: 0,
            fonte: '',
            data: '',
            fontes: [],
            arrecadacoes: []
        }
        this.addFundraise = this.addFundraise.bind(this)
    }
    componentDidMount() {
        fetch(this.props.serverPath + 'api/receipts')
            .then(result => {
                result.json().then(json => this.setState({ fontes: json }))
            })
        fetch(this.props.serverPath + 'api/fundraise')
            .then(result => {
                result.json().then(json => this.setState({ arrecadacoes: json }))
            })
    }
    addFundraise(e) {
        e.preventDefault();
        if (this.state.valor < 1 || this.state.data.trim().length < 1 || this.state.fonte.length < 1)
            return;
        fetch(this.props.serverPath + 'api/fundraise', {
                method: 'post',
                headers: {
                    'accept': '*/*',
                    'content-type': 'application/x-www-form-urlencoded'
                },
                body: "fundraiseValue=" + this.state.valor +
                    "&receiptName=" + this.state.fonte +
                    "&fundraiseDate=" + this.state.data
            })
            .then(result => {
                result.json().then(json => this.setState({ arrecadacoes: json, valor: 0, data: '', fonte: '' }))
            })
    }
    render() {
        return (
            <div style={{height:'100%'}} className='info-block'>
                <h3 className='title'>Arrecadação</h3>
                <div style={{padding:'10px'}}>
                    <Form inline onSubmit={this.addFundraise} className='text-center'>
                        <FormControl style={{width:'130px'}} type="number" placeholder="Digite o valor" value={this.state.valor} onChange={(e)=>{this.setState({valor:e.target.value})}}/>
                        {' '}
                        <FormControl style={{width:'135px'}} placeholder="Digite o mes/ano" value={this.state.data} onChange={(e)=>{this.setState({data:e.target.value})}}/>
                        {' '}
                        <select className='form-control' value={this.state.fonte} onChange={(e)=>{this.setState({fonte:e.target.value})}}>
                            <option defaultValue value=''>Selecione</option>
                            {
                                this.state.fontes.map((fonte)=>{
                                    return <option value={fonte.nome} key={fonte.nome}>{fonte.nome}</option>
                                })
                            }
                        </select>
                        {' '}
                        <Button type="submit">Adicionar</Button>
                    </Form>
                    <div style={{paddingTop:'10px'}}>
                        {
                            this.state.arrecadacoes.map((arrecadacao,i)=>{
                                return <div key={'arrecadacao-'+i}>- {arrecadacao.valor + ' - ' + arrecadacao.receiptName + ' ('+arrecadacao.data+')'}</div>
                            })
                        }
                    </div>
                </div>
            </div>
        )
    }
}


// <div>
//                     <input type="number" value={this.state.valor} onChange={(e)=>{this.setState({valor:e.target.value})}}/>
//                     <input value={this.state.data} onChange={(e)=>{this.setState({data:e.target.value})}}/>
//                     <select value={this.state.fonte} onChange={(e)=>{this.setState({fonte:e.target.value})}}>
//                         <option defaultValue value=''>Selecione</option>
//                         {
//                             this.state.fontes.map((fonte)=>{
//                                 return <option value={fonte.nome} key={fonte.nome}>{fonte.nome}</option>
//                             })
//                         }
//                     </select>
//                     <button onClick={this.addFundraise}>ADD</button>
//                 </div>
