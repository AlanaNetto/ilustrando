import React from 'react'
import {
    Form,
    FormControl,
    Button,
}
from 'react-bootstrap'

export default class Itens extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            item: '',
            categoria: ''
        }
        this.addItem = this.addItem.bind(this)

    }
    addItem(e) {
        e.preventDefault();
        this.props.addItem(this.state.item, this.state.categoria);
        this.setState({ item: '', categoria: '' })
    }

    render() {
        return (
            <div style={{height:'100%'}} className='info-block'>
                <h3 className='title'>Itens</h3>
    			<div style={{padding:'10px'}}>
                    <Form inline onSubmit={this.addItem} className='text-center'>
                        <FormControl placeholder="Digite o item" value={this.state.item} onChange={(e)=>{this.setState({item:e.target.value})}}/>
                        {' '}
                        <select className='form-control' value={this.state.categoria} onChange={(e)=>{this.setState({categoria:e.target.value})}}>
                            <option defaultValue value=''>Selecione</option>
                            {
                                this.props.categorias.map((categoria)=>{
                                    return <option value={categoria.nome} key={categoria.nome}>{categoria.nome}</option>
                                })
                            }
                        </select>
                        {' '}
                        <Button type="submit">Adicionar</Button>
                    </Form>
                    <div>
                        <div>
                            {
                                this.props.itens.map((item,i)=>{
                                    return <div key={'item-'+i}>- {item.nome}</div>
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
//                 <h1>Itens</h1>
//                 <div>
//                     <input value={this.state.item} onChange={(e)=>{this.setState({item:e.target.value})}}/>
//                     <select value={this.state.categoria} onChange={(e)=>{this.setState({categoria:e.target.value})}}>
//                         <option defaultValue value=''>Selecione</option>
//                         {
//                             this.props.categorias.map((categoria)=>{
//                                 return <option value={categoria.nome} key={categoria.nome}>{categoria.nome}</option>
//                             })
//                         }
//                     </select>
//                     <button onClick={this.addItem}>ADD</button>
//                 </div>
//                 <div>
//                     {
                        // this.props.itens.map((item,i)=>{
                        //     return <div key={'item-'+i}>{item.nome}</div>
                        // })
//                     }
//                 </div>
//             </div>