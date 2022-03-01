import { Component, OnInit } from '@angular/core';
import { Model } from 'src/app/model/Model';
import { ModelService } from 'src/app/service/ModelService';

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

  constructor(private modelService: ModelService) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(prd: any): void {
    this.modelService.delete(prd.id).subscribe();
    this.populateTable();
  }

  populateTable(): void {
    this.modelService.findAll().subscribe((data: any) => {
      if ( data && data.status == 200 ) {
        this.models  = data.entity ? data.entity : [];
      }
    });
  }
}
