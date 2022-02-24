import { Component, OnInit } from '@angular/core';
import { Model } from 'src/app/model/Model';
import { CarService } from 'src/app/service/CarService';

@Component({
  selector: 'app-model-table',
  templateUrl: './model-table.component.html',
  styleUrls: ['./model-table.component.css']
})
export class ModelTableComponent implements OnInit {

  page = 1;
  pageSize = 15;
  collectionSize = 1000;
  
  models: Array<Model> = [];

  constructor(private carService: CarService) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(prd: any): void {
    this.carService.deleteModel(prd.id);
  }

  populateTable(): void {
    this.carService.findAllModel().subscribe(resp => {
      this.models = resp;
    });
  }
}
