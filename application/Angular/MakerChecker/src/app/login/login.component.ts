import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass'],
  providers:  [ LoginService ]
})

export class LoginComponent implements OnInit {

  logForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router,private loginService : LoginService) { }

  ngOnInit() {
    this.logForm = this.formBuilder.group({
      'userName': new FormControl
    });
  }

  regBtnClick = function () {
    this.router.navigateByUrl('/app-register');
};

loginBtnClick = function () {
  this.loginService.loginUser(this.logForm.value).subscribe((response:any) =>{
    localStorage.setItem('currentUser',response );
    this.router.navigate(['/dashboard']);
  })
};

}
