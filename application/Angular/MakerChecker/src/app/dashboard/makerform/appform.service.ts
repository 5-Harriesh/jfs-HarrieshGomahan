import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../../environments/environment';


@Injectable()
export class AppformService {

  customerSaveURL =  environment.springAPiUrl+'customerForm/save'


  constructor(private _http: HttpClient) { }

  saveForm(appForm : object ) {
    return this._http.post(this.customerSaveURL,appForm);
  } 
}
