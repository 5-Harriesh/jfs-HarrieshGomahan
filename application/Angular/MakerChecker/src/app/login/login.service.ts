import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../environments/environment';

@Injectable()
export class LoginService {

  loginURL =  environment.nodeApiUrl+'login'

  constructor(private _http: HttpClient) { }

  loginUser(user : object ) {
    return this._http.post(this.loginURL,user,{ responseType: 'text'});
  } 

}
