import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brand } from '../model/Brand';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  baseUrl = 'http://localhost:8080/Brand/';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Response> {
    return this.http.get<Response>(this.baseUrl + 'findAll');
  }

  insert(brand: Brand) : Observable<any> {
    return this.http.post(this.baseUrl + 'insert', brand);
  }

  update(brand: Brand) : Observable<any> {
    return this.http.put(this.baseUrl + 'put', brand);
  }

  delete(id: any) : Observable<any> {
    return this.http.delete(this.baseUrl + 'delete?id=' + id);
  }

  checkIfHaveAssociationWithModel(id: any) : Observable<any> {
    return this.http.get(this.baseUrl + 'checkIfHaveAssociationWithModel?id=' + id);
  }

}
