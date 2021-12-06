import React, { useState, useEffect }from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container,Paper,Button } from '@mui/material';
import Axios from 'axios';


export default function Duenio() {
    const paperStyle={padding:'50px 20px ', width:600,margin: "20px auto"}
    const [nombreDuenio, setnombre_duenio] = useState('');
    const [numTelefono, setnum_telefono] = useState('');
    const [direccion, setdireccion] = useState('');
    const [cantMascotas, setcant_mascota] = useState('');
    const [duenios, setduenios] = useState([]);
    const [numNew,setNumNew]=useState('');
    const [direcNew,setDirecNew]=useState('');


    const deleteUsuario=obj=>{
        console.log(obj);
        Axios.delete(`http://localhost:8080/duenio/del/${obj}`);
    }
    
    const updateNum=(id,nombre,direc,cant)=>{
        Axios.put("http://localhost:8080/duenio/updateNum",{
          idDuenio:id,
          nombreDuenio:nombre,
          cantMascotas:cant,
          direccion:direc,
          numTelefono:numNew
        });
    }
    const updateDirec=(id,nombre,num,cant)=>{
        Axios.put("http://localhost:8080/duenio/updateDirec",{
          idDuenio:id,
          nombreDuenio:nombre,
          numTelefono:num,
          cantMascotas:cant,
          direccion:direcNew
        });
    }
    

  useEffect(() => {
      fetch('http://localhost:8080/duenio/getAll')
      .then(res=>res.json())
      .then((result)=>{
          setduenios(result);
      })
  }, [])
    //Fucnión cuando agregen datos al formulario
    const handleClick=(e)=>{
        e.preventDefault();

        const duenio={nombreDuenio,numTelefono,direccion,cantMascotas}
        console.log(duenio);
        fetch("http://localhost:8080/duenio/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(duenio)
        }).then(()=>{
            console.log("Dueño agregado");
        });
    }

    useEffect(() => {
        fetch('http://localhost:8080/duenio/getAll')
        .then(res=>res.json())
        .then((result)=>{
            setduenios(result);
        })
    }, [])

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}} > Agregar un Dueño </h1>
        <Box
        component="form"
        sx={{
            '& > :not(style)': { m: 1},
        }}
        noValidate
        autoComplete="off"
        >
        <TextField id="standard-basic" label="Nombre" variant="standard" fullWidth required value={nombreDuenio} onChange={(e)=>setnombre_duenio(e.target.value)} />
        <TextField id="standard-basic" label="Numero" variant="standard" fullWidth required value={numTelefono} onChange={(e)=>setnum_telefono(e.target.value)}/>
        <TextField id="standard-basic" label="Cant Mascotas" variant="standard" fullWidth value={cantMascotas} onChange={(e)=>setcant_mascota(e.target.value)} />
        <TextField id="standard-basic" label="Dirección" variant="standard" fullWidth value={direccion} onChange={(e)=>setdireccion(e.target.value)}/>
        
        <Button variant="contained" onClick={handleClick}>
        Enviar 
        </Button>
        
        
        


        </Box>
        </Paper>
        
        <Paper elevation={3} style={paperStyle}>
            {duenios.map(duenio=>(
                <Paper elevation={6} style={{margin:"10px",padding:"15 px",textAlign:"center"} } key={duenio.id}>
                    id:{duenio.idDuenio}<br/>
                    Nombre: {duenio.nombreDuenio}<br/>
                    telefono: {duenio.numTelefono}<br/>
                    Direccion: {duenio.direccion}<br/>
                    Cant Mascotas: {duenio.cantMascotas}<br/>
                    
                    <input placeholder="Nuevo numero" type="text" onChange={(e)=>{setNumNew(e.target.value)}} />
                    <button onClick={()=>{updateNum(duenio.idDuenio,duenio.nombreDuenio,duenio.direccion,duenio.cantMascotas)}} >Update</button>
                    <Button variant="contained" color="error" onClick={()=>{deleteUsuario(duenio.idDuenio)}} >Borrar</Button>
                    <input placeholder="Nueva Dirección" type="text" onChange={(e)=>{setDirecNew(e.target.value)}} />
                    <button onClick={()=>{updateDirec(duenio.idDuenio,duenio.nombreDuenio,duenio.numTelefono,duenio.cantMascotas)}} >Update</button>

                </Paper>
            ))}


        </Paper>


    </Container>
  );
}
