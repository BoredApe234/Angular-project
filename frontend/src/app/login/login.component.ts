import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {  Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new User(0,"","");
  msg = '';
  handleUpdateResponse: any = ()=>{console.log("Received")};
  handleError: any = ()=>{console.log("Error")};
  constructor(private _service:RegistrationService, private _router:Router) { }

  ngOnInit(): void {
  }
  loginUser(){
    this._service.loginUserFromRemote(this.user).subscribe({
      next: ()=>{console.log("Received")
    this._router.navigate(['/loginsuccess'])},
      error: ()=>{
        console.log("Error: Bad Credentail");
        this.msg = "Bad Credentials. Please enter your credentials again";
      }
    });
  }
}
