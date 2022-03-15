import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { Model } from 'src/app/model/Model';

import { ModelService } from 'src/app/service/model.service';
import { NotificationService } from 'src/app/utility/notification.service'

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

  constructor(
    private modelService: ModelService,
    private notifyService : NotificationService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.populateTable();
  }

  delete(mdl: any): void {
    this.modelService.checkIfHaveAssociationWithOwner(mdl.id).subscribe((response: any) => {
      if (response.entity != false) {
        if (response.entity.includes("011")) {
          this.notifyService.showWarning("", response.entity);
        }
      } else {
        const modalRef = this.modalService.open(NgbdModalContent);
        modalRef.componentInstance.model = mdl;
      }
    });
  }

  populateTable(): void {
    this.modelService.findAll().subscribe((data: any) => {
      if ( data && data.status == 200 ) {
        this.models  = data.entity ? data.entity : [];
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
      <p>Are you sure you want to delete the {{model.title}} model?</p>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.close('Close click')">Close</button>
      <button type="button" class="btn btn-outline-dark" (click)="delete()">Continue</button>
    </div>
  `
})
export class NgbdModalContent {

  @Input() model: any;

  constructor(
    public activeModal: NgbActiveModal,
    private modelService: ModelService,
    private router: Router
  ) { }

  delete(): void {
    this.modelService.delete(this.model.id).subscribe((response: any) => {
      this.activeModal.close();
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
        this.router.navigate(['/model'])
      );
    });
  }
}
