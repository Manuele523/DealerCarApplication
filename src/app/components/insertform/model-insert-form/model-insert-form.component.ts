import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Params, ActivatedRoute } from '@angular/router';

import { Brand } from 'src/app/model/Brand';
import { Model } from 'src/app/model/Model';
import { BrandService } from 'src/app/service/BrandService';
import { ModelService } from 'src/app/service/ModelService';

@Component({
  selector: 'app-model-insert-form',
  templateUrl: './model-insert-form.component.html',
  styleUrls: ['./model-insert-form.component.css']
})
export class ModelInsertFormComponent implements OnInit {

  brands: Array<Brand> = [];
  models: Array<Model> = [];
  model = {} as Model;

  modelForm = new FormGroup({
    code: new FormControl('', Validators.required),
    title: new FormControl('', Validators.required),
    brandId: new FormControl('', Validators.required)
  });

  constructor(private modelService: ModelService, private brandService: BrandService, private route:  ActivatedRoute) { }

  save(): void {
    var formVal = this.modelForm.value;
    var tmpBrand = this.brands.find((element: any) => element.id == formVal.brandId);

    if (tmpBrand != null && tmpBrand != undefined) {
      this.model = {
        code: formVal.code,
        title: formVal.title,
        brand: {
          id: tmpBrand.id,
          code: tmpBrand.code,
          title: tmpBrand.title,
        }
      }
      this.modelService.insert(this.model);
    }
  }

  ngOnInit(): void {
    this.brandService.findAll().subscribe(data => {
      this.brands = data;
    });
  }
}
