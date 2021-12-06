import axios from 'axios';

export class PersonaService {
    baseUrl="http://localhost:8080/api/mascota/";
    getAll(){
        return axios.get(this.baseUrl ).then(res => res.data);
    }

    save(persona){
      return axios.post(this.baseUrl, persona).then(res => res.data);
    }

    delete(id) {
        return axios.delete(this.baseUrl+id).then(res => res.data);
    }
}