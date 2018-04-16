import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import { connect } from 'react-redux';

import Papa from 'papaparse';
import axios from 'axios';

class App extends Component {
  constructor(props) {
    super(props);
    this.onFormSubmit = this.onFormSubmit.bind(this)
    this.onChange = this.onChange.bind(this)
  }

  onChange(e) {
    const elementos = [];
    Papa.parse(e.target.files[0], {
      delimiter: "",	// auto-detect)
      step: (e) => {
        if (e.data > 0) {
          elementos.push(Number(e.data));
        }
      },
      complete: () => {
        let req = '';
        elementos.forEach(element => {
          req = req + ',' + element;
        });
        this.props.guardarElementos(req.substr(1));
      }
    });
  }

  onFormSubmit(e) {
    e.preventDefault() // Stop form submit
    this.props.calcularViajes(this.props.elementos);
  }

  render() {
    const result = [];
    this.props.respuesta && result.push(<div><h2>Resultado</h2></div>);
    this.props.respuesta && this.props.respuesta.map((r, i) =>
      result.push(
        <div>
          {'case #' + (i + 1) + ' = ' + r}
        </div>)
    )
    return (
      <div className="App">
        <h1>Mudanza S.A</h1>
        <form onSubmit={this.onFormSubmit}>
          Cedula
          <br />
          <input type="text" />
          <br />
          <br />
          Archivo a procesar
          <br />
          <input type="file" onChange={this.onChange} />
          <br />
          <br />
          <br />
          <button type="submit">Calcular viajes</button>
        </form>
        <br />
        {result}
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    elementos: state.peticion,
    respuesta: state.respuesta,
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    guardarElementos: (value) => { dispatch({ type: "GUARDAR_ELEMENTOS", value }) },
    calcularViajes: (req) => {
      axios.post('http://localhost:8080/calcularViajes', req)
        .then(function (response) {
          dispatch({ type: "GUARDAR_RESPUESTA", value: response.data });
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(App);
