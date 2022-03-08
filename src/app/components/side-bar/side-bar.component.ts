import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent {

  title: String = '';
  isVisible: Boolean = false;

  constructor(private router: Router) { }

  onChangeTab(page: String) : void {
    this.title = 'TABLE ' + page.toUpperCase();
    this.isVisible = true;
  }

  goToComponent(page: String) : void {
    let url = this.router.url;
    let baseUrl = url;
    if (url != '/brand' && url != '/model' && url != '/owner') {
      baseUrl = url.substring(url.indexOf("/") + 1, url.lastIndexOf("/"));
    }
    this.title = page.toUpperCase() + ' ' + baseUrl.substring(baseUrl  .indexOf("/") + 1).toUpperCase();
    this.router.navigate([baseUrl + '/' + (page == 'table' ? '' : page)]);
  }

}
