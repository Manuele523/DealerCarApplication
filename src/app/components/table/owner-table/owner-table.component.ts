import { Component, OnInit } from '@angular/core';
import { Owner } from 'src/app/model/Owner';

import { OwnerService } from 'src/app/service/owner.service';
import { NotificationService } from 'src/app/utility/notification.service'

@Component({
  selector: 'app-owner-table',
  templateUrl: './owner-table.component.html',
  styleUrls: ['./owner-table.component.css']
})
export class OwnerTableComponent implements OnInit {

  page = 1;
  pageSize = 15;
  collectionSize = 1000;

  owners: Array<Owner> = [];

  constructor(private ownerService: OwnerService, private notifyService : NotificationService) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(prd: any): void {
    this.ownerService.delete(prd.id).subscribe((response: any) => {
      this.populateTable();
      this.notifyService.showInfo("Response:", response.entity);
    });
  }

  populateTable(): void {
    this.ownerService.findAll().subscribe((data: any) => {
      if ( data && data.status == 200 ) {
        this.owners = data.entity ? data.entity : [];
      }
    });
  }
}
