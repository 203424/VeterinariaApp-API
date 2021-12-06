import React, { Component } from 'react';
import './App.css';
import { PersonaService } from './service/PersonaService';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Panel } from 'primereact/panel';
import { Menubar } from 'primereact/menubar';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import ReactDOM from 'react-dom';
import App2 from './App2';

import 'primereact/resources/themes/nova/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

export default class App extends Component {
  constructor() {
    super();
    this.state = {
        visible: false,
        persona:{
          id:0,
          idDuenio:0,
          idTipoMascota:'',
          nombre:'',
          fechaIngreso:'',
          motivoIngreso:''
        },
        selectedPersona: {

        }
      }
    
    this.items = [
      {
        label : 'Nuevo',
        icon : 'pi pi-fw pi-plus',
        command : () => {this.showSaveDialog()}
      },
      {
        label : 'Editar',
        icon : 'pi pi-fw pi-pencil',
        command : () => {this.showEditDialog()}
      },
      {
        label : 'Eliminar',
        icon : 'pi pi-fw pi-trash',
        command : () => {this.delete()}
      }
    ];
    
    this.personaService = new PersonaService();
    this.save = this.save.bind(this);
    this.delete = this.delete.bind(this);
    this.footer = (
      <div>
        <Button label="Guardar" icon = "pi pi-check" onClick={this.save} />
      </div>
    )
    
  }

  componentDidMount() {
    this.personaService.getAll().then(data => this.setState({ personas: data }));
    this.setState({
      visible:false,
    });
  }

  save(){
    this.personaService.save(this.state.persona).then(data => {
      this.setState({
        visible: false,
        persona:{
          id:null,
          idDuenio:null,
          idTipoMascota:null,
          nombre:null,
          fechaIngreso:null,
          motivoIngreso:null
        }
      });
      this.personaService.getAll().then(data => this.setState({ personas: data }));
    })
  }

  delete() {
    if(window.confirm("¿Realmente desea eliminar el registro?")) {
      this.personaService.delete(this.state.selectedPersona.id).then(data => {
        this.personaService.getAll().then(data => this.setState({personas: data}));
      });
    }
  }

  render() {
    return (
      <div  style={{widht:'80%', marginTop: '20px', margin: '0 auto'}}>
        
        <Menubar model={this.items}/>
        <br/>
        <Panel header="Mascotas">
          
          <DataTable value ={this.state.personas} selectionMode="single" selection={this.state.selectedPersona} onSelectionChange={e => this.setState({ selectedPersona: e.value })}>
            <Column field="id" header="ID Mascota"></Column>
            <Column field="idDuenio" header="ID Dueño"></Column>
            <Column field="idTipoMascota" header="idTipoMascota"></Column>
            <Column field="nombre" header="Nombre"></Column>
            <Column field="fechaIngreso" header="Fecha de ingreso"></Column>
            <Column field="motivoIngreso" header="Motivo de ingreso"></Column>
          </DataTable>
        </Panel>
        <Dialog header="Crear Mascota" visible = {this.state.visible} style={{width:'400px'}} footer={this.footer} modal={true} onHide={() => this.setState({visible: false})}>
          <br/>
          <span className="p-float-label">
            <InputText style={{width:"100%"}} value={this.state.idDuenio} id="idDuenio" onChange={(e) => {
              let val=e.target.value;
              this.setState(prevState => {
                let persona = Object.assign({}, prevState.persona)
                persona.idDuenio = val;
              
                return {persona};
            })
          }
          }/>
            <label htmlFor="idDuenio">ID Dueño</label>
          </span>
          <br/>
          <span className="p-float-label">
            <InputText style={{width:"100%"}} value={this.state.idTipoMascota} id="idTipoMascota" onChange={(e) => {
              let val=e.target.value;
              this.setState(prevState => {
              let persona = Object.assign({}, prevState.persona)
              persona.idTipoMascota = val;
              
              return {persona};
          })}}/>
            <label htmlFor="idTipoMascota">ID Tipo mascota</label>
          </span>
          <br/>

          <span className="p-float-label">
            <InputText style={{width:"100%"}} value={this.state.nombre} id="nombre" onChange={(e) => {
              let val=e.target.value;
              this.setState(prevState => {
              let persona = Object.assign({}, prevState.persona)
              persona.nombre = val;
              
              return {persona};
          })}}/>
            <label htmlFor="nombre">Nombre</label>
          </span>
          <br/>

          <span className="p-float-label">
            <InputText style={{width:"100%"}} value={this.state.fechaIngreso} id="fechaIngreso" onChange={(e) => {
              let val=e.target.value;
              this.setState(prevState => {
              let persona = Object.assign({}, prevState.persona)
              persona.fechaIngreso = val;
              
              return {persona};
          })}}/>
            <label htmlFor="fechaIngreso">Fecha de ingreso</label>
          </span>
          <br/>

          <span className="p-float-label">
            <InputText style={{width:"100%"}} value={this.state.motivoIngreso} id="motivoIngreso" onChange={(e) => {
              let val=e.target.value;
              this.setState(prevState => {
              let persona = Object.assign({}, prevState.persona)
              persona.motivoIngreso = val;
              
              return {persona};
          })}}/>
            <label htmlFor="motivoIngreso">Motivo de ingreso</label>
          </span>
          <br/>
        </Dialog>
      </div>
      
    );
  }

  showSaveDialog() {
    this.setState({
      visible: true,
      persona:{
          id:null,
          idDuenio:null,
          idTipoMascota:null,
          nombre:null,
          fechaIngreso:null,
          motivoIngreso:null
      }
    });
  }
  showEditDialog() {
    this.setState({
      visible: true,
      persona:{
        id:this.state.selectedPersona.id,
        idDuenio:this.state.selectedPersona.idDuenio,
        idTipoMascota:this.state.selectedPersona.idTipoMascota,
        nombre:this.state.selectedPersona.nombre,
        fechaIngreso:this.state.selectedPersona.fechaIngreso,
        motivoIngreso:this.state.selectedPersona.motivoIngreso
      }
    })
  }
  cambiarPagina1(){
    ReactDOM.render(
      <React.StrictMode>
        <App2 />
      </React.StrictMode>,
      document.getElementById('root')
    );
  }
}