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

    insert(model: Model) : Observable<any> {
      return this.http.post(this.baseUrl + 'insert', model);
    }

    update(model: Model) : Observable<any> {
      return this.http.put(this.baseUrl + 'put', model);
    }

    delete(id: any) : Observable<any> {
      return this.http.delete(this.baseUrl + 'delete?id=' + id);
    }

}
