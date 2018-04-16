import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import './index.css';

import { createStore, combineReducers } from 'redux';
import { Provider } from 'react-redux';

const reducerPeticion = (state = false, action) => {
    var nuevoEstado = Object.assign({}, state);
    if (action.type === "GUARDAR_ELEMENTOS") {
        nuevoEstado = action.value;
        return nuevoEstado;
    }
    return state;
}

const reducerRespuesta = (state = false, action) => {
    var nuevoEstado = Object.assign({}, state);
    if (action.type === "GUARDAR_RESPUESTA") {
        nuevoEstado = action.value;
        return nuevoEstado;
    }
    return state;
}

const reducer = combineReducers({
    peticion: reducerPeticion,
    respuesta: reducerRespuesta,
});

const store = createStore(reducer);
ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>
    , document.getElementById('root'));
registerServiceWorker();
