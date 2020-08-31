import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  constructor(private http: HttpClient) { 

  }

  url = "http://localhost:8080/api/v1/location";
  getAllLocations(){
    //const headers = {'Access-Control-Allow-Origin': '*'};
    //return this.http.get("http://localhost:8080/api/v1/location", {headers: headers});
    return this.http.get(this.url);
  }
  
  addLocation(name, area, parent_location){
    return this.http.post(this.url, { name: name, area_m2: area, parentLoc: parent_location });
  }

  deleteLocation(id){
    let url = this.url + '/' + id;
    //const headers = {'Access-Control-Allow-Origin': '*'};
    //return this.http.delete(url, {headers: headers});
    return this.http.delete(url);
  }
  
  editLocation(id, name, area, parent_location){
    let url = this.url + '/' + id;
    return this.http.put(url, { name: name, area_m2: area, parentLoc: parent_location });
  }


}
