import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Model } from '../model/Model';

@Injectable({
    providedIn: 'root'
})
export class ModelService {

    baseUrl = 'http://localhost:8080/Model/';

    constructor(private http: HttpClient) { }

    findAll(): Observable<Response> {
      return this.http.get<Response>(this.baseUrl + 'findAll');
    }

    insert(model: Model) : Observable<Response> {
      return this.http.post<Response>(this.baseUrl + 'insert', model);
    }

    update(model: Model) : Observable<Response> {
      return this.http.put<Response>(this.baseUrl + 'put', model);
    }

    delete(id: any) : Observable<Response> {
      return this.http.delete<Response>(this.baseUrl + 'delete?id=' + id);
    }

    checkIfHaveAssociationWithOwner(id: any) : Observable<any> {
      return this.http.get(this.baseUrl + 'checkIfHaveAssociationWithOwner?id=' + id);
    }

}
