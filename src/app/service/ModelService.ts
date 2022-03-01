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

    findAll(): Observable<Array<Model>> {
        return this.http.get<Array<Model>>(this.baseUrl + 'findAll');
    }

    insert(model: Model) {
      this.http.post(this.baseUrl + 'insert', model);
    }

    update(model: Model) {
        this.http.put(this.baseUrl + 'put', model);
    }

    delete(id: any) {
        this.http.delete(this.baseUrl + 'delete?id=' + id);
    }

}
