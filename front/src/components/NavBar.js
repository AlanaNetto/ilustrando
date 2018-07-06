import React from 'react'
import {
	Navbar,
	Image
}
from 'react-bootstrap'

export default class MyNav extends React.Component {
	render() {
		return (
			<Navbar fluid>
				<Navbar.Header>
					<Navbar.Brand>
						<Image src="/images/logo.jpg" />
					</Navbar.Brand>
				</Navbar.Header>
			</Navbar>
		);
	}
}
