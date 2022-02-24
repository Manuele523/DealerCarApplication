import { Component, Input, OnInit } from '@angular/core';
import { Brand } from 'src/app/model/Brand';
import { CarService } from 'src/app/service/CarService';

@Component({
  selector: 'app-brand-table',
  templateUrl: './brand-table.component.html',
  styleUrls: ['./brand-table.component.css']
})
export class BrandTableComponent implements OnInit {

  page = 1;
  pageSize = 15;
  
  brands: Array<Brand> = [];

  constructor(private carService: CarService) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(prd: any): void {
    this.carService.deleteBrand(prd.id);
  }

  populateTable(): void {
    this.carService.findAllBrand().subscribe(resp => {
      this.brands = resp;
    });
  }

}
