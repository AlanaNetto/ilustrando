import React from 'react'
import {
    Form,
    Navbar,
    FormControl,
    Button,
}
from 'react-bootstrap'

export default class Receitas extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            receitas: [],
            receipt: ''
        }
        this.addReceipt = this.addReceipt.bind(this)
    }
    componentDidMount() {
        fetch(this.props.serverPath + 'api/receipts')
            .then(result => {
                result.json().then(json => this.setState({ receitas: json }))
            })
    }

    addReceipt(e) {
        e.preventDefault();
        if (this.state.receipt.trim().length < 1)
            return;

        fetch(this.props.serverPath + 'api/receipts', {
                method: 'post',
                headers: {
                    'accept': '*/*',
                    'content-type': 'application/x-www-form-urlencoded'
                },
                body: "receiptName=" + this.state.receipt
            })
            .then(result => {
                result.json().then(json => this.setState({ receitas: json, receipt: '' }))
            })

    }

    render() {
        return (
            <div style={{height:'100%'}}>
                <Navbar fluid className='header-subpanel'>
    				<Navbar.Text className='title'>
    				    fonte de receitas
    				</Navbar.Text>
    			</Navbar>
                <div style={{padding:'20px',height:'calc(100% - 55px)'}}>
                    <div style={{height:'100%'}} className='info-block'>
    			        <div style={{padding:'10px'}}>
                            <Form inline onSubmit={this.addReceipt}>
                                <FormControl placeholder="Digite o contribuinte" value={this.state.receipt} onChange={(e)=>{this.setState({receipt:e.target.value})}}/>
                                {' '}
                                <Button type="submit">Adicionar</Button>
                            </Form>
                            <div>
                                <div>
                                    {
                                        this.state.receitas.map((receita,i)=>{
                                            return <div>{' - ' + receita.nome}</div>
                                        })
                                    }
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
