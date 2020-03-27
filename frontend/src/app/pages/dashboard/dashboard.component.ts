import { Component, OnInit } from '@angular/core';
import { RequestService } from 'src/app/services/request';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  constructor(private requestService: RequestService) { }

  data: any;

  ngOnInit() {
    this.getData();
  }

  async getData(){
    const response = await this.requestService.send('usuario');
    this.data = response.result;
  }

}
