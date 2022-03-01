import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { Brand } from 'src/app/model/Brand';
import { BrandService } from 'src/app/service/BrandService';

@Component({
  selector: 'app-brand-insert-form',
  templateUrl: './brand-insert-form.component.html',
  styleUrls: ['./brand-insert-form.component.css']
})
export class BrandInsertFormComponent {
  
  brand = {} as Brand;
  isDisabled: Boolean = true;

  brandForm = new FormGroup({
    code: new FormControl('', Validators.required),
    title: new FormControl('', Validators.required),
  });

  constructor(private brandService: BrandService, private route: ActivatedRoute) { }

  save(): void {
    var formVal = this.brandForm.value;

    if (formVal != null || formVal != undefined) {
      this.brand = {
        code: formVal.code,
        title: formVal.title
      }
    }
    this.brandService.insert(this.brand);
  }

}
