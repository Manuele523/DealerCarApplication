import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brand } from '../model/Brand';
import { Model } from '../model/Model';

@Injectable({
    providedIn: 'root'
})
export class CarService {

   baseUrl = 'http://localhost:8080/Car/';

   constructor(private http: HttpClient) {}

   findAllBrand(): Observable<Array<Brand>> {
      return this.http.get<Array<Brand>>(this.baseUrl + 'findAllBrand');
   }

   findAllModel(): Observable<Array<Model>> {
      return this.http.get<Array<Model>>(this.baseUrl + 'findAll');
   }
  
   deleteBrand(id: any) {
      this.http.delete(this.baseUrl + 'deleteBrand?id=' + id);
   }
   
   deleteModel(id: any) {
      this.http.delete(this.baseUrl + 'deleteModel?id=' + id);
   }

}