import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CarOwner } from '../model/CarOwner';

@Injectable({
  providedIn: 'root'
})
export class CarOwnerService {

  baseUrl = 'http://localhost:8080/Service/';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Response> {
    return this.http.get<Response>(this.baseUrl + 'findAllCarOwner');
  }

  insert(carOwner: CarOwner) : Observable<Response> {
    return this.http.post<Response>(this.baseUrl + 'buyCar', carOwner);
  }

  delete(id: any) : Observable<Response> {
    return this.http.delete<Response>(this.baseUrl + 'delete?id=' + id);
  }
}
