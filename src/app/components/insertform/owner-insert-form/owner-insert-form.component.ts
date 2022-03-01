import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Params, ActivatedRoute } from '@angular/router';

import { Owner } from 'src/app/model/Owner';

import { OwnerService } from 'src/app/service/OwnerService';

@Component({
  selector: 'app-owner-insert-form',
  templateUrl: './owner-insert-form.component.html',
  styleUrls: ['./owner-insert-form.component.css']
})
export class OwnerInsertFormComponent {

  owners: Array<Owner> = [];
  owner = {} as Owner;

  ownerForm = new FormGroup({
    firstname: new FormControl('', Validators.required),
    lastname: new FormControl('', Validators.required),
    birthdate: new FormControl('', Validators.required),
    mail: new FormControl('', Validators.required)
  });

  constructor(private ownerService: OwnerService, private route:  ActivatedRoute) { }

  save(): void {
    var formVal = this.ownerForm.value;

    if (formVal != null || formVal != undefined) {
      this.owner = {
        firstname: formVal.firstname,
        lastname: formVal.lastname,
        birthdate: formVal.birthdate,
        mail: formVal.mail
      }
      this.ownerService.insert(this.owner);
    }
  }
}
