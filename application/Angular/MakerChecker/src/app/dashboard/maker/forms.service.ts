import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../../environments/environment';
import { DatatableRequests } from 'src/app/model/datatableRequest';

@Injectable()
export class FormsService {

  getFormsURL =  environment.springAPiUrl+'customerForm/getForms'

 
  constructor(private _http:HttpClient) { }

  getAllForms(datatableRequest : DatatableRequests) {
    return this._http.post(this.getFormsURL,datatableRequest);
  } 




}
