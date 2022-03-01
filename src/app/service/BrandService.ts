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
  
  findAll(): Observable<Array<Brand>> {
    return this.http.get<Array<Brand>>(this.baseUrl + 'findAll');
  }

  insert(brand: Brand) {
    this.http.post(this.baseUrl + 'insert', brand);
  }
  
  update(brand: Brand) {
    this.http.put(this.baseUrl + 'put', brand);
  }
  
  delete(id: any) {
    this.http.delete(this.baseUrl + 'delete?id=' + id);
  }
  
}
