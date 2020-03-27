import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RequestService } from 'src/app/services/request';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  constructor(private activeRoute: ActivatedRoute, private requestService: RequestService) { }
  
  data: any;

  ngOnInit() {
    this.getId();
  }

  getId() {
    this.activeRoute.params.subscribe(params => {
      if (params['id']) {
        this.getData(params['id']);
      }
    })
  }

  async getData(id){
    let url = 'usuario/'.concat(id);
    this.data = {
      usuario: await (await this.requestService.send(url)).result,
      ponto: await (await this.requestService.send(url.concat('/ponto'))).result
    }
  }

}
