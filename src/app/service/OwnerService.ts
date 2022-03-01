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

  findAll(): Observable<Array<Owner>> {
    return this.http.get<Array<Owner>>(this.baseUrl + 'findAll');
  }

  insert(owner: Owner) {
    this.http.post(this.baseUrl + 'insert', owner);
  }

  update(owner: Owner) {
    this.http.put(this.baseUrl + 'putOwner', owner);
  }

  delete(id: any) {
    this.http.delete(this.baseUrl + 'delete?id=' + id);
  }

}
