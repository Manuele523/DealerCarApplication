import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Params, ActivatedRoute } from '@angular/router';

import { Brand } from 'src/app/model/Brand';
import { Model } from 'src/app/model/Model';

import { BrandService } from 'src/app/service/brand.service';
import { ModelService } from 'src/app/service/model.service';
import { NotificationService } from 'src/app/utility/notification.service';

@Component({
  selector: 'app-model-update-form',
  templateUrl: './model-update-form.component.html',
  styleUrls: ['./model-update-form.component.css']
})
export class ModelUpdateFormComponent implements OnInit {

  brands: Array<Brand> = [];
  models: Array<Model> = [];
  model = {} as Model;
  isDisabledOption: Boolean = true;

  modelForm = new FormGroup({
    id: new FormControl('', Validators.required),
    code: new FormControl('', Validators.required),
    title: new FormControl('', Validators.required),
    brandId: new FormControl('', Validators.required)
  });

  constructor(
    private modelService: ModelService,
    private brandService: BrandService,
    private route:  ActivatedRoute,
    private notifyService: NotificationService
  ) { }

  update(): void {
    var formVal = this.modelForm.value;
    var tmpBrand = this.brands.find((element: any) => element.id == formVal.brandId);
    var tmpModel = this.models.find((element: any) => element.id == formVal.id);

    if (tmpBrand != null && tmpBrand != undefined
      && tmpModel != null && tmpModel != undefined) {
      this.model = {
        id: tmpModel.id,
        code: formVal.code,
        title: formVal.title,
        brand: {
          id: tmpBrand.id,
          code: tmpBrand.code,
          title: tmpBrand.title,
        }
      }
      this.modelService.update(this.model).subscribe((response: any) => {
        if (response.entity.includes("Error")) {
          this.notifyService.showWarning("", response.entity);
        } else {
          this.notifyService.showSuccess("", response.entity);
          this.populateOption();
          this.modelForm.reset();
        }
      });
    }
  }

  onClick(event: any) : void {
    var tmpModel = this.models.find(x => x.id == event.target.value);

    if (tmpModel != null && tmpModel != undefined ) {
      this.modelForm.setValue({
        id: tmpModel.id,
        code: tmpModel.code,
        title: tmpModel.title,
        brandId: tmpModel.brand.id
      });
      this.modelForm.enable();
    }
  }

  setToActive() : void {
    this.isDisabledOption = false;
  }

  ngOnInit(): void {
    this.modelForm.disable();
    this.brandService.findAll().subscribe((data: any) => {
      if ( data && data.status == 200) {
        this.brands = data.entity ? data.entity : [];
      }
    });
    this.populateOption();
  }

  populateOption() : void {
    this.modelService.findAll().subscribe((data: any) => {
      if ( data && data.status == 200) {
        this.models = data.entity ? data.entity : [];

        this.route.queryParams.subscribe((params: any) => {
          if ( params != null && params != undefined) {
            var tmpModel = this.models.find(x => x.id == params.id);
            if (tmpModel != null && tmpModel != undefined) {
              this.modelForm.setValue({
                id: tmpModel.id,
                code: tmpModel.code,
                title: tmpModel.title,
                brandId: tmpModel.brand.id
              });
              this.modelForm.enable();
            }
          }
        });
      }
    });
  }
}
