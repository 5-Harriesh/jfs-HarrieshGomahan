import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AppformService } from './appform.service';

@Component({
  selector: 'app-makerform',
  templateUrl: './makerform.component.html',
  styleUrls: ['./makerform.component.css'],
  providers:[AppformService]
})

export class MakerformComponent implements OnInit {

  appForm: FormGroup

  constructor(private formBuilder: FormBuilder, private router: Router, private appformService: AppformService) { }

  ngOnInit(): void {
    this.appForm = this.formBuilder.group({
      applicationtype: new FormControl,
      emailid: new FormControl,
      name: new FormControl,
      createddate: new FormControl,
      modifieddate: new FormControl,
      status: 'Submitted'
    });
  }

  onSubmit() {
    this.appformService.saveForm(this.appForm.value).subscribe((response: any) => {
      alert('Thanks!');
      this.router.navigate(['/dashboard']);
    })
  }
}
