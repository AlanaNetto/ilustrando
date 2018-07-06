import React from 'react'
import {
    Navbar,
    Nav,
    Row,
    Col
}
from 'react-bootstrap'

export default class Index extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            panelData: {
                totalByMonth: [],
            },
            arrecadacoes: [],
            destinacoes: [],
            monthSelected: {}
        }
        this.getDetails = this.getDetails.bind(this)
    }
    componentDidMount() {
        fetch(this.props.serverPath + 'api/panel')
            .then(result => {
                result.json().then(json => this.setState({ panelData: json }))
            })
    }
    getDetails(data) {
        this.setState({ monthSelected: data })
        fetch(this.props.serverPath + 'api/fundraise?fundraiseDate=' + data.month)
            .then(result => {
                result.json().then(json => this.setState({ arrecadacoes: json }))
            })
        fetch(this.props.serverPath + 'api/fundassignment?fundassignmentDate=' + data.month)
            .then(result => {
                result.json().then(json => this.setState({ destinacoes: json }))
            })
    }

    formatMonth(date) {
        if (!date) return ''
        var temp = date.split('/');
        if (temp.length < 2)
            return date;
        var shortMonth = ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dec']
        return shortMonth[temp[0] - 1] + '/' + temp[1]
    }

    render() {
        return (
            <div style={{height:'100%'}}>
                <Navbar fluid className='header-subpanel'>
    				<Navbar.Text className='title'>
    				    home
    				</Navbar.Text>
    				
    				<Nav pullRight>
    				    <div className='info-money'>
    				        <Row>
    				            <Col sm={12}>Arrecadação Total: <label className='money-in'>R$: {this.state.panelData.totalRaise}</label></Col>
    				        </Row>
    				        <Row>
    				            <Col sm={12}>Total de Saídas: <label className='money-out'>- R$: {this.state.panelData.totalAssignments}</label></Col>
    				        </Row>
    				    </div>
                    </Nav>
    			</Navbar>
    			<div style={{padding:'20px',height:'calc(100% - 55px)'}}>
        			<Row style={{maxHeight:'100px'}}>
        			    {
        			        this.state.panelData.totalByMonth.map((data)=>{
            			        return(
            			            <Col sm={2} className={'month-info ' + (this.state.monthSelected.month === data.month ? 'selected':'')} onClick={()=>{this.getDetails(data)}}>
            			                <div>{this.formatMonth(data.month)}</div>
            			                <div className='money-in'>R$: {data.totalRaise}</div>
            			                <div className='money-out'>-R$: {data.totalAssignments}</div>
            			            </Col>
        			            )
        			        })
        			    }
        			</Row>
        			<Row style={{height:'calc(100% - 100px)'}}>
        			    <Col className='detailed-month-info' sm={6}>
        			        <h3 className='title in'>
        			            Arrecadação {this.formatMonth(this.state.monthSelected.month)}
        			        </h3>
        			        <div className='infos in'>
        			            <div className='details'>
                			        {
                			            this.state.arrecadacoes.map((arrecadacao)=>{
                			                return <div>R$: {arrecadacao.valor} | {arrecadacao.receiptName}</div>
                			            })
                			        }
            			        </div>
        			            <div className='total money-in'>R$: {this.state.monthSelected.totalRaise || ''}</div>
        			        </div>
        			    </Col>
        			    <Col className='detailed-month-info' sm={6}>
    			            <h3 className='title out'>
        			            Destinação {this.formatMonth(this.state.monthSelected.month)}
        			        </h3>
        			        <div className='infos out'>
        			            <div className='details'>
            			            {
                			            this.state.destinacoes.map((destinacao)=>{
                			                return <div>R$: {destinacao.valor} | {destinacao.itemName}</div>
                			            })
                			        }
            			        </div>
        			            <div className='total money-out'>R$: {this.state.monthSelected.totalAssignments || ''}</div>
        			        </div>
        			    </Col>
        			</Row>
    			</div>
            </div>
        )
    }
}
