import React from 'react'
import {
    Form,
    FormControl,
    Button,
}
from 'react-bootstrap'

export default class Categorias extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            categoria: ''
        }
        this.addCategory = this.addCategory.bind(this)
    }

    addCategory(e) {
        e.preventDefault()
        this.props.addCategory(this.state.categoria);
        this.setState({ categoria: '' })
    }

    render() {
        return (
            <div style={{height:'100%'}} className='info-block'>
                <h3 className='title'>Categorias</h3>
    			<div style={{padding:'10px'}}>
                    <Form inline onSubmit={this.addCategory} className='text-center'>
                        <FormControl placeholder="Digite a categoria" value={this.state.categoria} onChange={(e)=>{this.setState({categoria:e.target.value})}}/>
                        {' '}
                        <Button type="submit">Adicionar</Button>
                    </Form>
                    <div>
                        <div>
                            {
                                this.props.categorias.map((categoria,i)=>{
                                    return <div key={'categoria-'+i}>{' - ' + categoria.nome}</div>
                                })
                            }
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

                // <div>
                //     <input value={this.state.categoria} onChange={(e)=>{this.setState({categoria:e.target.value})}}/>
                //     <button onClick={this.addCategory}>ADD</button>
                // </div>
                // <div>
                //     {
                //         this.props.categorias.map((categoria,i)=>{
                //             return <div key={'categoria-'+i}>{categoria.nome}</div>
                //         })
                //     }
                // </div>