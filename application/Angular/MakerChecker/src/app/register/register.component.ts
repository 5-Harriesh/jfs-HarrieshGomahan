import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass'],
  providers:  [ RegisterService ]
})
export class RegisterComponent implements OnInit {

  regForm: FormGroup;


  constructor(private formBuilder: FormBuilder, private router: Router,private registerService : RegisterService) { }

  ngOnInit() {
    this.regForm = this.formBuilder.group({
      'userName': new FormControl,
      'userType': new FormControl
    });
  }


  bkBtnClick = function () {
    this.router.navigateByUrl('');
  };

  regFinalBtnClick = function () {
    this.registerService.registerUser(this.regForm.value).subscribe((response:any) =>{
      console.log(response);
    })

  };

}
