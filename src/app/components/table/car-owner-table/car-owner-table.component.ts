import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { CarOwner } from 'src/app/model/CarOwner';

import { CarOwnerService } from 'src/app/service/car-owner.service';
import { NotificationService } from 'src/app/utility/notification.service'

@Component({
  selector: 'app-car-owner-table',
  templateUrl: './car-owner-table.component.html',
  styleUrls: ['./car-owner-table.component.css']
})
export class CarOwnerTableComponent implements OnInit {

  page = 1;
  pageSize = 15;
  collectionSize = 1000;

  carOwners: Array<CarOwner> = [];

  constructor(private carOwnerService: CarOwnerService, private router: Router, private route: ActivatedRoute, private notifyService : NotificationService) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(carOwn: any): void {
    this.carOwnerService.delete(carOwn.id).subscribe((response: any) => {
      this.populateTable();
      this.notifyService.showInfo("Response:", response.entity);
    });
  }

  populateTable(): void {
    this.carOwnerService.findAll()
      .subscribe((data: any) => {
        if (data && data.status == 200) {
          this.carOwners = data.entity;
        }
    });
  }

}
