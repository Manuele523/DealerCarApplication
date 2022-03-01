import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Brand } from 'src/app/model/Brand';
import { BrandService } from 'src/app/service/BrandService';

@Component({
  selector: 'app-brand-table',
  templateUrl: './brand-table.component.html',
  styleUrls: ['./brand-table.component.css']
})
export class BrandTableComponent implements OnInit {

  page = 1;
  pageSize = 15;
  collectionSize = 1000;

  brands: Array<Brand> = [];

  constructor(private brandService: BrandService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(prd: any): void {
    this.brandService.delete(prd.id).subscribe();
    this.populateTable();
  }

  populateTable(): void {
    this.brandService.findAll()
      .subscribe((data: any) => {
        console.log(data);
        if (data && data.status == 200) {
          this.brands = data.entity;
        }
    });
  }

}
