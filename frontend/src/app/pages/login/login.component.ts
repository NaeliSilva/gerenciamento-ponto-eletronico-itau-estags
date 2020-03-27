import { Component, OnInit, OnDestroy } from '@angular/core';
import { RequestService } from 'src/app/services/request';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  constructor(private requestService: RequestService) {}
  data = {
    usuarioId: 0,
    tipo: null,
  }

  ngOnInit() {
  }

  async submit() {
    await this.requestService.send('ponto', 'POST', this.data);
  }

}
