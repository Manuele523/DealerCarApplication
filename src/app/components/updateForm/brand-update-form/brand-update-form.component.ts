import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';

import { Brand } from 'src/app/model/Brand';

import { BrandService } from 'src/app/service/brand.service';
import { NotificationService } from 'src/app/utility/notification.service';

@Component({
  selector: 'app-brand-update-form',
  templateUrl: './brand-update-form.component.html',
  styleUrls: ['./brand-update-form.component.css']
})
export class BrandUpdateFormComponent implements OnInit {

  response: String = '';
  brands: Array<Brand> = [];
  brand = {} as Brand;
  isDisabled: Boolean = true;

  brandForm = new FormGroup({
    id: new FormControl('', Validators.required),
    code: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
    title: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
  });

  constructor(
    private brandService: BrandService,
    private route:  ActivatedRoute,
    private notifyService: NotificationService
  ) { }

  update(): void {
    var formVal = this.brandForm.value;
    var tmpBrand = this.brands.find((element: any) => element.id == formVal.id);

    if (tmpBrand != null || tmpBrand != undefined) {
      this.brand = {
        id: tmpBrand.id,
        code: formVal.code,
        title: formVal.title
      }
    }
    this.brandService.update(this.brand).subscribe((response: any) => {
      if (response.entity.includes("Error")) {
        this.notifyService.showWarning("", response.entity);
      } else {
        this.notifyService.showSuccess("", response.entity);
        this.populateOption();
        this.brandForm.reset();
      }
    });
  }

  onClick(event: any) : void {
    var tmpBrand = this.brands.find(x => x.id == event.target.value);

    if (tmpBrand != null) {
      this.brandForm.setValue({
        id: tmpBrand.id,
        code: tmpBrand.code,
        title: tmpBrand.title
      });
      this.brandForm.enable();
    }
  }

  ngOnInit(): void {
    this.populateOption();
  }

  populateOption() : void {
    this.brandService.findAll().subscribe((data: any) => {
        if ( data && data.status == 200) {
          this.brands = data.entity ? data.entity : [];

          this.route.queryParams.subscribe((params: any) => {
            if ( params != null && params != undefined) {
              var tmpBrand = this.brands.find(x => x.id == params.id);
              if (tmpBrand != null && tmpBrand != undefined) {
                this.brandForm.setValue({
                  id: tmpBrand.id,
                  code: tmpBrand.code,
                  title: tmpBrand.title
                });
                this.brandForm.enable();
              }
            }
          });
        }
    });
  }
}
