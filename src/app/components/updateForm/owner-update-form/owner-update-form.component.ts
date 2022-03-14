import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Params, ActivatedRoute } from '@angular/router';

import { Owner } from 'src/app/model/Owner';

import { OwnerService } from 'src/app/service/owner.service';

@Component({
  selector: 'app-owner-update-form',
  templateUrl: './owner-update-form.component.html',
  styleUrls: ['./owner-update-form.component.css']
})
export class OwnerUpdateFormComponent implements OnInit {

  owners: Array<Owner> = [];
  owner = {} as Owner;
  isDisabled: Boolean = true;

  ownerForm = new FormGroup({
    id: new FormControl('', Validators.required),
    firstname: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
    lastname: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
    birthdate: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
    mail: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required)
  });

  constructor(private ownerService: OwnerService, private route:  ActivatedRoute) { }

  update(): void {
    var formVal = this.ownerForm.value;
    var tmpOwner = this.owners.find((element: any) => element.id == formVal.id);

    if (tmpOwner != null || tmpOwner != undefined) {
      this.owner = {
        id: tmpOwner.id,
        firstname: formVal.firstname,
        lastname: formVal.lastname,
        birthdate: formVal.birthdate,
        mail: formVal.mail
      }
      this.ownerService.update(this.owner).subscribe();
    }
  }

  onClick(event: any) : void {
    var tmpOwner = this.owners.find((element: any) => element.id == event.target.value);

    if (tmpOwner != null) {
      this.ownerForm.setValue({
        id: tmpOwner.id,
        firstname: tmpOwner.firstname,
        lastname: tmpOwner.lastname,
        birthdate: tmpOwner.birthdate,
        mail: tmpOwner.mail
      });
      this.ownerForm.enable();
    }
  }

  ngOnInit(): void {
    this.ownerService.findAll().subscribe((data: any) => {
      if ( data && data.status == 200 ) {
        this.owners = data.entity ? data.entity : [];

        this.route.queryParams.subscribe((params: any) => {
          if ( params != null && params != undefined)
            var tmpOwner = this.owners.find(x => x.id == params.id);
              if (tmpOwner != null && tmpOwner != undefined) {
                this.ownerForm.setValue({
                  id: tmpOwner.id,
                  firstname: tmpOwner.firstname,
                  lastname: tmpOwner.lastname,
                  birthdate: tmpOwner.birthdate,
                  mail: tmpOwner.mail
                });
              this.ownerForm.enable();
            }
          });
        }
      });
    }
}
