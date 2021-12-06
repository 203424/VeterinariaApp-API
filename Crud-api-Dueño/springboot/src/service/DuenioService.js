import axios from 'axios';

export class DuenioServer{

    baseUrl= "htttp://localhost:8080/api/v1/"
    getAll(){
        return axios.get(this.baseUrl+'all').then(res=>res.data.data);
    }


}