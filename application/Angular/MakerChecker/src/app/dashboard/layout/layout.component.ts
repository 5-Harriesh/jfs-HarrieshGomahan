import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.sass']
})
export class LayoutComponent implements OnInit {

  userName : string
  userType : string

  constructor(private router : Router) { }

  ngOnInit() {
    this.userName = JSON.parse(localStorage.getItem('currentUser'))['userName'];
    this.userType = JSON.parse(localStorage.getItem('currentUser'))['userType'];
  }

  logoutBtnClick = function () {
    localStorage.setItem('currentUser','');
    this.router.navigate(['']);
  };
}
