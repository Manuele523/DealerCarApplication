import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { Brand } from 'src/app/model/Brand';

import { BrandService } from 'src/app/service/brand.service';
import { NotificationService } from 'src/app/utility/notification.service';

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

  constructor(
    private brandService: BrandService,
    private notifyService: NotificationService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(prd: any): void {
    this.brandService.checkIfHaveAssociationWithOwner(prd.id).subscribe((response: any) => {
      if (response.entity != false) {
        if (response.entity.includes("010")) {
          this.notifyService.showWarning("", response.entity);
        }
      } else {
        const modalRef = this.modalService.open(NgbdModalContent);
        modalRef.componentInstance.brand = prd;
      }
    });
  }

  populateTable(): void {
    this.brandService.findAll().subscribe((data: any) => {
      if (data && data.status == 200) {
        this.brands = data.entity;
      }
    });
  }
}



@Component({
  selector: 'ngbd-modal-content',
  template: `
    <div class="modal-header">
      <h4 class="modal-title">Hi there!</h4>
      <button type="button" class="btn-close" aria-label="Close" (click)="activeModal.dismiss('Cross click')"></button>
    </div>
    <div class="modal-body">
      <p>Are you sure you want to delete the {{brand.title}} brand?</p>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.close('Close click')">Close</button>
      <button type="button" class="btn btn-outline-dark" (click)="delete()">Continue</button>
    </div>
  `
})
export class NgbdModalContent {
  
  @Input() brand: any;

  constructor(
    public activeModal: NgbActiveModal,
    private brandService: BrandService,
    private router: Router
  ) { }

  delete(): void {
    this.brandService.delete(this.brand.id).subscribe((response: any) => {
      this.activeModal.close();  
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
        this.router.navigate(['/brand'])
      );
    });
  }
}