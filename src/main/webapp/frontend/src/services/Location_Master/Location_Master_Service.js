import httpClient from '../http-common';

const getAllLocation = () =>{
    return httpClient.get('/getlocation');
}

const addLocation = (data) =>{
    return httpClient.post('/addloaction',data)
}

const getLocationByCode = loca_cd => {
    return httpClient.get(`/getlocation/${loca_cd}`)
}

const deleteLocationById = loca_cd  => {
    return httpClient.delete(`/deletelocation/${loca_cd}`)
}

const updateLocation = (data,loca_cd) => {
    return httpClient.put(`/updatelocation/${loca_cd}`, data)
}

export default {getAllLocation, addLocation, getLocationByCode, deleteLocationById, updateLocation}