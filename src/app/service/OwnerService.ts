import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Owner } from '../model/Owner';

@Injectable({
    providedIn: 'root'
})
export class OwnerService {

  baseUrl = 'http://localhost:8080/Owner/';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Response> {
    return this.http.get<Response>(this.baseUrl + 'findAll');
  }

  insert(owner: Owner) : Observable<any> {
    return this.http.post(this.baseUrl + 'insert', owner);
  }

  update(owner: Owner) : Observable<any> {
    return this.http.put(this.baseUrl + 'putOwner', owner);
  }

  delete(id: any) : Observable<any> {
    return this.http.delete(this.baseUrl + 'delete?id=' + id);
  }

}
