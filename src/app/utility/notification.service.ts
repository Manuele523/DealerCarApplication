import { Injectable } from '@angular/core';

import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private toastr: ToastrService) { }

  showSuccess(title: string, message: string){
      this.toastr.success(title, message, { progressBar: true });
  }

  showError(title: string, message: string){
      this.toastr.error(title, message, { progressBar: true });
  }

  showInfo(title: string, message: string){
      this.toastr.info(title, message, { progressBar: true });
  }

  showWarning(title: string, message: string){
      this.toastr.warning(title, message, { progressBar: true });
  }

}
