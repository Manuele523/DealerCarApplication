import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Params, ActivatedRoute } from '@angular/router';

import { Brand } from 'src/app/model/Brand';
import { Model } from 'src/app/model/Model';
import { BrandService } from 'src/app/service/BrandService';
import { ModelService } from 'src/app/service/ModelService';

@Component({
  selector: 'app-model-update-form',
  templateUrl: './model-update-form.component.html',
  styleUrls: ['./model-update-form.component.css']
})
export class ModelUpdateFormComponent implements OnInit {

  brands: Array<Brand> = [];
  models: Array<Model> = [];
  model = {} as Model;
  isDisabled: Boolean = true;

  modelForm = new FormGroup({
    id: new FormControl('', Validators.required),
    code: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
    title: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
    brandId: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required)
  });

  constructor(private modelService: ModelService, private brandService: BrandService, private route:  ActivatedRoute) { }

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
      this.modelService.update(this.model);
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

  ngOnInit(): void {
    this.brandService.findAll().subscribe(data => {
      this.brands = data;
    });

    this.modelService.findAll().subscribe(data => {
      this.models = data;

      this.route.queryParams.subscribe((params: any) => {
        if ( params != null && params != undefined)
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
        });
      });
    }
}
