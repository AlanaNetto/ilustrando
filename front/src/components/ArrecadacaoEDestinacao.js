import React from 'react'
import {
    Row,
    Col,
    Navbar,
}
from 'react-bootstrap'

import Arrecadacao from './Arrecadacao'
import Destinacao from './Destinacao'

export default class ArrecadacaoEDestinacao extends React.Component {
    render(){
        return (
            <div style={{height:'100%'}}>
                <Navbar fluid className='header-subpanel'>
    				<Navbar.Text className='title'>
    				    arrecadação e destinação de verba
    				</Navbar.Text>
    			</Navbar>
                <Row style={{margin:'0px',padding:'20px',height:'calc(100% - 55px)'}}>
                    <Col sm={6} style={{height:'100%'}}>
                        <Arrecadacao {...this.props}/>
                    </Col>
                    <Col sm={6} style={{height:'100%'}}>
                        <Destinacao {...this.props}/>
                    </Col>
                </Row>
            </div>
        )        
    }
}