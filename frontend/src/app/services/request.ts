import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgxSpinnerService } from 'ngx-spinner';

@Injectable({
    providedIn: 'root',
})
export class RequestService {
    constructor(private http: HttpClient, private spinner: NgxSpinnerService) { }

    url: String = 'https://calm-oasis-34853.herokuapp.com/';

    async send(path: string = null, method: string = 'GET', body = null, headers = null, params = null) {
        let response = { error: false, result: null };
        this.spinner.show();
        await this.http.request(method, this.url.concat(path), {
            body,
            params,
            headers,
            reportProgress: null,
            withCredentials: null,
            responseType: null,
        }).toPromise()
            .then(result => Object.assign(response, { error: false, result }))
            .catch(result => Object.assign(response, { error: true, result }))
            .finally(() => this.spinner.hide());
        return response;
    }
}