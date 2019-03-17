import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../environments/environment'

@Injectable()
export class RegisterService {

  registerURL =  environment.nodeApiUrl+'login/save'
 
  constructor(private _http: HttpClient) { }

  registerUser(user : object ) {
    return this._http.post(this.registerURL,user,{ responseType: 'text'});
  }
}
